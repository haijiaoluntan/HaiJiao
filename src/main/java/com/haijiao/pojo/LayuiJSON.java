package com.haijiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LayuiJSON {
	private Integer code;
	private String msg;
	private Integer count; 
	private Integer rows;
	private Integer pages;
	private List<?> data;
	private List<?> total;
}
