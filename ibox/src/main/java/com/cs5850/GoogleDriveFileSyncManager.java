package com.cs5850;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files.List;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

public class GoogleDriveFileSyncManager{

	public Drive service;

	public GoogleDriveFileSyncManager(Drive service) {
		this.service = service;
}
	public void upload(java.io.File localFile) throws IOException {
		// upload file
		File body = new File();
		body.setTitle(localFile.getName());
		FileContent mediaContent = new FileContent("*/*", localFile);
		File file = service.files().insert(body, mediaContent).execute();
		System.out.println("File ID: " + file.getId());
		
	}

	public void modifyFile(java.io.File localFile) throws IOException {
		String fileId = getFileId(localFile.getName());
		if (fileId == null) {
			upload(localFile);
		} else {
			File body = new File();
			body.setTitle(localFile.getName());
			FileContent mediaContent = new FileContent("*/*", localFile);
			File file = service.files().update(fileId, body, mediaContent).execute();
			System.out.println("File ID: " + file.getId());
}
		
	}

	public void deleteFile(java.io.File localFile) throws IOException {
		String fileId = getFileId(localFile.getName());
		if (fileId == null) {
			throw new FileNotFoundException();
		} else {
			service.files().delete(fileId).execute();
		}
	}
	
	public String getFileId(String fileName) {
		try {
			List request = service.files().list();
			FileList files = request.execute();
			for(File file : files.getItems()) {
				if (file.getTitle().equals(fileName)) {
					return file.getId();
				}
			}
		} catch (IOException e) {
			System.out.println("An error occurred: " + e);
		}
		return null;
}

}
