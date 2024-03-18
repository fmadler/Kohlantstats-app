/*
	 Copyright (c) minuteproject, minuteproject@gmail.com
	 All rights reserved.

	 Licensed under the Apache License, Version 2.0 (the "License")
	 you may not use this file except in compliance with the License.
	 You may obtain a copy of the License at

	 http://www.apache.org/licenses/LICENSE-2.0

	 Unless required by applicable law or agreed to in writing, software
	 distributed under the License is distributed on an "AS IS" BASIS,
	 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 See the License for the specific language governing permissions and
	 limitations under the License.

	 More information on minuteproject:
	 twitter @minuteproject
	 wiki http://minuteproject.wikispaces.com
	 blog http://minuteproject.blogspot.net

*/
/*
	 template reference :
	 - Minuteproject version : 0.9.11
	 - name      : EmberCommonUtilsJs
	 - file name : EmberCommonUtilsJs.vm
*/
import fetch from 'fetch';
import { hash } from 'rsvp';
import _ from 'lodash';

async function postData(url = '', data = {}, format) {
   let options = {}
   if (format === 'JSON') {
     options.contentType = 'application/json'
     options.body = JSON.stringify(data)
   } else if (format === 'URLENCODED') {
     options.contentType = 'application/x-www-form-urlencoded'
     options.body = convertToUrlEncoding(data)
   }

    // Default options are marked with *
    const response = await fetch(url, {
      method: 'POST', // *GET, POST, PUT, DELETE, etc.
      mode: 'cors', // no-cors, *cors, same-origin
      cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
      credentials: 'same-origin', // include, *same-origin, omit
      headers: {
        'Content-Type': options.contentType
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      //redirect: 'follow', // manual, *follow, error
      //referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
      body: options.body // body data type must match "Content-Type" header
    });
    return response.json(); // parses JSON response into native JavaScript objects
}

export function getData(url) {
    return fetchIt(url, "get");
}

export function fetchData(url) {
    return getData(url);
}


export function fetchCaptcha(url) {
    return fetch(url,
        {
            method : 'GET',
            mode: 'cors',
            // headers : {
            //     'Content-type': 'application/json'
            // }
        })
        .then(res => {
            return res.text();
        })
        .then(data => {
            return data;
        });
    ;
}

export function fetchCaptchaScript(url) {
    // options = $.extend({
    //     dataType: 'script',
    //     cache: false,
    //     url: url
    // }, options || {});
    // return $.ajax(options);
    return fetch(url,
        {
            method : 'GET',
            mode: 'cors',
            headers : {
                 'Content-type': 'script'
            }
        })
        // .then(res => {
        //     return res.text();
        // })
        // .then(data => {
        //     return data;
        // });
    ;
}
export function fetchDataJwt(url, method) {
    let myjwt = JSON.parse(localStorage.getItem("ember_simple_auth-session")).authenticated.token
    return fetch(url,
        {
            method : method,
            mode: 'cors',
            headers : {
                'Content-type': 'application/json',
                'Authorization': 'Bearer '+myjwt,
            }
        })
        .then(function(response) {
            return response.json();
        })
        .catch(function(error) {
            throw {"session":"invalidate"};
        })

    ;
}

function fetchIt(url, method) {
    return fetch(url,
        {
            method : method,
            mode: 'cors',
            headers : {
                'Content-type': 'application/json'
            }
        })
        .then(function(response) {
            return response.json();
        })
    ;
}

export default {
    fetchData: fetchData
};

export function getJsonFromLocalStorage(key, adapter, dataCallback) {
    var c = window.localStorage.getItem(key);
    var result=(c && c!="undefined")?JSON.parse(c):null;
    if (!result) {
        var promise = adapter.findAll().then((data) => {
            return dataCallback(data);
        });
        var promises = {
            promise : promise
        };
        hash(promises).then(function(data) {
            result = data.promise;
            window.localStorage.setItem(key,JSON.stringify(result));
        });
    }
    return result;
}

export function webPath(input) {
    return replaceAll(input.toLowerCase(), " ", "-");
}

export function toWebPath(param) {
  if (param) {
    return param.trim().toLowerCase().split(' ').join('-');
  } else {
    return "";
  }
}

export function convertToUrlEncoding(payloadJson) {
  let formBody = [];
  for (var property in payloadJson) {
    var encodedKey = encodeURIComponent(payloadJson);
    var encodedValue = encodeURIComponent(payload[payloadJson]);
    formBody.push(encodedKey + "=" + encodedValue);
  }
  formBody = formBody.join("&");
  return formBody;
}
