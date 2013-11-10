package by.grsu.oop.ApacheLogAnalyzer.parsers;

import java.util.ArrayList;
import java.util.List;

import by.grsu.oop.ApacheLogAnalyzer.model.Path;

public class PathParser {

	public Path getPathObject(String textPath) {

		String[] pathParts = textPath.split("\\.");
		String extension = pathParts[1];
		String fileName = pathParts[0].substring(pathParts[0].lastIndexOf("/") + 1);
		String foldersPath = pathParts[0].substring(0, pathParts[0].lastIndexOf("/"));
		String[] foldersArray = foldersPath.split("/");
		
		List<String> folders = new ArrayList<String>();
		for(int i=0;i<foldersArray.length;i++){
			folders.add(foldersArray[i]);
		}
		
		return new Path(fileName, extension, folders);

	}

}
