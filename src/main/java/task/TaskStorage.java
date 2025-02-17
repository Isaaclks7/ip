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
        File f = new File("data/DuckyList.txt");
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String line = s.nextLine();
            String taskType = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
            boolean isDone = line.contains("[X]");
            String description = "";
            switch (taskType) {
            case "T":
                description = line.substring(line.indexOf("-") + 1);
                taskList.add(new Todo(description, isDone));
                break;
            case "D":
                    description = line.substring(line.indexOf("-") + 1, line.indexOf(" By: "));
                    String deadline = line.substring(line.indexOf("By: ") + 4);
                    taskList.add(new Deadline(description, isDone, deadline));
                break;
            case "E":
                description = line.substring(line.indexOf("-") + 1, line.indexOf(" From: "));
                String from = line.substring(line.indexOf("From: ") + 6, line.indexOf("To: "));
                String to = line.substring(line.indexOf(" To: ") + 5);
                taskList.add(new Event(description, isDone, from, to));
                break;
            default:
                Ducky.printBorder();
                System.out.println("    Error loading tasks");
                Ducky.printBorder();
                return;
            }
        }
    }

    public static void addTaskToFile(Task task, int index) {
        File f = new File("data/DuckyList.txt");
        File parentDir = f.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();  // This will create 'data' and any missing parent directories
        }
        try {
            if (!f.exists()) {
                boolean isCreated = f.createNewFile();
                if (!isCreated) {
                    System.out.println("Error creating file, please try again.");
                }
            }
            FileWriter fw = new FileWriter(f, true);

            fw.write(index + ". " + task.getType() + task.getStatusIcon() + " - " + task.getDescription());
            switch (task.getType()) {
            case "[T]":
                fw.write(System.lineSeparator());
                break;
            case "[D]":
                fw.write(" By: " + task.getDeadline() + System.lineSeparator());
                break;
            case "[E]":
                fw.write("From: " + task.getEventStart() + "To: " + task.getEventEnd() + System.lineSeparator());
                break;
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateTaskFile(ArrayList<Task> taskList) {
        File f = new File("data/DuckyList.txt");
        try {
            FileWriter fw = new FileWriter(f);
            int taskIndex = 1;
            for (Task task : taskList) {
                fw.write(taskIndex + ". " + task.getType() + task.getStatusIcon() + " - " + task.getDescription());
                taskIndex++;
                switch (task.getType()) {
                case "[T]":
                    fw.write(System.lineSeparator());
                    break;
                case "[D]":
                    fw.write(" By: " + task.getDeadline() + System.lineSeparator());
                    break;
                case "[E]":
                    fw.write(" From: " + task.getEventStart() + "To: " + task.getEventEnd() + System.lineSeparator());
                    break;
                default:
                    Ducky.printBorder();
                    System.out.println("    Error updating task");
                    Ducky.printBorder();
                    fw.close();
                    return;
                }
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
