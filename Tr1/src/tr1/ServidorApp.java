package tr1;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServidorApp   {
	
	private static ServerSocket srvSocket;
	private TCPBase tcpbase;
	

	
					
	
	public static void main (String args[]){
		
		String msg_cliente;
		String msg_cliente_cx_alta;
		
		
		try {
			
			ServerSocket server = new ServerSocket(3323); 	
			System.out.println("Servidor iniciado na porta 3323");
			
			Socket clienteApp = server.accept(); 
			System.out.println("Cliente conectado do IP "+clienteApp.getInetAddress(). getHostAddress());
			
					
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clienteApp.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(clienteApp.getOutputStream());
			
			msg_cliente = inFromClient.readLine();
			System.out.println("Recebido: " + msg_cliente);
			msg_cliente_cx_alta = msg_cliente.toUpperCase() + '\n';
			outToClient.writeBytes(msg_cliente_cx_alta);

			
			 Scanner entrada = new Scanner(clienteApp.getInputStream());
             while(entrada.hasNextLine()){
                 System.out.println(entrada.nextLine());
	
             }
             
             entrada.close();
             server.close();
		} catch (IOException ex) { 
			Logger.getLogger(ServidorApp.class.getName()).log(Level.SEVERE, null, ex); } } }


	