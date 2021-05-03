package io.nuvalence.onboarding.gcp.RESTDeident.service;

import io.nuvalence.onboarding.gcp.RESTDeident.exception.CloudStorageException;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Bucket;

import com.google.cloud.storage.BlobInfo;


@Service
public class CloudStorageService {

    @Value("${unclass-bucket-name}")
    private String bucketName;

    @Autowired
    private Storage storage;

    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	if(fileName.contains("..")) {
	    throw new CloudStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	}

	try {
	    storage.create(
			   BlobInfo.newBuilder(bucketName, fileName).build(),
			   file.getBytes()
			   );
	    return fileName;
	} catch (IOException e) {
	    return "IOError";
	}
    }
}
