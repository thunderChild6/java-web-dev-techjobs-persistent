package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Location is required")
    @Size(min=3, max=100, message = "Location must be between 3 and 100 characters")
    private String location;

    @OneToMany
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private final List<Job> jobs = new ArrayList<>();

    //constructors
    public Employer(String location) {
        this.location = location;
    }

    public Employer() {}

    //getters and setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
