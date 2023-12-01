package com.csi.repo;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    //custom methods to be add

    public List<Employee> findByEmpName(String empName);

    public List<Employee> findByEmpNameStartingWith(String preffix);
    public List<Employee> findByEmpNameEndingWith(String suffix);
    public List<Employee> findByEmpNameContaining(String words);

}
