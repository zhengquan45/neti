package com.zhq.neti.pojo;

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
@TableName("t_category_brand")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBrand {
    private Long categoryId;
    private Long brandId;
    @TableLogic
    private Boolean isDeleted;
}
