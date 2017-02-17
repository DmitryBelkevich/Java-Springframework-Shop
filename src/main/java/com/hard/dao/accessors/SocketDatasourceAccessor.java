package com.hard.dao.accessors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class SocketDatasourceAccessor {
	public SocketDatasourceAccessor() {
		
	}
	
	public Object sendRequest(String command) throws IOException, ClassNotFoundException {
		try (
			Socket socket = new Socket(getHost(), getPort());
			
			ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
			PrintWriter os = new PrintWriter(socket.getOutputStream());
		) {
			os.println(command);
			os.flush();
			
			Object res = is.readObject();
			
			return res;
		}
	}
	
	public abstract String getHost();
	public abstract int getPort();
}