package io.nuvalence.onboarding.gcp.RESTDeident;

import java.util.Optional;

import io.nuvalence.onboarding.gcp.RESTDeident.payload.UploadFileResponse;
import io.nuvalence.onboarding.gcp.RESTDeident.service.FileStorageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;


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
		//return new UploadFileResponse(fileName, fp.getContentType(), fp.getSize());
	    });
	//String fileName = fileStorageService.storeFile(file);
	
	//return new UploadFileResponse(fileName, file.getContentType(), file.getSize());
	return response;
    }
}
