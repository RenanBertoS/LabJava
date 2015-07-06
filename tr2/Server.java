import java.net.Socket;
import java.io.*;
import java.net.*;

public class Server {
static int _porta= 9090;
static String msg_cliente;
static ServerSocket srvApp;
static Socket sk = new Socket();


	private static void aguardarConexao() throws IOException{

		Server.srvApp = new ServerSocket(_porta);
		System.out.println("A Porta "+ _porta + " Disponivel \n Aguardando uma nova Conexao...\n");
		InetAddress inet = InetAddress.getByName("localhost");
		
		while(true){
			Server.sk = srvApp.accept();
			BufferedReader recebercliente = new BufferedReader(new InputStreamReader(sk.getInputStream()));

					
			Server.msg_cliente = recebercliente.readLine();
			System.out.println("From Cliente: " + msg_cliente);

				Thread cliente = new Thread(new TCPServerThread(sk, msg_cliente));
				cliente.start();
				System.out.println("Thread criada com sucesso.");

}
}
public static void main (String [] args) throws IOException, InterruptedException {

	Server.aguardarConexao();
	
}
}