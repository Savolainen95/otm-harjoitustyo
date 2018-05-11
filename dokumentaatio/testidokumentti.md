# Testausdokumentti

Ohjelmaa on testattu JUnit testeillä, sekä sen lisäksi on tehty pari käyttöliittymä testiä muutaman avuliaan ihmisen toimesta.

## JUnit testit

Käyttöliittymä on jätetty testeistä ulkopuolelle.

Sovellus logiikkaa testaa kaksi eri testi luokkaa GameTest.java ja PieceTest.java
Luokat testaavat koodin toiminnallisuutta, ja kertoo toimiiko kaikki halutulla tavalla.

Tietokantaa testailee testi luokka DatabaseTest.java.
Testit tarkistavat tallentuuko tiedot tietokantaan oikein, sekä onnistuuko tietokannan tyhjentäminen halutulla tavalla.


### Testauskattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 81% ja haarautumakattavuus 80%

![Testikattavuus](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/SnakePeli/Photos/jacocoReport.png)

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Ohjelma on ladattu ja konfiguroitu ohjeiden mukaisesti. Sen jälkeen sitä on testattu Windows ympäristössä.
Linuxilla tai IOS:illa ei ohjelmaa ole viellä testattu. Ohjelmassa ei pitäisi kuitenkaan olla mitään,
mikä estäisi ohjelmaa toimimasta muilla käyttöjärjestelmillä.

### Toiminnallisuudet

Testatessa ollaan yritetty testata kaikkia virhesyötteitä, mutta jotain on voinut jäädä huomioimatta.
[Määrittelydokumentin](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md) toiminnallisuudet ollaan saatu toimintaan halutulla tavalla.

## Sovellukseen jääneet laatuongelmat

Tietokannasta ei pysty muokkaamaan yksittäistä tulosta. Pystyy vain tyhjentämään koko tietokannan.
