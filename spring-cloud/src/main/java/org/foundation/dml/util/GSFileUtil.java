package org.foundation.dml.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.zip.GZIPOutputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.google.cloud.ReadChannel;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.StorageOptions;



public class GSFileUtil {
	
	public static void copyFile(String fromBucket,String fromPath,String toBucket,String toPath) {
		Storage storage = StorageOptions.getDefaultInstance().getService();

		//CopyRequest.of(sourceBlobId, targetBlobId)
		CopyRequest request = CopyRequest.of(fromBucket, fromPath, BlobId.of(toBucket, toPath));
		CopyWriter copyWriter = storage.copy(request);
		
	    System.out.printf("Copied %s%n", copyWriter.getResult());
	}
	
	
	public static void crateBucket(String bucketName) {
		Storage storage = StorageOptions.getDefaultInstance().getService();

	    // Create a bucket
	   // String bucketName = "outgoing-bucket"; // Change this to something unique
	    Bucket bucket = storage.create(BucketInfo.of(bucketName));
	    System.out.println("got the bucket:" + bucket.getName() + ",sisze" + new Date(bucket.getCreateTime()));

	}
	
	public static void download(String bucketName,String fromPath,File downloadTo) throws IOException {
		Storage storage = StorageOptions.getDefaultInstance().getService();

		BlobId blobId =  BlobId.of(bucketName, fromPath);
		Blob blob = storage.get(blobId);
	    
		if (blob == null) {
	        System.out.println("No such object");
	        return;
	    }
		
	    PrintStream writeTo = null;
	    ReadChannel reader =  null;
	    
	    try {
	        writeTo = new PrintStream(new FileOutputStream(downloadTo));
	        
	        if (blob.getSize() < 1_000_000) {
	            // Blob is small read all its content in one request
	            byte[] content = blob.getContent();
	            writeTo.write(content);
	        } else {
	            // When Blob size is big or unknown use the blob's channel reader.
	            reader = blob.reader();
	            WritableByteChannel channel = Channels.newChannel(writeTo);
	            ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
	            while (reader.read(bytes) > 0) {
	                bytes.flip();
	                channel.write(bytes);
	                bytes.clear();
	            }
	       }
	       
	       writeTo.flush();
	 	} finally {
	    	IOUtils.closeQuietly(writeTo);
	    	IOUtils.closeQuietly(reader);

	    }
	}
	
	
	public static boolean delete(String bucketName, String relativePath) {
		BlobId blobId = BlobId.of(bucketName, relativePath);
		
		Storage storage = StorageOptions.getDefaultInstance().getService();
        return storage.delete(blobId);
	}
	
	
	public static void upload(File uploadFromFile,String bucketName,String relativePath) throws IOException {
		Path uploadFrom = Paths.get(uploadFromFile.getAbsolutePath());
	    String contentType = Files.probeContentType(uploadFrom);
	    BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, relativePath).setContentType(contentType).build();
	    
	    
		//Path path = new Path(new File(""));
		Storage storage = StorageOptions.getDefaultInstance().getService();

		 if (Files.size(uploadFrom) > 1_000_000) {
		     // When content is not available or large (1MB or more) it is recommended
		     // to write it in chunks via the blob's channel writer.
		     try (WriteChannel writer = storage.writer(blobInfo)) {
		         byte[] buffer = new byte[1024];
		         try (InputStream input = Files.newInputStream(uploadFrom)) {
		             int limit;
		             while ((limit = input.read(buffer)) >= 0) {
		                 try {
		                     writer.write(ByteBuffer.wrap(buffer, 0, limit));
		                 } catch (Exception ex) {
		                     ex.printStackTrace();
		                 }
		              }
		          }
		      }
		   } else {
		        byte[] bytes = Files.readAllBytes(uploadFrom);
		        // create the blob in one request.
		        storage.create(blobInfo, bytes);
		   }
		  // System.out.println("Blob was created");
	}
	
	
	public static void main(String ar[]) {
	   //copyFile("sx-183314-bucket","landing/scp/LOH/tchan.txt","outgoing-bucket","landing/scp/LOH/tchan.txt");
		try {
		  //  download("sx-183314-bucket","landing/scp/LOH/tchan.txt",new File("D:\\learning\\gcp\\tmp\\tchan.txt"));
			
			//upload(new File("D:\\learning\\gcp\\tmp\\tchan.txt"),"outgoing-bucket","landing/scp/LOH/tchan2.txt");
			
			if (delete("outgoing-bucket","landing/scp/LOH/tchan2.txt")) {
				System.out.println("delete succssfully");;
			} else {
				System.out.println("failed to delete");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
