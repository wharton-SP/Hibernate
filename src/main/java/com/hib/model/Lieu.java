package com.hib.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lieu")
public class Lieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codelieu;
    private String designation;
    private String province;

    public Lieu() {}

    public Lieu(Long codelieu, String designation, String province) {
        this.codelieu = codelieu;
        this.designation = designation;
        this.province = province;
    }

    public Long getCodelieu() {
        return codelieu;
    }

    public void setCodelieu(Long codelieu) {
        this.codelieu = codelieu;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
