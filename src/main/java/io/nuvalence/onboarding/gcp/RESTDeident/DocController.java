package io.nuvalence.onboarding.gcp.RESTDeident;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DocController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();
	
    private static final Logger log = LoggerFactory.getLogger(DocController.class);

    @Value("${unclass-bucket-name}")
    String unclassBucketName;
	
    @GetMapping("/docs")
    public String  bucketName() throws InterruptedException {
	log.info("id:" + counter.incrementAndGet());
	return unclassBucketName;
    }
}
