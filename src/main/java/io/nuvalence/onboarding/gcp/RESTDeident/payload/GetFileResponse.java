package io.nuvalence.onboarding.gcp.RESTDeident.payload;

import com.google.cloud.storage.Blob;
import com.google.api.gax.paging.Page;

public class GetFileResponse {

    private Page<Blob> blobs;
    
    public GetFileResponse(Page<Blob> blobs) {
	this.blobs = blobs;

	for (Blob blob : blobs.iterateAll()) {
	    System.out.println("blob: " + blob.getName());
	}
    }

    public Page<Blob> getBlobs() {
	return this.blobs;
    }

    public void setBlobs(Page<Blob> blobs) {
	this.blobs = blobs;
    }

    @Override
    public String toString() {
	String str = "";
	for (Blob blob : blobs.iterateAll()) {
	    str += blob.getName() + "\n";
	}
	return str;
    }
}
