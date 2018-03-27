package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate kassa;

    @Before
    public void setU() {
        kassa = new Kassapaate();
    }

    @Test
    public void kassassaAlussa() {
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestik() {
        int rahat = kassa.syoEdullisesti(10000);
        assertEquals(rahat, 10000 - 240);
        assertEquals(kassa.kassassaRahaa(), 100000 + 240);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 1);

    }

    @Test
    public void syoMaukkaastik() {
        int rahat = kassa.syoMaukkaasti(10000);
        assertEquals(rahat, 10000 - 400);
        assertEquals(kassa.kassassaRahaa(), 100000 + 400);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);

    }

    @Test
    public void syoMaukaastiEiRahaa() {
        int rahat = kassa.syoMaukkaasti(200);
        assertEquals(rahat, 200);
        assertEquals(kassa.kassassaRahaa(), 100000);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 0);
    }

    @Test
    public void syoEdullisestiEiRahaa() {
        int rahat = kassa.syoEdullisesti(200);
        assertEquals(rahat, 200);
        assertEquals(kassa.kassassaRahaa(), 100000);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 0);
    }

    @Test
    public void syoEdullisestiKortilla() {
        assertTrue(kassa.syoEdullisesti(new Maksukortti(400)));
        assertEquals(kassa.edullisiaLounaitaMyyty(), 1);
        assertEquals(kassa.kassassaRahaa(), 100000);

    }

    @Test
    public void syoEdullisestiKortillaEiRahaa() {
        assertFalse(kassa.syoEdullisesti(new Maksukortti(200)));
        assertEquals(kassa.edullisiaLounaitaMyyty(), 0);
        assertEquals(kassa.kassassaRahaa(), 100000);
    }

    @Test
    public void syoMaukkaastiKortilla() {
        assertTrue(kassa.syoMaukkaasti(new Maksukortti(600)));
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);
        assertEquals(kassa.kassassaRahaa(), 100000);

    }

    @Test
    public void syoMaukkaastiKortillaEiRahaa() {
        assertFalse(kassa.syoMaukkaasti(new Maksukortti(200)));
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 0);
        assertEquals(kassa.kassassaRahaa(), 100000);
    }
    @Test
    public void kortilleLadataanRahaa() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(kassa.kassassaRahaa(), 100500);
        assertEquals(kortti.saldo(), 1000);
    }
    @Test 
    public void kortilleLadataanNegatiivistaRahaa() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(kassa.kassassaRahaa(), 100000);
        assertEquals(kortti.saldo(), 500);
    }
}
