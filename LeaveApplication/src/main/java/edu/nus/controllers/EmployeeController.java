package edu.nus.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.nus.models.Employee;
import edu.nus.repo.EmployeeRepository;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeRepository empRepo;

    @Autowired
    public void setProductRepository(EmployeeRepository employeeRepo) {
        this.empRepo = employeeRepo;
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add() {
        return "welcome";
    }
    

    @RequestMapping(path = "/{id}/list", method = RequestMethod.GET)
    public String showEmployeeList(Model model,@PathVariable(value = "id") String id) {
    	Employee em =  empRepo.findById(Long.valueOf(id)).orElse(new Employee());
    	
        model.addAttribute("employees",em.getEmployees());
        return "employee_list";
    }
    
   
    
}
