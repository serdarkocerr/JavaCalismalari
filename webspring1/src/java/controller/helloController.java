/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class helloController extends AbstractController {
    
    public helloController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
            String page = request.getParameter("tf1");
            System.out.println(" helloController'a gelen request icindeki page bilgisi : " + page);

             ModelAndView mw = new ModelAndView(page);//sayfanin adi olur. hello.jsp "hello"
             mw.addObject("message", "Mesaj helloController!!!!!");
            
             System.out.println("controller.helloController.handleRequestInternal() -- HELLO CONTROLLER");
             return mw;
    }
    
}
