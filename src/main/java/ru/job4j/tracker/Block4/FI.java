package ru.job4j.tracker.Block4;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FI {
    public static void main(String[] args) {
        Student[] sts = {
                new Student("image 1", 20),
                new Student("image 3", 120),
                new Student("image 2", 23)
        };
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        Arrays.sort(sts, comparator);

        Comparator<Attachment> cmpDescText = (left, right) -> {
            System.out.println("compare - " + right.getName() + " : " + left.getName());
            return right.getName().compareTo(left.getName());
        };
    }

    public static void raw(List<Student> list, Function<Student, InputStream> func) {
        for (Student st : list) {
            func.apply(st);
        }
    }
}
