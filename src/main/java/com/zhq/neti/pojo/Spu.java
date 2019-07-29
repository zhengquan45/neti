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

/**
 * @author zhengquan
 * @date 2019/7/21
 */
@TableName("t_spu")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Spu {

    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String title;
    private String subTitle;
    private Long categoryId;
    private Long brandId;
    private Long spgId;
    private Boolean saleable;
    private Boolean valid;
    private Date createTime;
    private Date lastUpdateTime;
    @TableLogic
    private Boolean isDeleted;

}
