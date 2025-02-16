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

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    //List down all existing tasks
    public static void listAllTasks(int taskCount, ArrayList<Task> taskList) {
        Ducky.printBorder();
        System.out.println("    Here are the tasks in your list:");
        for (Task task : taskList) {
            System.out.print("    " + (taskList.indexOf(task) + 1) + "." + task.getType() + task.getStatusIcon() + " " + task.description);
            if (task.getType().equals("[D]")) {
                System.out.println(" (By: " + task.getDeadline() + ")");
            } else if (task.getType().equals("[E]")) {
                System.out.println(" (From: " + task.getEventStart() + " To: " + task.getEventEnd() + ")");
            } else {
                System.out.println();
            }
        }
        Ducky.printBorder();
    }

    //Unmark a task to show that it is not done
    public static void unmarkTask(String line, ArrayList<Task> taskList) {
        try {
            int taskIndex;
            taskIndex = Integer.parseInt(line.substring(6).trim());

            Task task = taskList.get(taskIndex - 1);

            taskList.get(taskIndex - 1).setDone(false);
            Ducky.printBorder();
            System.out.println("    OK, I've marked this task as not done yet:");
            System.out.println("    " + task.getType() + task.getStatusIcon() + " " + task.description);
            Ducky.printBorder();
        } catch (Exception e) {
            System.out.println("Please enter a valid task index");
        }
    }

    //Mark a task to show that it is done
    public static void markTask(String line, ArrayList<Task> taskList) {
        try {
            int taskIndex;
            taskIndex = Integer.parseInt(line.substring(4).trim());

            Task task = taskList.get(taskIndex - 1);

            taskList.get(taskIndex - 1).setDone(true);
            Ducky.printBorder();
            System.out.println("    Nice! I've marked this task as done:");
            System.out.println("    " + task.getType() + task.getStatusIcon() + " " + task.description);
            Ducky.printBorder();
        } catch (Exception e) {
            System.out.println("Please enter a valid task index");
        }
    }

    public static void deleteTask(String line, ArrayList<Task> taskList) {
        int taskIndex;
        taskIndex = Integer.parseInt(line.substring(6).trim());

        try {
            Task task = taskList.get(taskIndex - 1);
            taskList.remove(taskIndex - 1);
            Ducky.printBorder();
            System.out.println("    I've deleted this task:");
            System.out.println("      " + task.getType() + task.getStatusIcon() + " " + task.getDescription());
            System.out.println("    " + "Now you have " + taskList.size() + " tasks in your list!");
            Ducky.printBorder();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter a valid task index");
        }
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
