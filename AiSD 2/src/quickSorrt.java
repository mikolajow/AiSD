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
		while ( true ) {
			while ( lista.get(indexPoczatkowy) < pivot ) {			//nie interesuj¹ mnie elementy równe pivotowi bo chce je po lewej stronie pivota
				indexPoczatkowy++;
			}//koniec while
			while (lista.get(indexKoncowy) > pivot ) {
				indexKoncowy--;
			}//koniec while
			if ( indexPoczatkowy < indexKoncowy ) {
				if ( lista.get(indexPoczatkowy) == lista.get(indexKoncowy) ) { indexPoczatkowy++; }	//jak sa takie same to przeskakuje z indexem do
																									//przodu zeby petla nie dzia³a³a w kó³ko
				
				//System.out.println( "index poczatkowy = " + indexPoczatkowy + " index koncowy = " + indexKoncowy);
				
				
				int czajnik = lista.get(indexPoczatkowy);
				lista.remove(indexPoczatkowy);
				lista.add(indexPoczatkowy, lista.get(indexKoncowy - 1));		//bo indexy sie poprzesówa³y o 1 -_-
				lista.remove(indexKoncowy);										//zamieniam miejscami
				lista.add(indexKoncowy, czajnik);
				
				
				
				/*
				for ( Integer i : lista ) {
					System.out.print(i + ",");
				} 
				System.out.println(" ");
				*/
				
			}//koniec if
			else {
				//System.out.println(indexKoncowy);
				return indexKoncowy;		
			}
		}//koniec zwenetrznego while
		
		
		//System.out.println("Index koncowy = " + (indexPoczatkowy-1) );
	}//koniec partycjonuj
	
	
	
	public void pivotOstatni( int indexPoczatkowy, int indexKoncowy) {
		
		int poczatekKolejnegoCyklu;
		
		if( indexPoczatkowy < indexKoncowy  ) {
			
			poczatekKolejnegoCyklu = partycjonuj(indexPoczatkowy, indexKoncowy, 9);		//chwilowo losowe 9  bo i tak zmieniam w partycjonowaniu
			pivotOstatni(indexPoczatkowy, poczatekKolejnegoCyklu -1 );
			pivotOstatni(poczatekKolejnegoCyklu + 1, indexKoncowy );
			
		}//konice if
		
		
		
}//koniec pivot ostatni
	
	
	
	
	
	
	
	
	
	
}//koniec klasy






























