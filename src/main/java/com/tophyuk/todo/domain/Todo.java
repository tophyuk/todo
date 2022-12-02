package com.tophyuk.todo.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=200, nullable = false)
    private String contents;


    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean complete;

    @Column(nullable = false)
    private LocalDate modifiedDate;

    public Todo() {

    }
    public Todo(Long id, String contents, Boolean complete) {
        this.id = id;
        this.contents = contents;
        this.complete = Boolean.FALSE;
        this.modifiedDate = LocalDate.now();
    }
}
