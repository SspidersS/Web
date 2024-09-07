package main.java.model;

import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static main.java.model.Client.BASE_URL;
import static main.java.model.Client.getResponse;
import static main.java.model.Post.extractLastPostId;

public class Comment {
    public static void saveCommentsOfLastPost(int userId) throws Exception {
        URL url = new URL(BASE_URL + "/" + userId + "/posts");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        String postsResponse = getResponse(conn);
        String lastPostId = extractLastPostId(postsResponse);

        url = new URL("https://jsonplaceholder.typicode.com/posts/" + lastPostId + "/comments");
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        String commentsResponse = getResponse(conn);

        String filename = "user-" + userId + "-post-" + lastPostId + "-comments.json";
        try (FileWriter file = new FileWriter(filename)) {
            file.write(commentsResponse);
        }

        System.out.println("Comments saved to file: " + filename);
    }
}
