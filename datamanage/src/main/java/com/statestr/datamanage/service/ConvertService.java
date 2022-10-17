package com.statestr.datamanage.service;


import com.statestr.datamanage.domain.ConvertMetadata;
import com.statestr.datamanage.domain.RuleInfo;

import java.util.List;

public interface ConvertService {


    String csvToJson(ConvertMetadata convertMetadata);

    String applyRule(String json, String fileName);
}
