package com.example.addressbook.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookResponseDto {
    private String firstName;
    private String phoneNumber;
    private String email;
    private String companyName;
    private String faxNumber;
}
