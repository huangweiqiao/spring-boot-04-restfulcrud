package com.hwq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HelloDbController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/query")
    public Map<String,Object> map(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from department");
        System.out.println(maps);
        return maps.get(0);
    }
}
