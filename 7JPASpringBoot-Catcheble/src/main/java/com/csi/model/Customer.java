package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int custId;

    @Size(min = 3,message = "size should be more than 3 letters")
    private String custName;

    private String custAddress;

    @Column(unique = true)
    private long custContactNumber;

    private double custSalary;

    @Email(message = "Email-id must be valid")
    private String custEmailId;


    @Size(min = 3,message = "Password should be more than 3 Chars")
    private String custPassword;

}
