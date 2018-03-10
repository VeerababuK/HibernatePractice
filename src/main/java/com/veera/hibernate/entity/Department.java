package com.veera.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DEPARTMENT")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int oid;

    @Column(name = "DEPT_NAME")
    private String name;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
