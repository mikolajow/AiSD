import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;


public class quickSorrt {
	
	private ArrayList<Integer> lista;
	
	public quickSorrt(File plik) {
		this.lista = new ArrayList<>();
		try( BufferedReader czytnik = new BufferedReader(new FileReader(plik))){
			while(true) {
				String[] tablica;
				tablica = czytnik.readLine().split(",");
				for ( String s : tablica ) {
					lista.add(Integer.parseInt(s));
				}//koniec for
			}//koniec while
		} catch (Exception e) {
			// TODO: handle exception
		//	e.printStackTrace();
		}//koniec catch
	}
	
	
	public quickSorrt( ArrayList<Integer> lista1 ) {
		this.lista = lista1;
	}//konstruktor domy�lny nic nie ustawia, wersja ma by� podana w wywo�aniu metody
	
	public ArrayList<Integer> getLista(){ return lista; }
	
	
	public void sortuj( int indexPoczatkowy, int indexKoncowy, int wersja) {
		
		int pivot;
		
		//miejsce na wyznaczanie pivota
		
		switch (wersja) {
		case 1:
			 pivot  = lista.get(indexKoncowy);
			break;
		case 2:
			int index1 = ThreadLocalRandom.current().nextInt(indexPoczatkowy, indexKoncowy + 1) ;
			if ( index1 > indexPoczatkowy && index1 < indexKoncowy )
				pivot  = lista.get(index1);
			else pivot  = lista.get(indexKoncowy);
			break;
		default :
			int index = (lista.get(indexPoczatkowy) + lista.get(indexKoncowy) + lista.get((indexPoczatkowy + indexKoncowy)/2 ))/3;
			if ( index > indexPoczatkowy && index < indexKoncowy )
				pivot  = lista.get(index);
			else pivot  = lista.get(indexKoncowy);
			break;
		}
		
		//partycjonowanie:
		
        int i = indexPoczatkowy;
        int j = indexKoncowy;
		
		while ( i <= j ) {
			while ( lista.get(i) < pivot ) {			//partycjonowanie, szukam elementu wiekszego lub r�wnego pivotovi
				i++;
			}//koniec while
			while (lista.get(j) > pivot ) {				//tu szukam elementu mniejszego lub r�wnego pivotovi z drugiej strony list
				j--;									//elementy r�wne pivotowi mog� sie znalezc z dowolnej strony od pivota
			}//koniec while								//bo w kolejnych etapach i tak przez partycjonowanie wyl�duj� obok niego
			if ( i <= j  ) {
				
				int czajnik = lista.get(i);				//jak znajde takie dwa elementy to przes�wam je
				lista.remove(i);
				lista.add(i, lista.get(j - 1));				//bo indexy sie poprzes�wa�y o 1 -_-
				lista.remove(j);							//zamieniam miejscami
				lista.add(j, czajnik);
				
				i++;								//przechodze na nastepny index z obu stron 
				j--;

			}//koniec if
		}//koniec zwenetrznego while
		
        if (indexPoczatkowy < j) {				//wywo�uje metode rekurencyjnie dla aktualnych i,j
            sortuj(indexPoczatkowy, j, wersja);	
        }
        if (i < indexKoncowy) {
            sortuj(i, indexKoncowy, wersja);
        }
	}//koniec sortuj
	
	public double Mediana() {
		if ( lista.size()%2 == 1 ) {
			return lista.get(lista.size()/2 );
		} else {
			return (double) ( lista.get( lista.size()/2 -1 ) + lista.get( lista.size()/2 ) ) /2;
		}
	}//koniec mediana


