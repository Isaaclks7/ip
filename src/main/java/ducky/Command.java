package ducky;

import task.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Command class Handles different types of commands.
 */
public class Command {

    /**
     * Executes the specified type of command.
     *
     * @param in User's input containing the command details.
     * @param taskList Current list of all added tasks.
     */
    public static void executeCommands(Scanner in, ArrayList<Task> taskList) {
        String line;
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
        Ui.printByeMsg();
    }

}
