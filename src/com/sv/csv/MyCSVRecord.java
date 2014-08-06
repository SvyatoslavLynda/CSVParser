package com.sv.csv;

import java.util.HashMap;

/**
 * Created by Svyatoslav Lynda
 * Date: 06.08.2014
 * Time: 21.00
 */
public class MyCSVRecord extends HashMap<String,String> implements CSVRecord {
    @Override
    public String getField(String header) {
        return get(header);
    }
}
