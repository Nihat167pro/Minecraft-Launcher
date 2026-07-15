package com.reals.launcher.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sistem Utilities
 */
public class SystemUtils {
    private static final Logger logger = LoggerFactory.getLogger(SystemUtils.class);

    public static String getOS() {
        return System.getProperty("os.name");
    }

    public static String getJavaVersion() {
        return System.getProperty("java.version");
    }

    public static long getTotalMemory() {
        return Runtime.getRuntime().totalMemory() / (1024 * 1024);
    }

    public static long getAvailableMemory() {
        return Runtime.getRuntime().freeMemory() / (1024 * 1024);
    }

    public static void printSystemInfo() {
        logger.info("===== Sistem Məlumatı =====");
        logger.info("OS: {}", getOS());
        logger.info("Java Versiyası: {}", getJavaVersion());
        logger.info("Ümumi RAM: {}MB", getTotalMemory());
        logger.info("Azad RAM: {}MB", getAvailableMemory());
        logger.info("=========================");
    }
}