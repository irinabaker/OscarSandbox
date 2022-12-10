package com.telran.oscar.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> posRegister() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/data.csv")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

            while (line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> negPasswordRegister() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/negPasswordData.csv")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while (line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> negEmailRegister() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(DataProviders.class
                .getResourceAsStream("/invalidEmailData.csv")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while (line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
    }
}
