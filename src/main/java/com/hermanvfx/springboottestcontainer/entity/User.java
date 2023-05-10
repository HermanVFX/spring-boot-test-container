package com.hermanvfx.springboottestcontainer.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NamedEntityGraph(name = "UserPhoneEmailGraph",
        attributeNodes = {@NamedAttributeNode("phones"), @NamedAttributeNode("emails")})
@Table(schema = "uzers", name = "usr")
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private OffsetDateTime birthDate;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Phone> phones = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Email> emails = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "account_id", insertable = false, updatable = false)
    private Long accountId;
}
