package it.fi.em.meucci;

import java.util.ArrayList;

public class Messaggio {

    private String nazioneRichiesta;
    ArrayList<Persona> listaPersone = new ArrayList<>();


    public Messaggio(String nazioneRichiesta, ArrayList<Persona> listaPersone) {
        this.nazioneRichiesta = nazioneRichiesta;
        this.listaPersone = listaPersone;
    }


    public String getNazioneRichiesta() {
        return nazioneRichiesta;
    }


    public void setNazioneRichiesta(String nazioneRichiesta) {
        this.nazioneRichiesta = nazioneRichiesta;
    }


    public ArrayList<Persona> getListaPersone() {
        return listaPersone;
    }


    public void setListaPersone(ArrayList<Persona> listaPersone) {
        this.listaPersone = listaPersone;
    }

    
    
}
