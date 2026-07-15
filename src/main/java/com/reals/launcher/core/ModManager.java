package com.reals.launcher.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Mod İdarəsi
 */
public class ModManager {
    private static final Logger logger = LoggerFactory.getLogger(ModManager.class);
    private static final String MODS_DIR = System.getProperty("user.home") + "/.minecraft/mods";

    public ModManager() {
        new File(MODS_DIR).mkdirs();
    }

    public void addMod(File modFile) {
        try {
            File destination = new File(MODS_DIR, modFile.getName());
            Files.copy(modFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            logger.info("✅ Mod əlavə edildi: {}", modFile.getName());
        } catch (IOException e) {
            logger.error("❌ Mod əlavə edilə xətası: ", e);
        }
    }

    public void removeMod(String modName) {
        File modFile = new File(MODS_DIR, modName);
        if (modFile.delete()) {
            logger.info("✅ Mod silindi: {}", modName);
        } else {
            logger.error("❌ Mod silinə bilinmədi: {}", modName);
        }
    }

    public List<String> getInstalledMods() {
        List<String> mods = new ArrayList<>();
        File[] files = new File(MODS_DIR).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".jar")) {
                    mods.add(file.getName());
                }
            }
        }
        return mods;
    }

    public void openModsFolder() {
        try {
            Desktop.getDesktop().open(new File(MODS_DIR));
        } catch (IOException e) {
            logger.error("❌ Modlar qovluğu açıla bilinmədi: ", e);
        }
    }
}