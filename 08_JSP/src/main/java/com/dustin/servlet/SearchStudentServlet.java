package com.dustin.servlet; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/24上午 03:17
 * @Created By Dustin_Peng
 */

import com.dustin.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
//        request.getParameter("xxx");
        //发送sql语句查询学生信息(可参考books中的做法)
        //保存查询到的结果(学生信息)到request域中  使用for循环生成查询到的学生信息模拟
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int j = i + 1;
            studentList.add(new Student(i + 1, "name" + j, 18 + j, "phone" + j));
        }
        request.setAttribute("studentList", studentList);
        //请求转发到showStudent.jsp
        request.getRequestDispatcher("/practice/showStudent.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
