package org.nust.heroine.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

import javax.swing.JFileChooser;

/**
 * 保存上次的路径
 * 
 * @author xxx
 * 
 */
public class MyJFileChooser {

	static {
		File file = new File("Effa_JFilechooserPath.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private String currentPath = null;
	private JFileChooser chooser = null;
	private File selectedFile = null;

	public MyJFileChooser() {
		chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(false);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}

	public int showDialog() {
		FileInputStream fis = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(new File("Effa_JFilechooserPath.txt"));
			br = new BufferedReader(new InputStreamReader(fis));
			currentPath = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (currentPath != null)
			chooser.setCurrentDirectory(new File(currentPath));// 设置当前目录

		return chooser.showDialog(null, "Select");

	}

	public File getSelectedFile() {
		selectedFile = chooser.getSelectedFile();
		File file = new File("Effa_JFilechooserPath.txt");
		Writer writer;
		try {
			file.createNewFile();
			writer = new FileWriter(file);
			writer.write(selectedFile.getParent());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return selectedFile;
	}

}
