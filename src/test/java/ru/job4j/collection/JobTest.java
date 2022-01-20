package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void useJobAscByNameComparator() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Edit task", 4),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("Edit task", 4),
                new Job("Fix bug", 1),
                new Job("X task", 0)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void useJobDescByNameComparator() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Edit task", 4),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("Fix bug", 1),
                new Job("Edit task", 4)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void useJobAscByPriorityComparator() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 5),
                new Job("Edit task", 3),
                new Job("X task", 7)
        );
        Collections.sort(jobs, new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Edit task", 3),
                new Job("Fix bug", 5),
                new Job("X task", 7)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void useJobDescByPriorityComparator() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 5),
                new Job("Edit task", 3),
                new Job("X task", 7)
        );
        Collections.sort(jobs, new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("X task", 7),
                new Job("Fix bug", 5),
                new Job("Edit task", 3)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void whenNamesEqualsThenCompareAscPriorities() {
        Comparator<Job> comb = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = comb.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenNamesEqualsThenCompareDescPriorities() {
        Comparator<Job> comb = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = comb.compare(
                new Job("Impl task", 3),
                new Job("Impl task", 5)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenPrioritiesEqualsThenCompareAscNames() {
        Comparator<Job> comb = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = comb.compare(
                new Job("Fix bug", 5),
                new Job("Impl task", 5)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenPrioritiesEqualsThenCompareDescNames() {
        Comparator<Job> comb = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = comb.compare(
                new Job("Fix bug", 5),
                new Job("Impl task", 5)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenNamesAndPrioritiesEquals() {
        Comparator<Job> comb = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = comb.compare(
                new Job("Impl task", 5),
                new Job("Impl task", 5)
        );
        assertThat(rsl, equalTo(0));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}