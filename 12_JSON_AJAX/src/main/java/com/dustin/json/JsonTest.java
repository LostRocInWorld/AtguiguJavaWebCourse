package com.dustin.json;

import com.dustin.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname JsonTest
 * @Descrption TODO
 * @Date 2021/7/7下午 09:29
 * @Created By Dustin_Peng
 */
public class JsonTest {

    //1.2.1 javaBean和json的互转
    @Test
    public void test1(){
        Person person = new Person(1,"靓仔","男");
        //创建Gson对象实例
        Gson gson =new Gson();
        //toJson()可以把java对象转换成JSON字符串形式
        String personJsonStr = gson.toJson(person);
        System.out.println(personJsonStr);  //{"id":1,"name":"靓仔","gender":"男"}

        //fromJson(@Nullable String json,@NotNull Class<T> classOfT)把JSON字符串转换成java对象
        //第一个参数是json字符串，第二个参数是转换回去的java对象类型
        Person person1 = gson.fromJson(personJsonStr, Person.class);
        System.out.println(person1);
    }

    @Test
    public void test2(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"靓仔","男"));
        personList.add(new Person(2,"康师傅","男"));

        //创建Gson对象实例
        Gson gson =new Gson();
        
        //toJson()把List集合转换成JSON字符串
        String personListJsonStr = gson.toJson(personList);
        System.out.println(personListJsonStr);

        //fromJson(@Nullable String json,reflect.Type typeOfT)把JSON字符串转换成List集合，需要一个继承TypeToken<T>的类来获得Type
        gson.fromJson(personListJsonStr,new PersonListType().getType());
    }

    @Test
    public void test3(){
        Map<String,Person> personMap = new HashMap<>();
        personMap.put("1",new Person(1,"靓仔","男"));
        personMap.put("2",new Person(2,"康师傅","男"));

        //创建Gson对象实例
        Gson gson =new Gson();

        //toJson()把List集合转换成JSON字符串
        String personMapJsonStr = gson.toJson(personMap);
        System.out.println(personMapJsonStr);

        //fromJson(@Nullable String json,reflect.Type typeOfT)把JSON字符串转换成Map，需要一个继承TypeToken<T>的类来获得Type
        //或者使用匿名内部类new TypeToken<HashMap<String,Person>>(){}.getType()
        Map<String,Person> personMap1 = gson.fromJson(personMapJsonStr, new TypeToken<HashMap<String, Person>>() {
        }.getType());
        System.out.println(personMap1);
        System.out.println(personMap1.get("1"));

    }


}
