package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue

    @Column(name = "ID")
    private int empId;

    @Column(name = "Name")
    @NotNull
    @Size(min = 3,message = "Name should be atlest 3 Letters")
    private String empName;

    @Column(name = "Address")
    @NotNull
    private String empAddress;

    @Column(name = "ContactNumber",unique = true)
    @NotNull
    @Range(min = 1000000000l,max = 9999999999l,message = "Contact Number must Be 10 digits")
    private long empContactNumber;

    @Column(name = "Salary")
    @NotNull
    private double empSalary;

    @Column(name = "Date_of_Birth")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date empDOB;

    @Column(name = "Department")
    @NotNull
    private String empDept;

    @Column(name = "UID" , unique = true)
    @NotNull
    private long empUID;

    @Column(name = "PanCard_Number")
    @NotNull
    private  String empPan;

    @Column(name = "Email_ID",unique = true)
    @NotNull
    @Email(message = "Email Should be Proper")
    private String empEmailId;

    @Column(name = "Password")
    @NotNull
    @Size(min = 4)
    private String empPassword;


}
