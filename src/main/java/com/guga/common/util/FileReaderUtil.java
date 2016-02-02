package com.guga.common.util;

import java.util.Scanner;

/**
 * Created by gvaldes
 */
public class FileReaderUtil {


    public Scanner readResource(String resourcePath){
        return new Scanner(getClass().getResourceAsStream(resourcePath));
    }
}
