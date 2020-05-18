package com.example.informationexchangeserviceplatform.data;

public class Techtask {
    private String Ttintro,Ttdiffi,TtMon;

    public Techtask(String ttintro, String ttdiffi, String ttMon) {
        Ttintro = ttintro;
        Ttdiffi = ttdiffi;
        TtMon = ttMon;
    }

    public String getTtintro() {
        return Ttintro;
    }

    public void setTtintro(String ttintro) {
        Ttintro = ttintro;
    }

    public String getTtdiffi() {
        return Ttdiffi;
    }

    public void setTtdiffi(String ttdiffi) {
        Ttdiffi = ttdiffi;
    }

    public String getTtMon() {
        return TtMon;
    }

    public void setTtMon(String ttMon) {
        TtMon = ttMon;
    }
}
