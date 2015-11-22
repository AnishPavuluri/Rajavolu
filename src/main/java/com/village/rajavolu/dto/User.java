package com.village.rajavolu.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: user
 * Date: 11/15/15
 * Time: 10:56 PM
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "USER")
public class User extends BaseDto{
    private String name;

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
