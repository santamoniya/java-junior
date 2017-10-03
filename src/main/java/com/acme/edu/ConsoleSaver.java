package com.acme.edu;

public class ConsoleSaver implements Saver {

    @Override
    public void save(String formattedString) {
        System.out.println(formattedString);
    }
}
