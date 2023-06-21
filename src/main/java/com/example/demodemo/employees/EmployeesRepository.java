package com.example.demodemo.employees;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;          
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    
    @Query(value="select * from employees", nativeQuery = true)
    List<Employees> findAll();

    @Query(value="select * from employees where name= ?1", nativeQuery = true)
    Employees findByName(String name);

    @Modifying
    @Transactional
    @Query(value="update employees set name = 'xxx' where name= ?1", nativeQuery = true)
    void updateUser(String name);

    @Modifying
    @Query(value="update employees set name = ?2, email = ?3, icon = ?4 where id = ?1", nativeQuery = true)
    void updateEmployee(int id, String name, String email, String icon);

    @Modifying
    @Transactional
    @Query(value="insert into employees (name, email,icon) values (?1, ?2, ?3)", nativeQuery = true)
     void addEmployee(String name, String email, String icon);

     

     Employees findById(int id);

    void deleteById(int id);

}

/* 
package com.example.demodemo.employees;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;          
import javax.transaction.Transactional;

public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    
    @Query(value="select * from employees", nativeQuery = true)
    List<Employees> findAll();

    @Query(value="select * from employees where name= ?1", nativeQuery = true)
    Employees findByName(String name);

    @Modifying
    @Transactional
    @Query(value="update employees set name = 'xxx' where name= ?1", nativeQuery = true)
    void updateUser(String name);

    @Modifying
    @Transactional
    @Query(value="insert into employees (name, email) values (?1, ?2)", nativeQuery = true)
     void addEmployee(String name, String email);

}
*/