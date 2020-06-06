package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import org.junit.Assert;

import java.util.concurrent.LinkedTransferQueue;

import static org.junit.Assert.*;


public class JobTest {

    Job developer;
    Job teacher;
    Job testJob;

    @Before
    public void createObjects() {
    developer = new Job();
    teacher = new Job();
    testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }


    @Test
    public void testSettingJobId() {
        assertTrue((teacher.getId() != developer.getId()) && (teacher.getId()-developer.getId() == 1));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
//  test id value assigned correctly
        assertTrue(testJob.getId() > 0);
//  test Name value assigned correctly
        assertTrue("Product tester" == testJob.getName());
//  test classes assigned correctly
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
//  test values for Employer, Location, Position Type and Core Competency assigned correctly
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job firstManager = new Job("Manager", new Employer("Apple"), new Location("Chicago"), new PositionType("Management"), new CoreCompetency("Leadership"));
        Job secondManager = new Job("Manager", new Employer("Apple"), new Location("Chicago"), new PositionType("Management"), new CoreCompetency("Leadership"));
        assertFalse(firstManager.equals(secondManager));
    }

    @Test
    public void returnStringContainsBlankLinesBeforeAndAfterJobInfo() {
        assertTrue(testJob instanceof Job && testJob.toString().startsWith("\n") && testJob.toString().endsWith("\n"));
    }

    @Test
    public void stringContainsEachFieldLabelAndDataOnNewLine() {
        //        test ID field for label and data
        assertTrue(testJob.toString().contains("ID"));
        assertTrue(testJob.toString().contains("4"));

        //        test Name field for label and data
        assertTrue(testJob.toString().contains("Name"));
        assertTrue(testJob.toString().contains("Product tester"));

       //         test Employer field for label and data
        assertTrue(testJob.toString().contains("Employer"));
        assertTrue(testJob.toString().contains("ACME"));

        //        test Location field for label and data
        assertTrue(testJob.toString().contains("Location"));
        assertTrue(testJob.toString().contains("Desert"));

        //        test PositionType field for label and data
        assertTrue(testJob.toString().contains("Position Type"));
        assertTrue(testJob.toString().contains("Quality control"));

        //        test CoreCompetency field for label and data
        assertTrue(testJob.toString().contains("Core Competency"));
        assertTrue(testJob.toString().contains("Persistence"));

        //        test that data follows label and each field is on new line
        assertEquals("\nID: 4\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n\n", testJob.toString());
    }


    Job emptyEmployerField = new Job("Engineer", new Employer(""), new Location("Boston"), new PositionType("Engineer"), new CoreCompetency("Engineering"));

    @Test
    public void emptyFieldReturnsDataNotAvailable() {
        System.out.println(emptyEmployerField.getEmployer());
        System.out.println(emptyEmployerField.getEmployer().getValue());
        System.out.println(emptyEmployerField.toString());
        assertEquals("\nID: 19\nName: Engineer\nEmployer: Data not available\nLocation: Boston\nPosition Type: Engineer\nCore Competency: Engineering\n\n", emptyEmployerField.toString());
    }
}


//CODE FOR TESTING FULL CONSTRUCTOR
//    Job webDeveloper = new Job("Web Developer", "LaunchCode", "Denver", "Developer", "Java");

