package org.ekipaenajst.beans;

import org.ekipaenajst.entitete.Parkirisce;
import org.ekipaenajst.entitete.Uporabnik;
import org.ekipaenajst.entitete.Zasedenost;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class ParkiriscaZrno {

    @PersistenceContext(unitName = "external-jpa")
    private EntityManager em;

    @Inject
    ZasedenostZrno zasedenostZrno;

    @PostConstruct
    public void init() {
        System.out.println("AAAAAAAjajajajaAAAAAAAAAAAAAAAAAA\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\nAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    private Logger log = Logger.getLogger(UporabnikiZrno.class.getName());


    public List<Parkirisce> getParkirisca() throws IOException, InterruptedException {

        Query q = em.createNamedQuery("Parkirisce.findAll", Parkirisce.class);

        List<Parkirisce> resultList = (List<Parkirisce>)q.getResultList();

        List<Zasedenost> zasedenosti = zasedenostZrno.getZasedenosti();

        for (Parkirisce p : resultList) {
            Zasedenost z = zasedenosti.stream().filter( z_ -> z_.getTitle().equals(p.getIme())).findFirst().orElse(null);

            if (z!=null) {
                p.setZasedenost(z);
            }

        }

        return resultList;
    }

    public Parkirisce getParkirisce(int id) throws IOException, InterruptedException {
        Parkirisce p = em.find(Parkirisce.class, id);

        if (p==null) return null;

        Zasedenost z = zasedenostZrno.getZasedenost(p.getIme());

        p.setZasedenost(z);

        return p;


    }

    @Transactional
    public void createParkirisce(Parkirisce p) throws IOException, InterruptedException {
        em.persist(p);
    }
}
