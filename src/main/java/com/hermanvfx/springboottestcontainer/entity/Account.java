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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(schema = "uzers", name = "account")
public class Account extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id")
    @ToString.Exclude
    private User user;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.valueOf(0);

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

}
