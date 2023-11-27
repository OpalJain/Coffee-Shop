package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class item_listController {

    // private static Logger log = LoggerFactory.getLogger(item_listController.class);

    @RequestMapping("/depts")
    public Result list(){
        log.info("search all data");
        return Result.success("did");
    }
}
