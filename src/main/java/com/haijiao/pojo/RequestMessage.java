package com.haijiao.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestMessage implements Serializable {
    private static final long serialVersionUID = 2707033029334864923L;

    private String id;
    private String url;
    private String method;
    private String signame;
    private String args;
}
