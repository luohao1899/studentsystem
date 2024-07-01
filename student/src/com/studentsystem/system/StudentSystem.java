package com.studentsystem.system;

import com.studentsystem.student.StudentList;

import java.util.Scanner;

public class StudentSystem {

    private final StudentList list;
    private final Scanner scanner;

    public StudentSystem() {
        this.list = new StudentList();
        this.scanner = new Scanner(System.in);
    }


    /** 添加学生 */
    public void add() {
        System.out.println("-------添加学生-------");
        System.out.println("请输入学生id：");
        String id = this.scanner.next();
        if (!this.idIsRepeat(id)) {
            System.out.println("请输入学生姓名：");
            String name = this.scanner.next();
            System.out.println("请输入学生年龄：");
            int age = this.scanner.nextInt();
            System.out.println("请输入学生住址：");
            String address = this.scanner.next();
            this.list.add(id,name,age,address);
            System.out.println("添加成功！");
        } else {
            System.out.println("id重复！");
        }

    }

    /** 删除学生 */
    public void delete() {
        System.out.println("-------删除学生-------");
        System.out.println("请输入学生id：");
        String id = this.scanner.next();
        if (this.idIsRepeat(id)) {
            this.list.delete(id);
            System.out.println("删除成功！");
        } else {
            System.out.println("id不存在！");
        }
    }

    /** 修改学生 */
    public void update() {
        System.out.println("-------修改学生-------");
        System.out.println("请输入学生id：");
        String id = this.scanner.next();
        if (this.idIsRepeat(id)) {
            System.out.println("请输入需要修改的信息类型(id,name,age,address");
            String sign = this.scanner.next();
            this.updateHelp(id,sign);
            System.out.println("修改成功！");
        } else {
            System.out.println("id不存在！");
        }
    }

    /** 查询学生 */
    public void query() {
        System.out.println("-------查询学生-------");
        if (this.list.size() > 0) {
            System.out.println(this.list.query());
        }
    }

    /** 修改学生辅助方法 */
    private void updateHelp(String id, String sign) {
        switch (sign) {
            case "id" -> {
                System.out.println("请输入新的学生id：");
                String newId = this.scanner.next();
                this.list.update(id, sign, newId);
            }
            case "name" -> {
                System.out.println("请输入新的学生name：");
                String newName = this.scanner.next();
                this.list.update(id, sign, newName);
            }
            case "age" -> {
                System.out.println("请输入新的学生age：");
                int newAge = this.scanner.nextInt();
                this.list.update(id, sign, newAge);
            }
            case "address" -> {
                System.out.println("请输入新的学生address：");
                String newAddress = this.scanner.next();
                this.list.update(id, sign, newAddress);
            }
        }
    }

    /** id是否重复 */
    private boolean idIsRepeat(String id){
        return this.list.repeat(id);
    }
}
