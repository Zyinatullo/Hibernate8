package postgres;

import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private int age;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';


    }

    public static int create(Student students) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.save(students);
        session.getTransaction().commit();
        System.out.println("added successfully" + students);
        return students.getId();

    }

    public static List<Student> getUser(String name,int age) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List<Student> students =
                session.createQuery("from Student ").getResultList();
        students.stream().filter(students1->students1.getName().equals(name)&&students1.getAge()>20).forEach(System.out::println);
        session.getTransaction().commit();
        session.close();
        return students;

    }
    public static List<Student> getUser1(String name,int age){
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List<Student>students1 =
                session.createQuery("from Student ").getResultList();
        students1.stream().filter(student -> student.getName().equals(name)).forEach(student -> student.setAge(age));
        session.getTransaction().commit();
        session.close();

        return students1;
    }

    public static List<Student> getUser2(String name){
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List<Student> students2 =
                session.createQuery(" FROM Student ").getResultList();
        students2.removeIf(student -> student.getName().equals(name));
        System.out.println(students2);
        session.close();
        return students2;

    }

}

