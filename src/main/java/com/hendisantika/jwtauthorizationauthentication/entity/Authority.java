package com.hendisantika.jwtauthorizationauthentication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : Spring Boot JWT Authorization Authentication
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/18/23
 * Time: 06:06
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
