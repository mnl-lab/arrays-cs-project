package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getAge() > oldest.getAge() ){
                oldest = students[i];
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if(students[i].getAge() >= 18){
                count += 1;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double average = 0;
        for ( Student x : students) {
            average += x.getGrade();

        }
        average /= students.length;
        return average;

    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student x : students){
            if(x.getName().equals(name)){
                return x;
            }
        }
        return null;

    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                if (students[j].getGrade() < students[i].getGrade()){
                   Student tamp = students[j];
                   students[j] = students[i];
                   students[i] = tamp;
                }
            }
        }


    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {

        for (int i = 0; i < students.length; i++) {
            if(students[i].getGrade() >= 15){
                System.out.println(students[i].getName());
            }
        }


    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student x : students){
            if (x.getId() == id){
                x.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length; j++) {
                if (students[i].getId() != students[j].getId() && students[i].getName().equals(students[j].getName())){
                    System.out.println("Duplicates found.");
                    return true;
                }

            }
        }
        System.out.println("No duplicates found.");
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] cp = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            cp[i] = students[i];

        }
        cp[students.length] = newStudent;
        return cp;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];
        arr[0] = new Student(0, "student0");
        arr[1] = new Student(1, "student1", 20);
        arr[2] = new Student(2, "student2",20,20);
        arr[3] = new Student(3, "student3");
        arr[4] = new Student(4, "student3",21);

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        Student oldest = findOldest(arr);
        System.out.println("The oldest student is " + oldest.getName());

        // 3) Count adults
        int numOfAdults = countAdults(arr);
        System.out.println("The number of adults among the students is " + numOfAdults);

        // 4) Average grade
        double averageGrade = averageGrade(arr);
        System.out.println("The average grade of the class is " + averageGrade);

        // 5) Find by name
        Student student1 = findStudentByName(arr, "student1");
        System.out.println("Found Student " + student1.getName() + " by name.");

        // 6) Sort by grade desc
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        sortByGradeDesc(arr);
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated = updateGrade(arr, 4, 20);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "student3"));

        // 9) Duplicate names
        System.out.println("Duplicate names:");
        hasDuplicateNames(arr);

        // 10) Append new student
        Student newStudent = new Student(5, "student5");
        Student[] updatedArr = appendStudent(arr, newStudent);
        System.out.println("Array of new students:");
        for (Student s : updatedArr) {
            System.out.println(s.getName() + " ");
        }
        System.out.println();

        // 11) 2D Array Representation of Class
        Student[][] classes = new Student[2][3];
        classes[0][0] = new Student(0, "student0", 20, 10);
        classes[0][1] = new Student(1, "student1", 21, 11);
        classes[0][2] = new Student(2, "student2", 22, 12);
        classes[1][0] = new Student(3, "student3", 23, 13);
        classes[1][1] = new Student(4, "student4", 24, 14);
        classes[1][2] = new Student(5, "student5", 25, 15);
        System.out.println("\n2D Array of Classes:");
        for (int i = 0; i < 2; ++i) {
            System.out.print("Class " + (i + 1) + ": ");
            for (Student s : classes[i]) {
                System.out.print(s.getName() + ", ");
            }
            System.out.println();
        }
        System.out.println("Top student of each class:");
        for (int i = 0; i < 2; ++i) {
            System.out.print("Class " + (i + 1) + ": ");
            Student topStudent = classes[i][0];
            for (Student s : classes[i]) {
                if (s.getGrade() > topStudent.getGrade()) {
                    topStudent = s;
                }
            }
            System.out.println(topStudent.getName());
        }
    }
}