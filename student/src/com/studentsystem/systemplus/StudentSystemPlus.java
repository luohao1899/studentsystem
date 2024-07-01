package com.studentsystem.systemplus;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StudentSystemPlus {

    private final ArrayList<User> list;
    private final Scanner scanner;

    public StudentSystemPlus() {
        this.list = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /** 用户登录 */
    public boolean login() {
        boolean ret = false;
        System.out.println("-------用户登录-------");
        System.out.println("请输入用户名：");
        String userName = this.scanner.next();
        System.out.println("请输入密码：");
        String passWord = this.scanner.next();
        while (true) {
            System.out.println("请输入验证码：");
            String trueCaptcha = this.captcha();
            System.out.println("当前正确验证码为：" + trueCaptcha);
            String captcha = this.scanner.next();
            if (trueCaptcha.equals(captcha)) {
                break;
            } else {
                System.out.println("验证码错误！");
            }
        }
        if (userIsExistence(userName, passWord)) {
            System.out.println("用户" + userName + "登陆成功！");
            ret = true;
        } else {
            System.out.println("用户" + userName + "不存在！");
        }
        return ret;
    }

    /** 用户注册 */
    public void enroll() {
        System.out.println("-------用户注册-------");
        System.out.println("请输入用户名（字母和数字组合，长度为3-15）：");
        User user = new User();
        String userName = this.scanner.next();
        if (!userIsExistence(userName)) {
            if (this.userNameJudgement(userName)) {
                user.setUserName(userName);
                while (true) {
                    System.out.println("请输入密码（长度为8-64）：");
                    String passWord = this.scanner.next();
                    if (passWord.length() > 7 && passWord.length() < 65) {
                        System.out.println("请再次输入密码（长度为8-64）：");
                        String newPassWord = this.scanner.next();
                        if (!passWord.equals(newPassWord)) {
                            System.out.println("两次输入的密码不一样，请重试！");
                        } else {
                            user.setPassWord(passWord);
                            break;
                        }
                    } else {
                        System.out.println("输入的密码不符合要求！");
                    }
                }
                while (true) {
                    System.out.println("请输入身份证号码：");
                    String personId = this.scanner.next();
                    if (!this.personIdJudgement(personId)) {
                        System.out.println("输入的身份证号码有误！");
                    } else {
                        user.setPersonId(personId);
                        break;
                    }
                }
                while (true) {
                    System.out.println("请输入手机号码：");
                    String phoneNumber = this.scanner.next();
                    if (!this.phoneNumberJudgement(phoneNumber)) {
                        System.out.println("输入的手机号码有误！");
                    } else {
                        user.setPhoneNumber(phoneNumber);
                        break;
                    }
                }
                this.list.add(user);
                System.out.println("用户" + userName + "注册成功！");
            } else {
                System.out.println("用户名" + userName + "不符合要求，将返回主菜单！");
            }

        } else {
            System.out.println("用户名" + userName + "存在，将返回主菜单！");
        }
    }

    /** 忘记密码 */
    public void forgotPassword() {
        System.out.println("-------忘记密码-------");
        System.out.println("请输入用户名：");
        String userName = this.scanner.next();
        int index = userAtIndex(userName);
        if (index != -1) {
            System.out.println("请输入身份证号码：");
            String personId = this.scanner.next();
            if (!this.list.get(index).getPersonId().equals(personId)) {
                System.out.println("输入的身份证号码有误，将返回主菜单！");
                return;
            }
            System.out.println("请输入手机号：");
            String phoneNumber = this.scanner.next();
            if (!this.list.get(index).getPhoneNumber().equals(phoneNumber)) {
                System.out.println("输入的手机号码有误，将返回主菜单！");
                return;
            }
            while (true) {
                System.out.println("请输入新的密码（长度为8-64）：");
                String passWord = this.scanner.next();
                if (passWord.length() > 7 && passWord.length() < 65) {
                    System.out.println("请再次输入新的密码（长度为8-64）：");
                    String newPassWord = this.scanner.next();
                    if (!passWord.equals(newPassWord)) {
                        System.out.println("两次输入的密码不一样，请重试！");
                    } else {
                        this.list.get(index).setPassWord(passWord);
                        System.out.println("密码修改成功！");
                    }
                    break;
                } else {
                    System.out.println("输入的密码不符合要求！");
                }
            }
        } else {
            System.out.println("用户" + userName + "未注册！");
        }
        System.out.println();
    }

    /** 用户查找 */
    private boolean userIsExistence(String userName) {
        boolean ret = false;
        int index = 0;
        while (index < this.list.size() && !ret) {
            ret = this.list.get(index).getUserName().equals(userName);
            index++;
        }
        return ret;
    }

    /** 用户查找 */
    private int userAtIndex(String userName) {
        int ret = -1;
        int index = 0;
        while (index < this.list.size()) {
            if (this.list.get(index).getUserName().equals(userName)) {
                ret = index;
            }
            index++;
        }
        return ret;
    }

    /** 用户查找 */
    private boolean userIsExistence(String userName, String passWord) {
        boolean ret = false;
        int index = 0;
        while (index < this.list.size() && !ret) {
            ret = this.list.get(index).getUserName().equals(userName) &&
                    this.list.get(index).getPassWord().equals(passWord);
            index++;
        }
        return ret;
    }

    /** 生成验证码 */
    private String captcha() {
        String words = "abcdefghijklmnopqrstuvwxyz";
        String upperWords = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int count = 0; count < 5; count++) {
            switch (random.nextInt(3)) {
                case 0:
                    str.append(words.charAt(random.nextInt(26)));
                    break;
                case 1:
                    str.append(upperWords.charAt(random.nextInt(26)));
                    break;
                case 2:
                    str.append(random.nextInt(10));
                    break;
            }
        }
        return str.toString();
    }

    /** 用户名判断 */
    private boolean userNameJudgement(String userName) {
        boolean ret = false;
        if (userName.length() > 2 && userName.length() < 16) {
            ret = true;
            int index = 0;
            while (index < userName.length() && ret) {
                ret = (userName.charAt(index) >= 'a' && userName.charAt(index) <= 'z') ||
                        (userName.charAt(index) >= 'A' && userName.charAt(index) <= 'Z') ||
                        (userName.charAt(index) >= '0' && userName.charAt(index) <= '9');
                index++;
            }
        }
        return ret;
    }

    /** 身份证号码判断 */
    private boolean personIdJudgement(String personId) {
        boolean ret = false;
        if (personId.length() == 18) {
            if (personId.charAt(0) > '0' && personId.charAt(0) <= '9') {
                ret = true;
                int index = 1;
                while (index < personId.length() - 1 && ret) {
                    ret = personId.charAt(index) >= '0' && personId.charAt(index) <= '9';
                    index++;
                }
                if (index == 17) {
                    char endChar = personId.charAt(personId.length() - 1);
                    ret = (endChar >= '0' && endChar <= '9') || (endChar == 'x' || endChar == 'X');
                }
            }
        }
        return ret;
    }

    /** 电话号码判断 */
    private boolean phoneNumberJudgement(String phoneNumber) {
        boolean ret = false;
        if (phoneNumber.length() == 11) {
            if (phoneNumber.charAt(0) > '0' && phoneNumber.charAt(0) <= '9') {
                ret = true;
                int index = 1;
                while (index < phoneNumber.length() && ret) {
                    ret = phoneNumber.charAt(index) >= '0' && phoneNumber.charAt(index) <= '9';
                    index++;
                }
            }
        }
        return ret;
    }

}
