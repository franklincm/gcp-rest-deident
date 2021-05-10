package io.nuvalence.onboarding.gcp.RESTDeident.payload;

import io.nuvalence.onboarding.gcp.RESTDeident.model.Document;
import com.google.cloud.storage.Blob;
import com.google.api.gax.paging.Page;
import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GetFileResponse {

    private ArrayList<Document> documents;
    
    public GetFileResponse(Page<Blob> blobs) {
	documents = new ArrayList<Document>();
	
	for (Blob blob: blobs.getValues()) {
	    documents.add(new Document(
				       blob.getName(),
				       blob.getContentType(),
				       blob.getSize(),
				       blob.getCreateTime()
				       )
			  );
	}
    }

    public ArrayList<Document> getDocuments() {
	return this.documents;
    }
    
    // TODO: @Override
    // public String toString()

}
