package com.haijiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataAuth {
    private Integer aid;
    private Integer did;
    private String dpath;
    private String describe;
    private Integer state;
}
