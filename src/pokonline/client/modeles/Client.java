package pokonline.client.modeles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private PlayerModeles p1;
	public Client(String pname) {
		this.p1 = new PlayerModeles(0,0,pname);
		try {
			StartClient();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void StartClient() throws UnknownHostException, IOException {
		
		Socket sock = new Socket("151.80.155.244", 5015);
		Scanner scanner = new Scanner(System.in);
		PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
		
		Thread t = new Thread(new Runnable() {
			public void run() {

						try {
				            InputStream input = sock.getInputStream();
				            
				            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				 
				            String line2;
				 
				            while ((line2 = reader.readLine()) != null) {
				                System.out.println(line2);
				            }

							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

			}
		
		});
		t.start();
		
		out.println(p1.getName());
		//Ecriture sur le serveur 
		while(true) {
			if(p1.isUpdate()) {
				out.println(p1.getName() +":"+p1.getDirection());
				p1.setUpdate(false);
			}
			
		}

		
		
	}

	public PlayerModeles getP1() {
		return p1;
	}

	public void setP1(PlayerModeles p1) {
		this.p1 = p1;
	}


}
