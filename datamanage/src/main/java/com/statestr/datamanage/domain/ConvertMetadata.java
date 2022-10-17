package com.statestr.datamanage.domain;

import lombok.Data;

@Data
public class ConvertMetadata {

    private String fileName;

    private String path;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public String getDestFilename() {
        return destFilename;
    }

    public void setDestFilename(String destFilename) {
        this.destFilename = destFilename;
    }

    private String destPath;

    private String destFilename;

}
