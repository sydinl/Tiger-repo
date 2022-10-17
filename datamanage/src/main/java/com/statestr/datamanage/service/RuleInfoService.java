package com.statestr.datamanage.service;

import com.statestr.datamanage.domain.RuleInfo;
import com.statestr.datamanage.mapper.RuleInfoMapper;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleInfoService {

    @Autowired
    RuleInfoMapper ruleInfoMapper;

    public List<RuleInfo> getRules(String filename){
        Map<String, Object> columnMap =new HashMap<>();
        columnMap.put("source_file_name",filename);
        List<RuleInfo> userList = ruleInfoMapper.selectByMap(columnMap);
        System.out.println(userList.size());
        return userList;
    }

    public void insertRules(List<RuleInfo> ruleinfos){
        for(RuleInfo ruleInfo:ruleinfos){
            ruleInfoMapper.insert(ruleInfo);
        }
    }
    public void insertRule(RuleInfo ruleinfo){

            ruleInfoMapper.insert(ruleinfo);

    }
}
