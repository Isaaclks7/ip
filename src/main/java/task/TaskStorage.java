package task;

import ducky.Ducky;
import ducky.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskStorage {

    public static void loadData(ArrayList<Task> taskList) throws FileNotFoundException {
        File f = new File("src/main/java/ducky/DuckyList.txt");
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String line = s.nextLine();
            String taskType = line.substring(4,5);
            boolean isDone = line.contains("[X]");
            String description = "";
            switch (taskType) {
            case "T":
                description = line.substring(10);
                taskList.add(new Todo(description, isDone));
                break;
            case "D":
                    description = line.substring(10, line.indexOf(" By: "));
                    String deadline = line.substring(line.indexOf("By: ") + 4);
                    taskList.add(new Deadline(description, isDone, deadline));
                break;
            case "E":
                description = line.substring(10, line.indexOf(" From: "));
                String from = line.substring(line.indexOf(" From: ") + 7, line.indexOf(" To: "));
                String to = line.substring(line.indexOf(" To: ") + 5);
                taskList.add(new Event(description, isDone, from, to));
                break;
            default:
                Ducky.printBorder();
                System.out.println("    Error loading tasks");
                Ducky.printBorder();
                break;
            }
        }
    }

    public static void addTaskToFile(Task task, int index) {
        File f = new File("src/main/java/ducky/DuckyList.txt");
        try {
            if (!f.exists()) {
                boolean isCreated = f.createNewFile();
                if (!isCreated) {
                    System.out.println("Error creating file, please try again.");
                }
            }
            FileWriter fw = new FileWriter(f, true);

            fw.write(index + ". " + task.getType() + task.getStatusIcon() + " " + task.getDescription());
            switch (task.getType()) {
            case "[T]":
                fw.write(System.lineSeparator());
                break;
            case "[D]":
                fw.write(" By: " + task.getDeadline() + System.lineSeparator());
                break;
            case "[E]":
                fw.write("From: " + task.getEventStart() + " To: " + task.getEventEnd() + System.lineSeparator());
                break;
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateTaskFile(Task task, int taskIndex) {
        File f = new File("src/main/java/ducky/DuckyList.txt");
        try {
            if (!f.exists()) {
                boolean isCreated = f.createNewFile();
                if (!isCreated) {
                    System.out.println("Error creating file, please try again.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
