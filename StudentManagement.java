import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }
}

public class StudentManagement {
    static List<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        students.add(new Student(id, name, age));
        System.out.println("Student Added Successfully!\n");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.\n");
        } else {
            System.out.println("Student Records:");
            for (Student s : students) {
                s.display();
            }
        }
    }

    public static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                sc.nextLine(); // Consume newline
                System.out.print("Enter New Name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter New Age: ");
                s.setAge(sc.nextInt());
                System.out.println("Student Updated Successfully!\n");
                return;
            }
        }
        System.out.println("Student Not Found!\n");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("Student Deleted Successfully!\n");
                return;
            }
        }
        System.out.println("Student Not Found!\n");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.out.println("Exiting...\n"); break;
                default: System.out.println("Invalid Choice! Try Again.\n");
            }
        } while (choice != 5);
    }
}
