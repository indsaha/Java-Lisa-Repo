package com.cg.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	public static void writePrimitives(OutputStream out) throws IOException{

		DataOutputStream dOut = new DataOutputStream(out);
		
		try{
			dOut.writeLong(1L);
			dOut.writeDouble(12.34);
			dOut.writeInt(1);
		}
		finally{
			dOut.close();
		}
	}
	
	static public void readPrimitives(InputStream in) throws IOException{
		
//		try with resources
		try(DataInputStream dIn = new DataInputStream(in)){
		
			System.out.println(dIn.readDouble());
			System.out.println(dIn.readLong());
			
			System.out.println(dIn.readInt());
		}
		
	}
	
	
}
