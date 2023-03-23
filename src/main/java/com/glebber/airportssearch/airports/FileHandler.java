package com.glebber.airportssearch.airports;

import java.io.File;

public class FileHandler {
    private String fileName;
    private String filePath;
    private File file;

    public FileHandler(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);
        this.filePath = file.getAbsolutePath();
    }

    public File getFile() {
        return file;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }
}