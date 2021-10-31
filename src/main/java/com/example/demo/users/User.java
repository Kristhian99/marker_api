package com.example.demo.users;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document
public class User {
    @Id
    private  String id;

    @Indexed(unique = true)
    private String email;
    private STATE state;
    private String password;


    public User(String email, STATE state, String password) {
        this.email = email;
        this.state = state;
        this.password = password;

    }
}
