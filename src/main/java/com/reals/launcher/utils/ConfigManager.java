package com.reals.launcher.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Konfiqurasiya İdarəsi
 */
public class ConfigManager {
    private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);
    private static final String CONFIG_DIR = System.getProperty("user.home") + "/.reals-launcher";
    private static final String CONFIG_FILE = CONFIG_DIR + "/config.json";
    private static JsonObject config;

    public static void loadConfig() {
        try {
            new File(CONFIG_DIR).mkdirs();
            File configFile = new File(CONFIG_FILE);

            if (configFile.exists()) {
                Gson gson = new Gson();
                config = gson.fromJson(new FileReader(configFile), JsonObject.class);
                logger.info("✅ Konfiqurasiya yükləndi");
            } else {
                createDefaultConfig();
            }
        } catch (Exception e) {
            logger.error("❌ Konfiqurasiya yüklənə xətası: ", e);
            createDefaultConfig();
        }
    }

    private static void createDefaultConfig() {
        config = new JsonObject();
        config.addProperty("version", "1.0");
        config.addProperty("selectedVersion", "1.20.1");
        config.addProperty("ramMin", 512);
        config.addProperty("ramMax", 4096);
        config.addProperty("gameResolution", "1920x1080");
        config.addProperty("javaPath", "java");
        config.addProperty("autoUpdate", true);
        config.addProperty("language", "az");
        saveConfig();
    }

    public static void saveConfig() {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(CONFIG_FILE);
            gson.toJson(config, writer);
            writer.close();
            logger.info("✅ Konfiqurasiya saxlandı");
        } catch (Exception e) {
            logger.error("❌ Konfiqurasiya saxlanma xətası: ", e);
        }
    }

    public static JsonObject getConfig() {
        return config;
    }
}