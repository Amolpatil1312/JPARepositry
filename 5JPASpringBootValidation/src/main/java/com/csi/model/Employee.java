package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int empId;

    @Column(name = "Name")
    @Size(min =5,max = 15,message = "Name Must be in between 5 to 15 char")
    private String empName;

    @Column(name = "Address")
    private String empAddress;

    @Column(name = "Salary")
    private double empSalary;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "DOB")
    private Date empDOB;

    @Range(min = 1000000000,max = 9999999999L,message = "Contact Number Should be 10 Digit")
    @Column(name = "ContactNumber")
    private long empContactNumber;

    @Email(message = "Email Must be Valid")
    @Column(name = "EmailId")
    private String empEmailId;

    @Size(min = 4 ,message = "Password should be must be more than 4 chars")
    @Column(name = "Password")
    private String empPassword;


}
