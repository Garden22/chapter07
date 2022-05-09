package echo;

import java.net.*;
import java.io.*;

public class ServerThread extends Thread {
	
	private Socket socket;
	
	public ServerThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	@Override
	public void run() {
		System.out.println("[클라이언트가 연결 되었습니다.]");
		
		try {
			//메세지 받기용 스트림
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
				
			//메세지 보내기용 스트링
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			while (true) {
				String msg = br.readLine();
				
				if (msg == null) {
					System.out.println("[클라이언트가 종료되었습니다.]");
					break;
				}
				
				System.out.println("받은메세지: " + msg);
				
				//메세지 보내기
				bw.write(msg);
				bw.newLine();
				bw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
}
