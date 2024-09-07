package main.java.model.task3;

import static main.java.model.ToDo.getOpenTodos;

public class Main {
    public static void main(String[] args) throws Exception {
        String openTodos = getOpenTodos(1);
        System.out.println("Open Todos for User 1: " + openTodos);
    }
}
