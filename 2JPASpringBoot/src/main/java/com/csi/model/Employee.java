package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue
    private int empId;

    private String empName;

    private String empaddress;

    private double empsalary;

    private long empContactNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date empDOB;

    private String empGender;

    private String empEmailId;

    private String empPassword;

}


