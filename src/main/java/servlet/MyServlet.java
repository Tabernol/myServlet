package servlet;

import model.Student;
import repo.DataSource;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyServlet extends HttpServlet {
    StudentService studentService;

    private static String index = "/WEB-INF/view/index.jsp";

//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        req.getRequestDispatcher(index).forward(req, resp);
//    }

    private List<Student> students;

    @Override
    public void init() throws ServletException {
        DataSource.init();
        studentService = new StudentService();
        students = studentService.getStudents();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("students", students);
        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");

        if (!requestIsValid(req)) {
            doGet(req, resp);
        }

        final String name = req.getParameter("name");
        final String id = req.getParameter("id");

        final Student student = new Student();
        student.setIdStudent(Integer.parseInt(id));
        student.setNameStudent(name);
        students.add(student);

        doGet(req, resp);
    }

    private boolean requestIsValid(final HttpServletRequest req) {

        final String name = req.getParameter("name");
        final String id = req.getParameter("id");

        return name != null && name.length() > 0 &&
                id != null && id.length() > 0 &&
                id.matches("[+]?\\d+");
    }
}
