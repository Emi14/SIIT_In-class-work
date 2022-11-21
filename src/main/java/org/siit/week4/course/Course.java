package org.siit.week4.course;


import org.siit.week4.student.Student;

import java.util.HashSet;
import java.util.Set;

public class Course {
    String courseName;
    int maxStudents;
    Classroom classroom;
    Set<Student> students = new HashSet<>();

    public Course(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public boolean enroll(Student student) {
        if (students.size() < maxStudents && !students.contains(student)) {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean dropOut(Student student) {
        return false;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String getCourseName() {
        return courseName;
    }
}
