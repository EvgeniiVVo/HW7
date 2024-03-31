package observer;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.text.Position;

public class JobSeeker implements Observer {


    private static int id;

    private String name;

    private String position;

    private int salary;

    private double experience;

    private Collection<JobVacancy> vacancys = new ArrayList<>();

    public JobSeeker(String name, String position, int salary, double experience) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.experience = experience;
        id++;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public double getExperience() {
        return experience;
    }

    public JobVacancy getSelectedVacancy() {
        int salaryResult = 0;
        JobVacancy vacancyResult = null;
        for (JobVacancy vacancy : vacancys) {
            int maxSalary = vacancy.getMaxSalary();
            if (maxSalary > salaryResult) {
                salaryResult = maxSalary;
                vacancyResult = vacancy;
            }
        }
        return vacancyResult;
    }

    @Override
    public String toString() {
        String info = " Данные \n" +
                "* Имя: " + name + ";\n" +
                "* Желаемая должность: " + position + ";\n" +
                "* Желаемая зарплата: " + salary + ";\n" +
                "* Опыт работы: " + experience + "\n";
        return info;
    }

    @Override
    public void receiveVacancy(JobVacancy vacancy) {
        if ((vacancy.getMinSalary() > salary || vacancy.getMaxSalary() > salary) && vacancy.getName() == position) {
            vacancys.add(vacancy);

            System.out.printf("Соискатель %s. Желаемая ЗП: %s. Ваше предложение меня заинтересовало! (компания: %s; заработная плата от %s до %s)\n",
                    name, salary, vacancy.getNameCompany(), vacancy.getMinSalary(), vacancy.getMaxSalary());
        }
        else {
            System.out.printf("Соискатель %s. Желаемая ЗП: %s. Я найду работу получше! (компания: %s; заработная плата от %s до %s)\n",
                    name, salary, vacancy.getNameCompany(), vacancy.getMinSalary(), vacancy.getMaxSalary());
        }
    }

    @Override
    public Boolean receiveOffer(JobVacancy vacancy, int salaryResult) {
        vacancys.remove(vacancy);
        if (this.salary <= salaryResult){
            System.out.printf("Соискатель %s. Желаемая ЗП: %s Мне нужна эта работа! (компания: %s; предложенная ЗП: %d)\n",
                    name, salary, vacancy.getNameCompany(), salaryResult);
            this.salary = salaryResult;
            return true;
        }
        else {
            System.out.printf("Соискатель %s. Желаемая ЗП: %s. Я найду работу получше! (компания: %s; предложенная ЗП: %d)\n",
                    name, salary, vacancy.getNameCompany(), salaryResult);
            return false;
        }

    }
}