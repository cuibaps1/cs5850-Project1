package com.cs5850;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.cs5850.FileSyncManager;
import com.cs5850.GoogleDriveFileSyncManager;
import com.cs5850.GoogleDriveServiceProvider;

public class App {
	static void usage() {
        System.err.println("usage: java Watch Folder dir");
        System.exit(-1);
    }

    public static void main(String[] args) throws IOException {
        // parse arguments
        if (args.length < 1) {
            usage();
        }

        // get file sync manager
        FileSyncManager fileSyncManager = new GoogleDriveFileSyncManager(
        		GoogleDriveServiceProvider.get().getGoogleDriveClient());

        // register directory and process its events
        Path dir = Paths.get(args[0]);
        new WatchFolder(dir, fileSyncManager).processEvents();
    }

}
