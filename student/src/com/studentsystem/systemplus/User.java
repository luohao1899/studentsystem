package com.studentsystem.systemplus;

public class User {
    private String userName;
    private String passWord;
    private String personId;
    private String phoneNumber;


    public User(){

    }

    public User(String userName, String passWord, String personId, String phoneNumber) {
        this.userName = userName;
        this.passWord = passWord;
        this.personId = personId;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
