package com.vnh.assignment.dto;

import com.vnh.assignment.enums.ContractType;
import com.vnh.assignment.enums.Gender;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    public String name;

    public Gender sex;

    public String dob;

    public String domestic;

    public String accountType;

    public List<String> businessRequirements;

    public ContractType contractType;

}
