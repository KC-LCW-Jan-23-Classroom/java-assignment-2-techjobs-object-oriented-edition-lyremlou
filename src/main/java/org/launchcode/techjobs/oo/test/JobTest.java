package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.CoreCompetency;


import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();

        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {

        Job jobThree = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(jobThree instanceof Job);
        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertTrue(jobThree.getLocation() instanceof Location);
        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", jobThree.getName());
        assertEquals("ACME", jobThree.getEmployer().getValue());
        assertEquals("Desert", jobThree.getLocation().getValue());
        assertEquals("Quality control", jobThree.getPositionType().getValue());
        assertEquals("Persistence", jobThree.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {

        Job jobA = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job jobB = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(jobA.equals(jobB));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        Job jobC =  new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String output = jobC.toString();

        assertEquals('\n', output.charAt(0));
        assertEquals('\n', output.charAt(output.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        Job jobD =  new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("\n" + "ID: " + jobD.getId() + "\n" +
                "Name: " + jobD.getName() + "\n" +
                "Employer: " + jobD.getEmployer() + "\n" +
                "Location: " + jobD.getLocation() + "\n" +
                "Position Type: " + jobD.getPositionType() + "\n" +
                 "Core Competency: " + jobD.getCoreCompetency() + "\n", jobD.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {

        Job jobE =  new Job("", new Employer("ACME"),
                new Location(""), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));



        assertEquals("\n" + "ID: " + jobE.getId() + "\n" +
                "Name: " + "Data not available" + "\n" +
                "Employer: " + jobE.getEmployer() + "\n" +
                "Location: " + "Data not available" + "\n" +
                "Position Type: " + jobE.getPositionType() + "\n" +
                "Core Competency: " + jobE.getCoreCompetency() + "\n", jobE.toString());

    }



    // This is not passing the autograder test-- calls assertion in Test 5.
    // Something is wrong with the format of all assertEquals assertions
}
