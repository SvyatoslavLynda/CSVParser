package com.sv.csv;

/**
 * Created by Svyatoslav Lynda
 * Date: 06.08.2014
 * Time: 21.00
 */
public class Main {
    public static void main(String[] args) {
        CSVSearch csvByName = new MyCSVSearch("ip,name,desc\n"+ "10.49.1.4,server1,Main Server\n"+ "10.52.5.1,server2,Backup Server\n", "name");

        System.out.println(csvByName.find("server2").getField("ip"));
        System.out.println(csvByName.find("sErver2").getField("ip"));
        System.out.println(csvByName.find("server9"));
    }
}