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
	* - name      : SDDOutputBeanCollection
	* - file name : JavaBeanCollection.vm
*/
package com.game.score.sdd.out.generic;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import com.game.score.sdd.out.generic.MasterDataOut;


/**
 *
 * <p>Title: MasterDataOutList</p>
 *
 * <p>Description: Java Bean MasterDataOutList </p>
 *
 */
@XmlRootElement (name="MasterDataOutList")
public class MasterDataOutList {

    @XmlElement (name="MasterDataOut") //(name="masterdataouts")
    private List<MasterDataOut> masterDataOuts;

    /**
    * Default constructor
    */
    public MasterDataOutList() {
    }
	
    public void setMasterDataOuts (List<MasterDataOut> masterDataOuts) {
        this.masterDataOuts = masterDataOuts;
    }

    @XmlTransient
    public List<MasterDataOut> getMasterDataOuts () {
        if (masterDataOuts==null)
            masterDataOuts = new ArrayList<>();
        return masterDataOuts;
    }

    public void addMasterDataOut (MasterDataOut masterDataOut) {
        getMasterDataOuts ().add(masterDataOut);
    }



}
