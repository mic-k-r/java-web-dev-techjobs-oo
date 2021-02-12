package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;
    Job job3;
    Job job4;
    Job job5;

    @Before
    public void createJobObject() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        job5 = new Job("", new Employer("Walmart"), new Location("Bentonville"), new PositionType(""), new CoreCompetency("Being a workaholic"));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, job2.getId() - job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertNotNull(job3.getEmployer());
        assertNotNull(job3.getLocation());
        assertNotNull(job3.getPositionType());
        assertNotNull(job3.getCoreCompetency());
        assertSame("Product Tester", job3.getName());
        assertSame("ACME", job3.getEmployer().getValue());
        assertSame("Desert", job3.getLocation().getValue());
        assertSame("Quality Control", job3.getPositionType().getValue());
        assertSame("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertNotEquals(job3, job4);
    }

    @Test
    public void jobToStringMethodHasFirstLine() {
        // scans first line of toString output and verifies it's a line
        assertTrue( job3.toString().startsWith("\n"));
    }

    // another test to scan last line of toString output that verifies it's a line
    @Test
    public void jobToStringMethodHasLastLine() {
        assertTrue(job3.toString().endsWith("\n"));
    }

    @Test
    public void jobToStringHasInfoOnSeparateLines() {
        assertTrue(job3.toString().contains("ID: " + job3.getId() + "\n" +
                                            "Name: " + job3.getName() + "\n" +
                                            "Employer: " + job3.getEmployer() + "\n" +
                                            "Location: " + job3.getLocation() + "\n" +
                                            "Position Type: " + job3.getPositionType() + "\n" +
                                            "Core Competency: " + job3.getCoreCompetency()
                                            ));
    }

    @Test
    public void jobToStringHasMessageWhenNoData() {
        assertTrue(job5.toString().contains("Name: Data is unavailable"));
        assertTrue(job5.toString().contains("Position Type: Data is unavailable"));
    }

    @Test
    public void jobToStringBonus() {
        assertTrue(job1.toString().contains("This object doesn't exist!"));
    }

}
