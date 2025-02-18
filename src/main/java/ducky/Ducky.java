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

public class Ducky {
    public static void main(String[] args) {
        printBorder();
        System.out.println("    Hello! I'm Ducky!");
        System.out.println("    What can I do for you?");
        printBorder();

        Scanner in = new Scanner(System.in);
        String line;
        ArrayList<Task> taskList = new ArrayList<>();

        try {
            TaskStorage.loadData(taskList);
        } catch (FileNotFoundException e) {
            System.out.println("    Add your tasks!");
        }
        //Handle different commands
        while (true) {
            line = in.nextLine();

            if (line.isEmpty()) {
                continue;
            }

            Parser result = Parser.extract(line);
            if (result == null) {
                continue;
            }

            if (result.command.equals("bye")) {
                break;
            }

            int taskIndex;
            switch (result.command) {
            case "list":
                Task.listAllTasks(taskList);
                break;
            case "mark":
                Task.markTask(line, taskList);
                TaskStorage.updateTaskFile(taskList);
                break;
            case "unmark":
                Task.unmarkTask(line, taskList);
                TaskStorage.updateTaskFile(taskList);
                break;
            case "todo":
                Todo.addTodo(taskList, result);
                TaskStorage.addTaskToFile(taskList.get(taskList.size() - 1), taskList.size());
                break;
            case "deadline":
                Deadline.addDeadline(taskList, result);
                TaskStorage.addTaskToFile(taskList.get(taskList.size() - 1), taskList.size());
                break;
            case "event":
                Event.addEvent(taskList, result);
                TaskStorage.addTaskToFile(taskList.get(taskList.size() - 1), taskList.size());
                break;
            case "delete":
                Task.deleteTask(line, taskList);
                TaskStorage.updateTaskFile(taskList);
                break;
            default:
                DuckyException.showValidCommands();
                break;
            }
        }
        printBorder();
        System.out.println("    Bye. Hope to see you again soon!");
        printBorder();
    }

    //Method to print line separator
    public static void printBorder() {
        System.out.println("    ____________________________________________________________");
    }
}
