package postgres;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Student students = new Student("Мухаммед", "Батыров", 19);
        Student students1 = new Student("Aза", "Маматов", 25);
        Student students2 = new Student("Эрмек", "Кобошов", 15);
        Student students3 = new Student("Аза", "Алымов", 27);
        Student students4 = new Student("Рахим", "Курбанов", 18);
        Student students5 = new Student("Аза", "Мамбетов", 30);
        Student students6 = new Student("Кубат", "Ашымжанов", 17);
        Student students7 = new Student("Аза", "Таиров", 16);
        Student.create(students);
        Student.create(students1);
        Student.create(students2);
        Student.create(students3);
        Student.create(students4);
        Student.create(students5);
        Student.create(students6);
        Student.create(students7);

        System.out.println(Student.getUser("Аза",20));
        System.out.println(Student.getUser1("Аза",18));
        System.out.println(Student.getUser2("Аза"));

    }
}

