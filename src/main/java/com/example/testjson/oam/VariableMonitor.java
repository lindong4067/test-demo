/*
 *         File : VariableMonitor.java
 *    Classname : VariableMonitor
 *    Author(s) : EZNLZHI
 *      Created : 2018-11-13
 *
 *
 */

package com.example.testjson.oam;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VariableMonitor {
    public static void startMonitor() {
    String SITE_EXPORT_DIR = "path";
        File directory = new File(SITE_EXPORT_DIR);
        long interval = TimeUnit.SECONDS.toMillis(10);
        FileAlterationObserver observer = new FileAlterationObserver(directory, FileFilterUtils.and(
                FileFilterUtils.fileFileFilter(), FileFilterUtils.suffixFileFilter(".export")));
        observer.addListener(new VariableListener());
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        try {
            monitor.start();
            log.debug("Variable Monitor Start.");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
