package com.example.addressbook.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class APIResponse <T>{
    private String message;
    private  Boolean success;
    private T payload;
}
