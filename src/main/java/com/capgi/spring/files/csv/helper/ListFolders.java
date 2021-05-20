package com.capgi.spring.files.csv.helper;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ListFolders {

	public static void main(String[] args) {

		try {
			File fXmlFile = new File("folders.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("folder");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					if (temp == 0) {
						getAllSubFoldersNames(hasChildNodes(nNode, eElement.getAttribute("name") + ":"));
					} else if (temp == nList.getLength() - 1) {
						Element tempElementX = (Element) eElement.getParentNode();
						getAllSubFoldersNames(hasChildNodes(nNode,
								tempElementX.getAttribute("name") + ":\\" + eElement.getAttribute("name")));
					} else {

					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public static String hasChildNodes(Node nNode, String result) {

		String fResult = "";
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			if (nNode.hasChildNodes() && nNode.getAttributes() != null) {
				NodeList tempList = nNode.getChildNodes();
				Node tempNode = tempList.item(1);
				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
					Element tempElement = (Element) tempNode;
					fResult = hasChildNodes(tempNode, result + "\\" + tempElement.getAttribute("name"));
				}
			} else {
				fResult = result;
			}
		}

		return fResult;
	}

	public static List<String> getAllSubFoldersNames(String filePath) {

		FileFilter directoryFileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};

		File directory = new File(filePath);

		File[] directoryListAsFile = directory.listFiles(directoryFileFilter);
		List<String> foldersInDirectory = new ArrayList<String>(directoryListAsFile.length);
		for (File directoryAsFile : directoryListAsFile) {
			foldersInDirectory.add(directoryAsFile.getName());
		}

		if (foldersInDirectory.size() > 0) {
			System.out.println("\nPath: " + filePath + "\nFolders available\n");
			for (String str : foldersInDirectory) {
				System.out.println("Folder Name: " + str);
			}
		} else {
			System.out.println("\nPath: " + filePath);
			System.out.println("No Folders available");
		}

		return foldersInDirectory;
	}

}