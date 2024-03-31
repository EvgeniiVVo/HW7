package observer;

import java.util.ArrayList;
import java.util.Collection;

public class JobAgency implements Publisher {

    private Collection<JobSeeker> observers = new ArrayList<>();

    @Override
    public void sendOffer(JobVacancy vacancy, int salary) {
        try {
            for (JobSeeker observer : observers) {
                JobVacancy selectedVacancy = observer.getSelectedVacancy();
                if (selectedVacancy.equals(vacancy)) {
                    if (observer.receiveOffer(vacancy, salary)) {
                        System.out.printf(
                                "Вакансия: %s, Компания: %s. Соискатель принял Ваше предложение (Соискатель: %s, должность %s, заработная плата %s\n",
                                vacancy.getName(), vacancy.getNameCompany(), observer.getName(), observer.getPosition(), salary);
                        removeObserver(observer);
                    }
                }
            }
        } catch (Exception e) {
            System.out.printf("Для вакансии: %s, компании: %s нет подходищих соискателей\n", vacancy.getName(),
                    vacancy.getNameCompany());
        }
    }

    @Override
    public void sendVacancy(JobVacancy vacancy) {
        for (JobSeeker observer : observers) {
            String position = observer.getPosition();
            if (vacancy.getName() == position) {
                observer.receiveVacancy(vacancy);
            }
        }
    }

    @Override
    public void registerObserver(JobSeeker observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(JobSeeker observer) {
        observers.remove(observer);
    }

    @Override
    public void getJobSeekerInfo() {
        for (JobSeeker jobSeeker : observers) {
            System.out.println(jobSeeker);
        }
    }

}