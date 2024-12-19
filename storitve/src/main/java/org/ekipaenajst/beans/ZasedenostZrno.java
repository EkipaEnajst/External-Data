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


    public List<Zasedenost> getZasedenosti() throws IOException, InterruptedException {
        //File input = new File("C:\\Users\\lovro\\Faks\\PRPO\\projekt\\externaldata\\storitve\\src\\main\\resources\\json-files\\availability.json");
//        String userDirectory = new File("").getAbsolutePath();
//        System.out.println(userDirectory);
//
//        return null;

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("./api/src/main/resources/json-files/scrapeTest.exe");

        process.waitFor();



        File input = new File("./api/src/main/resources/json-files/availability1.json");
        System.out.println("Input file: " + input.getAbsolutePath());

        Zasedenost[] zasedenosti = mapper.readValue(input, Zasedenost[].class);
        System.out.println(Arrays.toString(zasedenosti));


        System.out.println(process.isAlive());
        return Arrays.asList(zasedenosti);
    }


}
