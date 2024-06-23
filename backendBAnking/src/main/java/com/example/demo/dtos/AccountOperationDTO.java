package com.example.demo.dtos;

import lombok.Data;
import com.example.demo.enums.*;

import java.util.Date;

@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;
}

