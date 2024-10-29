package com.vnh.assignment.entity;

import com.vnh.assignment.enums.ContractType;
import com.vnh.assignment.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;

    public Gender sex;

    public String dob;

    public String domestic;

    @Column(name = "account_type")
    public String accountType;

    @Column(name = "business_requirements")
    public List<String> businessRequirements;

    @Column(name = "contract_type")
    public ContractType contractType;

}
