package com.example.efkanicc;
import java.util.*;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path = "/ogrenci")
public class ogrenci {
	private static List<Ogrenci> ogrenciListesi = new ArrayList<>();
	static {
		ogrenciListesi.add(new Ogrenci("Ali",25));
	}
	// ---------------------------------------
	private static class Ogrenci {
		private String isim;
		private int numara;
		public Ogrenci(String isim, int numara) {
			this.isim = isim;
			this.numara = numara;
		}
		@SuppressWarnings("unused")
		public String getIsim() { return isim; }
		@SuppressWarnings("unused")
		public int getNumara() { return numara; }
	}
	// ---------------------------------------
    @RequestMapping(path="/listele", method = RequestMethod.GET)
    public List<Ogrenci> listele() {
        return ogrenciListesi;
    }
    @RequestMapping(path="/ekle", method = RequestMethod.POST)
    public Ogrenci ekle(@RequestBody Ogrenci ogrenci) {
		ogrenciListesi.add(ogrenci);
        return ogrenci;
    }
}
