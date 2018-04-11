import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
		
		//dodajemy na poczatku pierwszy przedzia³
		//¿eby zadzia³a³a pêtla
        stos stack = new stos();
        stack.push(0);
        stack.push(indexKoncowy);

        while(!stack.isEmpty()){
        	
        	
            int koniec = stack.pop();
            int poczatek = stack.pop();
            
    		int IndexPivota = wyznaczIndexPivota(poczatek , koniec , wersja);
            
    		//pomijamy przypadek gdy pivot porównuje sie z samym sob¹
            if( koniec <= poczatek ){
                continue;
            }
    		
            
            int granica = partycjonuj(poczatek, koniec, IndexPivota);
            
            //dodajemy nowy przedzia³y na stos
            stack.push(granica + 1);
            stack.push(koniec);

            stack.push(poczatek);
            stack.push( granica -1 );
            
        }//koniec while
        
	}//koniec sortuj

	
	
	
	
	public int partycjonuj(int indexPoczatkowy, int indexKoncowy, int IndexPivota) {
		
		int pivot = lista.get(IndexPivota);
		
		//ustawiam pivot na koncu  listy
		//bo w zale¿noœci od "wersji" mo¿e byc w ró¿nych miejscach
		Collections.swap(lista, indexKoncowy, IndexPivota);
		
		int indexLewy =indexPoczatkowy;
		int indexPrawy = indexKoncowy - 1;
		 
		while(indexLewy <= indexPrawy) {
			
			while( indexLewy < lista.size() && lista.get(indexLewy) <= pivot ) {
				indexLewy++;}
			while(	lista.get(indexPrawy) > pivot ) {
			 	indexPrawy--;}
		 
			if( indexLewy < indexPrawy ) {
				Collections.swap(lista, indexLewy,indexPrawy);
			}//koniec if
			
		}//koniec while
		
		int index=indexPoczatkowy;
		
		while ( lista.get(index) <= pivot && index < indexKoncowy) {
			index++;
		}
		Collections.swap(lista,index, indexKoncowy);
		return index;
		
	}//koniec partycjinuj

	
	private int wyznaczIndexPivota( int indexPoczatkowy, int indexKoncowy, int wersja ) {
		
		int pivot;
		//miejsce na wyznaczanie pivota
		//wybranie wersji
		
		switch (wersja) {
		case 1:
			 pivot  = indexKoncowy;
			break;
		case 2:
			int index1 = ThreadLocalRandom.current().nextInt(indexPoczatkowy, indexKoncowy + 1) ;
			if ( index1 > indexPoczatkowy && index1 < indexKoncowy )
				pivot  = index1;
			else pivot  = indexKoncowy;
			break;
		default :
			int index = (lista.get(indexPoczatkowy) + lista.get(indexKoncowy) + lista.get((indexPoczatkowy + indexKoncowy)/2))/3;
			if ( index > indexPoczatkowy && index < indexKoncowy )
				pivot  = index;
			else pivot  = indexKoncowy;
			break;
		}
		//koniec ustalania wersji	
		
		return pivot;
	}//koniec metody wyznacz pivot
	
	
	
}//koniec klasy

















