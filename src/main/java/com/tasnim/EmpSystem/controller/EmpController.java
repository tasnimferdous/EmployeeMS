package com.tasnim.EmpSystem.controller;

import com.tasnim.EmpSystem.entity.Employee;
import com.tasnim.EmpSystem.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService service;
    @GetMapping("/")
    public String home(Model m){
        List<Employee> emp_lst = service.getAllEmp();
        m.addAttribute("emp_lst", emp_lst);
        return "index";
    }
    @GetMapping("/add-emp")
    public String addEmpForm(){
        return "add-emp";
    }
    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee emp, HttpSession session){
        service.addEmp(emp);
        session.setAttribute("msg", "Employee added successfully.");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m){
        Employee emp = service.getEMpById(id);
        m.addAttribute("emp", emp);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee emp, HttpSession session){
        service.addEmp(emp);
        session.setAttribute("msg", "Employee added successfully.");
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id){
        service.deleteEmp(id);
        return "redirect:/";
    }
}
