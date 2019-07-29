package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.EmpService;
import com.zhq.neti.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/29
 */
@RestController
@RequestMapping("/manage/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @PostMapping
    public ServerResponse save(EmpVO empVO){
        return empService.save(empVO);
    }

    @DeleteMapping
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return empService.delete(ids);
    }

    @PutMapping
    public ServerResponse update(EmpVO empVO){
        return  empService.update(empVO);
    }

    @GetMapping
    public ServerResponse find(@RequestParam Long id){
        return empService.find(id);
    }

}
