package com.example.IOBANK.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String accountId;


    private double balance;


    private String accountName;


    @Column(unique = true, nullable = false)
    private long accountNumber;


    private String currency;


    private String code;


    private String label;


    private char symbol;


    @UpdateTimestamp
    private LocalDateTime updatedAt;


    @CreationTimestamp
    private LocalDateTime createdAt;

    /**
     * User who owns the account.
     * This field is annotated with {@link JsonIgnore} to prevent infinite recursion during JSON serialization.
     */
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private Account owner;

    /**
     * List of transactions associated with the account.
     * This field is annotated with {@link OneToMany} to establish a one-to-many relationship with the {@link Transaction} entity.
     * The {@link CascadeType.ALL} option is used to propagate changes to the transactions.
     * The {@link FetchType.LAZY} option is used to fetch the transactions lazily.
     */
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;
}
