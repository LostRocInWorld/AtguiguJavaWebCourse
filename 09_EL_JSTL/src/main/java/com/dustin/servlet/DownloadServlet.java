package com.dustin.servlet; /**
 * @Classname ${NAME}
 * @Descrption TODO
 * @Date 2021/6/26上午 06:34
 * @Created By Dustin_Peng
 */

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 获取要下载的文件名
        String downloadFilename="1.jpeg";


        ServletContext servletContext = getServletContext();
        //       2. 在回传前，通过响应头告诉客户端返回的数据类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFilename);//获取要下载的类型
        response.setContentType(mimeType);
        System.out.println("下載的類型是："+mimeType);
//        3. 还要告诉客户端收到的数据是用于下载使用（使用响应头）
        //Content-Disposition，表示收到的數據怎麽處理
        //attachment表示附件，表示下載使用
        //filename 表示指定下載的文件名
        //URL編碼是把漢字转换成%xx%xx的格式

        //针对于火狐浏览器
        if(request.getHeader("User-Agent").contains("Firefox")){
            response.setHeader("Content-Disposition","attachment;filename==?UTF-8?B?"+
                    new BASE64Encoder().encode("你好啊.jpeg".getBytes("UTF-8"))+"?=");
        } else {
            //针对于IE和谷歌浏览器
            response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("你好啊.jpeg","UTF-8"));
        }

        //指定中文名時，需要使用URLEncode進行URL編碼
        //      4. 读取要下载的文件内容
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFilename);
        OutputStream outputStream=response.getOutputStream();
        //5. 把下载的文件内容回传给客户端
        //读取输入流中的全部数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);

//

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
