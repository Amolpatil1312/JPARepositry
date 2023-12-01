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
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue
    private int custId;

    private String custName;

    private String custAddress;

    private long custContactNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date custDOB;

    private String custEmailid;

    private String custPassword;
}
