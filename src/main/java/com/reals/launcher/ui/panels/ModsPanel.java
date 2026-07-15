package com.reals.launcher.ui.panels;

import com.reals.launcher.core.ModManager;

import javax.swing.*;
import java.awt.*;

/**
 * Modlar Paneli
 */
public class ModsPanel extends JPanel {
    private ModManager modManager;
    private JList<String> modsList;
    private DefaultListModel<String> modsListModel;

    public ModsPanel() {
        modManager = new ModManager();
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(30, 30, 30));

        // Başlıq
        JLabel titleLabel = new JLabel("📦 Modlar");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(30, 144, 255));

        // Modlar Siyahısı
        modsListModel = new DefaultListModel<>();
        modsList = new JList<>(modsListModel);
        modsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(modsList);

        // Düymələr Paneli
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonsPanel.setBackground(new Color(40, 40, 40));

        JButton addButton = new JButton("➕ Mod Əlavə Et");
        addButton.setFont(new Font("Arial", Font.BOLD, 12));
        addButton.setBackground(new Color(50, 205, 50));
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> addMod());

        JButton removeButton = new JButton("❌ Sil");
        removeButton.setFont(new Font("Arial", Font.BOLD, 12));
        removeButton.setBackground(new Color(220, 20, 60));
        removeButton.setForeground(Color.WHITE);
        removeButton.addActionListener(e -> removeMod());

        JButton openModsFolderButton = new JButton("📁 Modlar Qovluğu");
        openModsFolderButton.setFont(new Font("Arial", Font.BOLD, 12));
        openModsFolderButton.addActionListener(e -> modManager.openModsFolder());

        buttonsPanel.add(addButton);
        buttonsPanel.add(removeButton);
        buttonsPanel.add(openModsFolderButton);

        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        refreshModsList();
    }

    private void addMod() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            modManager.addMod(fileChooser.getSelectedFile());
            refreshModsList();
        }
    }

    private void removeMod() {
        int selectedIndex = modsList.getSelectedIndex();
        if (selectedIndex >= 0) {
            modManager.removeMod(modsList.getSelectedValue());
            refreshModsList();
        }
    }

    private void refreshModsList() {
        modsListModel.clear();
        for (String mod : modManager.getInstalledMods()) {
            modsListModel.addElement(mod);
        }
    }
}