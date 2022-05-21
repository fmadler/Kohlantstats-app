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
	* - name      : SDDServiceInterface
	* - file name : SDDDaoInterface.vm
*/
package com.game.score.service.face.generic;


import com.game.score.sdd.out.generic.MasterDataOutList;

/**
 *
 * <p>Title: MasterDataService</p>
 *
 * <p>Description: remote interface for MasterDataService service </p>
 *
 */
public interface MasterDataService {


    public MasterDataOutList execute (
        String table 
        ,String orderby
        ,String sort
    );




}