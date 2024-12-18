package org.ekipaenajst.entitete;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="parkirisce")
@NamedQueries(value = {
        @NamedQuery(name = "Parkirisce.findAll", query="SELECT p FROM Parkirisce p"),
        @NamedQuery(name = "Parkirisce.findByName",
                query="SELECT p FROM Parkirisce p WHERE p.ime = :imeParam")
})
public class Parkirisce implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
