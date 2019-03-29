package com.example.testpatterns.prototype.shallowcopy;

public class Resume {
    private String name;
    private String school;
    private Company company;

    public Resume(String name, String school, Company company) {
        this.name = name;
        this.school = school;
        this.company = company;
    }

    public Resume(Resume resume){
        this.name = resume.name;
        this.school = resume.school;
        this.company = resume.company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
