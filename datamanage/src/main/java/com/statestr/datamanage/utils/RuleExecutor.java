package com.statestr.datamanage.utils;

import com.statestr.datamanage.domain.RuleInfo;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RuleExecutor {

    public static void executeRule(List<RuleInfo> rules, JSONObject jsonObject) {
        Set<String> pendingDelCols = new HashSet<>();

        for (RuleInfo rule : rules) {
            String sourceColumn = rule.getSourceColumn();
            String destinationColumn = rule.getDestinationColumn();
            String dataRule = rule.getDataRule();
            String validationRule = rule.getValidationRule();
            validate(validationRule, jsonObject);
            String sourceValue = jsonObject.getString(sourceColumn);
            if (!"*".equals(dataRule)) {
                sourceValue = transform(sourceValue, dataRule, jsonObject);
            }
            jsonObject.put(destinationColumn, sourceValue);
            pendingDelCols.add(sourceColumn);
        }
        pendingDelCols.forEach(jsonObject::remove);
    }

    public static String transform(String sourceValue, String dataRule, JSONObject jsonObject) {
        if (dataRule.toLowerCase().startsWith("substr")) {
            if (dataRule.contains(",")) {
                String[] split = dataRule.split(",");
                int s = Integer.parseInt(split[0].replace("SUBSTR(", ""));
                int e = Integer.parseInt(split[1].replace(")", ""));
                return sourceValue.substring(s, e);
            }
            int s = Integer.parseInt(dataRule.replace("SUBSTR(", "").replace(")", ""));
            return sourceValue.substring(s);
        }
        return sourceValue;

    }

    private static void validate(String validationRule, JSONObject jsonObject) {

    }
}
