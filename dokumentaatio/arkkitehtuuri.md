# Arkkitehtuuri kuvaus #
### Rakenne ###
Ohjelma on rakennettu kolmeen kerrokseen ja on jaettu pakkauksiin snakepeli.ui, snakepeli.domain ja snakepeli.dao.

snakepeli.ui käyttöliittymän, mikä on näkyvissä käyttäjälle.
snakeplei.domain sisältää ohjelman sovelluslogiikan.
snakepeli.db sisältää tietokantoja vastaavan koodin.

### Käyttöliittymä ###

Käyttöliittymä sisältää neljä erillistä näkymää.

- Aloitus näkymä.
- Peli näkymä.
- Tallennus näkymä.
- Huippupiste näkymä.

Jokainen näkymä on toteutettu [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html) oliona, ja niistä voi olla vain yksi kerrallaan näkyvissä sijoitettuna [stageen](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html).
Käyttöliittymä on rakennettu luokkaan [snakepeli.ui.Graphic.java](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/SnakePeli/src/main/java/snakepeli/ui/Graphic.java)

Käyttäjä voi liikkua näiden näkymien välillä. Liikkuminen onnistuu näkymiin sijoitetuilla napeilla, jotka on on nimetty sen mukaan mihin näkymään se vie.

Käyttöliittymä on pyritty eristämään sovellus logiikasta. Joitan yksinkertaisia asioita on pitänyt kuitenkin suorittaa käyttöliittymässä, jotta maven ja JavaFX toimivat hyvin yhdessä. Käyttöliittymä kutsuu ja käyttää sovelluslogiikkaa suorittamaan peliä.

### Sovelluslogiikka ###

Snakepeli.domain koostuu viidestä eri luokasta.

- Piece
- Apple
- Snake
- Direction
- Game

Piece on rajapinta joka atribuutteina on vain X ja Y koordinaatit. Snake ja Apple implementoivat siis Piece luokkaa.
Snake on siis vain yksittäinen pala, mutta sille lisätään muistiin muiden Snake palojen koordinaatit listaan pieces.
Snake olio sisältää myös atribuutit grow ja Direction. Grow atribuutti kertoo, kuinka monta palasta snaken pitää pitää muistissa.
Direction on enumi, joka kertoo käärmeelle, mihin suuntaan uusi snake pala syntyy vanhaan palaan nähden.

Game luokka on on niin sanotusti ylläpitävä luokka. Se kutsuu muita luokkia ja niiden avulla suorittaa pelin. Game luokalla on myös yhteys tietokantaan, mihin se sitten tallettaa huipputuloksia.

### Tietokanta ###

snakepeli.db Tietokanta koostu seuraavista luokista.

- Database
- Dao
- HighScoreDao
- HighScore

Luokat yhdessä käyttävät databasea, joka sisältää huppupiste "olioita". Jos tietokantaa ei ole enestään olemassa, niin luokka Database luo uuden databasen, ja käyttää sitten sitä. Käyttäjän on mahdollista myös poistaa tietokanta. Tiedot jäävät siis lokaaliin muistiin erilliseen tiedostoon. HighScoreDao hyödyntää Databasen luomaa tietokantaa, ja luo sen avulla HighScore olioita. Tämä on tehty niin, että sovelluslogiikan on helpompi käyttää tietokantaa.


### Rakenteeseen jäänneet heikkoudet ###

Käyttöliittymä on koodattu kokonaan yhteen luokkaan Graphic. Sen olisi voinut jakaa useampaan luokkaan, jotta sen muokkaaminen ja korjaaminen olisi helpompaa. Graphic luokassa olevat oliot, kuten napit ja scenet olisi voinut nimetä hieman paremmin, koska tällä hetkellä on hieman vaikea seurata, mikä rakentuu ja missä vaiheessa.

Käyttöliittymä on toteutettu JavaFx;n avulla. Huomasin koodia kirjoittaessani, että java.awt olisi sopinut mavenin kanssa paremmin.



### Luokkakaavio ###
![Luokkakaavio SnakePeli](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/dokumentaatio/images/LuokkaKaavio.png)

### Sekvenssikaavioita ###

Pelin käynistäessä tapahtuu seuraavaa.

![Käynistys](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/dokumentaatio/images/New%20Game%20sekvenssi.png)

Peli on käynnissä, ja käärme on liikkumassa oletuksena alaspäin.
Käyttäjä antaa syötteen "right". Tapahtuu seuraavaa.

![Liiku oikealle](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/dokumentaatio/images/LiikkuuOikealleSekvenssi.png)

