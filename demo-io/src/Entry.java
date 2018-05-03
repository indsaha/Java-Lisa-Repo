import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.cg.util.IOUtils;

import sun.nio.ch.IOUtil;

public class Entry {
	public static void main(String[] args) throws IOException {
		
		String fileName = "test.mf";
		OutputStream out = new FileOutputStream(fileName);
		IOUtils.writePrimitives(out);
		
		InputStream in = new FileInputStream(fileName);
		
		IOUtils.readPrimitives(in);
		
		
		
		
		System.out.println("end of main()...");
		
	}
}
