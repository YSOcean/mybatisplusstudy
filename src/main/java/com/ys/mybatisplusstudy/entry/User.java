package com.ys.mybatisplusstudy.entry;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {
    private Long id;

    private String userName;

    private String userAge;
}
