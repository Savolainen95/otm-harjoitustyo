package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void lataaRahaaOikein() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }

    @Test
    public void otetaanRahaaOnSaldoa() {
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0", kortti.toString());
    }

    @Test
    public void otetaanRahaaEiSaldoa() {
        kortti.otaRahaa(20);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    @Test
    public void rahatRiitti() {
        assertTrue(kortti.otaRahaa(5));
        assertFalse(kortti.otaRahaa(10));
    }
    
    

}
