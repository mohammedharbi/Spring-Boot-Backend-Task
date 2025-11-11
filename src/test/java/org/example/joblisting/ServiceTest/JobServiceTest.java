package org.example.joblisting.Service;

import org.example.joblisting.API.ApiException;
import org.example.joblisting.Model.Job;
import org.example.joblisting.Repository.JobRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JobServiceTest {

    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobService jobService;

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
    void testAddJob() {
        jobService.addJob(job);
        verify(jobRepository, times(1)).save(job);
    }

    @Test
    void testGetAllJobs() {
        when(jobRepository.findAll()).thenReturn(Arrays.asList(job));
        List<Job> jobs = jobService.getAllJobs();
        assertEquals(1, jobs.size());
        verify(jobRepository, times(1)).findAll();
    }

    @Test
    void testUpdateJob() {
        when(jobRepository.findJobById(job.getId())).thenReturn(job);
        Job updatedJob = new Job();
        updatedJob.setTitle("Updated Title");
        jobService.updateJob(updatedJob, job.getId());
        verify(jobRepository, times(1)).save(job);
        assertEquals("Updated Title", job.getTitle());
    }

    @Test
    void testDeleteJob() {
        when(jobRepository.findJobById(job.getId())).thenReturn(job);
        jobService.deleteJob(job.getId());
        verify(jobRepository, times(1)).delete(job);
    }

    @Test
    void testGetJobsWithPaginationAndSorting() {
        Page<Job> page = new PageImpl<>(Arrays.asList(job));
        when(jobRepository.findAll(PageRequest.of(0, 1).withSort(org.springframework.data.domain.Sort.by("title"))))
                .thenReturn(page);
        Page<Job> result = jobService.getJobsWithPaginationAndSorting(0, 1, "title");
        assertEquals(1, result.getTotalElements());
    }
}
