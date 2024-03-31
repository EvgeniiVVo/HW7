package observer;

public class JobVacancy {

    private static int id;

    private String name;

    private String nameCompany;

    private int minSalary;

    private int maxSalary;

    private String responsibilities;

    private String requirements;

    private String conditions;

    public JobVacancy(String name, String nameCompany, int minSalary, int maxSalary, String responsibilities, String requirements, String conditions) {
        this.name = name;
        this.nameCompany = nameCompany;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.responsibilities = responsibilities;
        this.requirements = requirements;
        this.conditions = conditions;
        id++;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getConditions() {
        return conditions;
    }

    @Override
    public String toString() {
        String info = "------ Данные вакансии компании " + nameCompany + " -------\n" +
                "* Наименование вакансии: " + name + ";\n" +
                "* Наименование компании: " + nameCompany + ";\n" +
                "* Минимальный уровень заработной платы: " + minSalary + ";\n" +
                "* Максимальный уровень заработной платы: " + maxSalary + ";\n" +
                "* Обязанности: " + responsibilities + ";\n" +
                "* Требования: " + requirements + ";\n" +
                "* Условия: " + conditions + "\n";
        return info;
    }


    @Override
    public boolean equals(Object obj) {
        JobVacancy v = (JobVacancy)obj;
        return this.name == v.name &&
                this.nameCompany == v.nameCompany &&
                this.minSalary == v.minSalary &&
                this.maxSalary == v.maxSalary &&
                this.responsibilities == v.responsibilities &&
                this.requirements == v.requirements &&
                this.conditions == v.conditions
                ;
    }
}