package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Иванов Иван Иванович");
        student.setGroupName("Информатика и ВТ");
        student.setReceiptDate("01/01/2022");

        System.out.println(student.getFio());
        System.out.println(student.getGroupName());
        System.out.println(student.getReceiptDate());
    }
}
