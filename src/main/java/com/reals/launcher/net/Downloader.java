package com.reals.launcher.net;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Faylları Yükləyici
 */
public class Downloader {
    private static final Logger logger = LoggerFactory.getLogger(Downloader.class);
    private static final OkHttpClient client = new OkHttpClient();

    public static void download(String url, File destination) throws Exception {
        logger.info("⬇️ Yüklənir: {} -> {}", url, destination.getName());

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception("Yüklə xətası: " + response.code());
            }

            try (InputStream inputStream = response.body().byteStream();
                 FileOutputStream outputStream = new FileOutputStream(destination)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }

            logger.info("✅ Yükləndi: {}", destination.getName());
        }
    }
}