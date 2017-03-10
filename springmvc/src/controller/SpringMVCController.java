package controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}
