package com.reals.launcher;

import com.reals.launcher.ui.LauncherUI;
import com.reals.launcher.utils.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

/**
 * REALS Minecraft Launcher - Ana Giriş Nöqtəsi
 * Azərbaycan Minecraft Launcher - Real Versiyası
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("🎮 REALS Minecraft Launcher Başlanıyor...");
        
        try {
            // Config yükləyin
            ConfigManager.loadConfig();
            logger.info("✅ Konfiqurasiya yükləndi");

            // UI-ı SwingUtilities-də başladın
            SwingUtilities.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    LauncherUI launcher = new LauncherUI();
                    launcher.setVisible(true);
                    logger.info("✅ Launcher UI başladı");
                } catch (Exception e) {
                    logger.error("❌ UI başlanma xətası: ", e);
                    JOptionPane.showMessageDialog(null, 
                        "Launcher başlanarkən xəta baş verdi: " + e.getMessage(),
                        "Xəta",
                        JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }
            });
        } catch (Exception e) {
            logger.error("❌ Fatal xəta: ", e);
            System.exit(1);
        }
    }
}