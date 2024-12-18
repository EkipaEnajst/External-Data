package org.ekipaenajst.entitete;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;


public class Zasedenost {


    @JsonProperty("daily_users")
    private DnevniUporabniki dnevniUporabniki;
    @JsonProperty("subscribers")
    private Abonenti abonenti;

    @Override
    public String toString() {
        return String.format("%s\n",this.dnevniUporabniki);
    }

    @JsonGetter("daily_users")
    public DnevniUporabniki getDnevniUporabniki() {
        return dnevniUporabniki;
    }

    @JsonSetter("daily_users")
    public void setDnevniUporabniki(DnevniUporabniki dnevniUporabniki) {
        this.dnevniUporabniki = dnevniUporabniki;
    }

    @JsonGetter("subscribers")
    public Abonenti getAbonenti() {
        return abonenti;
    }

    @JsonSetter("subscribers")
    public void setAbonenti(Abonenti abonenti) {
        this.abonenti = abonenti;
    }
}


class DnevniUporabniki {

    @JsonProperty("total_spaces")
    private int naVoljo;

    @JsonProperty("available_spaces")
    private int prosta;

    @Override
    public String toString() {
        return String.format("Na voljo: %d, Prosta: %d", naVoljo, prosta);
    }

    @JsonGetter("total_spaces")
    public int getNaVoljo() {
        return naVoljo;
    }

    @JsonSetter("total_spaces")
    public void setNaVoljo(int naVoljo) {
        this.naVoljo = naVoljo;
    }

    @JsonGetter("available_spaces")
    public int getProsta() {
        return prosta;
    }

    @JsonSetter("available_spaces")
    public void setProsta(int prosta) {
        this.prosta = prosta;
    }
}

class Abonenti {
    @JsonProperty("total_spaces")
    private int naVoljo;
    @JsonProperty("reserved_spaces")
    private int rezervirana;
    @JsonProperty("free_spaces")
    private int prosta;
    @JsonProperty("waiting_queue")
    private int dolzinaVrste;

    @JsonGetter("total_spaces")
    public int getNaVoljo() {
        return naVoljo;
    }
    @JsonSetter("total_spaces")
    public void setNaVoljo(int naVoljo) {
        this.naVoljo = naVoljo;
    }
    @JsonGetter("reserved_spaces")
    public int getRezervirana() {
        return rezervirana;
    }
    @JsonSetter("reserved_spaces")
    public void setRezervirana(int rezervirana) {
        this.rezervirana = rezervirana;
    }
    @JsonGetter("free_spaces")
    public int getProsta() {
        return prosta;
    }
    @JsonSetter("free_spaces")
    public void setProsta(int prosta) {
        this.prosta = prosta;
    }
    @JsonGetter("waiting_queue")
    public int getDolzinaVrste() {
        return dolzinaVrste;
    }
    @JsonSetter("waiting_queue")
    public void setDolzinaVrste(int dolzinaVrste) {
        this.dolzinaVrste = dolzinaVrste;
    }
}
