package com.statestr.datamanage;

import com.statestr.datamanage.service.ConvertService;
import com.statestr.datamanage.utils.ConvertUtil;
import com.statestr.datamanage.utils.RuleExecutor;
import org.json.JSONArray;
import org.json.JSONException;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.InputStream;


@SpringBootTest
public class TestConverter {

    @Autowired
    ConvertService convertService;

    @Test
    public void testCsvToJson() throws JSONException {
        InputStream resourceAsStream = TestConverter.class.getClassLoader().getResourceAsStream("1-2-1.csv");
        String s = ConvertUtil.csvToJson(resourceAsStream);
        String resJson = convertService.applyRule(s, "1-2-1.csv");
//
        System.out.println(resJson);
        System.out.println(s);

    }

    @Test
    public void testException(){
        String simpleName = ArithmeticException.class.getSimpleName();
        System.out.println(simpleName);
    }

    @Test
    public void testReg(){
        String s = "substr(1,2)".replaceAll("\\s", "");
        System.out.println(s);
    }

    @Test
    public void transform(){
        String s = RuleExecutor.transform("abcdefghijk", "SUBSTR(1)", null);
        System.out.println(s);

    }
}
