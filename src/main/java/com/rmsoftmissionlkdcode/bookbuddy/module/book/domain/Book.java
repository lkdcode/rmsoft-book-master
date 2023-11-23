package com.rmsoftmissionlkdcode.bookbuddy.module.book.domain;

import com.rmsoftmissionlkdcode.bookbuddy.global.common.BaseEntity;
import com.rmsoftmissionlkdcode.bookbuddy.module.loan.domain.Loan;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_book")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Book extends BaseEntity {
    @Column(name = "ISBN", nullable = false, unique = true)
    private String ISBN;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans = new ArrayList<>();

    @Builder
    public Book(String ISBN, String title, String author, int quantity) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public void updateISBN(String updateISBN) {
        this.ISBN = updateISBN;
    }

    public void updateTitle(String updateTitle) {
        this.title = updateTitle;
    }

    public void updateAuthor(String updateAuthor) {
        this.author = updateAuthor;
    }

    public void updateQuantity(int updateQuantity) {
        this.quantity = updateQuantity;
    }
}