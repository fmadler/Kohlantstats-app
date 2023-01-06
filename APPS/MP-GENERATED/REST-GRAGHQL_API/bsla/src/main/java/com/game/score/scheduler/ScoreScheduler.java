/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9.11
	* - name      : SpringScheduler
	* - file name : SpringScheduler.vm
*/
package com.game.score.scheduler;



import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.sun.mail.smtp.SMTPTransport;
import jxl.Cell;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.write.*;
import jxl.write.Number;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import java.nio.file.*;

import lombok.extern.slf4j.Slf4j;

import com.game.score.dao.sdd.face.sitemap.SitemapDaoFace;
import com.game.score.sdd.in.sitemap.SitemapIn;
import com.game.score.sdd.out.sitemap.SitemapOut;
import com.game.score.sdd.out.sitemap.SitemapOutList;

/**
 *
 * <p>Title: ScoreScheduler</p>
 *
 * <p>Description: Scheduler of model score
 * </p>
 *
 */

@Component
@Slf4j
public class ScoreScheduler {

	private final String reportFileExt = ".xls";

    @Autowired
    SitemapDaoFace sitemapDaoFace;
    
    
	public SitemapOutList callImplementationprocess_sitemap (
	) {
        return sitemapDaoFace.execute(
        );
	}
	
    @Scheduled(cron="0 1 1 * * ?")
    public void process_sitemap() throws IOException {
    	String reportFileName = "process_sitemap"; 

        SitemapOutList list = 
            callImplementationprocess_sitemap (
		);
		if (list.getSitemapOuts().size()>=1) {
			log.info("Report process_sitemap in preparation with "+list.getSitemapOuts().size()+" records");
            performReportActions_process_sitemap(reportFileName, list);
		}
	}

    private void performReportActions_process_sitemap (String reportFileName, SitemapOutList list) throws IOException {
        performReportAndCopyprocess_sitemap (reportFileName, list);
        performReportAndCopyToDirprocess_sitemap (reportFileName, list);
        performReportAndMailSendprocess_sitemap (reportFileName, list);
    }

    private void performReportAndCopyprocess_sitemap (String reportFileName, SitemapOutList list) throws IOException {
        writeReportprocess_sitemap(reportFileName, list);
        String filename = getReportPath(reportFileName+reportFileExt);
        copyFile(filename, "/opt/tomcat/myapp/kls/sitemaps/sitemap.xml");
    }
    private void performReportAndCopyToDirprocess_sitemap (String reportFileName, SitemapOutList list) throws IOException {
        writeReportprocess_sitemap(reportFileName, list);
        String filename = getReportPath(reportFileName+reportFileExt);
        copyFile(filename, "/opt/tomcat/kls/winy/sitemaps");
    }

