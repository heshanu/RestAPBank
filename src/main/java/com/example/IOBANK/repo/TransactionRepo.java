package com.example.IOBANK.repo;

import com.example.IOBANK.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionRepo extends JpaRepository<Transaction,String> {
    Page<Transaction> findAllByOwnerUid(String uid, Pageable pageable);
    Page<Transaction> findAllByCardCardIdAndOwnerUid(String cardId, String uid, Pageable pageable);
    Page<Transaction> findAllByAccountAccountIdAndOwnerUid(String accountId, String uid, Pageable pageable);
}
