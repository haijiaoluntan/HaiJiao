package com.haijiao.pojo;

import java.io.Serializable;

/**
 * 省份类
 */
public class Province implements Serializable {
    
    private static final long serialVersionUID = -794564464367040168L;
    private Integer id;
    private String name;
    private String pycode;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPycode() {
        return pycode;
    }
    
    public void setPycode(String pycode) {
        this.pycode = pycode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Province").append('[')
                .append("id=")
                .append(id)
                .append(", name=")
                .append(name)
                .append(", pycode=")
                .append(pycode)
                .append(']');
        return sb.toString();
    }
}
