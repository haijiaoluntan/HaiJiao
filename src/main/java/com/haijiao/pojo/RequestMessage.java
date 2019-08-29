package com.haijiao.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class RequestMessage implements Serializable {
    private static final long serialVersionUID = 2707033029334864923L;

    private String id;
    private String url;
    private String method;
    private String signame;
    private String args;

    public RequestMessage(String id, String url, String method, String signame, String args) {
        this.id = id;
        this.url = url;
        this.method = method;
        this.signame = signame;
        this.args = args;
    }
}
