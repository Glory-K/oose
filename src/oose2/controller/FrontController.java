package oose2.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="frontController", value = "/front/*")

public class FrontController extends HttpServlet{

    private Map<String, Controller> controllerMap = new HashMap<>();

    public FrontController() {
        controllerMap.put("member", new MemberController());
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // http://localhost:8080/oose/front/member/regist

        // /front/memeber/regist
        String uri = request.getRequestURI();

        // /oose
        String conPath = request.getContextPath();

        System.out.println("\nconPath1 : "+ conPath);

        // /front
        conPath += "/front";

        // /front/member/regist.jsp -> /member/regist.jsp
        String com = uri.substring(conPath.length());

        // /front/memeber/regist.jsp
        System.out.println("\nuri : "+ uri);

        // /oose + /front
        System.out.println("\nconPath : " + conPath);

        // /member/regist.jsp
        System.out.println("\ncom : "+ com);

        if(com.equals("/")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        else {
            String[] tokens = com.split("/");
            String domain = tokens[1];
            Controller controller = controllerMap.get(domain);

            if(domain!=null)
                System.out.println("\n--------domain--------\n" + domain);

            if (controller == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            ModelAndView mv = controller.process(request, response, com);

            String viewPath = viewResolver(mv.getViewName());
            View view = new View(viewPath);
            view.render(mv.getModel(), request, response);
        }
    }
    private String viewResolver(String viewName) {
        // "WEB-INF/view/member/member-list.jsp"
        return "/WEB-INF/jsp/"+viewName+".jsp";
    }
}
