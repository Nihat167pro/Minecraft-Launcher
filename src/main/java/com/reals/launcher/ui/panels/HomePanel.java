package com.reals.launcher.ui.panels;

import com.reals.launcher.core.GameLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Ev Paneli - Oyunu Başlatma
 */
public class HomePanel extends JPanel {
    private static final Logger logger = LoggerFactory.getLogger(HomePanel.class);

    private JComboBox<String> versionCombo;
    private JComboBox<String> accountCombo;
    private JLabel ramLabel;
    private JSlider ramSlider;
    private JButton launchButton;
    private JLabel statusLabel;
    private GameLauncher gameLauncher;

    public HomePanel() {
        gameLauncher = new GameLauncher();
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(30, 30, 30));

        // Başlıq
        JLabel titleLabel = new JLabel("🎮 Minecraft Başlat");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(30, 144, 255));

        // Orta Panel
        JPanel centerPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        centerPanel.setBackground(new Color(40, 40, 40));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Oyun Ayarları"));

        // Versiya Seçimi
        JPanel versionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        versionPanel.add(new JLabel("Minecraft Versiyası:"));
        versionCombo = new JComboBox<>(new String[]{"1.8.9", "1.12.2", "1.16.5", "1.19.2", "1.20.1"});
        versionPanel.add(versionCombo);
        centerPanel.add(versionPanel);

        // Hesab Seçimi
        JPanel accountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        accountPanel.add(new JLabel("Hesab:"));
        accountCombo = new JComboBox<>(new String[]{"Oflayn", "Microsoft Account", "Digər Hesab"});
        accountPanel.add(accountCombo);
        centerPanel.add(accountPanel);

        // RAM Seçimi
        JPanel ramPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ramLabel = new JLabel("RAM: 2GB");
        ramSlider = new JSlider(JSlider.HORIZONTAL, 512, 16384, 2048);
        ramSlider.setMajorTickSpacing(2048);
        ramSlider.setPaintTicks(true);
        ramSlider.addChangeListener(e -> ramLabel.setText("RAM: " + (ramSlider.getValue() / 1024) + "GB"));
        ramPanel.add(ramLabel);
        ramPanel.add(ramSlider);
        centerPanel.add(ramPanel);

        // Status Label
        statusLabel = new JLabel("Hazırlasan...");
        statusLabel.setForeground(new Color(50, 205, 50));
        centerPanel.add(statusLabel);

        // Başlat Düyməsi
        launchButton = new JButton("▶️ OYUNU BAŞLAT");
        launchButton.setFont(new Font("Arial", Font.BOLD, 16));
        launchButton.setBackground(new Color(30, 144, 255));
        launchButton.setForeground(Color.WHITE);
        launchButton.addActionListener(this::onLaunchButtonClicked);

        add(titleLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(launchButton, BorderLayout.SOUTH);
    }

    private void onLaunchButtonClicked(ActionEvent e) {
        String version = (String) versionCombo.getSelectedItem();
        String account = (String) accountCombo.getSelectedItem();
        int ram = ramSlider.getValue();

        statusLabel.setText("⏳ Oyun başlanıyor: " + version + " (RAM: " + (ram / 1024) + "GB)");
        logger.info("🎮 Oyun başlanıyor: {} | Hesab: {} | RAM: {}MB", version, account, ram);

        new Thread(() -> {
            try {
                gameLauncher.launch(version, account, ram);
                statusLabel.setText("✅ Oyun başarıyla başladı!");
            } catch (Exception ex) {
                logger.error("❌ Oyun başlanma xətası", ex);
                statusLabel.setText("❌ Xəta: " + ex.getMessage());
            }
        }).start();
    }
}