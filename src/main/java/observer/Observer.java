package observer;

public interface Observer {

        void receiveVacancy(JobVacancy vacancy);

        Boolean receiveOffer(JobVacancy vacancy, int salaryResult);
    }