package cs425.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Comparable<Student> {
    private int studentId;
    private String name;
    private LocalDate dateOfAdmission;


    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}
