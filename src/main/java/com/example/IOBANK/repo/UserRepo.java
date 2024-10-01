package com.example.IOBANK.repo;

import com.example.IOBANK.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    User findByUsernameIgnoreCase(String username);
}
