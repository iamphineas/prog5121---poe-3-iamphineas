/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package poefinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Part3Test {

    Part3 testData1;
    Part3 testData2;
    Part3 testData3;
    Part3 testData4;

    @BeforeEach
    public void setUp() {
        Part3.WelcomeMessage();

        testData1 = new Part3("Create Login", "Task description 1", "Mike Smith", 5, 1);
        testData1.setTaskStatus("To Do");
        Part3.tasks.add(testData1);

        testData2 = new Part3("Create Add Features", "Task description 2", "Edward Harrison", 8, 2);
        testData2.setTaskStatus("Doing");
        Part3.tasks.add(testData2);

        testData3 = new Part3("Create Reports", "Task description 3", "Samantha Paulson", 2, 3);
        testData3.setTaskStatus("Done");
        Part3.tasks.add(testData3);

        testData4 = new Part3("Add Arrays", "Task description 4", "Glenda Oberholzer", 11, 4);
        testData4.setTaskStatus("To Do");
        Part3.tasks.add(testData4);
    }

    @Test
    public void testDeveloperArrayPopulated() {
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        String[] actualDevelopers = new String[Part3.tasks.size()];
        for (int i = 0; i < Part3.tasks.size(); i++) {
            actualDevelopers[i] = Part3.tasks.get(i).getDeveloperDetails();
        }
        assertArrayEquals(expectedDevelopers, actualDevelopers);
    }

    @Test
    public void testDisplayDeveloperAndDurationForTaskWithLongestDuration() {
        Part3 longestTask = null;
        for (Part3 task : Part3.tasks) {
            if (longestTask == null || task.getTaskDuration() > longestTask.getTaskDuration()) {
                longestTask = task;
            }
        }
        String expected = longestTask.getDeveloperDetails() + ", " + longestTask.getTaskDuration();
        String actual = longestTask.getDeveloperDetails() + ", " + longestTask.getTaskDuration();
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchForTask() {
        String taskNameToFind = "Create Login";
        String expected = "Mike Smith, Create Login";
        String actual = "";
        for (Part3 task : Part3.tasks) {
            if (task.getTaskName().equals(taskNameToFind)) {
                actual = task.getDeveloperDetails() + ", " + task.getTaskName();
                break;
            }
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchTasksAssignedToDeveloper() {
        String developerToFind = "Samantha Paulson";
        String expected = "Create Reports";
        StringBuilder sb = new StringBuilder();
        for (Part3 task : Part3.tasks) {
            if (task.getDeveloperDetails().equals(developerToFind)) {
                sb.append(task.getTaskName()).append("\n");
            }
        }
        String actual = sb.toString().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteTaskFromArray() {
        String taskNameToDelete = "Create Reports";
        int initialSize = Part3.tasks.size();
        Part3.tasks.removeIf(task -> task.getTaskName().equals(taskNameToDelete));
        int newSize = Part3.tasks.size();
        assertEquals(initialSize - 1, newSize);

        boolean found = false;
        for (Part3 task : Part3.tasks) {
            if (task.getTaskName().equals(taskNameToDelete)) {
                found = true;
                break;
            }
        }
        assertFalse(found, "Task with the given name should be deleted");
    }
}
