package com.statestr.datamanage.service.impl;

import com.statestr.datamanage.domain.ConvertMetadata;
import com.statestr.datamanage.domain.RuleInfo;
import com.statestr.datamanage.service.ConvertService;
import com.statestr.datamanage.service.RuleInfoService;
import com.statestr.datamanage.utils.ConvertUtil;
import com.statestr.datamanage.utils.RuleExecutor;
import com.statestr.datamanage.utils.S3Util;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class ConvertServiceImpl implements ConvertService {

    String bucket = "hackathon-ap-south-1-686868645966";
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmSSS");

    @Autowired
    private RuleInfoService ruleInfoService;

    @Override
    public String csvToJson(ConvertMetadata convertMetadata) {
        String fileName = convertMetadata.getFileName();
        String path = convertMetadata.getPath();
        String key = path + "/" + fileName;
        key = key.replace("//", "/");
        String upload = null;
        try {
            InputStream inputStream = S3Util.download(bucket, key);
            String json = ConvertUtil.csvToJson(inputStream);
            json = applyRule(json, fileName);
            String outputKey = getOutputKey(convertMetadata.getDestPath(), convertMetadata.getDestFilename());
            upload = S3Util.upload(bucket, outputKey, json.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return upload;
    }

    @Override
    public String applyRule(String json, String fileName) {

        List<RuleInfo> rules = ruleInfoService.getRules(fileName);

        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            RuleExecutor.executeRule(rules, jsonObject);
        }
        return jsonArray.toString();
    }


    String getOutputKey(String destPath, String fileName) {
        String format = LocalDateTime.now().format(dtf);
        return destPath + "/" + fileName.replace("YYYYMMDDHHMMSS", format) + ".json";
    }
}
