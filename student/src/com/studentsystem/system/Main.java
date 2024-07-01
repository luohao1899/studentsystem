package com.studentsystem.system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentSystem system = new StudentSystem();
        loop:while (true) {
            System.out.println("-----学生管理系统-----");
            System.out.println("\t1：添加学生");
            System.out.println("\t2：删除学生");
            System.out.println("\t3：修改学生");
            System.out.println("\t4：查询学生");
            System.out.println("\t5：退出系统");

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您想操作的选项标号：");
            String choose = sc.next();

            switch (choose){
                case "1" -> system.add();
                case "2" ->system. delete();
                case "3" -> system.update();
                case "4" -> system.query();
                case "5" -> {
                    System.out.println("感谢使用本系统！");
                    break loop;
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }
}
