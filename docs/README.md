# Ducky User Guide

Ducky is a chatbot assistant to help you manage and keep track of your tasks, similar to a to-do list. Given below are instructions on how to use it.

## Quick-Start

1. Copy the jar file into an empty folder.
1. Open a command window in that folder.
1. Run the command java -jar "{filename}.jar" (i.e., run the command in the same folder as the jar file).<br/>
   For example if the filename is "ip.jar":
   ```
   java -jar ip.jar
   ```
1. After that, if the setup is correct, you should see something like the below as the output:
   ```
   ____________________________________________________________
    Hello! I'm Ducky!
    What can I do for you?
    ____________________________________________________________
   ```
## Commands Available
Ducky supports the following commands to help manage your tasks.<br/>

| Command | Format | Description | Note |
|---------|--------|-------------|------|
| `todo` | `todo <task_description>` | Adds a to-do task | All inputs are compulsory |
| `deadline` | `deadline <task_description> /by <YYYY-MM-DD> ` | Adds a task with a deadline | All inputs are compulsory |
| `event` | `event <task_description> /from <start_date_and_time> /to <end_date_and_time>` | Adds an event with start and end times | All inputs are compulsory |
| `delete` | `delete <task_index>` | Deletes a task from the list | <task_index> is based on the index shown in `list` |
| `find` | `find <key_words>` | Finds and lists all tasks containing the key word(s) | Multiple keywords accepted |
| `list` | `list` | Displays all tasks in the current list |
| `mark` | `mark <task_index>` | Marks a task as done | <task_index> is based on the index shown in `list` |
| `unmark` | `unmark <task_index>` | Unmarks a task as not done | <task_index> is based on the index shown in `list` |
| `bye` | `bye` | Ends the program |
## Command Examples
Add todo task: `todo Buy groceries`<br/>
```
Got it. I've added this Todo:
[T][ ] Buy groceries
Now you have 1 tasks in your list.
```
Add task with deadline: `deadline Complete math assignment /by 2025-02-09`<br/>
```
Got it. I've added this Deadline:
[D][ ] Complete math assignment (By: Feb 9 2025)
Now you have 2 tasks in your list.
```
Add an event: `event Urgent meeting /from 7pm Today /to 9pm Today`<br/>
```
Got it. I've added this Event:
[E][ ] Urgent meeting  (From: 7pm Today  To: 9pm Today)
Now you have 3 tasks in your list.
```
Delete task with index 3: `delete 3`<br/>
```
I've deleted this task:
[E][ ] Urgent meeting  (From: 7pm Today  To: 9pm Today)
Now you have 2 tasks in your list!
```
Find tasks containing keyword "Buy": `find Buy`<br/>
```
Matching tasks found:
1. [T][ ] Buy groceries
```
Display all tasks: `list`<br/>
```
Here are the tasks in your list:
1. [T][ ] Buy groceries
2. [D][ ] Complete math assignment (By: Feb 9 2025)
```
Mark task with index 2 as done: `mark 2`<br/>
```
Nice! I've marked this task as done:
[D][X] Complete math assignment (By: Feb 9 2025)
```
Unmark task with index 2 as not done: `unmark 2`<br/>
```
OK, I've marked this task as not done yet:
[D][ ] Complete math assignment (By: Feb 9 2025)
```
End the program: `bye`<br/>
```
Bye. Hope to see you again soon!
```