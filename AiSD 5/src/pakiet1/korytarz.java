package pakiet1;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class korytarz {
	
	private int[] ustawienie;
	private int drogaDoPokonania;
	
	
	public korytarz(int liczbaSzaf) {
		ustawienie = new int[liczbaSzaf];
		ArrayList<Integer> lista = new ArrayList<>();
		
		for ( int i = 0; i < liczbaSzaf; i++ ) {
			lista.add(i);
		}//koniec for
		
		int index = 0;
		
		for ( int i = 0; i < ustawienie.length; i++ ) {
			
			if ( lista.size() != 1 ) {
				index = ThreadLocalRandom.current().nextInt(0, lista.size() -1);
			}else { index = 0; }
			
			ustawienie[i] = lista.get(index);
			lista.remove(index);
		}//koniec for
		
		this.drogaDoPokonania = liczDroge();
		
	}//koniec konstruktora
	
	
	private int liczDroge() {
		int droga = 0;
		
		
		
		return droga;
	}//koniec licz droge
	
	
	

	public int[] getUstawienie() {
		return ustawienie;
	}

	public void setUstawienie(int[] ustawienie) {
		this.ustawienie = ustawienie;
	}
	
	
	
	
}//koniec klasy






























