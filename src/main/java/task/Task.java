package task;

import ducky.Ducky;

import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;
    private static final String TYPE = "[T]";

    public Task() {
        description = "";
        isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    //List down all existing tasks
    public static void listAllTasks(int taskCount, ArrayList<Task> taskList) {
        Ducky.printBorder();
        System.out.println("    Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.print("    " + (i + 1) + "." + taskList.get(i).getType() + taskList.get(i).getStatusIcon() + " " + taskList.get(i).description);
            if (taskList.get(i).getType().equals("[D]")) {
                System.out.println(" (By: " + taskList.get(i).getDeadline() + ")");
            } else if (taskList.get(i).getType().equals("[E]")) {
                System.out.println(" (From: " + taskList.get(i).getEventStart() + " To: " + taskList.get(i).getEventEnd() + ")");
            } else {
                System.out.println();
            }
        }
        Ducky.printBorder();
    }

    //Unmark a task to show that it is not done
    public static void unmarkTask(String line, int taskCount, ArrayList<Task> taskList) {
        int taskIndex;
        taskIndex = Integer.parseInt(line.substring(6).trim());
        if (taskIndex <= 0 || taskIndex > taskCount) {
            System.out.println("Please enter a valid task index");
            return;
        }
        taskList.get(taskIndex - 1).setDone(false);
        Ducky.printBorder();
        System.out.println("    OK, I've marked this task as not done yet:");
        System.out.println("    " + taskList.get(taskIndex - 1).getType() + taskList.get(taskIndex - 1).getStatusIcon() + " " + taskList.get(taskIndex - 1).description);
        Ducky.printBorder();
    }

    //Mark a task to show that it is done
    public static void markTask(String line, int taskCount, ArrayList<Task> taskList) {
        int taskIndex;
        taskIndex = Integer.parseInt(line.substring(4).trim());
        if (taskIndex <= 0 || taskIndex > taskCount) {
            System.out.println("Please enter a valid task index");
            return;
        }
        taskList.get(taskIndex - 1).setDone(true);
        Ducky.printBorder();
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("    " + taskList.get(taskIndex - 1).getType() + taskList.get(taskIndex - 1).getStatusIcon() + " " + taskList.get(taskIndex - 1).description);
        Ducky.printBorder();
    }

    //Getters and setters
    public void setDone(Boolean value) {
        this.isDone = value;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }

    public String getType() {
        return TYPE;
    }

    public String getDeadline() {
        return "";
    }

    public String getEventStart() {
        return "";
    }

    public String getEventEnd() {
        return "";
    }
}
