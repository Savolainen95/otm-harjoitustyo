# Arkkitehtuuri kuvaus #
### Rakenne ###
Ohjelma on rakennettu kolmeen kerrokseen ja on jaettu pakkauksiin snakepeli.ui, snakepeli.domain ja snakepeli.dao.

snakepeli.ui käyttöliittymän, mikä on näkyvissä käyttäjälle.
snakeplei.domain sisältää ohjelman sovelluslogiikan.
snakepeli.dao sisältää tietokantoja vastaavan koodin.

### Käyttöliittymä ###

Käyttöliittymä sisältää neljä erillistä näkymää.

- Aloitus näkymä.
- Peli näkymä.
- Tallennus näkymä.
- Huippupiste näkymä.

Jokainen näkymä on toteutettu [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html) oliona, ja niistä voi olla vain yksi kerrallaan näkyvissä sijoitettuna [stageen](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html).
Käyttöliittymä on rakennettu luokkaan [snakepeli.ui.Graphic.java](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/SnakePeli/src/main/java/snakepeli/ui/Graphic.java)


### Luokkakaavio ###
![Luokkakaavio SnakePeli](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/dokumentaatio/images/LuokkaKaavio.png)

### Sekvenssikaavio oikealle kääntymisestä ###
Peli on käynnissä, ja käärme on liikkumassa oletuksena alaspäin.
Käyttäjä antaa syötteen "right". Tapahtuu seuraavaa.

![Liiku oikealle](https://github.com/Savolainen95/otm-harjoitustyo/blob/master/dokumentaatio/images/LiikkuuOikealleSekvenssi.png)

