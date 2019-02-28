package com.cs5850;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import org.junit.Test;
import org.junit.Assert;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.Drive.Files;
import com.cs5850.GoogleDriveFileSyncManager;
import com.cs5850.GoogleDriveServiceProvider;
public class IntegrationTest {
/*	Drive mockDriveService;
	GoogleDriveFileSyncManager GoogleSync;
		public void setup() throws IOException{		
		mockDriveService = GoogleDriveServiceProvider.get().getGoogleDriveClient() ;
		//GoogleSync = new GoogleDriveFileSyncManager(mockDriveService);
	}
		public void initGoogleDriveServices() throws IOException {
		       HttpTransport httpTransport = new NetHttpTransport();
		       JsonFactory jsonFactory = new JacksonFactory();
		       try{
		           GoogleCredential credential = new  GoogleCredential.Builder()
		             .setTransport(httpTransport)
		             .setJsonFactory(jsonFactory)
		             .setServiceAccountId(
		            		 "1007786677669-kiq9nur4cse3f2h5usnf33rkbv20efbk@developer.gserviceaccount.com"  		 
		            		 )
		             .setServiceAccountScopes(Collections.singleton(DriveScopes.DRIVE))
		             .setServiceAccountPrivateKeyFromP12File(
		            		 new File("ibox-48d9ea96c0fe.p12"))
		             .build();
		           mockDriveService = new Drive.Builder(httpTransport, 
		        		   jsonFactory, credential).setApplicationName("ibox").build();  
		       }catch(GeneralSecurityException e){
		           e.printStackTrace();
		       }
		   }
	
	
	@Test
	public void testAddFiles() throws IOException {
		setup();		
		File localFile = new File(System.getProperty("user.home") + "/file.txt");
		if(!localFile.exists()){
			localFile.createNewFile();
		}
		
		Files initialServiceFiles = mockDriveService.files();
		GoogleSync.upload(localFile);
		localFile.delete();
		Assert.assertNotSame(mockDriveService.files(), initialServiceFiles);
	}
	
	@Test
	public void testUpdateFiles() throws IOException {
		setup();		
		File localFile = new File(System.getProperty("user.home") + "/file.txt");
		if(!localFile.exists()){
			localFile.createNewFile();
		}
		
		GoogleSync.modifyFile(localFile);
	}
	
	@Test(expected = Exception.class)
	public void testExceptionUpdateFiles() throws IOException{
		setup();
		File localFile = null;
		GoogleSync.modifyFile(localFile);
	}
	
	
	@Test
	public void testDeleteFiles() throws IOException {
		setup();		
		File localFile = new File(System.getProperty("user.home") + "/file.txt");
		if(!localFile.exists()){
			localFile.createNewFile();
		}
		
		GoogleSync.upload(localFile);
		GoogleSync.deleteFile(localFile);
	}
	@Test(expected = Exception.class)
	public void testExceptionDeleteFiles() throws IOException{
		setup();
		File localFile = null;
		GoogleSync.modifyFile(localFile);
	}
	
	@Test
	public void testGetFileId() throws IOException{
		setup();
		String id1 = GoogleSync.getFileId("file.txt");
		File localFile = new File(System.getProperty("user.home") + "/file.txt");
		if(!localFile.exists()){
			localFile.createNewFile();
		}
		String id2 = GoogleSync.getFileId(localFile.getName());
		Assert.assertEquals("", id1, id2);
	}
	
	@Test
	public void testGetNullFileId() throws IOException{
		setup();
		String id = GoogleSync.getFileId(null);
		Assert.assertNull(id);
	}
*/
}
