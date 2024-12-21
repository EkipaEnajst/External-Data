package org.ekipaenajst.beans;

import org.ekipaenajst.entitete.Zasedenost;

import javax.enterprise.context.ApplicationScoped;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class ZasedenostZrno {

    ObjectMapper mapper = new ObjectMapper();


    public List<Zasedenost> getZasedenosti() throws IOException, InterruptedException {

        String pth = "./api/src/main/resources/json-files/";
        ProcessBuilder pb = new ProcessBuilder(pth + "scrapeTest.exe/", "-o", "\""+pth+"\"");
        pb.redirectErrorStream(true);
        Process p = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;

        //System.out.println(p.isAlive());
        p.waitFor();
        //System.out.println(p.isAlive());





        File input = new File(pth + "availability.json/");
        System.out.println("Input file: " + input.getAbsolutePath());

        Zasedenost[] zasedenosti = mapper.readValue(input, Zasedenost[].class);
        //System.out.println(Arrays.toString(zasedenosti));


        //System.out.println(process.isAlive());
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        return Arrays.asList(zasedenosti);
    }

    public Zasedenost getZasedenost(String title) throws IOException, InterruptedException {
        List<Zasedenost> zasedenosti = this.getZasedenosti();

        Zasedenost z = zasedenosti.stream().filter( z_ -> z_.getTitle().equals(title)).findFirst().orElse(null);
        return z;
    }


}
