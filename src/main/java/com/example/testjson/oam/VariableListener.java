/*
 *         File : VariableListener.java
 *    Classname : VariableListener
 *    Author(s) : EZNLZHI
 *      Created : 2018-11-13
 *
 *
 */

package com.example.testjson.oam;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import java.io.File;

@Slf4j
public class VariableListener extends FileAlterationListenerAdaptor {

    @Override
    public void onFileChange(File file) {
        log.debug("File : {} changed.", file.getAbsolutePath());
        log.debug("System variable changed.");
//        VariableService.clearCache();
        log.debug("Clear system variable cache.");
        super.onFileChange(file);
    }
}
