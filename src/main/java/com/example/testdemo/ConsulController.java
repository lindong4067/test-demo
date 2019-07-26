//
package com.example.testdemo;
//
//import ericsson.admin.common.framework.ExpressApiConsul;
//import ericsson.admin.service.componentconfiguration.RequestParser;
//import ericsson.admin.service.jasonobject.networkdata.IPStorage;
//import ericsson.admin.service.jaxbobject.gmpc.networkdata.IPStorageRequestParser;
//import ericsson.admin.service.jaxbobject.gmpc.networkdata.IPStorageResponseParser;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import static ericsson.admin.common.framework.Defs.NETWORK_STORAGE_IP_STORAGE;
//import static ericsson.admin.common.utils.StringUtils.escapeEncode;
//
//@RestController
//public class ConsulController {
//
//    @PostMapping("/{cluster}/ip/save")
//    public Object saveIP(@RequestBody IPStorage ipStroage, @PathVariable String cluster) {
//
//        return ExpressApiConsul.postKVCover(RequestParser.getURLDataStorage(cluster, NETWORK_STORAGE_IP_STORAGE, RequestParser.getSpecialEncode(escapeEncode(ipStroage.getUrl()))),
//                IPStorageRequestParser.parseJsonToString(ipStroage),
//                null,
//                IPStorageResponseParser::parsePostIPStorages);
//    }
//
//    @GetMapping("/{cluster}/ip/get")
//    public static IPStorage getIP(@RequestParam String gmpcAddress, @PathVariable String cluster) {
//        IPStorage theIPStorage = null;
//        ResponseEntity theResponse = ExpressApiConsul.queryConsulKey(RequestParser.getURLDataStorage(cluster, NETWORK_STORAGE_IP_STORAGE, RequestParser.getSpecialEncode(escapeEncode(gmpcAddress))),
//                null,
//                IPStorageResponseParser::parseGetIPStorage);
//        if (theResponse.getStatusCode() == HttpStatus.OK) {
//            theIPStorage = (IPStorage) theResponse.getBody();
//        }
//
//        return theIPStorage;
//    }
//}
