package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.DeptService;
import com.zhq.neti.vo.BrandVO;
import com.zhq.neti.vo.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/25
 */
@RestController
@RequestMapping("/manage/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping
    public ServerResponse save(DeptVO deptVO){
        return deptService.save(deptVO);
    }

    @DeleteMapping
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return deptService.delete(ids);
    }

    @PutMapping
    public ServerResponse update(DeptVO deptVO){
        return  deptService.update(deptVO);
    }

    @GetMapping
    public ServerResponse find(@RequestParam Long id){
        return deptService.find(id);
    }

    @GetMapping("/list")
    public ServerResponse findList(){
        return deptService.findList();
    }
}
