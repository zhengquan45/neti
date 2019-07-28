package com.zhq.neti.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author zhengquan
 */
@Data
public class PageQuery {

    @Min(value = 1, message = "当前页码不合法")
    private int pageNo = 1;

    @Min(value = 1, message = "每页展示数量不合法")
    private int pageSize = 10;

    public <T>Page <T>adapt(){
        return new Page(pageNo,pageSize);
    }
}
