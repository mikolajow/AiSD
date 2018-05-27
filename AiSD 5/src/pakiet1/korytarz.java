package pakiet1;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class korytarz {
	
	private int[] ustawienie;
	private int drogaDoPokonania;
	private int[][] macierz;
	private int wspolczynnikKolonowania;
	
	public korytarz(int liczbaSzaf, int[][] macie) {
		ustawienie = new int[liczbaSzaf];
		ArrayList<Integer> lista = new ArrayList<>();
		this.macierz = macie;
		
		for ( int i = 1; i <= liczbaSzaf; i++ ) {
			lista.add(i);
		}//koniec for
		
		int index = 0;
		
		for ( int i = 0; i < ustawienie.length; i++ ) {
			
			if ( lista.size() != 1 ) {
				index = ThreadLocalRandom.current().nextInt(0, lista.size());
			}else { index = 0; }
			
			ustawienie[i] = lista.get(index);
			lista.remove(index);
		}//koniec for
		
		this.drogaDoPokonania = liczDroge();
		
	}//koniec konstruktora
	
	private korytarz( korytarz k ) {
		this.ustawienie = new int[k.getUstawienie().length];
		for ( int i = 0; i < k.getUstawienie().length; i++ ) {
			this.ustawienie[i] = k.getUstawienie()[i];
		}//koniec for - wypelniam ustawienie nowego obiektu
		
		this.macierz = k.getMacierz();
		this.drogaDoPokonania = liczDroge();
		this.wspolczynnikKolonowania = 0;
	}//koniec kopiujacego
	
	private int liczDroge() {
		int droga = 0;
		int indexPierwszego =0;
		int indexDrugiego = 0;
		
		for ( int i = 1; i < macierz.length; i++ ) {
			for ( int j = 1; j < macierz.length; j++ ) {
				
				//i jest tez numerem pierwszego pokoju j numerem drugiego
				for ( int licznik = 0; licznik < ustawienie.length; licznik++ ) {
					if( ustawienie[licznik] == i ) {
						indexPierwszego = licznik;
					}//koniec if
					if( ustawienie[licznik] == j ) {
						indexDrugiego = licznik;
					}//koniec if
				}//koniec for
				
				droga = droga + Math.abs(indexPierwszego - indexDrugiego)*macierz[i][j];
				
			}//koniec for
		}//koniec for
		return droga/2;
	}//koniec licz droge
	
	public int wyznaczWspolczynnikKlonowania(double srednia) {
		srednia = Math.floor(srednia);
		this.wspolczynnikKolonowania = (int)srednia/drogaDoPokonania;
		return wspolczynnikKolonowania;
	}//koniec wyznaczania wspolczynnika
	
	public korytarz mutuj( ) {
		korytarz mutant = new korytarz(this);
		
		int indexPierwszego = ThreadLocalRandom.current().nextInt(0, mutant.getUstawienie().length);
		int indexDrugiego = 0;
		
		do {
		indexDrugiego = ThreadLocalRandom.current().nextInt(0,mutant.getUstawienie().length);
		}while(indexDrugiego == indexPierwszego);
		
		int czajnik = mutant.getUstawienie()[indexPierwszego];
		mutant.getUstawienie()[indexPierwszego] = mutant.getUstawienie()[indexDrugiego];
		mutant.getUstawienie()[indexDrugiego] = czajnik;
		
		return mutant;
	}//koniec mutuj
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int[] getUstawienie() {
		return ustawienie;
	}

	public void setUstawienie(int[] ustawienie) {
		this.ustawienie = ustawienie;
	}


	public int getDrogaDoPokonania() {
		return drogaDoPokonania;
	}


	public void setDrogaDoPokonania(int drogaDoPokonania) {
		this.drogaDoPokonania = drogaDoPokonania;
	}


	public int[][] getMacierz() {
		return macierz;
	}


	public void setMacierz(int[][] macierz) {
		this.macierz = macierz;
	}

	public int getWspolczynnikKolonowania() {
		return wspolczynnikKolonowania;
	}

	public void setWspolczynnikKolonowania(int wspolczynnikKolonowania) {
		this.wspolczynnikKolonowania = wspolczynnikKolonowania;
	}
	
	
	
	
}//koniec klasy






























