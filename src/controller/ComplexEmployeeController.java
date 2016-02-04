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
public class ComplexEmployeeController {
	@Autowired
	private EmployeesDAO dao;
	
	@RequestMapping(path="allEmployees.do", method=RequestMethod.GET)
	public ModelAndView allEmployees(){
		ArrayList<Employee> emp = dao.listAllEmployees();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employees.jsp");
		mv.addObject("employees", emp);
		
		return mv;
	}
	
	@RequestMapping(path="employee.do", params="id", method=RequestMethod.GET)
	public ModelAndView displayEmployee(@RequestParam("id") int id){
		Employee employee = dao.getEmployee(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employee.jsp");
		mv.addObject("employee", employee);
		
		return mv;
	}
	
}
