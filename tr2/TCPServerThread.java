import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class TCPServerThread implements Runnable{

private Socket _socket;
private String _msg;

static TCPServerThread tcp;


public TCPServerThread(Socket socket, String msg ){
this._socket= socket;
this._msg = msg;




	try{     
			File file = new File("c:\\temp\\MSG"+Thread.currentThread().getId()+".txt");
			FileWriter w = new FileWriter(file);
			
			w.write("Mensagem From Client:  " +_msg);
			w.close();
			System.out.println("Arquivo "+file+" Criado com Sucesso: ");
			
	} catch (IOException ex) {
	
	
	
		}
	}
	@Override
		public void run(){
		}
	}