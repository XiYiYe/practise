package com.code.practise.controller;

import com.code.practise.util.MultiLanguageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 多语言控制层
 */
@Slf4j
@RestController
@RequestMapping("/ ")
public class MultiLanguageController {

    @GetMapping("/query/result")
    public String queryResult(String key){
        return MultiLanguageUtils.getMessage(key);
    }

}
