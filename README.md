# **OTM-Harjoitustyö**

## **Harjoitustyö**
Tämä on ohjelmistotekniikan menetelmien harjoitustyö. Aiheena on Snake peli, jossa pelaaja liikuttaa matoa aidatussa tilassa. Pelaaja saa pisteitä, kun hän syö tilassa olevia omenoita. Kun pelaaja syö omenan, niin aitaukseen syntyy uusi omena ja käärmeen pituus kasvaa.
Peli päättyy jos pelaaja ohjaa käärmeensä aitauksen seinään, tai törmää omaan häntäänsä.


### **Dokumentaatio**

[Käyttöohje](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md)

[Arkkitehtuurikuvaus](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentaatio](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/dokumentaatio/Testidokumentti.md)

[Työaikakirjanpito](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)


### Releaset ###

[Viikko 5](https://github.com/Savolainen95/otm-harjoitustyo/releases)

[Valmis Peli](https://github.com/Savolainen95/otm-harjoitustyo/releases/tag/viikko7)


### Komentorivitoiminnot ###
#### Testaus ####
Testit suoritetaan komennolla:

`mvn test`

Testikattavuusraportti luodaan komennolla:

`mvn test jacoco:report`

Kattavuus testejä voi tarkastella selaimella avaamalla tiedosto target/site/jacoco/index.html

####  Jarin generointi ####

`mvn package`

generoi hakemistoon target suoritettavan jar-tiedoston Snakepeli-1.0-SNAPSHOT.jar

#### JavaDoc ####

JavaDoc generoidaan komennolla

`mvn javadoc:javadoc`

JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html

#### Checkstyle ####
Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla:

`mvn jxr:jxr checkstyle:checkstyle`
 
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html
