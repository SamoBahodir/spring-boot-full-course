package com.spring.api.ws.captcha;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users_captcha")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;

    @Transient
    private String captcha;

    @Transient
    private String hiddenCaptcha;

    @Transient
    private String realCaptcha;

}
