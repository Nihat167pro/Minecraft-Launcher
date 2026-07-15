package com.reals.launcher.ui.panels;

import com.reals.launcher.utils.ConfigManager;

import javax.swing.*;
import java.awt.*;

/**
 * Ayarlar Paneli
 */
public class SettingsPanel extends JPanel {

    public SettingsPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(30, 30, 30));

        // Başlıq
        JLabel titleLabel = new JLabel("⚙️ Ayarlar");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(30, 144, 255));

        // Ayarlar Paneli
        JPanel settingsPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        settingsPanel.setBackground(new Color(40, 40, 40));
        settingsPanel.setBorder(BorderFactory.createTitledBorder("Launcher Ayarları"));

        // Java Yolu
        settingsPanel.add(new JLabel("Java Yolu:"));
        JTextField javaPathField = new JTextField(ConfigManager.getConfig().getAsJsonObject().get("javaPath").getAsString());
        settingsPanel.add(javaPathField);

        // JVM Arqumentləri
        settingsPanel.add(new JLabel("JVM Arqumentləri:"));
        JTextField jvmArgsField = new JTextField("-XX:+UseG1GC -XX:MaxGCPauseMillis=200");
        settingsPanel.add(jvmArgsField);

        // Dil Seçimi
        settingsPanel.add(new JLabel("Dil:"));
        JComboBox<String> languageCombo = new JComboBox<>(new String[]{"Azərbaycanca", "English", "Türkçe", "Русский"});
        settingsPanel.add(languageCombo);

        // Auto Update
        settingsPanel.add(new JLabel("Avtomatik Güncəllə:"));
        JCheckBox autoUpdateCheckbox = new JCheckBox("", true);
        settingsPanel.add(autoUpdateCheckbox);

        // Debug Mode
        settingsPanel.add(new JLabel("Debug Mode:"));
        JCheckBox debugCheckbox = new JCheckBox("", false);
        settingsPanel.add(debugCheckbox);

        // Saxla Düyməsi
        JButton saveButton = new JButton("💾 Saxla");
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
        saveButton.setBackground(new Color(50, 205, 50));
        saveButton.setForeground(Color.WHITE);
        saveButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "✅ Ayarlar saxlandı!", "Uğurlu", JOptionPane.INFORMATION_MESSAGE);
        });

        add(titleLabel, BorderLayout.NORTH);
        add(new JScrollPane(settingsPanel), BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);
    }
}