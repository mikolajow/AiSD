package klasy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class quickSort {
	
	private ArrayList<Integer> lista;
	private int maxWyokoscStosu;
	private int liczbaZamian;
	private File plik;
	private String wersja;
	
	public String getWersja() {return wersja;}
	public void setWersja(String wersja) {this.wersja = wersja;}
	public File getPlik() {return plik;}
	public void setPlik(File plik) {this.plik = plik;}



	public quickSort(File plik) {
		this.plik = plik;
		this.maxWyokoscStosu = 0;
		this.liczbaZamian = 0;
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
	
	
	
	
	
	public void sortuj( int indexPoczatkowy, int indexKoncowy, int wersja) {
		
		//dodajemy na poczatku pierwszy przedziaï¿½
		//ï¿½eby zadziaï¿½aï¿½a pï¿½tla
        stos stack = new stos();
        stack.push(0);
        stack.push(indexKoncowy);
        
        setMaxWyokoscStosu(stack.size());
        
        while(!stack.isEmpty()){
        	
        	
            int koniec = stack.pop();
            int poczatek = stack.pop();
            
            
    		//pomijamy przypadek gdy pivot porównuje sie z samym sob¹
            if( koniec <= poczatek ){
                continue;
            }
            
            
    		int IndexPivota = wyznaczIndexPivota(poczatek , koniec , wersja);
            
            int granica = partycjonuj(poczatek, koniec, IndexPivota);
            
            //dodajemy nowy przedziaï¿½y na stos
            stack.push(granica + 1);
            stack.push(koniec);

            stack.push(poczatek);
            stack.push( granica -1 );
            
            if ( maxWyokoscStosu < stack.size() ) {
            	maxWyokoscStosu = stack.size();
            }
            
        }//koniec while
        
	}//koniec sortuj

	
	
	
	
	public int partycjonuj(int indexPoczatkowy, int indexKoncowy, int IndexPivota) {
		
		int pivot = lista.get(IndexPivota);
		
		//ustawiam pivot na koncu  listy
		//bo w bo w zaleznosci od wersji moze byc w roznym miejscu 
		
		Collections.swap(lista, indexKoncowy, IndexPivota);
		
		int indexLewy =indexPoczatkowy;
		int indexPrawy = indexKoncowy - 1;
		 
		while(indexLewy <= indexPrawy) {
			
			while( indexLewy < indexKoncowy && lista.get(indexLewy) <= pivot ) {
				indexLewy++;}
			while( indexPrawy >= indexPoczatkowy && lista.get(indexPrawy) > pivot ) {
			 	indexPrawy--;}
		 
			if( indexLewy < indexPrawy ) {
				Collections.swap(lista, indexLewy,indexPrawy);
				InkrementujLiczbeZamian();
			}//koniec if
			
		}//koniec while
		
		int index=indexPoczatkowy;
		
		while ( lista.get(index) <= pivot && index < indexKoncowy) {
			index++;
		}
		Collections.swap(lista,index, indexKoncowy);
		InkrementujLiczbeZamian();
		return index;
		
	}//koniec partycjinuj

	
	private int wyznaczIndexPivota( int indexPoczatkowy, int indexKoncowy, int wersja ) {
		
		int pivot;
		//miejsce na wyznaczanie pivota
		//wybranie wersji
		
		switch (wersja) {
		case 1:
			 pivot  = indexKoncowy;
			 this.wersja = "koncowy element";
			break;
		case 2:
			int index1 = ThreadLocalRandom.current().nextInt(indexPoczatkowy, indexKoncowy + 1) ;
			if ( index1 > indexPoczatkowy && index1 < indexKoncowy ) {
				pivot  = index1;
			} else {pivot  = indexKoncowy;}
			this.wersja = "random element";
			break;
		default :
			if (  Math.abs(indexPoczatkowy - indexKoncowy) >= 2 )//minimum 3 elementy np o indexach 0,1,2 lub 6,7,8
				pivot  = IndexMediany(indexPoczatkowy, indexKoncowy);
			else pivot  = indexKoncowy;
			this.wersja = "mediana";
			break;
		}//koniec ustalania wersji	
		
		return pivot;
	}//koniec metody wyznacz pivot
	
	
	private int IndexMediany(int indexPoczatkowy, int indexKoncowy) {
		int index = 0;
		ArrayList<Integer> tab = new ArrayList<>();
		tab.add(lista.get(indexPoczatkowy));
		tab.add(lista.get(indexKoncowy));
		tab.add(lista.get(  (indexPoczatkowy + indexKoncowy)/2 )); //element ze srodka
		Collections.sort(tab);
		
		int szukanaWartoscMediany = tab.get(1);
		
		if ( lista.get(indexPoczatkowy) == szukanaWartoscMediany ) {
			index = indexPoczatkowy;
		}else if ( lista.get(indexKoncowy) == szukanaWartoscMediany ) {
			index = indexKoncowy;
		} else {
			index = (indexPoczatkowy + indexKoncowy)/2;
		}
		return index;
	}//koniec element ze srodka
	
	//metoda inkrementujÄ…ca liczbe zmian
	public void InkrementujLiczbeZamian() {
		this.liczbaZamian++;
	}//koniec inkrementowania zmian
	
	
	public int getMaxWyokoscStosu() { return maxWyokoscStosu; }
	public int getLiczbaZamian() { return liczbaZamian; }
	public ArrayList<Integer> getLista(){ return lista; }
	
	public void setMaxWyokoscStosu(int maxWyokoscStosu) { this.maxWyokoscStosu = maxWyokoscStosu; }
	public void setLiczbaZamian(int liczbaZamian) { this.liczbaZamian = liczbaZamian; }
	public void setLista(ArrayList<Integer> lista) { this.lista = lista; }
	
}//koniec klasy

















