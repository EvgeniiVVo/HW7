package observer;

public interface Publisher {

    void sendOffer(JobVacancy vacancy, int salary);

    void sendVacancy(JobVacancy vacancy);

    void registerObserver(JobSeeker observer);

    void removeObserver(JobSeeker observer);

    void getJobSeekerInfo();
}