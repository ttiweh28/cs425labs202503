package cs425;


import cs425.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        Student[] students = {
                new Student(110001, "Dave", LocalDate.parse("11/18/1951", formatter)),
                new Student(110002, "Anna", LocalDate.parse("12/07/1990", formatter)),
                new Student(110003, "Erica", LocalDate.parse("01/31/1974", formatter)),
                new Student(110004, "Carlos", LocalDate.parse("08/22/2009", formatter)),
                new Student(110005, "Bob", LocalDate.parse("08/05/1994", formatter))
        };



        printListOfStudents(students);

        printListOfStudents(students);


        List<Student> platinumAlumni = getListOfPlatinumAlumniStudents(students);
        System.out.println("\nPlatinum Alumni Students (Sorted by Date of Admission - Descending):");
        for (Student student : platinumAlumni) {
            System.out.println(student);
        }


        printHelloWorld(new int[]{10, 14, 35, 49, 70});


        System.out.println("\nSecond biggest number: " + findSecondBiggest(new int[]{19, 9, 11, 0, 12}));
    }

    public static void printListOfStudents(Student[] students) {
        Arrays.sort(students);
        System.out.println("Sorted List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        List<Student> platinumAlumni = new ArrayList<>();
        LocalDate thirtyYearsAgo = LocalDate.now().minusYears(30);

        for (Student student : students) {
            if (student.getDateOfAdmission().isBefore(thirtyYearsAgo)) {
                platinumAlumni.add(student);
            }
        }

        platinumAlumni.sort((s1, s2) -> s2.getDateOfAdmission().compareTo(s1.getDateOfAdmission()));

        return platinumAlumni;
    }

    public static void printHelloWorld(int[] numbers) {
        System.out.println("\nHelloWorld Output:");
        for (int num : numbers) {
            if (num % 5 == 0 && num % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (num % 5 == 0) {
                System.out.println("Hello");
            } else if (num % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    public static int findSecondBiggest(int[] numbers) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
        }
        return secondMax;
    }
}
