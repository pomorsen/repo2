package com.sda.annotations.example;

public class TeddyBear {
    private String name;

    @LimitWartosci(minimum = 5, maximum = 100)
    private int wiek;

    public TeddyBear(String name, int age) {
        this.name = name;
        this.wiek = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
        if(!WeryfikatorLimituWartosci.czyMiesciSieWLimicie(this)){
            throw new IllegalArgumentException("Limit wartości przekroczony!");
        }
    }

    @Override
    public String toString() {
        return "TeddyBear{" +
                "name='" + name + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
