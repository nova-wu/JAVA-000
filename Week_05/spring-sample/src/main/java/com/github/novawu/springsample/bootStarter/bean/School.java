package com.github.novawu.springsample.bootStarter.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {

    private String schoolName;
    private String address;

    private Student student;
}
