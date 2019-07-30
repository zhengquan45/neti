package com.zhq.neti.controller.manage;

import com.zhq.neti.common.ServerResponse;
import com.zhq.neti.service.JobService;
import com.zhq.neti.vo.JobVO;
import com.zhq.neti.vo.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhengquan
 * @date 2019/7/15
 */
@RestController
@RequestMapping("/manage/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public ServerResponse save(JobVO jobVO){
        return jobService.save(jobVO);
    }

    @DeleteMapping
    public ServerResponse delete(@RequestParam("ids") List<Long> ids){
        return jobService.delete(ids);
    }

    @PutMapping
    public ServerResponse update(JobVO jobVO){
        return  jobService.update(jobVO);
    }

    @GetMapping
    public ServerResponse find(@RequestParam Long id){
        return jobService.find(id);
    }

    @GetMapping("/list")
    public ServerResponse findList(PageQuery pageQuery){
        return jobService.findList(pageQuery);
    }
}
