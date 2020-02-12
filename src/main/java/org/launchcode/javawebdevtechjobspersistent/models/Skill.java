package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @NotBlank(message = "Description is required")
    @Size(min=3, max=500, message = "Description must be between 3 and 500 characters")
    private String description;

    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs = new ArrayList<>();

    //constructors


    public Skill(String description, List<Job> jobs) {
        this.description = description;
        this.jobs = jobs;
    }

    public Skill() {}

    //getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}