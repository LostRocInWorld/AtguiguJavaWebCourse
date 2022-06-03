package com.dustin.pojo;

/**
 * @Classname Student
 * @Descrption TODO
 * @Date 2021/6/25上午 04:46
 * @Created By Dustin_Peng
 */
public class Student {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String phone;

    public Student() {
    }

    public Student(Integer id, String name, String password, Integer age, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
