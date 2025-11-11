package org.example.joblisting.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.joblisting.Model.Job;
import org.example.joblisting.Service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Job-listing-system")
public class JobController {
    private final JobService jobService;


@Operation(summary = "Get all jobs", description = "Returns a list of all job postings in the system.")
@GetMapping("/read-all-jobs")
public ResponseEntity readJobListing() {
    log.info("Request received: GET /read-all-jobs");
    return ResponseEntity.status(200).body(jobService.getAllJobs());
}


    @Operation(
            summary = "Add a new job",
            description = "add a new job posting. Requires job title, description, location, salary, and employment type.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Job object to be added",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Job.class))
            )
    )
@PostMapping("/add-job")
//@Operation(summary = "to add job to the job list")
public ResponseEntity addJob(@RequestBody @Valid Job job) {

        log.info("Request received: POST /add-job, Job Title={}", job.getTitle());
        jobService.addJob(job);
    return ResponseEntity.status(200).body("Job added to the list successfully");
}

    @Operation(
            summary = "Update a job ",
            description = "update an existing job posting. Provide the job ID along with updated details.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Updated job object",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Job.class))
            )
    )
@PutMapping("/update-job/id/{id}")
public ResponseEntity updateJob(@RequestBody @Valid Job job, @PathVariable int id) {

    jobService.updateJob(job, id);
    return ResponseEntity.status(200).body("Job updated successfully");
}

    @Operation(
            summary = "Delete a job",
            description = "delete an existing job posting. Provide the job ID in the request body.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Job object to delete (must include ID)",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Job.class))
            )
    )
@DeleteMapping("/delete-job/id/{id}")
public ResponseEntity deleteJob(@PathVariable int id) {
    jobService.deleteJob(id);
    return ResponseEntity.status(200).body("Job deleted successfully");
}

    @Operation(
            summary = "Get all jobs with pagination and sorting",
            description = "Returns a paginated and sorted list of jobs. You can specify offset, page size, and the field to sort by."
    )
    @GetMapping("/jobs-pagination-sort/offSet/{offset}/pageSize/{pageSize}/field/{field}")
    public ResponseEntity getAllJobsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Job> jobsWithPaginationAndSort = jobService.getJobsWithPaginationAndSorting(offset, pageSize, field);
        return ResponseEntity.status(200).body(jobsWithPaginationAndSort);
    }
    }


