package org.ekipaenajst.beans;

import org.ekipaenajst.entitete.Zasedenost;

import javax.enterprise.context.ApplicationScoped;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class ZasedenostZrno {

    ObjectMapper mapper = new ObjectMapper();


    public List<Zasedenost> getZasedenosti() throws IOException {
        File input = new File("./availability.json");
        Zasedenost[] zasedenosti = mapper.readValue(input, Zasedenost[].class);
        System.out.println(Arrays.toString(zasedenosti));
        return Arrays.asList(zasedenosti);
    }


}
