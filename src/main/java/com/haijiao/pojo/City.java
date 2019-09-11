package com.haijiao.pojo;

import java.io.Serializable;

/**
 * 城市类
 */
public class City implements Serializable {
    
    private static final long serialVersionUID = -8652210334075372731L;
    private Integer id;
    private String name;
    private String pycode;
    private Integer pid;
    private String postcode;
    private String areacode;
    
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
    
    public Integer getPid() {
        return pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    
    public String getPostcode() {
        return postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    public String getAreacode() {
        return areacode;
    }
    
    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City").append('[')
                .append("id=")
                .append(id)
                .append(", name=")
                .append(name)
                .append(", pycode=")
                .append(pycode)
                .append(", pid=")
                .append(pid)
                .append(", postcode=")
                .append(postcode)
                .append(", areacode=")
                .append(areacode)
                .append(']');
        return sb.toString();
    }
}
