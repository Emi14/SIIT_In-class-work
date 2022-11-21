package org.SII.week4.student;


import org.SII.week4.course.Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Student {
    final String cnp;
    List<Course> courses = new LinkedList<>();

    public Student() {
        System.out.println("Student constructor");
        cnp = "N/A";
    }

    public Student(String cnp) {
        this.cnp = cnp;
        this.courses.clear();
    }

    public Student(String cnp, List<Course> courses) {
        this.cnp = cnp;
        for (Course course : courses) {
            course.enroll(this);
        }
    }

    /**
     * Enrolls student to train
     *
     * @param train train to enroll student to
     * @return true is successful, false otherwise
     */
    public boolean enrollToCourse(Course train) {
        if (train.enroll(this)) {
//            train.setMaxStudents(5);
            this.courses.add(train);
            return true;
        }
        return false;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Course> getCoursesOrderedByName() {
        List<Course> coursesToSort = new ArrayList<>(this.courses);
        coursesToSort.sort(Comparator.comparing(Course::getCourseName));
        return coursesToSort;
    }
}
