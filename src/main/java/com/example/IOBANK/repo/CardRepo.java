package com.example.IOBANK.repo;

import com.example.IOBANK.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepo extends JpaRepository<Card,String> {
    boolean existsByCardNumber(double cardNumber);
    Optional<Card> findByOwnerUid(String uid);
}
