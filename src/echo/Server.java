package echo;

import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.2", 10001)); //ip는 문자열
		
		System.out.println("<서버 시작>");
		System.out.println("==================================================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		
		/// 반복 시작 /////////
		while(true) {
		Socket socket = serverSocket.accept();

		Thread thread = new ServerThread(socket);
		thread.start();
		
		}
				
		/// 반복 종료 /////////////////////

		/*
		System.out.println("==================================================");
		System.out.println("<서버 종료>");
		
		br.close();
		bw.close();
		socket.close();
		serverSocket.close();
		*/
	}
}
