package org.ekipaenajst.beans;

import org.ekipaenajst.entitete.Parkirisce;
import org.ekipaenajst.entitete.Uporabnik;
import org.ekipaenajst.entitete.Zasedenost;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class ParkiriscaZrno {

    @PersistenceContext(unitName = "external-jpa")
    private EntityManager em;

    @Inject
    ZasedenostZrno zasedenostZrno;

    private Logger log = Logger.getLogger(UporabnikiZrno.class.getName());


    public List<Parkirisce> getParkirisca() {

        Query q = em.createNamedQuery("Parkirisce.findAll", Parkirisce.class);

        List<Parkirisce> resultList = (List<Parkirisce>)q.getResultList();

        return resultList;
    }

    public Parkirisce getParkirisce(int id) throws IOException, InterruptedException {
        Parkirisce p = em.find(Parkirisce.class, id);

        Zasedenost z = zasedenostZrno.getZasedenost(p.getIme());

        p.setZasedenost(z);

        return p;


    }
}
