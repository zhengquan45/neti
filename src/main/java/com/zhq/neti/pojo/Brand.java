package com.zhq.neti.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengquan
 * @date 2019/7/20
 */
@TableName("t_brand")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String name;
    private String images;
    private String letter;
    @TableLogic
    private Boolean isDeleted;
}