	// HISTOGRAM -----------------------------------------------------------------------------
	
	
	public void histogram( int liczbaPrzedzialow ) {
		
		ArrayList<Integer> rozneWartosci = new ArrayList<>();
		
		for (Integer i : lista) {
			if( !rozneWartosci.contains(i) ) {
				rozneWartosci.add(i);						//dodaje do listy wszystkie wartosci wystepujace w liscie
			}//koniec if
		}//koniec for
		
		
		int liczbaRoznychWartosci = rozneWartosci.size();	//zliczam ich ilosc
		int iloscRoznychWartosciWPrzedziale;				//do wyznaczenia idex�w pierwszej i ostatniej wartosci w przedziale
		
		if ( liczbaRoznychWartosci % liczbaPrzedzialow == 0 ) {
			iloscRoznychWartosciWPrzedziale = liczbaRoznychWartosci/liczbaPrzedzialow -1 ;	//gdy podzielna bez reszty to w kazdym przedziale bedzie tyle samo roznych wartosci
		} else {
			iloscRoznychWartosciWPrzedziale = liczbaRoznychWartosci/liczbaPrzedzialow;	//w przeciwnym wypadku w ostatnim przedziale bedzie mniej roznych wartosci
		}//koniec else
		
		int index = 0;
		int counter=0;
		
		boolean skalowane = false;
		
		int indexTabeli = -1;
		
		int[] tabela = new int[liczbaPrzedzialow];
		
		while ( index < liczbaRoznychWartosci ) {
			
			indexTabeli++;
			
			int liczbaZnakow = 0;
			
			
			if ( index + iloscRoznychWartosciWPrzedziale < liczbaRoznychWartosci  ) {
				System.out.printf( "%15s" , "<" + rozneWartosci.get(index) + "," + rozneWartosci.get(index + iloscRoznychWartosciWPrzedziale) + ">" + "\t");
				int wartPoczatkowa = rozneWartosci.get(index);
				int wartoscKoncowa = rozneWartosci.get(index + iloscRoznychWartosciWPrzedziale);
				
				for ( Integer i : lista ) {
					
					if ( i>=wartPoczatkowa && i<= wartoscKoncowa ) {
						System.out.print("#");
						liczbaZnakow++;
						counter++;
					}//koniec if
					
					if ( liczbaZnakow > 100 ) {
						skalowane = true;
					}//koniec if
					
				}//koniec for
				
				tabela[indexTabeli] = liczbaZnakow;
				
				index++;
				
			}//koniec if
			else {
				System.out.printf( "%15s" , "<" + rozneWartosci.get(index) + "," + rozneWartosci.get( liczbaRoznychWartosci -1 ) + ">" + "\t");
				int wartPoczatkowa = rozneWartosci.get(index);
				int wartoscKoncowa = rozneWartosci.get( liczbaRoznychWartosci -1 );
				
				for ( Integer i : lista ) {
					if ( i>=wartPoczatkowa && i<= wartoscKoncowa ) {
						System.out.print("#");
						liczbaZnakow++;
						counter++;
					}//koniec if
					
				}//koniec for
				
				tabela[indexTabeli] = liczbaZnakow;
				
				index++;
				
			}//koniec else
			
			System.out.print ("");
			System.out.println("");
			
			index = index + iloscRoznychWartosciWPrzedziale;
			
		}//koniec while
		
		System.out.println("counter = " + counter);
		
		for ( int i = 0; i < tabela.length; i++ ) {
			System.out.println( tabela[i]);
		}//koniec for
		
		if ( skalowane ) {
			histogtamSkalowany(liczbaPrzedzialow, tabela);
		}//koniec if
	}//koniec histogram

	
	
	
	
	
	
	
	
	
	
	
	
	

	private void histogtamSkalowany( int liczbaPrzedzialow, int[] tabela) {
		System.out.println("PRZESKALOWANY HISTOGRAM");
		ArrayList<Integer> rozneWartosci = new ArrayList<>();
		
		//SKALOWANIE TABLICY
		for ( int s = 0; s < tabela.length; s++ ) {
			tabela[s] = tabela[s]*30/100;
		}//koniec for
		
		for (Integer i : lista) {
			if( !rozneWartosci.contains(i) ) {
				rozneWartosci.add(i);						//dodaje do listy wszystkie wartosci wystepujace w liscie
			}//koniec if
		}//koniec for
		
		
		int liczbaRoznychWartosci = rozneWartosci.size();	//zliczam ich ilosc
		int iloscRoznychWartosciWPrzedziale;				//do wyznaczenia idex�w pierwszej i ostatniej wartosci w przedziale
		
		if ( liczbaRoznychWartosci % liczbaPrzedzialow == 0 ) {
			iloscRoznychWartosciWPrzedziale = liczbaRoznychWartosci/liczbaPrzedzialow -1 ;	//gdy podzielna bez reszty to w kazdym przedziale bedzie tyle samo roznych wartosci
		} else {
			iloscRoznychWartosciWPrzedziale = liczbaRoznychWartosci/liczbaPrzedzialow;	//w przeciwnym wypadku w ostatnim przedziale bedzie mniej roznych wartosci
		}//koniec else
		
		
		int index = 0;
				
		int indexTabeli = -1;
		
		while ( index < liczbaRoznychWartosci ) {
			
			indexTabeli++;
			
			if ( index + iloscRoznychWartosciWPrzedziale < liczbaRoznychWartosci  ) {
				System.out.printf( "%15s" , "<" + rozneWartosci.get(index) + "," + rozneWartosci.get(index + iloscRoznychWartosciWPrzedziale) + ">" + "\t");
				
				for ( int j = 0; j < tabela[indexTabeli]; j++) {
					System.out.print("#");
				}//koniec for
				
				
				index++;
				
			}//koniec if
			else {
				System.out.printf( "%15s" , "<" + rozneWartosci.get(index) + "," + rozneWartosci.get( liczbaRoznychWartosci -1 ) + ">" + "\t");
				
				for ( int j = 0; j < tabela[indexTabeli]; j++) {
					System.out.print("#");
				}//koniec for
				
				
				index++;
				
			}//koniec else
			
			System.out.print ("");
			System.out.println("");
			
			index = index + iloscRoznychWartosciWPrzedziale;
			
		}//koniec while
		
		
	}//koniec metody skalowany histogram
	
}//koniec klasy






























