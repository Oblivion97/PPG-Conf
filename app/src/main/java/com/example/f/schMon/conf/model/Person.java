/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.model;

/**
 * Created by Mir Ferdous on 10/24/2017.
 */

public class Person {
    public String _id;
    public String sl;
    public String name;
    public String topic;
    public String theme;
    public String mail;
    public String designation;
    public String organization;
    public String country;
    public String digit;
    public String t_d;
    public String venue;
    public String working;
    public String parallel;

    //extra
    public String topicExtra;
    public String themeExtra;
    public String countryExtra;
    public String digitExtra;
    public String d_tExtra;
    public String venueExtra;

    @Override
    public String toString() {
        return "Person{" +
                "\n_id='" + _id + '\'' +
                ", \nsl='" + sl + '\'' +
                ", \nname='" + name + '\'' +
                ", \ntopic='" + topic + '\'' +
                ", \ntheme='" + theme + '\'' +
                ", \nmail='" + mail + '\'' +
                ", \ndesignation='" + designation + '\'' +
                ", \norganization='" + organization + '\'' +
                ", \ncountry='" + country + '\'' +
                ", \ndigit='" + digit + '\'' +
                ", \nDateTime='" + t_d + '\'' +
                ", \nVenue='" + venue + '\'' +
                ", \nWorkingSessin='" + working + '\'' +
                ", \nParallelSessin='" + parallel + '\'' +
                ", \ntopicExtra='" + topicExtra + '\'' +
                ", \nthemeExtra='" + themeExtra + '\'' +
                ", \ncountryExtra='" + countryExtra + '\'' +
                ", \ndigitExtra='" + digitExtra + '\'' +
                ", \nDateTimeExtra='" + d_tExtra + '\'' +
                ", \nVenueExtra='" + venueExtra + '\'' +
                '}';
    }
}
