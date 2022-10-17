package com.statestr.datamanage;

import com.statestr.datamanage.utils.ConvertUtil;
import com.statestr.datamanage.utils.S3Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

@SpringBootTest
public class TestS3Util {

    String bucket="hackathon-ap-south-1-686868645966";
    @Test
    public void testDownloadCsv(){
        InputStream inputStream = S3Util.download("hackathon-ap-south-1-686868645966", "tiger/csv_data.csv");
        String s = ConvertUtil.csvToJson(inputStream);
        System.out.println(s);
    }

    @Test
    public void testUpload(){
        InputStream inputStream = S3Util.download("hackathon-ap-south-1-686868645966", "tiger/csv_data.csv");
        String s = ConvertUtil.csvToJson(inputStream);
        String res = S3Util.upload(bucket, "tiger/output.json", s.getBytes());
        System.out.println(res);

    }
}
