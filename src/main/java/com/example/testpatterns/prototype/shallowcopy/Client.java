package com.example.testpatterns.prototype.shallowcopy;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Company company = new Company("Baidu");
        Resume resume = new Resume("Zhang San", "Tinghua University", company);
        System.out.println(resume);
        Resume resume1 = new Resume(resume);
        System.out.println(resume1);
        Resume resume2 = new Resume(resume);
        System.out.println(resume2);
        System.out.println(resume.getCompany());
        System.out.println(resume1.getCompany());
        System.out.println(resume2.getCompany());

    }
}
