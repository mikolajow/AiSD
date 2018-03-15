import java.util.ArrayList;

public class quickSorrt {
	
	private ArrayList<Integer> lista;
	
	public quickSorrt( ArrayList<Integer> lista1 ) {
		this.lista = lista1;
	}//konstruktor domyœlny nic nie ustawia, wersja ma byæ podana w wywo³aniu metody
	
	public ArrayList<Integer> getLista(){ return lista; }
	
	/*
	public void sortuj ( int numerWersji ) {
		switch (numerWersji) {
		case 1:
			pivotOstatni();
			break;
		case 2:
			pivotLosowy();
			break;
		default:
			pivotMediana();
			break;
		}//konice switch
	}//koniec sortuj
	
	*/
	
	public int partycjonuj( int indexPoczatkowy, int indexKoncowy, int pivot ) {
		pivot  = lista.get(indexKoncowy);
		while ( indexPoczatkowy < indexKoncowy ) {
			while ( lista.get(indexPoczatkowy) <= pivot ) {			//nie interesuj¹ mnie elementy równe pivotowi bo chce je po lewej stronie pivota
				indexPoczatkowy++;
			}//koniec while
			while (lista.get(indexKoncowy) > pivot ) {
				indexKoncowy--;
			}//koniec while
			if ( indexPoczatkowy < indexKoncowy ) {
				System.out.println( "index poczatkowy = " + indexPoczatkowy + " index koncowy = " + indexKoncowy);
				int czajnik = lista.get(indexPoczatkowy);
				lista.remove(indexPoczatkowy);
				lista.add(indexPoczatkowy, lista.get(indexKoncowy - 1));		//bo indexy sie poprzesówa³y o 1 -_-
				lista.remove(indexKoncowy);
				lista.add(indexKoncowy, czajnik);
				indexPoczatkowy++;												//te elementy sa juz na odpowiednich miejscach
				indexKoncowy--;													//niezbedna zmiana wartosci indexów w przypadku gdy trafimy na wartosc rowna pivotowi
				for ( Integer i : lista ) {
					System.out.print(i + ",");
				} 
				System.out.println(" ");
			}//koniec if
		}//koniec zwenetrznego while
		System.out.println("Index koncowy = " + (indexPoczatkowy-1) );
		return indexPoczatkowy - 1;		//bo w ostatnim if zosta³ zwiêkszony
	}//koniec partycjonuj
	
	
	
	private void pivotOstatni( int indexPoczatkowy, int indexKoncowy) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//koniec pivot ostatni
	
	
	
	
	
	
	
	
	
	
}//koniec klasy






























