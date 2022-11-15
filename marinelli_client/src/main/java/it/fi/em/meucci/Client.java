package it.fi.em.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {
    
    String nomeServer = "localhost";
    int porta = 7865;
    Socket socket;    
    String stringaInviata;
    String stringaRicevuta;
    private String scelta;



    BufferedReader  tastiera;
    DataOutputStream  outVersoIlServer;
    BufferedReader  inDalServer;

    public Socket connetti() {


        try{
        ObjectMapper objectMapper = new ObjectMapper();

        tastiera = new BufferedReader(new InputStreamReader(System.in));
        socket = new Socket(nomeServer, porta);

    
    
        outVersoIlServer = new DataOutputStream(socket.getOutputStream());
        inDalServer = new BufferedReader(new InputStreamReader(socket.getInputStream() ));


            System.out.println("Client connesso.");

            
        }catch(Exception e){
            System.out.println("ERRORE!");
        }
            return socket;


            

    }


    public void comunica(){

        try{
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println("Inserire nome: ");
            String name = tastiera.readLine();
            System.out.println("Inserire cognome: ");
            String cognome = tastiera.readLine();
            System.out.println("Inserire nazionalita': ");
            String naz = tastiera.readLine();

            Persona p = new Persona(name, cognome , naz);

            
        ArrayList <Persona> listaPers = new ArrayList<>();
        System.out.println("Scelta: ");
        
        
        
    }catch(Exception e){
        System.out.println("Si e' verificato un errore. Riprovare.");
    }


    }
}
