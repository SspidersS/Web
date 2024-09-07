package main.java.model;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static main.java.model.Client.BASE_URL;
import static main.java.model.Client.getResponse;

public class User {
    public static String createUser(String userJson) throws Exception {
        URL url = new URL(BASE_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = userJson.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        return getResponse(conn);
    }

    public static String updateUser(int id, String userJson) throws Exception {
        URL url = new URL(BASE_URL + "/" + id);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = userJson.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        return getResponse(conn);
    }

    public static int deleteUser(int id) throws Exception {
        URL url = new URL(BASE_URL + "/" + id);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");

        return conn.getResponseCode();  // Повертає код статусу (наприклад, 200)
    }

    public static String getAllUsers() throws Exception {
        URL url = new URL(BASE_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        return getResponse(conn);
    }

    public static String getUserById(int id) throws Exception {
        URL url = new URL(BASE_URL + "/" + id);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        return getResponse(conn);
    }

    public static String getUserByUsername(String username) throws Exception {
        URL url = new URL(BASE_URL + "?username=" + username);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        return getResponse(conn);
    }
}
