package com.dustin.servlet; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/25下午 10:36
 * @Created By Dustin_Peng
 */

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("文件上传ok");
        //以流的形式发送需要以流的形式接受，下面的获取参数无法获取
//        System.out.println(request.getParameter("username"));
//        System.out.println(request.getParameter("photo"));
//        ServletInputStream inputStream = request.getInputStream();
//        byte[] buffer= new byte[1024];
//        int read = inputStream.read(buffer);
////        System.out.println(new String(buffer,0,read));


        //1.判断上传的数据是否是多段数据(只有是多段的，才是文件上传的)
        if(ServletFileUpload.isMultipartContent(request)){
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            //创建用于上传解析数据的工具类ServletFileUpload
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            //解析上传的数据，得到每一个表单项
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //循环判断每一个表单项的类型
                for(FileItem fileItem:list){
                    if(fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name属性值"+fileItem.getFieldName());
                        System.out.println("表单项的name属性值"+fileItem.getString("UTF-8"));
                    }else {
                        System.out.println("上传文件的name属性值"+fileItem.getFieldName());
                        System.out.println("上传文件名"+fileItem.getName());
                        fileItem.write(new File("D:\\TempFile_Java\\"+fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
