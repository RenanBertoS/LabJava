package tr1;

import java.io.OutputStream;

public class Mensagem {
	
	
	private int id;
	private String msgs;
	
	public void setID(int id){
		this.id = id;
		
	}
	public void setMensagem(String msg){
		this. msgs = msg;
	}
	
	public int getID(){
		return id;
		
	}
	public String getMensagem(){
		return msgs;
		
	}
	public static String readLine() {
		// TODO Auto-generated method stub
		return null;
	}
	public OutputStream getOutputStream() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
