package com.reals.launcher.ui;

import com.reals.launcher.ui.panels.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

/**
 * REALS Launcher Ana UI
 */
public class LauncherUI extends JFrame {
    private static final Logger logger = LoggerFactory.getLogger(LauncherUI.class);
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 650;

    private JTabbedPane tabbedPane;
    private HomePanel homePanel;
    private SettingsPanel settingsPanel;
    private ModsPanel modsPanel;
    private AccountsPanel accountsPanel;

    public LauncherUI() {
        setTitle("REALS Minecraft Launcher v1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/assets/icon.png")).getImage());

        initComponents();
        logger.info("✅ LauncherUI açılışı tamamlandı");
    }

    private void initComponents() {
        // Tabbed Pane
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 12));

        // Panelləri əlavə edin
        homePanel = new HomePanel();
        settingsPanel = new SettingsPanel();
        modsPanel = new ModsPanel();
        accountsPanel = new AccountsPanel();

        tabbedPane.addTab("🏠 Ev", homePanel);
        tabbedPane.addTab("⚙️ Ayarlar", settingsPanel);
        tabbedPane.addTab("📦 Modlar", modsPanel);
        tabbedPane.addTab("👤 Hesablar", accountsPanel);

        add(tabbedPane);
    }
}