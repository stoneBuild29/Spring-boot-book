package com.stone.boot.stream;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @className: User
 * @author: Stone
 * @date: 2024/8/14
 **/
    @Data
    @Entity
    @EqualsAndHashCode(callSuper = true)
    @Table(indexes = {@Index(name = "uk_email", columnList = "email",unique = true)})
    public class User  extends BaseEnity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Transient
    private int age;

    @Column(nullable = false, length = 20)
    private String email;

    private LocalDate birthday;

}
