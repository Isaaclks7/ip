# Ducky User Guide

Ducky is a chatbot assistant app to help you manage and keep track of your tasks, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).
If you can type fast, Ducky can get your task management done faster than traditional GUI apps.<br/>

- [Quick start](#quick-start)
- [Features](#features)
  - [Adding a To-do task: `todo`](#adding-a-to-do-task-todo)
  - [Adding task with deadline: `deadline`](#adding-task-with-deadline-deadline)
  - [Adding an event: `event`](#adding-an-event-event)
  - [Deleting a task: `delete`](#deleting-a-task-delete)
  - [Finding tasks: `find`](#finding-tasks-find)
  - [Listing all tasks: `list`](#listing-all-tasks-list)
  - [Marking a task: `mark`](#marking-a-task-mark)
  - [Unmarking a task `unmark`](#unmarking-a-task-unmark)
  - [Exiting the program: `bye`](#exiting-the-program-bye)

## Quick start

1. Download the latest `.jar` file from [here](https://github.com/Isaaclks7/ip/releases/tag/A-Jar).
2. Copy the file to the folder you want to use as the home folder for your DuckyList (List of tasks).
3. Open a command terminal, `cd` into the folder you put the `.jar` file in.
4. Run the command `java -jar ip.jar`
5. If the setup is correct, you should see something like the following in a few seconds.
   ```
   ____________________________________________________________
    Hello! I'm Ducky!
    What can I do for you?
    ____________________________________________________________
   ```
6. Refer to the [Features](#Features) section for the different commands available.

## Features

Notes about the command format:<br/>
- Words in `UPPER_CASE` are the parameters to be supplied by the user.<br/>
   e.g. in `todo [DESCRIPTION]`, square brackets indicates that the input is required while `DESCRIPTION` is a parameter which can be used as `todo Buy groceries for dinner`.
- Additional parameters start with `/` are required to be followed by an input<br/>
   e.g. in `deadline [DESCRIPTION] /by [DEADLINE]`, `/by` is followed by the `[DEADLINE]` input which the task should be completed by.

## Adding a To-do task: `todo`

Adds a To-do task to the list of tasks.

Format: `todo [DESCRIPTION]`

Examples:<br/>
- `todo Buy groceries`<br/>

## Adding task with deadline: `deadline`

Adds a task with a deadline.<br/>

Format: `deadline [DESCRIPTION] /by [DEADLINE]`
- `DEADLINE` can be input as a string, number or a mix of both
- `DEADLINE` inputted as YYYY-MM-DD format (e.g. 2025-02-09) will be converted into MMM-dd-yyyy format (e.g. Feb 09 2025)

Examples:<br/>
- `deadline Complete CS2113 Assignment /by 2025-02-09`<br/>
- `deadline Watch Lecture videos /by 9pm Tonight`<br/>

## Adding an event: `event`

Adds an event with start and end dates/times.<br/>

Format: `event [DESCRIPTION] /from [START] /to [END]`

Examples:<br/>
- `event Urgent Meeting /from 5pm /to 7pm Tonight`<br/>

## Deleting a task: `delete`

Deletes an existing task from the task list.

Format: `delete [TASK_INDEX]`<br/>
- `TASK_INDEX` must exist in the list of tasks.

Examples:<br/>
- `delete 3`<br/>

## Finding tasks: `find`

Lists out all tasks containing `KEYWORD`.<br/>

Format: `find [KEYWORD]`
- `KEYWORD` can be multiple strings/numbers or a mix of both.

Examples:<br/>
- `find Urgent`

## Listing all tasks: `list`

Lists out all tasks in task list.<br/>

Format: `list`

## Marking a task: `mark`

Marks a task to show that it is completed.<br/>

Format: `mark [TASK_INDEX]`
- `TASK_INDEX` must exist in the list of tasks.

Examples:
- `mark 5`

## Unmarking a task `unmark`

Unmarks a task to show that it is not completed.<br/>

Format: `unmark [TASK_INDEX]`
- `TASK_INDEX` must exist in the list of tasks.

Examples:
- `unmark 5`

## Exiting the program: `bye`

Exits the program.<br/>

Format: `bye`
