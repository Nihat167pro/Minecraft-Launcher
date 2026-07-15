package com.reals.launcher.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Fayl Utilities
 */
public class FileUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static void deleteDirectory(File dir) throws IOException {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteDirectory(file);
                }
            }
        }
        if (!dir.delete()) {
            throw new IOException("Siliə bilinmədi: " + dir.getAbsolutePath());
        }
    }

    public static long getDirectorySize(File dir) {
        long size = 0;
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    size += getDirectorySize(file);
                }
            }
        } else {
            size = dir.length();
        }
        return size;
    }
}