package com.example.springboot1.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    public User (String userName,String email,String nickName,String regTime){
        this.userName = userName;
        this.email = email;
        this.nickName = nickName;
        this.regTime = regTime;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String passWord;

    private String email;

    private String nickName;

    private String regTime;
}
