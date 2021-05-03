package io.nuvalence.onboarding.gcp.RESTDeident;

import java.util.Optional;

import io.nuvalence.onboarding.gcp.RESTDeident.payload.UploadFileResponse;
import io.nuvalence.onboarding.gcp.RESTDeident.service.FileStorageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DocController {
    
    private static final Logger log = LoggerFactory.getLogger(DocController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/docs")
    public UploadFileResponse uploadFile(@RequestParam("file") Optional<MultipartFile> file) {

    	UploadFileResponse response = new UploadFileResponse("no file", "", -1);
	
    	file.ifPresent(fp -> {
    		String fileName = fileStorageService.storeFile(fp);
    		response.setFileName(fileName);
    		response.setFileType(fp.getContentType());
    		response.setSize(fp.getSize());
	    	});
	
    	return response;
    }
}
