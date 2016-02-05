package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import JDBC.Employee;
import JDBC.EmployeesDAO;

@Controller
public class EmployeesController {
	@Autowired
	private EmployeesDAO dao;

	@RequestMapping(path = "sql.do", method = RequestMethod.GET)
	public ModelAndView select()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("select.jsp");
		return mv;
	}

	@RequestMapping(path = "sql.do", params = "query", method = RequestMethod.GET)
	public ModelAndView select(@RequestParam("query") String sqltext)
	{
		ArrayList<ArrayList> arrList = dao.select(sqltext);
		System.out.println("after dao select method");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("arrayList", arrList);

		return mv;

	}
	
	@RequestMapping(path="update.do", method = RequestMethod.GET)
	public ModelAndView update(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("simpleupdate.jsp");
		return mv;
	}
	
	@RequestMapping(path="update.do", params="sqltext", method=RequestMethod.POST)
	public ModelAndView update(@RequestParam("sqltext") String sqltext){
		//System.out.println(sqltext);
		int uc = dao.update(sqltext);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update.jsp");
		mv.addObject("number", uc );
		
		return mv;
	}
}
