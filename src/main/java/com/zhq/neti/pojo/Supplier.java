package com.zhq.neti.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhq.neti.common.enums.SupplierTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_supplier")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String code;
    private String name;
    private SupplierTypeEnum type;
    private String linkMan;
    private String tel;
    private String address;
    private String bankName;
    private String backAccount;
    private Integer status;
    @TableLogic
    private Boolean isDeleted;
}
