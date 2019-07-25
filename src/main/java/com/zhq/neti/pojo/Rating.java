package com.zhq.neti.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_rating")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private Long orderId;
    private Long skuId;
    private String img;
    private Integer rating;
    private String comment;
    private Date createTime;
    @TableLogic
    private Boolean isDeleted;
}
