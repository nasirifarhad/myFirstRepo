package loggers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.slf4j.LoggerFactory;
import org.testng.log4testng.Logger;

public class LoggingClass {

    public static void main(String[] args) {
        //Log4j
        Logger log4jLogger = Logger.getLogger(LoggingClass.class);
        log4jLogger.info("This is Log4j here");

        //Log4j version2
        //there is lots of LogManager classes, make sure import the right one otherwise wont work
        org.apache.logging.log4j.Logger log4jv2 = LogManager.getLogger(LoggingClass.class);
        log4jv2.info("This is Log4j version 2");

        //java util logging
        java.util.logging.Logger jULogger = java.util.logging.Logger.getLogger(LoggingClass.class.getName());
        jULogger.info("This is java util logger");

        //Apache commons logger
        Log apachecl = LogFactory.getLog(LoggingClass.class);
        apachecl.info("this is Apache commons logger");

        //slf logger
        org.slf4j.Logger logger = LoggerFactory.getLogger(LoggingClass.class);
        logger.info("SLF4j rule them all");



    }
}
