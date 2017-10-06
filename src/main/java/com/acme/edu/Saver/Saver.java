package com.acme.edu.Saver;

import com.acme.edu.Exceptions.SaverException;

public interface Saver {
    void save(String formattedString) throws SaverException ;
}