	private void performReportAndMailSendprocess_sitemap (String reportFileName, SitemapOutList list) {
        writeReportprocess_sitemap (reportFileName, list);
        String from = "thewineryproject@gmail.com";
        String to1 = "thewineryproject@gmail.com";
        String host = "smtp.mailgun.org";

        //Get the session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        //custom mail server
        properties.put("mail.smtps.auth", "true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.ssl.trust", "smtp.mailgun.org");
        Session session = Session.getDefaultInstance(properties);

        //compose the message
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
        	message.addRecipient(Message.RecipientType.TO,new InternetAddress(to1));
			List<SitemapOut> values = list.getSitemapOuts();
			String reportValue = "";
			reportValue = values.size()+"";
			String subject = (StringUtils.isNotEmpty(reportValue))?"Process sitemap report ("+reportValue+")":"Process sitemap report";
            message.setSubject(subject);
            
            // attachment
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            String bodyPart = subject+"\n";
            
			messageBodyPart.setText(bodyPart);
            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = getReportPath(reportFileName+reportFileExt);
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(reportFileName+"-"+getDateTimeAppender()+reportFileExt);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
            t.connect("smtp.mailgun.com", "postmaster@winerylabs.com", "xxx");
            t.sendMessage(message, message.getAllRecipients());
            t.close();

        } catch (MessagingException  ex) {
        	ex.printStackTrace();
        }
    }
	
    private void writeReportprocess_sitemap (String name, SitemapOutList list) {

        //1. Create an Excel file
        WritableWorkbook myFirstWbook = null;
        try {

            File file = new File(getReportPath(name+reportFileExt));
            if (!file.exists()) {
                file.createNewFile();
            }
            myFirstWbook = Workbook.createWorkbook(file);

            // create an Excel sheet
            WritableSheet excelSheet = myFirstWbook.createSheet("process_sitemap", 0);

            // add something into the Excel sheet
            excelSheet.addCell(new Label(0, 0, "location", getHeaderFont()));
            excelSheet.addCell(new Label(1, 0, "last_modification", getHeaderFont()));
            excelSheet.addCell(new Label(2, 0, "frequency", getHeaderFont()));
            excelSheet.addCell(new Label(3, 0, "priority", getHeaderFont()));
            excelSheet.addCell(new Label(4, 0, "score", getHeaderFont()));
			int cpt = 1;
			for (SitemapOut c : list.getSitemapOuts()) {
            	excelSheet.addCell(new Label(0, cpt, c.getLocation()));
            	excelSheet.addCell(new Label(1, cpt, c.getLastModification()));
            	excelSheet.addCell(new Label(2, cpt, c.getFrequency()));
            	excelSheet.addCell(new Label(3, cpt, c.getPriority()));
            	excelSheet.addCell(new Label(4, cpt, c.getScore()+""));
				cpt++;
			}

			sheetAutoFitColumns(myFirstWbook.getSheet(0));
            myFirstWbook.write();


        } catch (IOException |  WriteException e) {
            e.printStackTrace();
        } finally {

            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	



    @Autowired
    private ServletContext servletContext;
    private String getReportPathServlet () {
        return servletContext.getRealPath("/");
    }
    
    private WritableCellFormat getHeaderFont () throws WriteException {
        WritableFont cellFont = new WritableFont(WritableFont.COURIER, 12);
        cellFont.setBoldStyle(WritableFont.BOLD);
        return new WritableCellFormat(cellFont);
    }
    
    private String getTimeAppender() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
    
    private String getDateTimeAppender() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        return date.format(formatter);
    }

    private void sheetAutoFitColumns(WritableSheet sheet) {
        for (int i = 0; i < sheet.getColumns(); i++) {
            Cell[] cells = sheet.getColumn(i);
            int longestStrLen = -1;

            if (cells.length == 0)
                continue;

        /* Find the widest cell in the column. */
            for (int j = 0; j < cells.length; j++) {
                if ( cells[j].getContents().length() > longestStrLen ) {
                    String str = cells[j].getContents();
                    if (str == null || str.isEmpty())
                        continue;
                    longestStrLen = str.trim().length();
                }
            }

        /* If not found, skip the column. */
            if (longestStrLen == -1)
                continue;

        /* If wider than the max width, crop width */
            if (longestStrLen > 255)
                longestStrLen = 255;

            CellView cv = sheet.getColumnView(i);
            cv.setSize(longestStrLen * 256 + 100); /* Every character is 256 units wide, so scale it. */
            sheet.setColumnView(i, cv);
        }
    }


    private static String getReportPath (String name) {
        return System.getProperty("java.io.tmpdir")+"/"+name;
    }

    private static void copyFile(String from, String to) throws IOException {
        Path src = Paths.get(from);
        Path dest = Paths.get(to);
        Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
    }

    public static String getEnvironment(Properties props) {
		String environment = System.getProperty("environment");
		if (environment == null) {
			environment = System.getProperty("env");
		}
		if (environment == null) {
			environment = System.getProperty("spring.profiles.active");
		}
		if (environment == null) {
			environment = props.getProperty("environment");
			if (environment.equals("${environment}")) {					
				environment = null;
			}
		}
		if (environment == null) {
			environment = "TBD";
		}
		return environment;
	}
}
