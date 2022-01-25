package com.gdm.unitbv.bdd.backend.domain.entity;

import java.io.Serializable;
import java.util.Objects;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gdm.unitbv.bdd.backend.domain.util.BaseEntity;
import com.gdm.unitbv.bdd.backend.domain.util.Maker;

@Entity
@Table(name = "car")

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Car extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Column(name = "maker")
    @NonNull
    private Maker maker;

    @Column(name = "model")
    @NonNull
    private String model;

    @Column(name = "price")
    @NonNull
    private Double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Car car = (Car) o;
        return getId() != null && Objects.equals(getId(), car.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
