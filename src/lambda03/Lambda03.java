package lambda03;

import lambda01.Lambda01;

import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trileçe", "havucDilim", "kokorec",
                "küşleme", "waffle", "künefe", "sarma", "güvec", "güvec"));

        alfBykTekrarsiz(menu);
        System.out.println();
        tersSirali(menu);
        System.out.println();
        characterKckByk(menu);
        System.out.println();
        harfSayisi7denAzKontrol(menu);
        wIleBaslayan(menu);
        xIleBiten(menu);
        enBuyukEleman(menu);
        ilkElHrcSonHrf(menu);
        System.out.println();
        System.out.print("Odev Cozumu : \t");
        abc(menu);

    }

    // Task -1 : List elemanlarini alafabetik buyuk harf ve tekrarsiz print ediniz.
    public static void alfBykTekrarsiz(List<String> yemek) {

        yemek.
                stream().//akis basladi
                map(String::toUpperCase).//Buyuk harf
                sorted().//dogal siralama
                distinct().//elemanlari tekrarsiz olmasini sagladi
                forEach(t -> System.out.print(t + " "));//yazdirdi

    }

    // Task -2 : List elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void tersSirali(List<String> ikram) {

        ikram.
                stream().//akis basladi
                map(String::length).//akis guncellendi ve uzunluklari alindi
                sorted(Comparator.reverseOrder()).//ters sirali
                distinct().//tekrarsiz > bu soru özelinde ise AYNI KARAKTER SAYILARINA sahip elemanlari tekrar etmez
                forEach(Lambda01::yazdir);//lambda01 classindan cagirdik

    }

    // Task-3 : List elemanlarini character sayisina gore kucukten buyuge gore print ediniz..
    public static void characterKckByk(List<String> ikram) {

        ikram.
                stream().//akis basladi
                sorted(Comparator.comparing(String::length)).//String ifadeler character sayisina (Kucuk-Buyuk) göre siralandi
                forEach(Lambda01::yazdir);// lambda01 gidip yazdir methodunun String versiyonunu olusturduk.
                                          // O yüzden yazdir() methodunu artık stringlerde kullanabildik
    }


    // ********************* anyMatch() *** allMatch() *** noneMatch() ************************

    //anyMatch() --> En az bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> Tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> Hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    // Task-4 : List elemanlarinin tamaminin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7denAzKontrol(List<String> ikram) {

        System.out.println(ikram.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanlari 7 ve daha az harften olusuyor" :
                "list elemanlarinda 7 harften buyuk eleman var");

    }

    // Task-5 : List elemanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayan(List<String> ikram) {

        System.out.println(ikram.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile yemek ismi mi olur" : "w ile yemek ismi icat ettik.");

    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı var mı kontrol ediniz.
    public static void xIleBiten(List<String> ikram) {

        System.out.println(ikram.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "var" : "yok");
    }

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void enBuyukEleman(List<String> ikram) {

        Stream<String> sonHal = ikram.
                stream().// akıs                                        //Comparator.comparing stream getirir.
                sorted(Comparator.comparing(t -> t.toString().length()).//Stream olarak geldiği icin toString ile stringe çevrildi.
                        reversed()).//karakter sırasına gore tersten sıralandı.

                limit(1);//limit içerisine verilen sayı kadar baştan başlayarak eleman getirir.
                                // Stream dondürür o yüzden direk sout içine alınamaz.Limit üstüne gelerek uygun bir
                                // konteynar'a koyduk daha sonra da bize array verdiği için stringe çevirerek okuttuk.

        System.out.println(Arrays.toString(sonHal.toArray()));// Arrayi String yapıya çevirdik.

        // limit() methodunun dönen degeri Stream<String> yapıdadır.
        // sonHal.toArray() --> Stream olan akıs Array'e cevrildi
        // Arrays.toString(sonHal.toArray()) --> Arrayi String yapıya çevirdik.
    }

    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHrcSonHrf(List<String> ikram) {

        ikram.
                stream().//akis
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).// son harfe gore alfabetik siralandi
                skip(1). // Atla  --> kac eleman atlamak isterseniz skip() icerisine yazmalisiniz
                forEach(Lambda01::yazdir);
    }

    //  ODEV : List elemanlarını son harfe göre sıralayıp, son 3 elemanı yazdırın
    public static void abc(List<String> x){
        x.stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
                skip(x.size()-3).
                forEach(t-> System.out.print(t+" "));
    }
}
