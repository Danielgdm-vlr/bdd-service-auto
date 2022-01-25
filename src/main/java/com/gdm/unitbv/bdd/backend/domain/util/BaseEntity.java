package com.gdm.unitbv.bdd.backend.domain.util;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Hibernate;
import javax.persistence.*;
import lombok.Getter;
import lombok.ToString;

@MappedSuperclass
@ToString
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BaseEntity that = (BaseEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
