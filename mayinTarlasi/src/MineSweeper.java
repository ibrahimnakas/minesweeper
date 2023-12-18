import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int satirNo, sutunNo, boyut;
    int[][] tarla;
    int[][] ekran;
    boolean oyun = true;

    Random rnd = new Random();
    Scanner input = new Scanner(System.in);

    MineSweeper(int satirNo, int sutunNo) {
        this.satirNo = satirNo;
        this.sutunNo = sutunNo;
        this.tarla = new int[satirNo][sutunNo];
        this.ekran = new int[satirNo][sutunNo];
        this.boyut = satirNo * sutunNo;
    }

    void calistir() {
        int satir, sutun , puan = 0;
        mayinYerlestir();
        tarlayiGoster(tarla);
        System.out.println();
        while (oyun) {
            tarlayiGoster(tarla);
            System.out.print("Hangi Satır : ");
            satir = input.nextInt();
            System.out.print("Hangi Sütun : ");
            sutun = input.nextInt();

            if (satir < 0 || satir >= satirNo){
                System.out.println("Hatalı Konum. Tekrar Deneyin!");
                continue;
            }

            if (sutun < 0 || sutun >= sutunNo){
                System.out.println("Hatalı Konum. Tekrar Deneyin!");
                continue;
            }

            if (tarla[satir][sutun] != -1) {
                mayinKontrol(satir, sutun);
                puan++;
                if (puan == (boyut - (boyut/4))){
                    System.out.println("Tebrikler. KAZANDINIZ!");
                }
            } else{
              oyun = false;
                System.out.println("Mayına Bastınız. KAYBETTİNİZ!");
            }

        }
    }

    void mayinKontrol(int satir, int sutun) {
        if (tarla[satir][sutun] == 0){
            if ((sutun < sutunNo - 1) && (tarla[satir][sutun + 1] == -1)) {
                ekran[satir][sutun]++;
            }

            if ((satir < satirNo-3) && (tarla[satir + 1][sutun] == -1)) {
                ekran[satir][sutun]++;
            }

            if ((satir > 0) && (tarla[satir - 1][sutun] == -1)) {
                ekran[satir][sutun]++;
            }

            if ((sutun > 0) && (tarla[satir][sutun - 1] == -1)) {
                ekran[satir][sutun]++;
            }

            if (ekran[satir][sutun] == 0){
                ekran[satir][sutun] = -2;
            }
        }


    }

    void mayinYerlestir() {
        int satirKonumu, sutunKonumu, elemanSayisi = 0;

        while (elemanSayisi != (boyut / 4)) {
            satirKonumu = rnd.nextInt(satirNo);
            sutunKonumu = rnd.nextInt(sutunNo);
            if (tarla[satirKonumu][sutunKonumu] != -1) {
                tarla[satirKonumu][sutunKonumu] = -1;
                elemanSayisi++;
            }
        }


    }

    void tarlayiGoster(int[][] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {

                if (dizi[i][j] >= 0) {
                    System.out.print(" ");
                }

                System.out.print(dizi[i][j] + " ");
            }
            System.out.println();
        }
    }

}
