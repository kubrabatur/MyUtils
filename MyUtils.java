/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYP;

import java.util.Scanner;

/**
 *
 * @author Kubra Batur
 */
public class MyUtils {

    public static float ucgenCevre(float a, float b, float c) {

        float sonuc = a + b + c;

        return sonuc;
    }

    public static float ucgenAlan(float a, float b, float c) {
        float sonuc = 0, s;

        s = ucgenCevre(a, b, c) / 2;

        sonuc = (float) Math.sqrt((s * (s - a) * (s - b) * (s - c)));

        return sonuc;
    }

    public static float cokgenCevre(float[] kenar) {
        float sonuc = 0;
        for (int i = 0; i < kenar.length; i++) {
            sonuc += kenar[i];
        }

        return sonuc;
    }

    public static float cokgenAlan(float[] kenar) {
        float icycap, sonuc;
        System.out.print("İç yarıçapı giriniz : ");
        Scanner giris = new Scanner(System.in);

        icycap = giris.nextFloat();
        float cevre = cokgenCevre(kenar);

        sonuc = cevre * icycap * (float) 0.5;
        //çevre * iç yarıçap *1/2
        return sonuc;
    }

    public static double[] Fonksiyon(int[] sayilar) {

        double[] degerler = new double[sayilar.length*2];
        int indis=0;
        
        for (int i = 0; i < sayilar.length; i++) {
            
            double fonk1 = (3 * sayilar[i] * sayilar[i]) - (2 * Math.exp(sayilar[i])) + Math.sqrt(sayilar[i]);
            degerler[indis] = fonk1;
            indis++;
            
            double fonk2 = 1 / (1+Math.exp(sayilar[i]));
            degerler[indis] = fonk2;
            indis++;
        }

        return degerler;
    }

    public static void main(String[] args) {
        
        float ucgenCevreSonuc, ucgenAlanSonuc, cokgenCevreSonuc, cokgenAlanSonuc;
        float a = 0, b = 0, c = 0;
        int kenarsayisi;

        System.out.print("Kenar sayisini giriniz : ");
        Scanner giris = new Scanner(System.in);
        kenarsayisi = giris.nextInt();

        float kenarlar[] = new float[kenarsayisi];

        for (int i = 0; i < kenarsayisi; i++) {
            if (kenarsayisi == 3) {
                System.out.println(i + 1 + ". kenarı giriniz :");
                giris = new Scanner(System.in);
                kenarlar[i] = giris.nextFloat();
            }
            if (kenarsayisi > 3) {
                System.out.println(i + 1 + ". kenarı giriniz : ");
                giris = new Scanner(System.in);
                kenarlar[i] = giris.nextFloat();
            }
        }
        
        
        if (kenarsayisi == 3) {
            a = kenarlar[0];
            b = kenarlar[1];
            c = kenarlar[2];

            ucgenAlanSonuc = ucgenAlan(a, b, c);
            ucgenCevreSonuc = ucgenCevre(a, b, c);
            System.out.println("Ucgenin Alani: " + ucgenAlanSonuc + "  Ucgenin Cevresi: " + ucgenCevreSonuc);

        } else if (kenarsayisi > 3) {

            cokgenAlanSonuc = cokgenAlan(kenarlar);
            cokgenCevreSonuc = cokgenCevre(kenarlar);
            System.out.println("Cokgenin Alani: " + cokgenAlanSonuc + "  Cokgenin Cevresi :" + cokgenCevreSonuc);
        }

        // -100 - 100 degerler (fonksiyon sorusu)
        int[] sayilar = new int[199];
        
        int value = -100;

        for (int i = 0; i < sayilar.length; i++) {
            value++;
            if (value < 100) {
                sayilar[i] = value;
            }
        }

        double[] sonuclar = Fonksiyon(sayilar);
        System.out.println("Fonksiyon Degerleri:");
        
        for (int i = 0; i < sonuclar.length; i++) {
            System.out.println(sonuclar[i]);
        }


    }//end main

}//end class
