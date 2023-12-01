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
public class Customer {

    @Id
    @GeneratedValue

    private int custId;

    @Size(min = 3,message = "Name Must be Atleast 4 chars")
    private String custFirstName;

    @Size(min = 3,message = "Name Must be Atleast 4 chars")
    private String custLastName;

    @Size(min = 3,message = "Name Must be Atleast 4 chars")
    private String custAddress;

    private double custSalary;

    @Range(min = 1000000000l,max = 9999999999l,message = "Mobile number Should be 10 digits")
    private long custContactNumber;

    @Range(min = 100000000000l,max = 999999999999l,message = "Mobile number Should be 10 digits")
    private long custUID;

    private String custPanCardNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date custDOB;

    @Email(message = "Email should be valid..")
    private String custEmailId;

    @Size(min = 3,message = "Password must be more than 4 chars")
    private String custPassword;


}
