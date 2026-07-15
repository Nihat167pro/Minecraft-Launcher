package com.reals.launcher.ui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Hesablar Paneli
 */
public class AccountsPanel extends JPanel {
    private JList<String> accountsList;
    private DefaultListModel<String> accountsListModel;

    public AccountsPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(30, 30, 30));

        // Başlıq
        JLabel titleLabel = new JLabel("👤 Minecraft Hesabları");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(30, 144, 255));

        // Hesablar Siyahısı
        accountsListModel = new DefaultListModel<>();
        accountsList = new JList<>(accountsListModel);
        accountsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(accountsList);

        // Düymələr Paneli
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonsPanel.setBackground(new Color(40, 40, 40));

        JButton addAccountButton = new JButton("➕ Hesab Əlavə Et");
        addAccountButton.setFont(new Font("Arial", Font.BOLD, 12));
        addAccountButton.setBackground(new Color(50, 205, 50));
        addAccountButton.setForeground(Color.WHITE);
        addAccountButton.addActionListener(e -> addAccount());

        JButton removeAccountButton = new JButton("❌ Sil");
        removeAccountButton.setFont(new Font("Arial", Font.BOLD, 12));
        removeAccountButton.setBackground(new Color(220, 20, 60));
        removeAccountButton.setForeground(Color.WHITE);
        removeAccountButton.addActionListener(e -> removeAccount());

        JButton microsoftLoginButton = new JButton("🔐 Microsoft ile Giriş");
        microsoftLoginButton.setFont(new Font("Arial", Font.BOLD, 12));
        microsoftLoginButton.setBackground(new Color(0, 102, 204));
        microsoftLoginButton.setForeground(Color.WHITE);
        microsoftLoginButton.addActionListener(e -> microsoftLogin());

        buttonsPanel.add(addAccountButton);
        buttonsPanel.add(microsoftLoginButton);
        buttonsPanel.add(removeAccountButton);

        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        // Nümunə Hesablar Əlavə Et
        accountsListModel.addElement("Oflayn: Player");
        accountsListModel.addElement("Microsoft: user@outlook.com");
    }

    private void addAccount() {
        String accountName = JOptionPane.showInputDialog(this, "Hesab adını daxil edin:");
        if (accountName != null && !accountName.trim().isEmpty()) {
            accountsListModel.addElement("Oflayn: " + accountName);
        }
    }

    private void removeAccount() {
        int selectedIndex = accountsList.getSelectedIndex();
        if (selectedIndex >= 0) {
            accountsListModel.remove(selectedIndex);
        }
    }

    private void microsoftLogin() {
        JOptionPane.showMessageDialog(this, "🔐 Microsoft Giriş prosesi başlanacaq...", "Microsoft Giriş", JOptionPane.INFORMATION_MESSAGE);
        // Microsoft OAuth 2.0 inteqrasiyası burada
    }
}