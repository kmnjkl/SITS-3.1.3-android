package com.example.sits_313_android;

public class Situation {
    Situation[] direction;
    String subject, text;
    String[] variantsTexts;
    int dK, dA, dR;

    public Situation(String subject, String text, int dK, int dA, int dR) {
        this.subject = subject;
        this.text = text;
        this.dK = dK;
        this.dA = dA;
        this.dR = dR;
        direction = new Situation[0];
        variantsTexts = new String[]{"Да!"};
    }

    public Situation (String subject, String text, int variants, String[] variantsTexts, int dk, int da, int dr) {
        this.subject = subject;
        this.text = text;
        dK = dk;
        dA = da;
        dR = dr;
        direction = new Situation[variants];
        this.variantsTexts = variantsTexts;
    }
}
