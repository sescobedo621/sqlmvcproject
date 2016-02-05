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
import JDBC.StatesDAO;
@Controller
public class ComplexEmployeeController {
	@Autowired
	private EmployeesDAO dao;
	@Autowired
	private StatesDAO stateDAO;
	
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
	@RequestMapping(path="addEmployee.do", method=RequestMethod.GET)
	public ModelAndView addEmployeeForm(){
		stateDAO.initStates();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add.jsp");
		mv.addObject("states", stateDAO.getAbbrev());
		mv.addObject(new Employee());
		return mv;
	}
	@RequestMapping(path="addEmployee.do", method=RequestMethod.POST)
	public ModelAndView addEmployee(Employee emp){
		dao.addEmployee(emp);
		ModelAndView mv = allEmployees();
		return mv;
	}
	@RequestMapping(path="updateEmployee.do", method=RequestMethod.GET)
	public ModelAndView updateEmployeeForm(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delete.jsp");
		mv.addObject("employees", dao.listAllEmployees());
		return mv;
	}
	@RequestMapping(path="deleteEmployee.do", method=RequestMethod.POST)
	public ModelAndView deleteEmployee(Employee emp){
		//System.out.println(emp.getAddress());
		dao.remove(emp);
		ModelAndView mv = allEmployees();
		return mv;
	}
	@RequestMapping(path="updateEmployee.do", params="id", method=RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam("id") int id){
		Employee emp = dao.getEmployee(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateEmployee.jsp");
		mv.addObject("employee", emp);
		mv.addObject("states", stateDAO.getAbbrev());
		return mv;
	}
	@RequestMapping(path="updateEmployee.do", method=RequestMethod.POST)
	public ModelAndView updateEmployee(Employee emp){
		dao.updateEmployee(emp);
		
		ModelAndView mv = displayEmployee(emp.getId());
		
		return mv;
	}
}
