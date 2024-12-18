package org.ekipaenajst.entitete;

import javax.persistence.*;

@Entity
@Table(name="parkirisce")
@NamedQueries(value = {
        @NamedQuery(name = "Parkirisce.findAll", query="SELECT p FROM Parkirisce p"),
        @NamedQuery(name = "Uporabnik.findByName",
                query="SELECT p FROM Parkirisce p WHERE p.ime = :imeParam")
})
public class Parkirisce {

    @Id
    @GeneratedValue
    private int id;

    private String ime;
    private int zacetekDneva;
    private int konecDneva;
    private double cenaDnevnaPrviDveUri;
    private double cenaDnevnaTretjaUra;
    private double cenaDefault;
    private double cenaNocna;
    private String lokacija;


}
