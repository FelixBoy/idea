package controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SpringMVCController extends MultiActionController {
	public ModelAndView add(HttpServletRequest request,  
            HttpServletResponse response) {
        String idq = request.getParameter("idq");
	    request.setAttribute("idq", idq);
        ModelAndView mav = new ModelAndView();  
        mav.setViewName("b.jsp");  
        return mav;  
    }  
	public ModelAndView del(HttpServletRequest request,  
            HttpServletResponse responser) {
        ModelAndView mav = new ModelAndView();  
        mav.setViewName("c.jsp");  
        return mav;  
    }
    public ModelAndView test(HttpServletRequest request,
                            HttpServletResponse responser) throws IOException {
	    String name = request.getParameter("name");
        String email = request.getParameter("email");
        String date = request.getParameter("datetime");
        System.out.print(name + " " + email + " " + date);
        responser.setCharacterEncoding("UTF-8");
       responser.getWriter().write("哈哈哈");
        return null;
    }
}
