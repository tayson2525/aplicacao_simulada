package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket listener = new ServerSocket(9090);
		System.out.println("Servidor iniciado na porta 9090");
		try {
            while (true) {
                Socket socket = listener.accept();
                //System.out.println("Cliente conectado");
                try {
                	BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                	String content = br.readLine();
                	System.out.println(content);
                	BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\kevin\\Codigo_Agent_Java\\ServerSocket\\src\\server\\server_log.txt", true)); 
            		out.write("Novo Evento: " + content);
                    out.newLine();
                    out.close();
                }finally {}
            }
        }
        finally {
            listener.close();
        }
    }

	}