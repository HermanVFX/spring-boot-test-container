package com.hermanvfx.springboottestcontainer.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    private String birthDate;

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
    @Column(name = "account")
    private Account account;

    @Column(name = "account", insertable = false, updatable = false)
    private Long accountId;
}
