package org.ekipaenajst.beans;

import org.ekipaenajst.entitete.Zasedenost;

import javax.enterprise.context.ApplicationScoped;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

@ApplicationScoped
public class ZasedenostZrno {

    ObjectMapper mapper = new ObjectMapper();


    public List<Zasedenost> getZasedenosti() {

    }

}
