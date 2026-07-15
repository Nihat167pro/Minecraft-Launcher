package com.reals.launcher.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Oyun Başlatıcısı
 */
public class GameLauncher {
    private static final Logger logger = LoggerFactory.getLogger(GameLauncher.class);
    private static final String MINECRAFT_DIR = System.getProperty("user.home") + "/.minecraft";

    public void launch(String version, String account, int ram) throws IOException {
        logger.info("🎮 Oyun Başlanıyor: Versiya={}, Hesab={}, RAM={}MB", version, account, ram);

        String javaPath = "java";
        StringBuilder command = new StringBuilder();
        command.append(javaPath)
                .append(" -Xmx").append(ram).append("M")
                .append(" -Xms").append(ram / 2).append("M")
                .append(" -XX:+UseG1GC")
                .append(" -XX:MaxGCPauseMillis=200")
                .append(" -Dfml.ignoreInvalidMinecraftCertificates=true")
                .append(" -cp ").append(buildClassPath(version))
                .append(" net.minecraft.client.main.Main");

        try {
            ProcessBuilder pb = new ProcessBuilder("bash", "-c", command.toString());
            pb.directory(new File(MINECRAFT_DIR));
            Process process = pb.start();
            logger.info("✅ Oyun başladı. PID: {}", process.pid());
        } catch (Exception e) {
            logger.error("❌ Oyun başlanma xətası: ", e);
            throw e;
        }
    }

    private String buildClassPath(String version) {
        return MINECRAFT_DIR + "/libraries/*:" + MINECRAFT_DIR + "/versions/" + version + "/" + version + ".jar";
    }
}