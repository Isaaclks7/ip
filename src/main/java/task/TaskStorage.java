package task;

import ducky.Parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskStorage {
    public static void addTaskToFile(Task task) {
        File f = new File("src/main/java/ducky/DuckyList.txt");
        try {
            if (!f.exists()) {
                boolean isCreated = f.createNewFile();
                if (!isCreated) {
                    System.out.println("Error creating file, please try again.");
                }
            }
            FileWriter fw = new FileWriter(f, true);

            fw.write(task.getType() + task.getStatusIcon() + task.getDescription());
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
}
