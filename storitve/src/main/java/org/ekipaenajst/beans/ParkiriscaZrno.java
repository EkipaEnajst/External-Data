package org.ekipaenajst.beans;

import org.ekipaenajst.entitete.Parkirisce;
import org.ekipaenajst.entitete.Uporabnik;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class ParkiriscaZrno {

    @PersistenceContext(unitName = "external-jpa")
    private EntityManager em;

    private Logger log = Logger.getLogger(UporabnikiZrno.class.getName());


    public List<Parkirisce> getParkirisca() {

        Query q = em.createNamedQuery("Parkirisce.findAll", Parkirisce.class);

        List<Parkirisce> resultList = (List<Parkirisce>)q.getResultList();

        return resultList;
    }
}
