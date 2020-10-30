package com.lambdaschool.piggybank.controller;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.PiggyBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class piggyBankController {
    @Autowired
    PiggyBankRepository PiggyRepo;

//    private List<Coin> findCoin(List<Coin> myList,)
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> listTotal()
    {
        List<Coin> myList = new ArrayList<>();
        PiggyRepo.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((coin1,coin2)->(int)(coin1.getQuantity()-coin2.getQuantity()));
        List<Coin> rtnList = (List<Coin>) myList.get(0);
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }
}
