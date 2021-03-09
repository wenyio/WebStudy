package cn.mypji.GenericServlet.servlet;

import cn.mypji.GenericServlet.vo.Student;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 2. 将五个学生的信息打印在网页上
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/3/9
 * @see: cn.mypji.GenericServlet.servlet
 * @version: v1.0.0
 */
public class StudentServlet extends GenericServlet {

    List<Student> list = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        for (int i = 1; i < 6; i++) {
            Student student = new Student();
            student.setNumber("201817000" + i);
            student.setName("张大胆" + i + "号");
            student.setAge(18 + i);
            student.setSex((byte)(i % 2)); // 0 男 1 女
            student.setGrade((float) (i * 10.1));
            list.add(student);
        }
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setCharacterEncoding("gbk");
        servletResponse.setContentType("text/html");

        PrintWriter out = servletResponse.getWriter();
        out.println("<html><body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>学号</th>");
        out.println("<th>姓名</th>");
        out.println("<th>年龄</th>");
        out.println("<th>性别</th>");
        out.println("<th>成绩</th>");
        out.println("</tr>");
        for (Student student : list) {
            out.println("<tr>");
            out.println("<td>" + student.getNumber() + "</td>");
            out.println("<td>" + student.getName() + "</td>");
            out.println("<td>" + student.getAge() + "</td>");
            out.println("<td>" + (student.getSex() == 0 ? "男" : "女") + "</td>");
            out.println("<td>" + student.getGrade() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
    }
}
