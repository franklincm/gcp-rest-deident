package io.nuvalence.onboarding.gcp.RESTDeident.payload;

public class UploadFileResponse {
    private String fileName;
    private String fileType;
    private long size;

    public UploadFileResponse(String fileName, String fileType, long size) {
	this.fileName = fileName;
	this.fileType = fileType;
	this.size = size;
    }

    public String getFileName() {
	return this.fileName;
    }

    public void setFileName(String fileName) {
	this.fileName = fileName;
    }

    public String getFileType() {
	return this.fileType;
    }

    public void setFileType(String fileType) {
	this.fileType = fileType;
    }

    public long getSize() {
	return this.size;
    }

    public void setSize(long size) {
	this.size = size;
    }

    @Override
    public String toString() {
	return String.format("name: '%1$s', type: %2$s, size: %3$s", this.fileName, this.fileType, this.size);
    }
}
