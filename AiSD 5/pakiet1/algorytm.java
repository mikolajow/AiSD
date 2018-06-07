package pakiet1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class algorytm {
	
	private int liczbaSzaf;
	private int[][] macierz;
	private int wielkoscPopulacji;
	private ArrayList<korytarz> populacja;
	private ArrayList<korytarz> nowaPopulacja;
	private double sredniaDrogaPopulacji;
	
	public algorytm( String nazwaPliku , int wielkoscPopulacji ) {
		
		try( BufferedReader scaner = new BufferedReader( new FileReader( new File(nazwaPliku))) ){
			String[] linia = scaner.readLine().split(",");
			int wielkosc = linia.length;
			macierz = new int[wielkosc + 1][wielkosc + 1];
			
	        for (int i = 0; i < macierz.length; i++) {
	        	macierz[i][0] = i;
	        	macierz[0][i] = i;
	        }// wypelniam pierwszy wiersz i kolumne numerami pokojow od 1 do n, 1=a
			
	        for( int j=0; j < linia.length; j++ ) {
	        	if ( linia[j].equals("x") || linia[j].equals("X") ) {
	        		macierz[1][j+1] = 0;
	        	}//koniec if
	        	else {
	        		macierz[1][j+1] = Integer.parseInt(linia[j]);
	        	}//koniec else
	        }// wypelniam pierwszya wczesniej zaczytana linie
			
	        int i = 2;
	        while ( true ) {
	        	linia = scaner.readLine().split(",");
	        	
		        for( int j = 0; j < linia.length; j++ ) {
		        	if ( linia[j].equals("x") || linia[j].equals("X")  ) {
		        		macierz[i][j+1] = 0;
		        	}//koniec if
		        	else {
		        		macierz[i][j+1] = Integer.parseInt(linia[j]);
		        	}//koniec else
		        }//koniec for
	        	i++;
	        }//koniec while
		}catch (Exception e) {
			//System.out.println("Problem");
			//e.printStackTrace();
		}// koniec catch
		
        this.liczbaSzaf = macierz.length - 1;
        populacja = new ArrayList<>();
        nowaPopulacja = new ArrayList<>();
        
        //losuje losowa populacje na starcie
        for( int i = 0; i < wielkoscPopulacji; i++ ) {
        	populacja.add(new korytarz(this.liczbaSzaf, this.macierz ));
        }//koniec for
		this.wielkoscPopulacji = wielkoscPopulacji;
	}//koniec konstruktora
	
	
	public void liczSredniaDrogeDlaPopulacji() {
		double srednia = 0;
		
		for ( korytarz k : populacja ) {
			srednia = srednia + k.getDrogaDoPokonania();
		}//koniec for
		
		this.sredniaDrogaPopulacji = srednia/populacja.size();
	}//koniec sredniej drogi
	
	
	
	public void generujNowaPopulacje(int ileRazy){		
		for(int i = 0; i < ileRazy; i++) {
			
			liczSredniaDrogeDlaPopulacji();
			
			for (korytarz k : populacja) {
				k.wyznaczWspolczynnikKlonowania(sredniaDrogaPopulacji);
			}//koniec for
			
			//sortujemy aktualna populacje po wspó³czynniku klonowania
			Collections.sort(populacja, new Comparator<korytarz>() {
				@Override
				public int compare(korytarz o1, korytarz o2) {
					return o2.getWspolczynnikKolonowania() - o1.getWspolczynnikKolonowania();
				}
			});;
			
			int j = 0 ;
			
			//WYNIKIEM WHILA MOZE BYC ZA DUZOO W POPULACJI TRZEBA BEDZIE OSTATNIE DODANE USUNAC!!!!
			while( j < populacja.size() && nowaPopulacja.size() <= wielkoscPopulacji ) {
				korytarz aktualny = populacja.get(j);
				int IleKlonow = aktualny.getWspolczynnikKolonowania();
				for (int g = 0; g < IleKlonow; g++) {
					korytarz mutant = aktualny.mutuj();
					if(mutant.getDrogaDoPokonania() <= aktualny.getDrogaDoPokonania()) {
						nowaPopulacja.add(mutant);
					}//koniec if
				}//koniec for
				nowaPopulacja.add(aktualny);
				j++;
			}//koniec while - dodalem wszystkie kolny
			
			Collections.sort(populacja, new Comparator<korytarz>() {
				@Override
				public int compare(korytarz o1, korytarz o2) {
					// TODO Auto-generated method stub
					return o1.getDrogaDoPokonania() - o2.getDrogaDoPokonania();
				}//koniec obiektu comparator
			});;
			
			while (nowaPopulacja.size() > wielkoscPopulacji) {
				nowaPopulacja.remove(nowaPopulacja.size()-1);
			}//koniec while - usówanie nadmiaru osobnikow
			
			this.populacja = nowaPopulacja;
			this.nowaPopulacja = new ArrayList<korytarz>();
		}//koniec for - ile razy mamy generowac nowa populacje
		
		//po wygenerowaniu populacji sortujemy tak aby najlepsze rozwiazanie bylo pierwsze
		Collections.sort(populacja, new Comparator<korytarz>() {
			@Override
			public int compare(korytarz o1, korytarz o2) {
				// TODO Auto-generated method stub
				return o1.getDrogaDoPokonania() - o2.getDrogaDoPokonania();
			}//koniec obiektu comparator
		});;
		
	}//koniec generowania nowej populacji
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int[][] getMacierz() {
		return macierz;
	}
	public void setMacierz(int[][] macierz) {
		this.macierz = macierz;
	}
	public int getLiczbaSzaf() {
		return liczbaSzaf;
	}
	public void setLiczbaSzaf(int liczbaSzaf) {
		this.liczbaSzaf = liczbaSzaf;
	}
	public ArrayList<korytarz> getPopulacja() {
		return populacja;
	}
	public void setPopulacja(ArrayList<korytarz> populacja) {
		this.populacja = populacja;
	}
	public ArrayList<korytarz> getNowaPopulacja() {
		return nowaPopulacja;
	}
	public void setNowaPopulacja(ArrayList<korytarz> nowaPopulacja) {
		this.nowaPopulacja = nowaPopulacja;
	}
	
}//koniec klasy

























