package main.java.model;

public class Post {
    public static String extractLastPostId(String postsResponse) {
        int lastIndex = postsResponse.lastIndexOf("\"id\":");
        int startIndex = postsResponse.indexOf(":", lastIndex) + 1;
        int endIndex = postsResponse.indexOf(",", startIndex);
        return postsResponse.substring(startIndex, endIndex).trim();
    }

}
