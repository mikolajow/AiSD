 package pakiet_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Apostezjon {
	
	private HashMap<String, HashMap<String, Integer>> mapa;
	private String pocz;
	private ArrayList<trasa> wyniki;
	
	
	public Apostezjon() {
		this.wyniki = new ArrayList<>();
		this.mapa= new HashMap<>();
		wypelnij();
	}//koniec konstruktora
	
	
	public void szukajPolaczenia( String poczatek, String koniec ) {
		
		this.pocz = poczatek;
		szukaj(poczatek, koniec, new trasa("") );
		
		//sortuje wyniki
		Collections.sort(wyniki, new Comparator<trasa>() {

			@Override
			public int compare(trasa o1, trasa o2) {
				return o1.getDlugoscTrasy() - o2.getDlugoscTrasy();
			}//koniec compare
		});//koniec sortowania
		
		for ( trasa t : wyniki ) {
			System.out.print("trasa = ");
			for ( String s: t.getStacje() ) {
				System.out.printf( "%-14s", s  );
			}//koniec for
			System.out.println( "liczba przesiadek = " + t.getLiczbaPrzesiadek() + "\t" + "d³ugoœæ trasy = " + t.getDlugoscTrasy() );
		}//koniec for
		
	}//koniec szukaj po³¹czenia
	
	private void szukaj( String poczatek, String koniec, trasa trasa ) {
		
		trasa.getStacje().add(poczatek);
		
		if ( mapa.get(poczatek).get(koniec) != null ) {
			trasa.setDlugoscTrasy(trasa.getDlugoscTrasy() + mapa.get(poczatek).get(koniec) );
			trasa.getStacje().add(koniec);
			wyniki.add(trasa);
		}//koniec if
		
		
		else if ( trasa.getLiczbaPrzesiadek() < 2 ) {
			trasa.setLiczbaPrzesiadek(trasa.getLiczbaPrzesiadek() + 1);
			for (String s :mapa.get(poczatek).keySet()) {
				trasa nowa = new trasa(trasa);
				nowa.setDlugoscTrasy(nowa.getDlugoscTrasy() + mapa.get(poczatek).get(s) );
				if ( !s.equals(this.pocz) ) { szukaj(s, koniec, nowa); }
			}//koniec for
		}//koniec if else
			
	}//koniec szukaj
	
	
	
	
	
	
	
	
	private void wypelnij() {
		HashMap<String, Integer> 	polaczeniaZAngmar 		 = new HashMap<>();
		HashMap<String, Integer> 	polaczeniaZGondolin	 	 = new HashMap<>();
		HashMap<String, Integer> 	polaczeniaZIsengard	 	 = new HashMap<>();
		HashMap<String, Integer> 	polaczeniaZRivendell	 = new HashMap<>();
		HashMap<String, Integer> 	polaczeniaZBree		 	 = new HashMap<>();
		HashMap<String, Integer> 	polaczeniaZTrondheim 	 = new HashMap<>();
		HashMap<String, Integer> 	polaczeniaZLusitania	 = new HashMap<>();
		HashMap<String, Integer> 	polaczeniaZRoke	 		 = new HashMap<>();
		HashMap<String, Integer> 	polaczeniaZGont	 		 = new HashMap<>();
		HashMap<String, Integer> 	polaczeniaZAtuan	 	 = new HashMap<>();
		HashMap<String, Integer> 	polaczeniaZSelidor	 	 = new HashMap<>();
		HashMap<String, Integer> 	polaczeniaZHavnor		 = new HashMap<>();
		
		polaczeniaZAngmar.put("Gondolin", 581);
		polaczeniaZAngmar.put("Isengard", 218);
		polaczeniaZAngmar.put("Bree", 360);
		polaczeniaZAngmar.put("Rivendell", 186);
		
		polaczeniaZGondolin.put("Angmar", 581);
		polaczeniaZGondolin.put("Rivendell", 480);
		polaczeniaZGondolin.put("Bree", 279);
		polaczeniaZGondolin.put("Isengard", 357);
		
		polaczeniaZIsengard.put("Gondolin", 357);
		polaczeniaZIsengard.put("Angmar", 218);
		polaczeniaZIsengard.put("Rivendell", 312);
		polaczeniaZIsengard.put("Bree", 437);
		
		polaczeniaZRivendell.put("Angmar", 186);
		polaczeniaZRivendell.put("Gondolin", 480);
		polaczeniaZRivendell.put("Isengard", 312);
		polaczeniaZRivendell.put("Bree", 525);
		polaczeniaZRivendell.put("Trondheim", 842);
		polaczeniaZRivendell.put("Lusitania", 790);
		polaczeniaZRivendell.put("Roke", 1024);
		polaczeniaZRivendell.put("Gont", 996);
		
		polaczeniaZBree.put("Angmar", 360);
		polaczeniaZBree.put("Gondolin", 279);
		polaczeniaZBree.put("Isengard", 437);
		polaczeniaZBree.put("Rivendell", 525);
		polaczeniaZBree.put("Trondheim", 638);
		polaczeniaZBree.put("Lusitania", 630);
		polaczeniaZBree.put("Roke", 1140);
		polaczeniaZBree.put("Gont", 1210);
		
		polaczeniaZTrondheim.put("Rivendell", 842);
		polaczeniaZTrondheim.put("Bree", 638);
		polaczeniaZTrondheim.put("Roke", 876);
		polaczeniaZTrondheim.put("Gont", 615);
		polaczeniaZTrondheim.put("Lusitania", 820);
		
		polaczeniaZLusitania.put("Rivendell", 790);
		polaczeniaZLusitania.put("Bree", 630);
		polaczeniaZLusitania.put("Trondheim", 820);
		polaczeniaZLusitania.put("Roke", 726);
		polaczeniaZLusitania.put("Gont", 750);
		
		polaczeniaZRoke.put("Atuan", 512);
		polaczeniaZRoke.put("Selidor", 410);
		polaczeniaZRoke.put("Havnor", 337);
		polaczeniaZRoke.put("Gont", 375);
		polaczeniaZRoke.put("Trondheim", 876);
		polaczeniaZRoke.put("Lusitania", 726);
		polaczeniaZRoke.put("Rivendell", 1024);
		polaczeniaZRoke.put("Bree", 1140);
		
		polaczeniaZGont.put("Roke", 375);
		polaczeniaZGont.put("Atuan", 685);
		polaczeniaZGont.put("Selidor", 560);
		polaczeniaZGont.put("Havnor", 484);
		polaczeniaZGont.put("Lusitania", 750);
		polaczeniaZGont.put("Trondheim", 615);
		polaczeniaZGont.put("Bree", 1210);
		polaczeniaZGont.put("Rivendell", 996);
		
		polaczeniaZAtuan.put("Roke", 512);
		polaczeniaZAtuan.put("Selidor", 604);
		polaczeniaZAtuan.put("Havnor", 607);
		polaczeniaZAtuan.put("Gont", 685);
		
		polaczeniaZSelidor.put("Roke", 410);
		polaczeniaZSelidor.put("Atuan", 604);
		polaczeniaZSelidor.put("Havnor", 350);
		polaczeniaZSelidor.put("Gont", 560);
		
		polaczeniaZHavnor.put("Roke", 337);
		polaczeniaZHavnor.put("Atuan", 607);
		polaczeniaZHavnor.put("Selidor", 350);
		polaczeniaZHavnor.put("Gont", 484);
		
		
		mapa.put("Angmar", polaczeniaZAngmar);
		mapa.put("Gondolin", polaczeniaZGondolin);
		mapa.put("Isengard", polaczeniaZIsengard);
		mapa.put("Rivendell", polaczeniaZRivendell);
		mapa.put("Bree", polaczeniaZBree);
		
		mapa.put("Trondheim", polaczeniaZTrondheim);
		mapa.put("Lusitania", polaczeniaZLusitania);
		
		mapa.put("Roke", polaczeniaZRoke);
		mapa.put("Atuan", polaczeniaZAtuan);
		mapa.put("Selidor", polaczeniaZSelidor);
		mapa.put("Havnor", polaczeniaZHavnor);
		mapa.put("Gont", polaczeniaZGont);
	}//koniec wypelnij
	
	public HashMap<String, HashMap<String, Integer>> getMapa() {
		return mapa;
	}//getter
	
}//koniec klasy


/* MIASTA:

Angmar
Gondolin
Isengard
Rivendell
Bree

Trondheim
Lusitania

Roke
Atuan
Selidor
Havnor
Gont

*/

















