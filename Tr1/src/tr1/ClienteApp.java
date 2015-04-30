package tr1;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class ClienteApp extends TCPBase {
	

	 static int porta;
	 static String endereco;
	
	 static int id;
	 static String msgs;
	 static String sentence;   
	 static String modifiedSentence;   
	 static BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));  
	 

	public static void main (String[]args) throws UnknownHostException, IOException{
		
		 @SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		
		    System.out.print("Qual o Endereço:(localhost)");
		    endereco = s.nextLine();
		    
		    System.out.print("Qual a porta:(3323)");
		    porta = s.nextInt();
		    
		   		
		    TCPBase tcpbase = new TCPBase();
		    tcpbase.setEndereco(endereco);
		    tcpbase.setPorta(porta);
		
	
			try(Socket socket = new Socket(tcpbase.getEndereco(), tcpbase.getPorta()); 
				Scanner teclado = new Scanner(System.in); 
				
			PrintStream saida = new PrintStream(socket.getOutputStream())) {
			System.out.println("você está conectado ao servidor!");
			
			@SuppressWarnings("resource")
			Scanner p = new Scanner(System.in);

			System.out.print(" Digite o ID: ");
			id = p.nextInt();
					
		    System.out.print(" Digite a Mensagen: ");
		    msgs = p.nextLine();
		    
		   		
		    Mensagem mensagem = new Mensagem();
		    mensagem.setMensagem(msgs);
		    mensagem.setID(id);

		   
		    DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());   
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
			
			sentence = inFromUser.readLine();   
			outToServer.writeBytes(sentence + '\n');   
			modifiedSentence = inFromServer.readLine();   
			System.out.println(" ID:"+ mensagem.getID()+" "+ modifiedSentence);   
			socket.close(); 
			
			
			
		    
	}
			
			
	 }
		    				
	}

	
	