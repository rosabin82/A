package hb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		Socket socket = null; //Client와 통신하기 위한 Socket
		ServerSocket server_socket = null; //서버생성을 위한 serverSocket
		BufferedReader in = null; //Client로부터 데이터를 읽어들이기위한 입력스트림
		PrintWriter out = null; //Client로 데이터를 내보내기 위한 출력 스트림 
		
		try {
			server_socket = new ServerSocket(1395); //특정 포트입력
		}catch(IOException e) {
			System.out.println("해당 포트가 열려있습니다."); //포트열려있는지 확인 이미 열려있다면 에러구문
		}
		
		try {
			System.out.println("서버가 열렸습니다.");
			socket = server_socket.accept(); // 서버를 생성, Client는 접속 대기
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 입력스트림 생성 //문자 단위 입출력을 위한 하위 스트림 클래스
			
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // 출력스트림 생성
			
			String str = null;
			str = in.readLine(); // Client로부터 데이터 읽어옴
			
			System.out.println("Client로부터 온 메세지 : " + str);
			
			out.write(str); // print(str)와 비슷// 문자 단위 입출력을 위한
			out.flush(); // 버퍼링으로 인해 기록되지 않은 데이터를 출력 스트림에 모두 출력
			socket.close(); // 출력되지 않은 스트림은 모두 출력하고 스트림을 닫는다. 
		}catch(IOException e) {
			
		}
	}

}
