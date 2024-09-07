package main.java.model;

import java.net.HttpURLConnection;
import java.net.URL;

import static main.java.model.Client.BASE_URL;
import static main.java.model.Client.getResponse;

public class ToDo {
    public static String getOpenTodos(int userId) throws Exception {
        URL url = new URL(BASE_URL + "/" + userId + "/todos");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        String todosResponse = getResponse(conn);
        String openTodos = extractOpenTodos(todosResponse);
        return openTodos;
    }

    private static String extractOpenTodos(String todosResponse) {
        String[] tasks = todosResponse.split("\\},\\{");
        StringBuilder openTasks = new StringBuilder();

        for (String task : tasks) {
            // Перевіряємо, чи task містить "completed": false
            boolean isCompleted = task.contains("\"completed\": false");
            if (isCompleted) {
                // Якщо задача відкрита, додаємо її до результату
                openTasks.append("{").append(task).append("},\n");
            }
        }

        if (openTasks.length() > 0) {
            openTasks.setLength(openTasks.length() - 2);
        }

        return openTasks.toString();
    }
}
