package com.haijiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperAuth {
    private Integer oid;
    private String describe;
    private  String authname;
}
