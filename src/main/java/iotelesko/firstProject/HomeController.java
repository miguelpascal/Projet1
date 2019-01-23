package iotelesko.firstProject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("hi");
		return "home";
	}
	@RequestMapping("hello")
	public String hello(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String name= req.getParameter("name");
		System.out.println("hi "+ name);
		session.setAttribute("name", name);
		return "hello";
	}
	@RequestMapping("hi")
	public String hi(@RequestParam("name")  String myName, HttpSession session) {
		
		System.out.println("hi "+ myName);
		session.setAttribute("name", myName);
		return "hello";
	}
	@RequestMapping("salut")
	public ModelAndView salut(@RequestParam("name")  String myName) {
		
		System.out.println("hi "+ myName);
		ModelAndView mv= new ModelAndView();
		mv.addObject("name", myName);
		mv.setViewName("hello");

		return mv;
	}
	
	@RequestMapping("bonjour")
	public ModelAndView bonjour(Alien alien) {
		
		System.out.println("hi "+ alien.getAname());
		ModelAndView mv= new ModelAndView();
		mv.addObject("obj", alien);
		mv.setViewName("hello");

		return mv;
	}

}
