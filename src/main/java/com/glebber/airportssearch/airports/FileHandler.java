package com.glebber.airportssearch.airports;

import java.io.File;

public class FileHandler {
    private String fileName;
    private String filePath;
    private File file;

    public FileHandler(File file) {
        this.file = file;
        this.filePath = file.getPath();
        this.fileName = file.getName();
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