package hb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

		public static void main(String[] args) {
			Socket socket = null; // Server와 통신하기 위한 Client의 Socket
			BufferedReader in = null; // Server로부터 데이터를 읽어들이기 위한 입력스트림
			BufferedReader in2 = null; // 키보드로부터 읽어들이기 위한 입력스트림
			PrintWriter out = null; // 서버로 내보내기 위한 출력 스트림
			InetAddress ia = null; //IP주소를 표현한 클래스
			
			try {
				ia = InetAddress.getLocalHost(); // 서버로 접속하기 위해 서버 주소 입력
				
				socket = new Socket(ia, 1395); //컴퓨터 한대로 통신하기에 ia에 getLocalHost()써서 local ip 불러옴
				in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // BufferedReader 선언
				in2 = new BufferedReader(new InputStreamReader(System.in)); // BufferredReader2 선언
				out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // 이하 동문
				//InputStream / OutputStream = 바이트 단위 입출력을 위한 최상위 입출력 스트림 클래스
				System.out.println(socket.toString());
			}catch(IOException e) {
				
			}
			
			try {
				System.out.print("서버로 보낼 매세지 : ");
				String data = in2.readLine(); // 키보드로부터 입력 //readLine()  입력값으로 들어온 데이터를 한 줄로 읽어서 String으로 바꾸는 메
				out.println(data);
				out.flush(); //버퍼에 잔류하는 모든 바이트를 출력
				
				String str2 = in.readLine(); // 서버로부터 되돌아오는 데이터를 읽어들임
				System.out.println("서버로부터 되돌아온 메세지 : " + str2);
				socket.close();
			}catch(IOException e) {
				
			}
	}

}
