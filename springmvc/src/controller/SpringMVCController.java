package controller;

import entity.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

//下面的注解，标志这是一个spring中的controller
@Controller
@RequestMapping(value = "/home")
public class SpringMVCController{
    @RequestMapping("/index")
    public String index(HttpServletRequest resq, HttpServletResponse resp, @RequestParam(value="id") String id, Test test,Map<String, Object> model){
        System.out.println("正在执行index方法 id:" + id);
        System.out.println("Test: " + test);
        //req.setAttribute("msg", "hello " + name);
        model.put("msg", "hello " + id);
        return "index";
    }
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
