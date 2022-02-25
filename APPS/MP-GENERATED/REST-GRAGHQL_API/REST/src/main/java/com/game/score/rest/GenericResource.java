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
	* - name      : RESTDbAPIGenericResource
	* - file name : RESTDbAPIGenericResource.vm
*/
package com.game.score.rest;



import io.swagger.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import net.sf.minuteProject.model.dao.GenericDao;
import net.sf.minuteProject.model.data.criteria.EntityCriteria;
import net.sf.minuteProject.model.data.criteria.EntitySort;
import net.sf.minuteProject.model.data.criteria.QueryData;
import net.sf.minuteProject.model.data.criteria.constant.EntityMatchType;
import net.sf.minuteProject.model.data.criteria.constant.OperandType;
import net.sf.minuteProject.model.data.criteria.constant.QuerySortOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.sf.minuteProject.model.service.GenericService;
import net.sf.minuteProject.architecture.bsla.domain.AbstractDomainObject;

/**
 *
 * <p>Title: GenericResource</p>
 *
 * <p>Description: Generic controller GenericResource </p>
 *
 */
public abstract class GenericResource <T extends AbstractDomainObject, S extends GenericDao<T>> implements java.io.Serializable{

	protected abstract S getService();
	protected abstract T getInstance();
	protected abstract T getElement(T t);

    @GET
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Find entity with pagination")
	public QueryData<T> find(@QueryParam("sortOrder") String sortOrder,                              @QueryParam("sortField") String sortField,                              @QueryParam("take") int take, //kendoui specific
                             @QueryParam("skip") int skip, //kendoui specific
                             @QueryParam("first") int first,
                             @QueryParam("pageSize") int pageSize) throws Exception {
        //kendoui specific
        if (take!=0 && skip!=0) {
            first = skip;
        }
        QuerySortOrder order = QuerySortOrder.ASC;
        if (QuerySortOrder.DESC.toString().equals(sortOrder)) {
            order = QuerySortOrder.DESC;
        }

        T esMask = getInstance();
        esMask.mask(sortField);
        EntitySort<T> es = new EntitySort<T>(esMask, order);

        T ecMask = getInstance();
        //ecMask.mask(filters);
        EntityCriteria<T> ec = new EntityCriteria<T>(ecMask, EntityMatchType.ALL, OperandType.CONTAINS, false);

        QueryData<T> data = new QueryData<T>(first, pageSize, es, ec);
        getService().find(data);
        List<T> list = data.getResult();
        List<T> listDetached = new ArrayList<T>();
        for (T element : list) {
            listDetached.add(getElement(element));
        }
        data.setResult(listDetached);
        int count = data.getTotalResultCount().intValue();
        return data;
    }



}