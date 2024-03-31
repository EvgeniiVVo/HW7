package observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Company {

    private Collection<JobVacancy> vacancys = new ArrayList<>();

    private Random random = new Random();

    private String name;

    private Publisher jobAgency;

    private int maxSalary;

    public Company(String name, Publisher jobAgency, int maxSalary) {
        this.name = name;
        this.jobAgency = jobAgency;
        this.maxSalary = maxSalary;
    }

    public String getName() {
        return name;
    }

    public void addVacancy(JobVacancy vacancy) {
        vacancys.add(vacancy);
    }

    public void sendOutVacancies () {
        for (JobVacancy vacancy : vacancys) {
            jobAgency.sendVacancy(vacancy);
        }
    }

    public void needEmployee() {
        int salary = random.nextInt(maxSalary);
        for (JobVacancy vacancy : vacancys) {
            jobAgency.sendOffer(vacancy, salary);
        }
    }

    public void getVacancysInfo() {
        for (JobVacancy vacancy : vacancys) {
            System.out.println(vacancy);
        }
    }
}