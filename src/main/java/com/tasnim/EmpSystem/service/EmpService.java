package com.tasnim.EmpSystem.service;

import com.tasnim.EmpSystem.entity.Employee;
import com.tasnim.EmpSystem.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo repo;
    public void addEmp(Employee emp){
        repo.save(emp);
    }

    public List<Employee> getAllEmp(){
        return repo.findAll();
    }

    public Employee getEMpById(int id) {
        Optional<Employee> emp = repo.findById(id);
        if (emp.isPresent()) {
            return emp.get();
        }
        return null;
    }

    public void deleteEmp(int id) {
        repo.deleteById(id);
    }
}
