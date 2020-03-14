package com.busyzero.demo.netty.demo;

import java.io.File;
import java.io.Serializable;

public class FileUploadFile implements Serializable {
    public static final long SerialVersionUID = 1L;

    private File file;
    private  String file_md5;
    private int startPods;
    private byte[] bytes;
    private int endPods;

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFile_md5() {
        return file_md5;
    }

    public void setFile_md5(String file_md5) {
        this.file_md5 = file_md5;
    }

    public int getStartPods() {
        return startPods;
    }

    public void setStartPods(int startPods) {
        this.startPods = startPods;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getEndPods() {
        return endPods;
    }

    public void setEndPods(int endPods) {
        this.endPods = endPods;
    }
}
