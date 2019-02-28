package com.cs5850;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.Drive.Files.Delete;
import com.google.api.services.drive.Drive.Files.Insert;
import com.google.api.services.drive.Drive.Files.Update;
import com.cs5850.GoogleDriveFileSyncManager;
public class GoogleDriveFileSyncManagerTest {
	 Drive mockDriveService;
     GoogleDriveFileSyncManager GoogleSync;
           void setup()throws Exception{
             mockDriveService = Mockito.mock(Drive.class);                
             GoogleSync = new GoogleDriveFileSyncManager(mockDriveService);
     }
        // ++ we are adding a file
     @Test
     public void testAddFile() throws Exception {          
             setup();
             
             File localFile = Mockito.mock(File.class);
             Files testDir = Mockito.mock(Files.class);
             when(mockDriveService.files()).thenReturn(testDir);
             
             Insert insertTest = Mockito.mock(Insert.class);
     		when(testDir.insert(isA(com.google.api.services.drive.model.File.class), 
     				isA(com.google.api.client.http.FileContent.class))).thenReturn(insertTest);
     		
     		
     		com.google.api.services.drive.model.File finalFile = 
     				new com.google.api.services.drive.model.File();
     		finalFile.setId("Test ID");
     		when(insertTest.execute()).thenReturn(finalFile);
     		finalFile.getId();		
     		
     		GoogleSync.upload(localFile);
     		verify(mockDriveService).files();								
     	}
 
           
     		

     @Test(expected = Exception.class)  
     public void testExceptionUpdateFile() throws Exception{
             setup();
             
             File localFile = Mockito.mock(File.class);
             when(localFile.getName()).thenReturn(null);
             
             GoogleSync.modifyFile(localFile);
     }
 
     @Test
     public void testUpdateFile() throws Exception{                
             setup();
                             
             File localFile = Mockito.mock(File.class);
             when(localFile.getName()).thenReturn("test.txt");
             
             
             Files testDir = mock(Files.class);
             when(mockDriveService.files()).thenReturn(testDir);
             
             com.google.api.services.drive.Drive.Files.List mockList = 
                             mock(com.google.api.services.drive.Drive.Files.List.class);
             when(testDir.list()).thenReturn(mockList);
             
             com.google.api.services.drive.model.File finalFile = 
                             new com.google.api.services.drive.model.File();
             finalFile.setId("Test ID");
             finalFile.setTitle("test.txt");
             
             com.google.api.services.drive.model.FileList files = 
                             new com.google.api.services.drive.model.FileList();
             List<com.google.api.services.drive.model.File> items = 
                     new ArrayList<com.google.api.services.drive.model.File>();
             items.add(finalFile);
             files.setItems(items);
             
             when(mockList.execute()).thenReturn(files);
             
             String fileId = GoogleSync.getFileId("test.txt");
                                     
             Update updateTest = Mockito.mock(Update.class);
             when(testDir.update(eq(fileId), isA(com.google.api.services.drive.model.File.class), 
                             isA(AbstractInputStreamContent.class)))
                     .thenReturn(updateTest);
             
             com.google.api.services.drive.model.File finalFile2 = 
                             new com.google.api.services.drive.model.File();
             when(updateTest.execute()).thenReturn(finalFile2);
             
             GoogleSync.modifyFile(localFile);
             verify(mockDriveService, times(3)).files();                                                          
     }

     
     @Test(expected = Exception.class)  
     public void testExceptionDeleteFile() throws IOException{
             Drive MockDriveService = Mockito.mock(Drive.class);          
             GoogleDriveFileSyncManager GoogleDriveFileSyncManager_test = new GoogleDriveFileSyncManager(MockDriveService);
             
             File localFile = Mockito.mock(File.class);
             when(localFile.getName()).thenReturn(null);
             
             GoogleDriveFileSyncManager_test.deleteFile(localFile);
     }
     
     @Test
     public void testGetFileId() throws Exception{
             setup();
             
             Files testDir = mock(Files.class);
             when(mockDriveService.files()).thenReturn(testDir);
             
             com.google.api.services.drive.Drive.Files.List mockList = 
                             mock(com.google.api.services.drive.Drive.Files.List.class);
             when(testDir.list()).thenReturn(mockList);
             
             com.google.api.services.drive.model.File finalFile = 
                             new com.google.api.services.drive.model.File();
             finalFile.setId("Test ID");
             finalFile.setTitle("test.txt");
             
             com.google.api.services.drive.model.FileList files = 
                             new com.google.api.services.drive.model.FileList();
             List<com.google.api.services.drive.model.File> items = 
                     new ArrayList<com.google.api.services.drive.model.File>();
             items.add(finalFile);
             files.setItems(items);
             
             when(mockList.execute()).thenReturn(files);
                                             
             String getId =GoogleSync.getFileId("test.txt");
             Assert.assertEquals("Test ID", getId);  
     }
     
     
     //Test delete file
     
     @Test
     public void testDeleteFile() throws Exception{
             setup();
             
             Files testDir = mock(Files.class);
             when(mockDriveService.files()).thenReturn(testDir);
             
             com.google.api.services.drive.Drive.Files.List mockList = 
                             mock(com.google.api.services.drive.Drive.Files.List.class);
             when(testDir.list()).thenReturn(mockList);
             
             com.google.api.services.drive.model.File finalFile = 
                             new com.google.api.services.drive.model.File();
             finalFile.setId("Test ID");
             finalFile.setTitle("test.txt");
             
             com.google.api.services.drive.model.FileList files = 
                             new com.google.api.services.drive.model.FileList();
             List<com.google.api.services.drive.model.File> items = 
                     new ArrayList<com.google.api.services.drive.model.File>();
             items.add(finalFile);
             files.setItems(items);
             
             when(mockList.execute()).thenReturn(files);
             
             String fileId = GoogleSync.getFileId("test.txt");
                             
             File localFile = Mockito.mock(File.class);
             when(localFile.getName()).thenReturn("test.txt");
             
             Delete deleteTest = Mockito.mock(Delete.class);
             when(testDir.delete(eq(fileId)))
                     .thenReturn(deleteTest);                
                             
             GoogleSync.deleteFile(localFile);
             verify(mockDriveService, times(3)).files();                                                          
}
}
