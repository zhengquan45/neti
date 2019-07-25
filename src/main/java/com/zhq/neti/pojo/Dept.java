package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@TableName("t_dept")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dept {

    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String name;
    private String alias;
    @TableLogic
    private Boolean isDeleted;
}
