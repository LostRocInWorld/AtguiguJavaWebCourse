package com.dustin.pojo;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Classname Dom4jTest
 * @Descrption TODO
 * @Date 2021/6/17上午 04:24
 * @Created By Dustin_Peng
 */
public class Dom4jTest {
    @Test
    public void test1() throws Exception {
        //创建一个SAXReader输入流，去读取xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");    //相对路径默认当前Module下

//        System.out.println(document);
    }

    /**
     * 读取books.xml文件生成Book类
     */
    @Test
    public void test2() throws Exception {
        //1.读取books.xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");    //在Junit中，相对路径是从Module名开始算的
        //2.通过Document对象获取根元素
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement);
        //3.通过根元素获取book标签对象
        //element()和elements都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        //4.遍历，处理每个book标签转换为Book类
        for(Element book:books){
            //asXML()把标签对象转换为标签字符串
//            System.out.println(book.asXML());
            Element nameElement = book.element("name");//name标签对象
            //getText()方法可以获取标签中的文本内容
            String nameText = nameElement.getText();

            //直接获取指定标签名的文本内容
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");
            System.out.println(priceText);

            //获取属性值
            String snValue = book.attributeValue("sn");

            //创建Book类
            System.out.println(new Book(snValue,nameText,new BigDecimal(priceText),authorText));
        }
    }
}
