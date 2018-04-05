import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class quickSort {
	
	private ArrayList<Integer> lista;
	
	public quickSort(File plik) {
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
	}//koniec konstruktora
	
	
	public quickSort( ArrayList<Integer> lista1 ) {
		this.lista = lista1;
	}//konstruktor kopiujacy
	
	
	public ArrayList<Integer> getLista(){ return lista; }
	
	
	
	public void sortuj( int indexPoczatkowy, int indexKoncowy, int wersja) {
		
		int pivot;
		
		//miejsce na wyznaczanie pivota
		//wybranie wersji
		
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
		//koniec ustalania wersji
		
		
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
		//koniec partycjonowania
		
        if (indexPoczatkowy < j) {					//wywo�uje metode rekurencyjnie dla aktualnych i,j
            sortuj(indexPoczatkowy, j, wersja);	
        }
        if (i < indexKoncowy) {
            sortuj(i, indexKoncowy, wersja);
        }
	}//koniec sortuj
	
	
	
	
	
	
	
	
	
	
	
	
}//koniec klasy

















