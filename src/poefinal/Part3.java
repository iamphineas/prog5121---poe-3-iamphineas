/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poefinal;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * The Part3 class represents a task management system.
 */
public class Part3 {

    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;
    private int taskNumber;
    private String taskID;
    private static int totalHours;
    public static ArrayList<Part3> tasks = new ArrayList<>();

    public Part3(String taskName, String taskDescription, String developerDetails, int taskDuration, int taskNumber) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = chooseTaskStatus();
        this.taskNumber = taskNumber;
        this.taskID = createTaskID();
        totalHours += taskDuration;
    }

    public static void WelcomeMessage() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");
    }

    public static void showMenu() {
        while (true) {
            String option = JOptionPane.showInputDialog(null, "Please choose an option:\n"
                    + "1. Add task\n"
                    + "2. Show report\n"
                    + "3. Quit\n"
                    + "Type the number only");

            switch (option) {
                case "1":
                    addNewTask();
                    break;
                case "2":
                    viewShowReport();
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Exiting the EasyKanban app.");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose a valid option.");
            }
        }
    }

    public static void addNewTask() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));

        for (int i = 1; i <= numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter the name for task " + i + ":");
            while (taskName.isBlank()) {
                JOptionPane.showMessageDialog(null, "Please ensure Task name is not empty!!");
                taskName = JOptionPane.showInputDialog("Enter the name for task " + i + ":");
            }

            String taskDescription = JOptionPane.showInputDialog("Enter the description for task " + i + " (less than 50 characters):");

            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                i--;
                continue;
            }

            String developerDetails = JOptionPane.showInputDialog("Please enter the developer's first and last name: ");
            if (developerDetails.length() < 3) {
                JOptionPane.showMessageDialog(null, "The developers Details should be longer than 3 characters:");
                i--;
                continue;
            }
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration in hours: "));

            Part3 task = new Part3(taskName, taskDescription, developerDetails, taskDuration, i);
            tasks.add(task);

            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }
    }

    public String createTaskID() {
        String taskID = taskName.substring(0, 1).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskID;
    }

    private String chooseTaskStatus() {
        String[] options = {"To do", "Done", "Doing"};
        int choice = JOptionPane.showOptionDialog(null, "Select the task status:", "Task status", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return options[choice];
    }

    public String printTaskDetails() {
        return "Task status: " + taskStatus + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Number: " + taskNumber + "\n" +
                "taskDescription: " + taskDescription + "\n" +
                "Task ID: " + taskID + "\n" +
                "Duration: " + taskDuration + " hours";
    }

    public static void viewShowReport() {
        while (true) {
            String option = JOptionPane.showInputDialog("Please choose an option to be Displayed:\n"
                    + "1. All tasks with the status of done.\n"
                    + "2. The task with the longest duration.\n"
                    + "3. Search for a task with a Task Name.\n"
                    + "4. Search for a task with the developers name and surname.\n"
                    + "5. Delete a task.\n"
                    + "6. A report that lists the full details of all captured tasks.\n"
                    + "7. Return to main menu.");

            StringBuilder sb = new StringBuilder();
            switch (option) {
                case "1":
                    for (Part3 task : tasks) {
                        if (task.taskStatus.equals("Done")) {
                            sb.append("Developer: ").append(task.developerDetails)
                                    .append("\nTask Name: ").append(task.taskName)
                                    .append("\nTask Duration: ").append(task.taskDuration).append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                    break;
                case "2":
                    Part3 longestTask = null;
                    for (Part3 task : tasks) {
                        if (longestTask == null || task.taskDuration > longestTask.taskDuration) {
                            longestTask = task;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Developer: " + longestTask.developerDetails
                            + "\nDuration: " + longestTask.taskDuration);
                    break;
                case "3":
                    String taskNameToFind = JOptionPane.showInputDialog("Enter the task name to search for: ");
                    boolean foundTaskName = false;
                    for (Part3 task : tasks) {
                        if (task.taskName.equals(taskNameToFind)) {
                            sb.append("Task Name: ").append(task.taskName)
                                    .append("\nDeveloper: ").append(task.developerDetails)
                                    .append("\nTask Status: ").append(task.taskStatus).append("\n");
                            foundTaskName = true;
                        }
                    }
                    if (foundTaskName) {
                        JOptionPane.showMessageDialog(null, sb.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Task with the given name not found!");
                    }
                    break;
                case "4":
                    String developerToFind = JOptionPane.showInputDialog("Enter the developer name to search for: ");
                    boolean foundDeveloper = false;
                    for (Part3 task : tasks) {
                        if (task.developerDetails.equals(developerToFind)) {
                            sb.append("Task Name: ").append(task.taskName)
                                    .append("\nDeveloper: ").append(task.developerDetails)
                                    .append("\nTask Status: ").append(task.taskStatus).append("\n");
                            foundDeveloper = true;
                        }
                    }
                    if (foundDeveloper) {
                        JOptionPane.showMessageDialog(null, sb.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Tasks with the given developer not found!");
                    }
                    break;
                case "5":
                    String taskNameToDelete= JOptionPane.showInputDialog("Enter the task name to delete: ");
                    boolean taskDeleted = false;
                    for (int i = 0; i < tasks.size(); i++) {
                        Part3 task = tasks.get(i);

                        if (task.taskName.equals(taskNameToDelete)) {
                            tasks.remove(i);
                            taskDeleted = true;
                            break;
                        }
                    }
                    if (taskDeleted) {
                        JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Task with the given name not found!");
                    }
                    break;
                case "6":
                    if (tasks.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No tasks captured yet!");
                    } else {
                        for (Part3 task : tasks) {
                            sb.append(task.printTaskDetails()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                    break;
                case "7":
                    return; // Exit viewShowReport and return to main menu
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose a valid option.");
            }
        }
    }

    public static int returnTotalHours() {
        return totalHours;
    }

    public static void displayTotalHours() {
        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
    }

    public boolean checkTaskDescription(String description) {
        return description != null && !description.isEmpty() && description.length() <= 50;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }
}
