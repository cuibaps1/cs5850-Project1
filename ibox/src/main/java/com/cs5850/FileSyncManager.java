package com.cs5850;

import java.io.File;
import java.io.IOException;

public interface FileSyncManager {

	public void upload(File localFile) throws IOException;
	
	public void modifyFile(File localFile) throws IOException;
	
	public void deleteFile(File localFile) throws IOException;
	
	
}
