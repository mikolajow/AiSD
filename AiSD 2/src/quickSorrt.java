import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


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
	}//konstruktor domyœlny nic nie ustawia, wersja ma byæ podana w wywo³aniu metody
	
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
			while ( lista.get(i) < pivot ) {			//partycjonowanie, szukam elementu wiekszego lub równego pivotovi
				i++;
			}//koniec while
			while (lista.get(j) > pivot ) {				//tu szukam elementu mniejszego lub równego pivotovi z drugiej strony list
				j--;									//elementy równe pivotowi mog¹ sie znalezc z dowolnej strony od pivota
			}//koniec while								//bo w kolejnych etapach i tak przez partycjonowanie wyl¹duj¹ obok niego
			if ( i <= j  ) {
				
				int czajnik = lista.get(i);				//jak znajde takie dwa elementy to przesówam je
				lista.remove(i);
				lista.add(i, lista.get(j - 1));				//bo indexy sie poprzesówa³y o 1 -_-
				lista.remove(j);							//zamieniam miejscami
				lista.add(j, czajnik);
				
				i++;								//przechodze na nastepny index z obu stron 
				j--;

			}//koniec if
		}//koniec zwenetrznego while
		
        if (indexPoczatkowy < j) {				//wywo³uje metode rekurencyjnie dla aktualnych i,j
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


	public void histogram( int liczbaPrzedzialow ) {
		
		ArrayList<Integer> rozneWartosci = new ArrayList<>();
		
		for (Integer i : lista) {
			if( !rozneWartosci.contains(i) ) {
				rozneWartosci.add(i);						//dodaje do listy wszystkie wartosci wystepujace w liscie
			}//koniec if
		}//koniec for
		
		/*
		for (Integer i : rozneWartosci ) {
			System.out.print( i + ",");	
		}
		System.out.println(" ");
		*/
		
		int liczbaRoznychWartosci = rozneWartosci.size();	//zliczam ich ilosc
		int iloscRoznychWartosciWPrzedziale;				//do wyznaczenia idexów pierwszej i ostatniej wartosci w przedziale
		
		if ( liczbaRoznychWartosci % liczbaPrzedzialow == 0 ) {
			iloscRoznychWartosciWPrzedziale = liczbaRoznychWartosci/liczbaPrzedzialow -1 ;	//gdy podzielna bez reszty to w kazdym przedziale bedzie tyle samo roznych wartosci
		} else {
			iloscRoznychWartosciWPrzedziale = liczbaRoznychWartosci/liczbaPrzedzialow;	//w przeciwnym wypadku w ostatnim przedziale bedzie mniej roznych wartosci
		}//koniec else
		
		int index = 0;
		int counter=0;
		
		
		//dcdc
		
		while ( index < liczbaRoznychWartosci ) {
			if ( index + iloscRoznychWartosciWPrzedziale < liczbaRoznychWartosci  ) {
				System.out.printf( "%15s" , "<" + rozneWartosci.get(index) + "," + rozneWartosci.get(index + iloscRoznychWartosciWPrzedziale) + ">" + "\t");
				int wartPoczatkowa = rozneWartosci.get(index);
				int wartoscKoncowa = rozneWartosci.get(index + iloscRoznychWartosciWPrzedziale);
				
				for ( Integer i : lista ) {
					if ( i>=wartPoczatkowa && i<= wartoscKoncowa ) {
						System.out.print("#");
						counter++;
					}//koniec if
				}//koniec for
				
				index++;
				
			} else {
				System.out.printf( "%15s" , "<" + rozneWartosci.get(index) + "," + rozneWartosci.get( liczbaRoznychWartosci -1 ) + ">" + "\t");
				int wartPoczatkowa = rozneWartosci.get(index);
				int wartoscKoncowa = rozneWartosci.get( liczbaRoznychWartosci -1 );
				
				for ( Integer i : lista ) {
					if ( i>=wartPoczatkowa && i<= wartoscKoncowa ) {
						System.out.print("#");
						counter++;
					}//koniec if
				}//koniec for
				
				index++;
				
			}//koniec else
			
			System.out.print ("");
			System.out.println("");
			
			index = index + iloscRoznychWartosciWPrzedziale;
			
		}//koniec while
		
		System.out.println("counter = " + counter);
		
	}//koniec histogram
}//koniec klasy






























