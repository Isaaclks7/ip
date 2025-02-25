package task;

import ducky.Ducky;
import ducky.Ui;

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
    public static void listAllTasks(ArrayList<Task> taskList) {
        Ui.printBorder();
        System.out.println("    Here are the tasks in your list:");
        for (Task task : taskList) {
            System.out.println("    " + (taskList.indexOf(task) + 1) + ". " + task.toString());
        }
        Ui.printBorder();
    }

    //Unmark a task to show that it is not done
    public static void unmarkTask(String line, ArrayList<Task> taskList) {
        try {
            int taskIndex;
            taskIndex = Integer.parseInt(line.substring(6).trim());

            Task task = taskList.get(taskIndex - 1);

            taskList.get(taskIndex - 1).setDone(false);
            Ui.printBorder();
            System.out.println("    OK, I've marked this task as not done yet:");
            System.out.println("    " + task.toString());
            Ui.printBorder();
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
            Ui.printBorder();
            System.out.println("    Nice! I've marked this task as done:");
            System.out.println("    " + task.toString());
            Ui.printBorder();
        } catch (Exception e) {
            System.out.println("Please enter a valid task index");
            return;
        }
    }

    public static void deleteTask(String line, ArrayList<Task> taskList) {
        int taskIndex;
        taskIndex = Integer.parseInt(line.substring(6).trim());

        try {
            Task task = taskList.get(taskIndex - 1);
            taskList.remove(taskIndex - 1);
            Ui.printBorder();
            System.out.println("    I've deleted this task:");
            System.out.println("    " + task.toString());
            System.out.println("    " + "Now you have " + taskList.size() + " tasks in your list!");
            Ui.printBorder();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter a valid task index");
        }
    }

    public static void findTask(String line, ArrayList<Task> taskList) {
        String keyWord;
        try {
            keyWord = line.substring(4).trim().toLowerCase();
        } catch (Exception e) {
            System.out.println("Error looking for task");
            return;
        }
        Ui.printBorder();
        System.out.println("    Matching tasks found:");
        for (Task task : taskList) {
            if (task.getDescription().toLowerCase().contains(keyWord)) {
                System.out.println("    " + (taskList.indexOf(task)+1) + ". " + task.toString());
            }
        }
        Ui.printBorder();
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
