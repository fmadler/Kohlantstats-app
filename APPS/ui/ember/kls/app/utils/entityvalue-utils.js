import _ from 'lodash';

export function fillCustomEntityValue(data, filters, datasourceUrl) {
    data.custom = {};
    let descriptions = data.descriptionEntityValueRequest;
    if (descriptions.length != 0) {
      //TODO get FR only
      data.custom["description"] = descriptions[0].description;
    }
    let binaries = data.binaryEntityValueRequest;
    if (binaries.length != 0) {
      data.custom["binary_url"] = getBinaryUrl(binaries[0], datasourceUrl);
    }
    return data;
}

export function fillCustomBinaryEntityValue(data, filters, datasourceUrl) {
  data.custom = {};
  let binaries = _.filter(data.BinaryEntityValueRequestOut, filters);
  if (binaries.length != 0) {
    data.custom["binary_url"] = getBinaryUrl(binaries[0], datasourceUrl);
  }
  return data;
}


export function getBinaryUrl(binaryInfo, datasourceUrl) {
  let {binaryType, entityFullWebPath, shortUrl, id} = binaryInfo;
  if (binaryType && entityFullWebPath) {
    return datasourceUrl + '/data/public/binary/one/' + entityFullWebPath + '?binaryType=' + binaryType;
  }
  if (shortUrl) {
    return datasourceUrl + '/data/public/binary/get/' + shortUrl + '_' +id;
  } 
  return "";
}