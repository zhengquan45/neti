package com.zhq.neti.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuDto {
    private String path;
    private String name;
    private String component;
    private Boolean hidden;
    private Meta meta;
    private List<MenuDto> children;
}
