# Käyttoohje #
Lataa tiedosto [Valmiin pelin release](https://github.com/Savolainen95/otm-harjoitustyo/releases)


## Konfigurointi ##
Ohjelma olettaa, että Snake.png on sijoitettu kansioon nimeltä "Photos". 
Kansiota ei voinut lisätä issueen, niin kansio pitää luoda itse.
Eli *SnakePeli.The.Game.jar* tiedoston kanssa samassa kansiossa pitää olla Kansio Photos, jonka sisällä kuva Snake.png.

Pelin käynistäessä syntyy Tietokanta HighScore samaan repositioon jar tiedoston kanssa.

## Ohjelman käynnistäminen ##
Ohjelma käynistetään komennolla

*java -jar SnakePeli.The.Game.jar*

## Ohjelman aloitus ##
Nappi *"New Game"* aloittaa uuden pelin.

Nappi *"High Score"* avaa huippupiste ikkunan, missä on parhaat 10 tulosta (ei tällä hetkellä viellä käytössä).

![Aloitus näyttö](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/SnakePeli/Photos/aloitus.png)

## Pelaaminen ## 
Käärmettä voi ohjailla nuolinäppäimillä.

Tavoite on syödä omenoita, jolloinka pisteet kasvavat.

![peli käynnissä](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/SnakePeli/Photos/pelikaynnissa.png)

## Pelin loppu ##
Jos pelaaja osuu käärmeellään seinään tai omaan häntäänsä hän häviää pelin.

Tuloksen näkee vasemmasta ylä laidasta, mistä löytyy myös nappi, mistä pääsee loppu näyttöön.

![havisit pelin](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/SnakePeli/Photos/h%C3%A4vi%C3%B6.png)

## Loppu näyttö ##

Pelaaja voi tallentaa tuloksensa kirjoittamalla nimensä tekstikenttään. Jos tulos oli tarpeeksi hyvä, niin pelaajan tulos on nähtävissä "HighScore" näkymässä.

Ylläpitäjä voi tyhjentää tietokannan tässä ruudussa. Pisteiden tallentamisen sijaan ylläpitäjä voi kirjoittaa teksti kenttään "CLOSE AND CLEAR". Tämä antaa tietokannalle DROP TABLE komennon.


![loppu naytto](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/SnakePeli/Photos/h%C3%A4vi%C3%B6%20ruutu.png)

## Huippupisteet ##
Huippupiste näyttö näyttää parhaat kymmenen tulosta. Jos tuloksia on alle kymmenen, niin tulee näkyville kaikki tulokset.
![Huppupisteet](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/SnakePeli/Photos/huippupisteet.png)

## Tulevaa ##

