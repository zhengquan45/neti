package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@TableName("t_city")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private Integer id;
    private Integer pid;
    private String name;
    private Integer type;

    @TableField(exist=false)
    private List<City> list;
}
