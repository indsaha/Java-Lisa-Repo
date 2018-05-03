import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) throws IOException {
		
		ServerSocket service = new ServerSocket(8080);
		
		System.out.println("Waiting for client connection");
		
		while(true){
			final Socket clientSocket = service.accept();
			
//			System.out.println("Client is now connected");
//			System.out.println(clientSocket);
			
			new Thread(
					
						new Runnable() {
							
							public void run() {
								
								try {
									
//									TODO	Read HTTP request and print it on console
									
									InputStream in = clientSocket.getInputStream();
									
									InputStreamReader iReader = new InputStreamReader(in);
									BufferedReader buff = new BufferedReader(iReader);
									
									String requestFormat=null;

									do{
										requestFormat = buff.readLine();
										System.out.println(requestFormat);
										
									}while(buff.ready());
									
									System.out.println(requestFormat);
									
//									TODO	Preparing a HTTP repsonse and sending it
									
									
									OutputStream out = clientSocket.getOutputStream();
									
									PrintWriter pOut = new PrintWriter(out,true);
									System.out.println("sending response "+ clientSocket);
									
									pOut.println("HTTP/1.1 200 Ok");
									pOut.println();
									pOut.println("Hello, world!");
									pOut.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
								
								
							}
						}
					
					
					
			).start();
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
	}
}
