package com.reals.launcher.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Minecraft Versiyaları İdarəsi
 */
public class VersionManager {
    private static final Logger logger = LoggerFactory.getLogger(VersionManager.class);
    private static final String LAUNCHER_META_URL = "https://launchermeta.mojang.com/mc/game/version_manifest.json";

    public List<String> getAvailableVersions() {
        List<String> versions = new ArrayList<>();
        try {
            String json = readUrlContent(LAUNCHER_META_URL);
            JsonObject manifest = JsonParser.parseString(json).getAsJsonObject();
            JsonArray versionsArray = manifest.getAsJsonArray("versions");

            versionsArray.forEach(element -> {
                JsonObject versionObj = element.getAsJsonObject();
                String id = versionObj.get("id").getAsString();
                versions.add(id);
            });

            logger.info("✅ {} Minecraft versiyası tapıldı", versions.size());
        } catch (IOException e) {
            logger.error("❌ Versiyalar yükləniə xətası: ", e);
        }
        return versions;
    }

    private String readUrlContent(String urlString) throws IOException {
        URL url = new URL(urlString);
        return new String(url.openStream().readAllBytes());
    }
}