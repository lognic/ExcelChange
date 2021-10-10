package com.log.excelchange.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static void info(String tag, String msg) {
        logger.info("[" + tag + "] " + msg);
    }

    public static void debug(String tag, String msg) {
        logger.debug("[" + tag + "] " + msg);
    }

    public static void error(String tag, String msg) {
        logger.error("[" + tag + "] " + msg);
    }

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void debug(String msg) {
        logger.debug(msg);
    }

    public static void error(String msg) {
        logger.error(msg);
    }
}
