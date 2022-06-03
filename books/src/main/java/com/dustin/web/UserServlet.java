package com.dustin.web; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/26下午 10:24
 * @Created By Dustin_Peng
 */

import com.dustin.pojo.User;
import com.dustin.service.UserService;
import com.dustin.service.impl.UserServiceImpl;
import com.dustin.utils.WebUtil;
import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("经过了UserServlet的doGet()方法，俺啥也不做");
//    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
////        System.out.println(action);
////        if("login".equals(action)){
////            login(request,response);
////        }else if("regist".equals(action)){
////            regist(request,response);
////        }
//        //反射优化else if
//        try {
//            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
//            method.invoke(this, request, response);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 处理登陆功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理登录的业务
//            System.out.println("处理login");
        //        1. 获取请求的参数；
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        2. 调用XxxService.xxx()处理业务；
        User loginUser = userService.login(new User(null, username, password, null));
//        3. 根据login()方法返回结果判断登录
        if (loginUser == null) {
//          3.2 失败  跳回登录页面
            //把错误信息和回显的表单项信息，保存到request域中(请求转发request仍是同一个且有效)
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
//            System.out.println("用戶名或密碼錯誤");

            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
//          3.1 成功  跳到登录成功页面

            //保存用户登录的信息到Session域中
            request.getSession().setAttribute("user",loginUser);

            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    /**
     * 处理注册功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理注册的业务
//            System.out.println("处理regist");
//        super.doPost(request,response);

        //获取Session中的验证码，并删除Session中的验证码
        String token = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);//防止第二次使用

//        1. 获取请求参数；
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");


//            int sum = Integer.sum(100, 200);

        //        1. 获取请求参数，使用BeanUtils优化
        User user = WebUtil.copyParamToBean(request.getParameterMap(), new User());

////        关于populate()注入的细节
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        for (Map.Entry<String, String[]> map :
//                parameterMap.entrySet()) {
//            System.out.println(map.getKey() + "=" + Arrays.asList(map.getValue()));
//            try {
//                //当更改setUsernam()为setUsername1()时，username未正确注入
//                BeanUtils.populate(user, parameterMap);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }


//        2. 检查 验证码是否正确  ,比较Session中的验证码和表单中的验证码
            if (token!=null && token.equalsIgnoreCase(code)) {
//              正确
//                   3.检查用户名是否可用
                if (userService.existUsername(username)) {
//      	            不可用,跳回注册页面
//                System.out.println("用户名已存在：" + username);
                    //把回显信息保存到request域中
                    request.setAttribute("msg", "用户名已存在!");
                    request.setAttribute("username", username);
                    request.setAttribute("email", email);
                    request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
                } else {
//                      可用
//   		    调用Service保存到数据库，跳到注册成功页面regist_success.html
                    userService.registerUser(new User(null, username, password, email));
                    request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
                }
            } else {
//            System.out.println("---验证码错误:" + code);
                //把回显信息保存到request域中
                request.setAttribute("msg", "验证码错误!");
                request.setAttribute("username", username);
                request.setAttribute("email", email);

                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            }
        }

    /**
     * 登出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 销毁Session中用户登陆的信息（或者销毁Session）
        request.getSession().invalidate();
//        2. 重定向到首页（或者登陆页面）
        response.sendRedirect(request.getContextPath());
    }

    /**
     * ajax检查用户名是否已经存在
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxExistsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数
        String username = request.getParameter("username");
        //2.调用UserService.existsUserName
        boolean existsUsername = userService.existUsername(username);
        //3.把返回的结果封装成为Map对象，
        Map<String,Object> resultMap = new Hashtable<>();
        resultMap.put("existsUsername",existsUsername);
        //转换成json对象
        Gson gson = new Gson();
        String resultJson = gson.toJson(resultMap);
        //4.response响应输出
        response.getWriter().write(resultJson);

    }

    }

