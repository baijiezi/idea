/**
 *
 */
package com.b510.hongten.hibernate4maven;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Hongten
 * @created 2014年11月1日
 */
@Entity
@Table(name = "hibernate_base_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Column(columnDefinition = "int default 0")
    private Integer age;
    private String gender;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
