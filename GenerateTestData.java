import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Random;

public class GenerateTestData{
	public static void main(String[] args) {
		String[] alphabet = {"A","C","G","T"};
	    int N = alphabet.length;

	    Random r = new Random();
	    
	    BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			File file = new File("test_data.txt");

			if (!file.exists()) {
				file.delete();
				file.createNewFile();
			}

			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			for(int i = 0; i < 50; i++){
				String randomChar = alphabet[r.nextInt(N)];
				bw.write(randomChar);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}