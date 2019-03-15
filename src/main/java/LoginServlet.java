import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        if(req.getParameter("remember") == "true"){
            session.setAttribute("username",req.getParameter("username"));
            session.setAttribute("password",req.getParameter("password"));
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String currname = req.getParameter("username");
        String currpass = req.getParameter("password");
        String remember = req.getParameter("remember");
        HttpSession session = req.getSession();
        session.setAttribute("Username",currname);
        session.setAttribute("Password",currpass);
        if("yes".equals(remember)){
            Cookie c = new Cookie("Username", currname);
            c.setMaxAge(60*60*24*30);
            resp.addCookie(c);
        } else {
            Cookie c = new Cookie("Username", null);
            c.setMaxAge(0);
            resp.addCookie(c);
        }

        User newUser = new User(currname,currpass);
        boolean userFound = false;
        Userdata userdata = new Userdata();
        for (User u : userdata.users ) {
            if(u.equals(newUser)) userFound = true;
        }
        if (userFound == true) {
            resp.sendRedirect("login.jsp");
        }else {
            req.setAttribute("err_msg","Username and/or password is invalid!");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        };
    }
}
