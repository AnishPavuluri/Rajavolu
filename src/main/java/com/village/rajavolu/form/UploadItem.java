package com.village.rajavolu.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * User: Anish
 * Date: 12/1/15
 * Time: 12:02 AM
 */
public class UploadItem {
    private String filename;
    private CommonsMultipartFile fileData;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public CommonsMultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }
}
