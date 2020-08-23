package datetime.history;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadHistoryFromFile {

	@SuppressWarnings("unchecked")
	ArrayList<History> readFromFile(){
			
			String filename = "SessionHistory.ser";
			
			try {
				FileInputStream file = new FileInputStream(filename);
				ObjectInputStream ois = new ObjectInputStream(file);
				 ArrayList<History> session=new ArrayList<History>();
				session = (ArrayList<History>) ois.readObject();
				ois.close();
				file.close();
				return session;
	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		return null;
		
	} 
}
