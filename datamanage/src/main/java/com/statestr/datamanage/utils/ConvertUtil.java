package com.statestr.datamanage.utils;

import com.statestr.datamanage.domain.RuleInfo;
import org.json.CDL;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtil {

    public static String csvToJson(InputStream inputStream){
        String csvAsString = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
        String json = CDL.toJSONArray(csvAsString).toString();

        return json;
    }

}
