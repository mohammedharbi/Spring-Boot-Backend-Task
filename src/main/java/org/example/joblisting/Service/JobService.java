package org.example.joblisting.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.joblisting.API.ApiException;
import org.example.joblisting.Model.Job;
import org.example.joblisting.Repository.JobRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

public void addJob(Job job) {

    if (job == null) {
        throw new ApiException("job is empty");
    }

    jobRepository.save(job);
}

public List<Job> getAllJobs() {
    return jobRepository.findAll();
}

public void updateJob(Job job, int id) {

    log.info("Updating job id={} with new data", id);

    if (job == null) {
        log.error("Job with id {} not found", id);
        throw new ApiException("job is empty");
    }

    Job newJob = jobRepository.findJobById(id);

    log.debug("Before update: {}", newJob);
    log.debug("Update payload: {}", job);

    if (newJob == null) {
        throw new ApiException("job not found");
    }

    newJob.setTitle(job.getTitle());
    newJob.setDescription(job.getDescription());
    newJob.setLocation(job.getLocation());
    newJob.setSalary(job.getSalary());
    newJob.setEmploymentType(job.getEmploymentType());
    jobRepository.save(newJob);

    log.info("Job with id {} updated successfully", id);

}

public void deleteJob(int id) {

    Job tempJob = jobRepository.findJobById(id);

    if (tempJob == null) {
        log.error("deleteJob failed: job id {} not found", id);
        throw new ApiException("Job not found");
    }

    log.info("Deleting job id {} with title: {}", id, tempJob.getTitle());

    jobRepository.delete(tempJob);

    log.info("Job id {} deleted successfully", id);

}

public Page<Job> getJobsWithPaginationAndSorting(int offSet, int pageSize, String sortField) {
    Page<Job> jobs = jobRepository.findAll(PageRequest.of(offSet, pageSize).withSort(Sort.by(sortField)));
    return jobs;
}

}
