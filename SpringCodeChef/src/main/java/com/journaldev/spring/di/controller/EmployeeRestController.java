package com.journaldev.spring.di.controller;

import com.journaldev.spring.di.entity.Employee;
import com.journaldev.spring.di.exception.EmployeeNotFoundException;
import com.journaldev.spring.di.services.IEmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EmployeeRestController {

    private static final Logger logger = Logger.getLogger(EmployeeRestController.class);

    @Autowired
    private IEmployeeService employeeService;


    @ResponseBody
    @RequestMapping(value = "/rest/employee/get/{id}",method = RequestMethod.GET,produces = "application/json")
    public Employee getEmployeeByID(@PathVariable("id") int id) throws EmployeeNotFoundException {
        if(id==1){
            throw new EmployeeNotFoundException(id);
        }
        return employeeService.getEmployee(id);
    }

    @ResponseBody
    @RequestMapping(value = "/rest/employee/getAll" , method = RequestMethod.GET)
    //Returning is List is supported with JSON response only
    //If you want XML, then add a wrapper class as Root XML element, for example EmployeeList
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    @ResponseBody
    @RequestMapping(value = "/rest/employee/create",method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee emp) {
        employeeService.addEmployee(emp);
        return emp;
    }
    @ResponseBody
    @RequestMapping(value = "/rest/employee/search/{name}",method = RequestMethod.GET)
    public Employee getEmployeeByName(@PathVariable("name") String name) {
        return employeeService.search(name);
    }

    @ResponseBody
    @RequestMapping(value = "/rest/employee/delete/{id}",method = RequestMethod.DELETE)
    public void deleteEmployeeByID(@PathVariable("id") int id) {
         employeeService.deleteEmployee(id);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
        logger.error("Requested URL="+request.getRequestURL());
        logger.error("Exception Raised="+ex);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("database_error");
        return modelAndView;
    }

}
