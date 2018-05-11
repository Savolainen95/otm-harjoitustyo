# Määrittelydokumentti

Tarkoituksena on tehdä kaikille tuttu Snake peli. Pelaaja voi syödä omenoita, joka sitten kasvattaa käärmeen pituutta.
Pelaaja voi liikkua käärmeellä ylös, vasemmalle, oikealle ja alas. Jos pelaaaja osuu käärmeellään seinään tai omaan häntäänsä, niin peli päättyy. Peli mahdollistaa myös pisteiden laskun, jossa omenasta saa aina yhden pisteen. Käyttäjän halutessa peli tallentaa pisteet tietokantaan, ja niistä voi katsoa top 10.

## Toiminallisuudet

### Käyttäjä
* Käyttäjä voi listätä tuloksensa tietokantaan.
* Käyttäjä voi katsoa top 10 tulokset
* Käyttäjä voi aloittaa halutessaan uuden pelin.

### Ylläpitäjä
*Ylläpitäjä voi tyhjentää tietokannan pelin loppu näkymässä syöttämällä "CLOSE AND CLEAR" tekstikenttään ja painamalla "Submit" nappia.

### Toimintaympäristön rajoitteet
* Tietokanta tallentuu kovalevylle tietokantaan.
* Työ on maven projekti, joten se vaatii javan ja mavenin toimiakseen.
