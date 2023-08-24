package com.example.addressbook.controllers;

import com.example.addressbook.dtos.APIResponse;
import com.example.addressbook.dtos.AddressBookRequestDto;
import com.example.addressbook.models.address.AddressBook;
import com.example.addressbook.models.user.User;
import com.example.addressbook.repositories.address.AddressBookRepository;
import com.example.addressbook.repositories.user.UserRepository;
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
    private final UserRepository userRepository;
    private final AddressBookRepository addressBookRepository;


    @PostMapping("/addAddressBook")
    public ResponseEntity<APIResponse> addAddressBook(@RequestBody AddressBook requestDto){
        return responder.okay(addressBookRepository.save(requestDto));
    }
    @PostMapping("/user")
    public ResponseEntity<APIResponse> createUser(@RequestBody User user){
        return responder.okay(userRepository.save(user));
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
