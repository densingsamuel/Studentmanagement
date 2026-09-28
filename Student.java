public class Student {
    int id;
    String name;
    String department;
    int year;
    

public Student(int id, String name, String department, int year) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.year = year;
}
public int getId() {
    return id;
}

public String getName() {
    return name;
}

public String getDepartment() {
    return department;
}

public int getYear() {
    return year;
}
public void setName(String name) {
    this.name = name;
}

public void setDepartment(String department) {
    this.department = department;
}

public void setYear(int year) {
    this.year = year;
}
}