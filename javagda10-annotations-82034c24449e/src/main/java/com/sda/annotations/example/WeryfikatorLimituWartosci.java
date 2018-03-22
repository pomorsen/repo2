package com.sda.annotations.example;

import java.lang.reflect.Field;

public class WeryfikatorLimituWartosci {
    public static boolean czyMiesciSieWLimicie(Object obiekt){

        Field[] pola = obiekt.getClass().getDeclaredFields();
        for (Field pole: pola) {
            LimitWartosci adnotacja = pole.getAnnotation(LimitWartosci.class);
            if(adnotacja!=null){
                int min = adnotacja.minimum();
                int max = adnotacja.maximum();

                try {
                    pole.setAccessible(true);
                    int wartośćPola = (int) pole.get(obiekt);
                    if(wartośćPola > max || wartośćPola < min){
                        return false;
                    }
                    pole.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
