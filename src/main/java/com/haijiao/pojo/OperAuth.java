package com.haijiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperAuth {
    private Integer aid;
    private Integer oid;
    private String describe;
    private  String authname;
    private Integer state;
}
