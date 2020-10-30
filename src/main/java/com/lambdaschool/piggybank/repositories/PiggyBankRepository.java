package com.lambdaschool.piggybank.repositories;


import com.lambdaschool.piggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface PiggyBankRepository extends CrudRepository<Coin, Long> {
}
