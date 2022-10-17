package com.statestr.datamanage;

import com.statestr.datamanage.domain.RuleConf;
import com.statestr.datamanage.mapper.RuleConfMapper;
import com.statestr.datamanage.service.RuleInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import com.statestr.datamanage.domain.RuleInfo;
@SpringBootTest
public class MapperTest {

    @Autowired
    RuleConfMapper mapper;
    @Autowired
    RuleInfoService ruleInfoService;



    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<RuleConf> userList = mapper.selectList(null);
        System.out.println(userList.size());

    }

    @Test
    public void testSelectRuleMapper() {
        System.out.println(("----- selectAll method test ------"));
        List<RuleInfo> userList = ruleInfoService.getRules("1-2-1.csv");
        System.out.println(userList.size());

    }


//    @Test
//    public void testInsertRuleMapper(){
//        System.out.println(("----- insert method test ------"));
//        List<RuleInfo> ruleInfo = new ArrayList<>();
//        RuleInfo ruleInfo1 =  new RuleInfo();
//        ruleInfo1.set("SOURCE_APP","WSS");
//        ruleInfo1.set("SOURCE_MODULE_NAME","FSI");
//        ruleInfo1.set("SOURCE_S3_PATH","tiger/upload/WSS/FSI/inbound/");
//        ruleInfo1.set("SOURCE_FILE_NAME", "1-2-1.csv");
//        ruleInfo1.set("DEST_APP","BJ");
//        ruleInfo1.set("DEST_MODULE_NAME","FSI");
//        ruleInfo1.set("DEST_S3_PATH","tiger/upload/BJ/FSI/inbound/");
//        ruleInfo1.set("DEST_FILE_NAME","WSS_FSI_YYYYMMDDHHMMSS.json");
//        ruleInfo1.set("RULE_NAME","WSS_BJ_FSI_CSV_JSON");
//        ruleInfo1.set("SOURCE_COLUMN","ADDR");
//        ruleInfo1.set("DESTINATION_COLUMN","COUNTRY");
//        ruleInfo1.set("VALIDATION_RULE","*");
//        ruleInfo1.set("DATA_RULE","SUBSTR(0,5)");
//        ruleInfo.add(ruleInfo1);
//        ruleInfoService.insertRules(ruleInfo);
//        System.out.println(ruleInfo.toString());
//    }
}
