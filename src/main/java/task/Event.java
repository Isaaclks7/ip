package task;

import ducky.Ducky;
import ducky.Parser;
import ducky.Ui;

import java.util.ArrayList;

/**
 * Subclass of Task class to handle Event-type tasks.
 */
public class Event extends Task {
    private String eventStart;
    private String eventEnd;
    private static final String TYPE = "[E]";

    /**
     * Constructor that creates a new Event object
     *
     * @param description The description of the event.
     * @param isDone The status of the event, whether it is marked as done or not.
     * @param startTime The start date/time of the event specified.
     * @param endTime The end date/time of the event specified.
     */
    public Event(String description, boolean isDone, String startTime, String endTime) {
        super(description, isDone);
        this.eventStart = startTime;
        this.eventEnd = endTime;
    }

    /**
     * Returns the Event object as a String in readable format.
     *
     * @return The Event's type, status icon, description, start and end dates/times of the event.
     */
    @Override
    public String toString(){
        return getType() + getStatusIcon() + " " + getDescription() + " (From: " + getEventStart() + " To: " + getEventEnd() + ")";
    }

    /**
     * Adds an Event Object to a list of Tasks.
     *
     * @param taskList The list of Tasks to store all the different types of tasks added.
     * @param result Parsed user's input which contains event details.
     */
    public static void addEvent(ArrayList<Task> taskList, Parser result) {
        taskList.add(new Event(result.description, false, result.eventStart, result.eventEnd));
        Ui.printBorder();
        System.out.println("    Got it. I've added this Event:");
        System.out.println("    " + taskList.get(taskList.size()-1).toString());
        System.out.println("    Now you have " + taskList.size() + " tasks in your list.");
        Ui.printBorder();
    }

    /**
     * Gets event's start date/time.
     *
     * @return The Event's start date/time.
     */
    @Override
    public String getEventStart() {
        return eventStart;
    }

    /**
     * Gets event's end date/time.
     *
     * @return The Event's end date/time.
     */
    @Override
    public String getEventEnd() {
        return eventEnd;
    }

    /**
     * Gets the task's type as an icon.
     *
     * @return The Event objects icon "[E]".
     */
    @Override
    public String getType() {
        return TYPE;
    }
}
