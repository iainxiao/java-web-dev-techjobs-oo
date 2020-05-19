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

    @Before
    public void createObjects() {
    developer = new Job();
    teacher = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertTrue((teacher.getId() != developer.getId()) && (teacher.getId()-developer.getId() == 1));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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


}


//CODE FOR TESTING FULL CONSTRUCTOR
//    Job webDeveloper = new Job("Web Developer", "LaunchCode", "Denver", "Developer", "Java");

