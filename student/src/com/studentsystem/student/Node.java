package com.studentsystem.student;

public class Node {

    private Node pre;
    private Node next;
    private Student student;

    public Node() {
    }

    public Node(Node pre, Node next) {
        this.pre = pre;
        this.next = next;
    }

    public Node(String id, String name, int age, String address) {
        this.student = new Student(id,name,age,address);
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(String id, String name, int age, String address) {
        this.student = new Student(id,name,age,address);
    }
}
