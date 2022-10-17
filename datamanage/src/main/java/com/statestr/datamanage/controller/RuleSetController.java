package com.statestr.datamanage.controller;

import com.statestr.datamanage.domain.RuleInfo;
import com.statestr.datamanage.service.RuleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RuleSetController {
    @Autowired
    private RuleInfoService ruleInfoService;


    @PostMapping("/setRules")
    @ResponseBody
    public String ruleSet(@RequestBody RuleInfo rule){
        ruleInfoService.insertRule(rule);
        return "Successfully";
    }
}
