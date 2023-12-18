import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int satir , sutun ;

        System.out.println("Mayın Tarlasına Hoşgeldiniz!!!");
        System.out.println("Mayın Tarlasının Boyutlarını Giriniz");
        System.out.print("Satır Sayısını Giriniz : ");
        satir = input.nextInt();
        System.out.print("Sütun Sayısını Giriniz : ");
        sutun = input.nextInt();

        MineSweeper mayin = new MineSweeper(satir , sutun);
        mayin.calistir();

    }
}
