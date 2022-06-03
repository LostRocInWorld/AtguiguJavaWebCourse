package com.dustin.servlet;

import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname RegisterServlet
 * @Descrption TODO
 * @Date 2021/7/4上午 03:10
 * @Created By Dustin_Peng
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

//        ————————验证码————————

        //1.获取Session中的验证码，并删除Session中的验证码
        String token = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);//防止第二次使用
        //2.获取表单项中的表单信息
        //获取验证码
        String code = request.getParameter("code");

        //获取用户密码和密码
        String username = request.getParameter("username");

        //3.比较Session中的验证码和表单中的验证码
        if(token!=null &&token.equalsIgnoreCase(code)){
            System.out.println("保存到数据库:"+username);
        }else {
            System.out.println("请不要重复提交");
        }
//        request.getRequestDispatcher("/ok.jsp").forward(request,response);


/*        //模拟网络延迟
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //使用重定向防止表单重复提交
        response.sendRedirect(request.getContextPath()+"/ok.jsp");
    }
}
