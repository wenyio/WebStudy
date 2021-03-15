package cn.njpji.ServletContext.servlet;

import cn.njpji.ServletContext.constant.ContentType;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/3/15
 * @see: cn.njpji.ServletContext.servlet
 * @version: v1.0.0
 */
public class ImgServlet extends HttpServlet {

    private static final String JPG = "image/jpeg;charset=GB2312";
    private static final String HTML = "text/html";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OutputStream output = resp.getOutputStream();
        ServletContext context = this.getServletContext();

        resp.reset();
        resp.setContentType(ContentType.JPG);

        // 获取web.xml中的文件路径
        String imgPath = context.getInitParameter("imgPath");
        // 得到图片的文件流
        InputStream inImage = context.getResourceAsStream(imgPath);
        // 得到输入的编码器，将文件流进行jpg格式编码
        JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(inImage);
        // 得到输出的编码器
        BufferedImage image = decoder.decodeAsBufferedImage();
        // 得到输出的编码器
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(output);
        // 对图片进行输出编码
        encoder.encode(image);
        // 关闭文件流
        inImage.close();
    }
}
