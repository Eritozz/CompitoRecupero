package it.fi.em.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ServerThread extends Thread{
    

    Socket client = null;

    BufferedReader inDalClient = null;
    DataOutputStream outVersoIlClient = null;

    
    ServerThread(Socket socket ){
        this.client = socket;
    }


    public void comunica(){

        try{
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoIlClient = new DataOutputStream(client.getOutputStream());
        
        ObjectMapper objectMapper = new ObjectMapper();

        while(true){
            String stringaRicevuta = inDalClient.readLine();
            Messaggio messaggio = objectMapper.readValue(stringaRicevuta, Messaggio.class);     

            ArrayList <Persona> listaPers = new ArrayList<>();

            if(messaggio.getListaPersone().size() != 0 && messaggio.getNazioneRichiesta() == null ){

            
            }
            else if(messaggio.getNazioneRichiesta() != null && messaggio.getListaPersone().size() == 0){
                for(int i = 0; i < listaPers.size(); i++){
                    if(messaggio.getNazioneRichiesta() == listaPers.get(i).getNazioneDiResidenza()){
                        System.out.println(listaPers.get(i));
                    }
                }
                
                
    
            }else if(messaggio.getNazioneRichiesta() == null && messaggio.getListaPersone().size() == 0){
                
            }
        }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        public void run(){

            try {
                this.comunica();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
        }
    }

