import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try {

            if (operations.file.createNewFile()) {
                System.out.println("File created successfully");
            } else {
                System.out.println("File already exists");
            }
        } catch (Exception e) {
            System.out.println("Error creating file");
        }
        operations.loadStudentsinfoFromFile();
        Scanner sc = new Scanner(System.in);
        for (int choice = 0; choice <= 5; choice++) {
            System.out.println("********** STUDENT MANAGEMENT SYSTEM **********");
            System.out.println("1. ADD STUDENT");
            System.out.println("2. VIEW STUDENT");
            System.out.println("3. UPDATE STUDENT");
            System.out.println("4. DELETE STUDENT");
            System.out.println("5. EXIT");
            System.out.println("************************************************");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("NOW YOU CAN ADD STUDENT DETAILS");
                operations.addstudentpage(sc);
            }
            if (choice == 2) {
                System.out.println("NOW YOU CAN VIEW STUDENT DETAILS");
                operations.viewstudentpage(sc);
            }
            if (choice == 3) {
                System.out.println("NOW YOU CAN UPDATE STUDENT DETAILS");
                operations.updatestudentpage(sc);
            }
            if (choice == 4) {
                System.out.println("NOW YOU CAN DELETE STUDENT DETAILS");
                operations.deletestudentpage(sc);
            }
            if (choice == 5) {
                operations.exitpage(sc);
            }
        }
    }

  
}