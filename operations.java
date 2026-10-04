import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
public class operations {
        static ArrayList<Student> students = new ArrayList<>();
        static File file = new File("students.txt");
        public static void addstudentpage(Scanner sc) {
        System.out.println("***************** ADD STUDENT ****************");
        System.out.print("Enter student ID: ");
        for (; !sc.hasNextInt();) {
        System.out.println("Invalid input! Please enter ID in numbers only.");
        sc.next();
        }
        int stu_id = sc.nextInt();
        sc.nextLine();
        for (; stu_id <= 1;) {
        System.out.print("Invalid ID! Enter  1 or higher value: ");
        stu_id = sc.nextInt();
        }
        sc.nextLine();
        for (Student student : students) {
        if (student.getId() == stu_id) {
            System.out.println("Student ID already exists!");
            return;
        }
    }
        System.out.print("Enter student name: ");
        String stu_name = sc.nextLine();
        System.out.print("Enter student department: ");
        String stu_department = sc.nextLine();
        System.out.print("Enter student year: ");
        int stu_year;
        while (true) {
            for (;!sc.hasNextInt();) {
                System.out.println("Invalid input! Please enter Year in numbers.");
                sc.next();
            }
            stu_year = sc.nextInt();
            if (stu_year >= 1 && stu_year <= 4) {
                break;
            }
            System.out.print("Invalid year! Enter year 1 to 4: ");
        }
        System.out.println("STUDENT ID: " + stu_id);
        System.out.println("STUDENT NAME: " + stu_name);
        System.out.println("STUDENT DEPARTMENT: " + stu_department);
        System.out.println("STUDENT YEAR: " + stu_year);
        Student student = new Student(
            stu_id,
            stu_name,
            stu_department,
            stu_year
        );
        students.add(student);
        savestudentinfoToFile(student);
        System.out.println("STUDENT DETAILS ADDED SUCCESSFULLY");
    }

    public static void viewstudentpage(Scanner sc) {
        System.out.println("***************** VIEW STUDENTS DETAILS ****************");
        for (Student student : students) {
            System.out.println("STUDENT ID: " + student.getId());
            System.out.println("STUDENT NAME: " + student.getName());
            System.out.println("STUDENT DEPARTMENT: " + student.getDepartment());
            System.out.println("STUDENT YEAR: " + student.getYear());
            System.out.println("--------------------------------------");
        }
    }


    public static void updatestudentpage(Scanner sc) {
        System.out.println("***************** UPDATE STUDENT DETAILS ****************");
        System.out.print("Enter student ID to update: ");
        int stu_id = sc.nextInt();
        sc.nextLine();
        for (Student student : students) {
            if (student.getId() == stu_id) {
                System.out.print("Enter new student name: ");
                String stu_name = sc.nextLine();
                student.setName(stu_name);
                System.out.print("Enter new student department: ");
                String stu_department = sc.nextLine();
                student.setDepartment(stu_department);
                System.out.print("Enter new student year: ");
                int stu_year = sc.nextInt();
                student.setYear(stu_year);            
                saveAllStudentsToFile();
                System.out.println("STUDENT DETAILS UPDATED SUCCESSFULLY");
                break;
            }
        }
    }



    public static void deletestudentpage(Scanner sc) {
        System.out.println("***************** DELETE STUDENT DETAILS ****************");
        System.out.print("Enter student ID to delete: ");
        int stu_id = sc.nextInt();
        for (int i = 0; i < students.size(); i++) {
        if (students.get(i).getId() == stu_id) {
        students.remove(i);
        saveAllStudentsToFile();
        System.out.println("STUDENT DETAILS DELETED SUCCESSFULLY");
        return;
       }
    }
        System.out.println("Student ID not found!");
    }


    public static void exitpage(Scanner sc) {
        System.out.println("***************** EXIT ****************");
        System.out.println("THANK YOU FOR USING THE SYSTEM");
    }


    public static void savestudentinfoToFile(Student student) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(
                student.getId() + "," +
                student.getName() + "," +
                student.getDepartment() + "," +
                student.getYear()
            );
            writer.write("\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving student");
        }
    }


    public static void saveAllStudentsToFile() {
        try {
            FileWriter writer = new FileWriter(file);
            for (Student student : students) {
                writer.write(
                    student.getId() + "," +
                    student.getName() + "," +
                    student.getDepartment() + "," +
                    student.getYear()
                );
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving students");
        }
    }


    public static void loadStudentsinfoFromFile() {
        try {
            BufferedReader reader =
                new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String department = data[2];
                int year = Integer.parseInt(data[3]);
                Student student =
                    new Student(id, name, department, year);
                students.add(student);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
    }
}
