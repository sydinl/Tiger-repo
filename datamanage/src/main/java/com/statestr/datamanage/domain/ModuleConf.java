package com.statestr.datamanage.domain;

import lombok.Data;

@Data
public class ModuleConf {

    String moduleId;

    String appId;

    String moduleName;

    String dataFormat;

    String s3Path;

    String fileName;

    String dbTableName;

}
