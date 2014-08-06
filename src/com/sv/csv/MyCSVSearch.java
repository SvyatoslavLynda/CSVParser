package com.sv.csv;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Svyatoslav Lynda
 * Date: 06.08.2014
 * Time: 21.00
 */
public class MyCSVSearch implements CSVSearch {
    static String LINE_SEPARATOR = "\n";
    static String CELL_SEPARATOR = ",";
    static int INITIAL_ROW_NUMBER = 1;
    static int HEADERS_ROW_NUMBER = 0;

    private List<MyCSVRecord> records = new ArrayList<>();
    private String searchableColumnName;

    public MyCSVSearch(String csvString, String searchableColumnName) {
        this.searchableColumnName = searchableColumnName;
        String[] rows = csvString.split(LINE_SEPARATOR);
        final String[] headers = csvString.split(LINE_SEPARATOR)[HEADERS_ROW_NUMBER].split(CELL_SEPARATOR);

        for (int i = INITIAL_ROW_NUMBER; i < rows.length; i++) {
            final String[] cells = rows[i].split(CELL_SEPARATOR);
            records.add(new MyCSVRecord() {{ for (int i = 0; i < cells.length; i++) put(headers[i], cells[i]); }});
        }
    }

    @Override
    public CSVRecord find(String query) {
        for (MyCSVRecord record : records)
            if (record.get(searchableColumnName).equalsIgnoreCase(query))
                return record;

        return null;
    }
}