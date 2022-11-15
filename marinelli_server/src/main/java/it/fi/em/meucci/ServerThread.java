package it.fi.em.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ServerThread extends Thread{
    

    Socket client = null;

    BufferedReader inDalClient = null;
    DataOutputStream outVersoIlClient = null;

    
    ServerThread(Socket socket ){
        this.client = socket;
    }


    public void comunica() throws Exception{

        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoIlClient = new DataOutputStream(client.getOutputStream());
        
        ObjectMapper objectMapper = new ObjectMapper();

        while(true){
            String stringaRicevuta = inDalClient.readLine();
            Messaggio messaggio = objectMapper.readValue(stringaRicevuta, Messaggio.class);     

            if (messaggio.getListaPersone().size() == 0){                     
                Messaggio mess = new Messaggio(ServerMain.listaPersone);
                outVersoIlClient.writeBytes(objectMapper.writeValueAsString(mess) + "\n");

            }else{
                

            }
        }
    }
}
