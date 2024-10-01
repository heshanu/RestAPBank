package com.example.IOBANK.repo;

import com.example.IOBANK.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account,String> {
    boolean existsByAccountNumber(Long accountNumber);
    boolean existsByCodeAndOwnerUid(String code, String uid);
    List<Account> findAllByOwnerUid(String uid);
    Optional<Account> findByCodeAndOwnerUid(String code, String uid);
    Optional<Account> findByAccountNumber(long recipientAccountNumber);
}
