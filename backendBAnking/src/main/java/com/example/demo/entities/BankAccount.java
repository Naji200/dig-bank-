package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.enums.*;

import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// fait la difference entre les different type de compte
@DiscriminatorColumn(name = "TYPE",length = 4)
// est ajouter pour differncier ent les differnt type de compte dans la BD
@Data
@NoArgsConstructor
@AllArgsConstructor
//il exist 2 types de compte bancaire currentAccount
//et saving account
//la difference est dans un att interestRate et overDraft
//ces deux types sont representer dans 2 classe qui herite de la classe bankaccount
//ces 3 classes sont representer dans la BD dans par une seule table
//cette  methode est une de 3 est appelee single table
public class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    //le status celon le type dans l enum
    private AccountStatus status;
    @ManyToOne
    //un compte peut apartenir a un seul customer
    private Customer customer;

    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY)
    //chaque compte a une liste des operation
    private List<AccountOperation> accountOperations;
}
