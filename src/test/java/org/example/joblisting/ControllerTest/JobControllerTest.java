package org.example.joblisting.Controller;

import org.example.joblisting.Model.Job;
import org.example.joblisting.Service.JobService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class JobControllerTest {

    @Mock
    private JobService jobService;

    @InjectMocks
    private JobController jobController;

    private Job job;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        job = new Job();
        job.setId(1);
        job.setTitle("Software Engineer");
        job.setDescription("Develop backend services");
        job.setLocation("Riyadh");
        job.setSalary(12000);
        job.setEmploymentType("FULL_TIME");
    }

    @Test
    void testReadJobListing() {
        when(jobService.getAllJobs()).thenReturn(Arrays.asList(job));
        ResponseEntity response = jobController.readJobListing();
        assertEquals(200, response.getStatusCodeValue());
        verify(jobService, times(1)).getAllJobs();
    }

    @Test
    void testAddJob() {
        ResponseEntity response = jobController.addJob(job);
        assertEquals(200, response.getStatusCodeValue());
        verify(jobService, times(1)).addJob(job);
    }

    @Test
    void testUpdateJob() {
        ResponseEntity response = jobController.updateJob(job, job.getId());
        assertEquals(200, response.getStatusCodeValue());
        verify(jobService, times(1)).updateJob(job, job.getId());
    }

    @Test
    void testDeleteJob() {
        ResponseEntity response = jobController.deleteJob(job.getId());
        assertEquals(200, response.getStatusCodeValue());
        verify(jobService, times(1)).deleteJob(job.getId());
    }

    @Test
    void testGetAllJobsWithPaginationAndSort() {
        Page<Job> page = new PageImpl<>(Arrays.asList(job));
        when(jobService.getJobsWithPaginationAndSorting(0, 1, "title")).thenReturn(page);
        ResponseEntity response = jobController.getAllJobsWithPaginationAndSort(0, 1, "title");
        assertEquals(200, response.getStatusCodeValue());
        verify(jobService, times(1)).getJobsWithPaginationAndSorting(0, 1, "title");
    }
}
