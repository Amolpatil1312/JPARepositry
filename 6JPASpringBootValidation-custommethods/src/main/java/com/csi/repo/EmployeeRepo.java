package com.csi.repo;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    public Employee findByEmpEmailIdAndEmpPassword(String empEmailId,String empPassword);

    public List<Employee> findByEmpName(String empName);

    public Employee findByEmpContactNumber(long empContact);

    public Employee findByEmpEmailId(String empEmail);

    public Employee findByEmpUID(long empUID);
}
