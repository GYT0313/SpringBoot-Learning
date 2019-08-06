package com.gyt.springboot.entity;


import javax.persistence.*;

// 使用JPA注解配置映射关系
// 告诉JAP这是一个实体类(和数据表应应映射的类)
@Entity
// 指定和那个表对应，默认是类名小写
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "last_name", length = 50)
    private String lastName;

    /**
     * 默认列名就是属性名
     */
    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
