package org.example.joblisting.Repository;

import org.example.joblisting.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    Job findJobById(Integer id);
}
