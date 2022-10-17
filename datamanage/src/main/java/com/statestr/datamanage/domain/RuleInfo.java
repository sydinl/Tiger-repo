package com.statestr.datamanage.domain;

import lombok.Data;

@Data
public class RuleInfo {
    String sourceApp;
    String sourceModuleName;
    String sourceS3Path;
    String sourceFileName;
    String destApp;
    String destModuleName;
    String destS3Path;
    String destFileName;
    String ruleName;
    String sourceColumn;
    String destinationColumn;
    String validationRule;
    String dataRule;

    public String getSourceApp() {
        return sourceApp;
    }

    public void setSourceApp(String sourceApp) {
        this.sourceApp = sourceApp;
    }

    public String getSourceModuleName() {
        return sourceModuleName;
    }

    public void setSourceModuleName(String sourceModuleName) {
        this.sourceModuleName = sourceModuleName;
    }

    public String getSourceS3Path() {
        return sourceS3Path;
    }

    public void setSourceS3Path(String sourceS3Path) {
        this.sourceS3Path = sourceS3Path;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public String getDestApp() {
        return destApp;
    }

    public void setDestApp(String destApp) {
        this.destApp = destApp;
    }

    public String getDestModuleName() {
        return destModuleName;
    }

    public void setDestModuleName(String destModuleName) {
        this.destModuleName = destModuleName;
    }

    public String getDestS3Path() {
        return destS3Path;
    }

    public void setDestS3Path(String destS3Path) {
        this.destS3Path = destS3Path;
    }

    public String getDestFileName() {
        return destFileName;
    }

    public void setDestFileName(String destFileName) {
        this.destFileName = destFileName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getSourceColumn() {
        return sourceColumn;
    }

    public void setSourceColumn(String sourceColumn) {
        this.sourceColumn = sourceColumn;
    }

    public String getDestinationColumn() {
        return destinationColumn;
    }

    public void setDestinationColumn(String destinationColumn) {
        this.destinationColumn = destinationColumn;
    }

    public String getValidationRule() {
        return validationRule;
    }

    public void setValidationRule(String validationRule) {
        this.validationRule = validationRule;
    }

    public String getDataRule() {
        return dataRule;
    }

    public void setDataRule(String dataRule) {
        this.dataRule = dataRule;
    }
}
