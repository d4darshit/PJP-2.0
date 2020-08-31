package com.datetime.history;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StoreHistoryInFile {

	public boolean storeSession(ArrayList<History> session){
		
		String filename = "SessionHistory.ser";
		System.out.println("");
		try {
			
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(file);
			oos.writeObject(session);		
			oos.close();
			file.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
		
	}
}
