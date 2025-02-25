package ducky;

import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;
import task.TaskStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

import ducky.Ui;

public class Ducky {
    public static void main(String[] args) {
        Ui.printWelcomeMsg();

        Scanner in = new Scanner(System.in);
        String line;
        ArrayList<Task> taskList = new ArrayList<>();

        //Load already stored tasks into current list
        try {
            TaskStorage.loadData(taskList);
        } catch (FileNotFoundException e) {
            System.out.println("    Add your tasks!");
        }

        //Handle different commands
        Command.executeCommands(in, taskList);
    }
}
