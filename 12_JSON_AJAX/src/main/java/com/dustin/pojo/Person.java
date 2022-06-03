package com.dustin.pojo;

/**
 * @Classname Person
 * @Descrption TODO
 * @Date 2021/7/7下午 09:28
 * @Created By Dustin_Peng
 */
public class Person {
    private Integer id;
    private String name;
    private String gender;

    public Person() {
    }

    public Person(Integer id,String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
