package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.RoleService;
import com.zhq.neti.vo.PageQuery;
import com.zhq.neti.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/15
 */
@RestController
@RequestMapping("/manage/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ServerResponse save(RoleVO roleVO){
        return roleService.save(roleVO);
    }

    @DeleteMapping
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return roleService.delete(ids);
    }

    @PutMapping
    public ServerResponse update(RoleVO roleVO){
        return  roleService.update(roleVO);
    }

    @GetMapping
    public ServerResponse find(@RequestParam Long id){
        return roleService.find(id);
    }

    @GetMapping("/list")
    public ServerResponse findList(PageQuery pageQuery){
        return roleService.findList(pageQuery);
    }
}
