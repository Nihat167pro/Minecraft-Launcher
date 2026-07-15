package com.reals.launcher.core;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Hesab İdarəsi
 */
public class AccountManager {
    private static final Logger logger = LoggerFactory.getLogger(AccountManager.class);
    private Map<String, JsonObject> accounts = new HashMap<>();

    public void addAccount(String username, String accessToken, String uuid) {
        JsonObject account = new JsonObject();
        account.addProperty("username", username);
        account.addProperty("accessToken", accessToken);
        account.addProperty("uuid", uuid);
        account.addProperty("type", "microsoft");
        
        accounts.put(username, account);
        logger.info("✅ Hesab əlavə edildi: {}", username);
    }

    public JsonObject getAccount(String username) {
        return accounts.get(username);
    }

    public void removeAccount(String username) {
        accounts.remove(username);
        logger.info("✅ Hesab silindi: {}", username);
    }
}