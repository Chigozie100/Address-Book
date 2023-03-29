package com.example.addressbook.controllers;

import com.example.addressbook.dtos.APIResponse;
import com.example.addressbook.dtos.AddressBookRequestDto;
import com.example.addressbook.models.AddressBook;
import com.example.addressbook.services.AddressBookService;
import com.example.addressbook.utils.Constants;
import com.example.addressbook.utils.Responder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/")
@RestController
@RequiredArgsConstructor
public class AddressBookController {
    private final AddressBookService service;
    private final Responder responder;


    @PostMapping("/addAddressBook")
    public ResponseEntity<APIResponse> addAddressBook(@RequestBody AddressBookRequestDto requestDto){
        return responder.okay(service.createAddressBook(requestDto));
    }

    @GetMapping("/getAddressBook/{name}")
    public ResponseEntity<APIResponse> getAddressBook(@PathVariable String name){
        return  responder.okay(service.getAddressBook(name));
    }

    @GetMapping("allAddressBooks")
    public ResponseEntity<Page<AddressBook>> getAddressBooks(@RequestParam(defaultValue = Constants.PAGENO) Integer pageNo,
                                                      @RequestParam(defaultValue = Constants.PAGESIZE) Integer pageSize,
                                                      @RequestParam(defaultValue = "id") String sortBy) {
        Page<AddressBook> pagedResult = service.getAllAddressaBooks(pageNo, pageSize, sortBy);

        if(pagedResult.hasContent()) {
            return new ResponseEntity<>(pagedResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateAddressBook/{id}")
    public ResponseEntity<APIResponse> updateAddressBook(@PathVariable(name = "id") Long id,
                                                                    @RequestBody AddressBookRequestDto requestDto){
        return responder.okay(service.updateAddressBook(id, requestDto));
    }

    @DeleteMapping("/deleteAddressBook/{id}")
    public void deleteAddressBook(@PathVariable Long id) {
        service.deleteAddressBook(id);
    }


    }
