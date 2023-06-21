package com.example.demodemo.employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController  
@RequestMapping("/api")
@CrossOrigin
public class EmployeesController {
    @Autowired   
    private EmployeesRepository repository;

    @PutMapping("/employees/{id}")
    public Employees updateEmployee(@PathVariable("id") int id, @RequestBody Employees updatedEmployee) {
    Employees employee = repository.findById(id);
    if (employee != null) {
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setIcon(updatedEmployee.getIcon());
        return repository.save(employee);
    } else {
        throw new IllegalArgumentException("指定されたIDの従業員が見つかりません");
    }
}

    @GetMapping("/employees") 
    public List<Employees>getAllUsers(){
        List<Employees>employees=repository.findAll();
        return employees;
    }

    @GetMapping("/{name1}")
    public Employees getById(@PathVariable("name1")String name){
        return repository.findByName(name);
    }

    @PostMapping("update")
    public String updateName(@RequestParam(("fromName")) String fromName){
        repository.updateUser(fromName);
        return "変更しました";
    }

    @PostMapping("/employees")
    public Employees addEmployee(@RequestParam("name") String name, @RequestParam("email") String email,@RequestParam("icon") String icon) {
    Employees newEmployee = new Employees();
    newEmployee.setName(name);
    newEmployee.setEmail(email);
    newEmployee.setIcon(icon);
    
    return repository.save(newEmployee);
    }

    

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        repository.deleteById(id);
        return "削除しました";
    }

     
}

/* 
package com.example.demodemo.employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController  
@RequestMapping("/api")
@CrossOrigin
public class EmployeesController {
    @Autowired   
    private EmployeesRepository repository;

    @GetMapping("/employees") 
    public List<Employees>getAllUsers(){
        List<Employees>employees=repository.findAll();
        return employees;
    }

    @GetMapping("/{name1}")
    public Employees getById(@PathVariable("name1")String name){
        return repository.findByName(name);
    }

    @PostMapping("update")
    public String updateName(@RequestParam(("fromName")) String fromName){
        repository.updateUser(fromName);
        return "変更しました";
    }

    @PostMapping("/employees")
    public Employees addEmployee(@RequestParam("name") String name, @RequestParam("email") String email) {
    Employees newEmployee = new Employees();
    newEmployee.setName(name);
    newEmployee.setEmail(email);
    
    return repository.save(newEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        repository.deleteById(id);
        return "削除しました";
    }
    
}
*/

/* 
package com.example.demodemo.employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Controller
@RestController  
@RequestMapping("/api")
@CrossOrigin
public class EmployeesController {
    @Autowired   
    private EmployeesRepository repository;

    @GetMapping("/employees") 
    public List<Employees>getAllUsers(){
        List<Employees>employees=repository.findAll();
        return employees;
    }

    @GetMapping("/{name1}")
    public Employees getById(@PathVariable("name1")String name){
        return repository.findByName(name);
    }

    @PostMapping("update")
    public String updateName(@RequestParam(("fromName")) String fromName){
        repository.updateUser(fromName);
        return "変更しました";
    }

    @PostMapping("/employees")
    public Employees addEmployee(@RequestParam("name") String name, @RequestParam("email") String email) {
    Employees newEmployee = new Employees();
    newEmployee.setName(name);
    newEmployee.setEmail(email);
    
    return repository.save(newEmployee);
    }
    
}
*/