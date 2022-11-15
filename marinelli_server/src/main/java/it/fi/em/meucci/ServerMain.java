package it.fi.em.meucci;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMain {
    

    public ServerSocket serverSocket;     
    public static ArrayList<Persona> listaPersone = new ArrayList<>();

    public ServerMain(){

    }

    public void avvia(){
        try {

            System.out.println("Il server e' stato avviato.");
            System.out.println("Ti diamo il benvenuto.");
                                                            
            this.serverSocket = new ServerSocket(7865); 

            while (true) {      
                           
                Socket socket = serverSocket.accept();      
                ServerThread thread = new ServerThread(socket);


                thread.start();                

            }

        } catch (Exception e) {
            System.out.println("Il server e' stato spento.");
        }        
    }
}
