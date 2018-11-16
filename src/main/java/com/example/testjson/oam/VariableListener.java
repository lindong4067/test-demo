/*
 *         File : VariableListener.java
 *    Classname : VariableListener
 *    Author(s) : EZNLZHI
 *      Created : 2018-11-13
 *
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.
 * The Copyright to the computer program(s) herein is the property of
 * Ericsson AB, Sweden.
 * The program(s) may be used and/or copied with the written permission
 * from Ericsson AB or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s)
 * have been supplied.
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
