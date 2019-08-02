package com.zhq.neti.dto;

import com.zhq.neti.pojo.Acl;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MenuDto {
    private Long id;
    private String path;
    private String name;
    private String component;
    private Boolean hidden;
    private Meta meta;
    private String level;
    private Integer sort;
    private List<MenuDto> children;

    public static MenuDto adapt(Acl acl){
        MenuDto menuDto = MenuDto.builder()
                .id(acl.getId())
                .path(acl.getUrl())
                .name(acl.getName())
                .component(acl.getComponent())
                .hidden(acl.getHidden())
                .level(acl.getLevel())
                .sort(acl.getSort())
                .meta(Meta.builder().title(acl.getTitle()).icon(acl.getIcon()).build())
                .build();
        return menuDto;
    }
}
