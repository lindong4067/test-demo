package com.example.testpatterns.prototype.deepcopy;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume resume = new Resume("Zhang San", "Tinghua University", "Baidu.com");
        System.out.println(resume);
        Resume resume1 = new Resume(resume);
        System.out.println(resume1);
        Resume resume2 = new Resume(resume);
        System.out.println(resume2);

        ResumeCloneable resumeCloneable = new ResumeCloneable("Li Si", "Shaanxi", "Ali");
        System.out.println(resumeCloneable);
        ResumeCloneable resumeCloneable1 = (ResumeCloneable) resumeCloneable.clone();
        System.out.println(resumeCloneable1);
        ResumeCloneable resumeCloneable2 = (ResumeCloneable) resumeCloneable.clone();
        System.out.println(resumeCloneable2);
    }
}
