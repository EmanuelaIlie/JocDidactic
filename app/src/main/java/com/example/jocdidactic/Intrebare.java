package com.example.jocdidactic;

public class Intrebare {
    private String textCerinta;
    private String intrebare;
    private String raspuns1;
    private String raspuns2;
    private String raspuns3;
    private int raspunsCorect;

    public Intrebare(String textCerinta, String intrebare, String raspuns1, String raspuns2, String raspuns3, int raspunsCorect) {
        this.textCerinta = textCerinta;
        this.intrebare = intrebare;
        this.raspuns1 = raspuns1;
        this.raspuns2 = raspuns2;
        this.raspuns3 = raspuns3;
        this.raspunsCorect = raspunsCorect;
    }

    public Intrebare() {
    }

    public String getTextCerinta() {
        return textCerinta;
    }

    public void setTextCerinta(String textCerinta) {
        this.textCerinta = textCerinta;
    }

    public String getIntrebare() {
        return intrebare;
    }

    public void setIntrebare(String intrebare) {
        this.intrebare = intrebare;
    }

    public String getRaspuns1() {
        return raspuns1;
    }

    public void setRaspuns1(String raspuns1) {
        this.raspuns1 = raspuns1;
    }

    public String getRaspuns2() {
        return raspuns2;
    }

    public void setRaspuns2(String raspuns2) {
        this.raspuns2 = raspuns2;
    }

    public String getRaspuns3() {
        return raspuns3;
    }

    public void setRaspuns3(String raspuns3) {
        this.raspuns3 = raspuns3;
    }

    public int getRaspunsCorect() {
        return raspunsCorect;
    }

    public void setRaspunsCorect(int raspunsCorect) {
        this.raspunsCorect = raspunsCorect;
    }
}
