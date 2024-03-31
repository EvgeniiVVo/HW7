package observer;

public class Program {

    /**
     *  TODO: Доработать приложение, которое разрабатывалось на семинаре,
     *  поработать с шаблоном проектирования Observer,
     *  добавить новый тип соискателя.
     *  Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     *  Только после этого вы можете усложнить ваше приложение (при желании), например,
     *  добавить тип вакансии (enum),
     *  учитывать тип вакансии при отправке предложения соискателю.
     *  ***. Добавить возможность отписаться от рассылки новых вакансий.
     * @param args
     */
    public static void main(String[] args) {

        Publisher publisher = new JobAgency();
        Company google = new Company("Google", publisher, 120000);
        Company yandex = new Company("Yandex", publisher, 95000);
        Company geekBrains = new Company("GeekBrains", publisher, 98000);

        google.addVacancy(new JobVacancy("Инженер-программист",
                google.getName(),
                80000,
                100000,
                "Разработка программного обеспечения",
                "Знание языков IEC 61131-3 (IL, ST, LD, FBD)",
                "Оформление в соответствии с ТК РФ"));

        yandex.addVacancy(new JobVacancy("Ведущий Инженер-программист",
                yandex.getName(),
                160000,
                200000,
                "Разработка программного обеспечения",
                "Высшее образование, Знание SQL, Java",
                "Заработная плата по итогам собеседования"));

        geekBrains.addVacancy(new JobVacancy("Инженер-программист",
                geekBrains.getName(),
                90000,
                130000,
                "Разработка программного обеспечения",
                "Знание SQL, Java",
                "Работа в официально аккредитованной IT компании"));

        google.getVacancysInfo();
        yandex.getVacancysInfo();
        geekBrains.getVacancysInfo();


        JobSeeker student1 = new JobSeeker("Студент #1", "Инженер-программист", 90000, 3);
        JobSeeker master1 = new JobSeeker("Мастер #1", "Ведущий Инженер-программист", 120000, 5);
        JobSeeker master2 = new JobSeeker("Мастер #2", "Инженер-программист", 150000, 7);

        publisher.registerObserver(student1);
        publisher.registerObserver(master1);
        publisher.registerObserver(master2);

        publisher.getJobSeekerInfo();

        System.out.println(" Рассылка вакансий ");
        for (int i = 0; i < 3; i++){
            google.sendOutVacancies();
            yandex.sendOutVacancies();
            geekBrains.sendOutVacancies();
            System.out.println();
        }

        // System.out.println();

        System.out.println(" Рассылка предложений о работе ");
        for (int i = 0; i < 3; i++){
            google.needEmployee();
            System.out.println();

            yandex.needEmployee();
            System.out.println();

            geekBrains.needEmployee();
            System.out.println();
        }

    }
}