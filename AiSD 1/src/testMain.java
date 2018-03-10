import java.io.File;
import java.util.Collections;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File plik = new File("z1data1.csv");
		
		posortowanaLista nowa = new posortowanaLista(plik);
		
		System.out.println(" ");
		
		System.out.print( "Nieposortowana lista 1:: " );
		for ( Integer i : nowa.getLista() ) {
			System.out.print(i + " " );
		}
		
		System.out.println(" ");
		
		System.out.print( "Posortowana lista 1:: " );
		nowa.wyswietl();
		
		System.out.println(" ");
		
		System.out.println( "Mediana " + nowa.mediana());
		
		System.out.println("Wartoœæ Max " + nowa.wartoscMax() );
		
		System.out.println("Wartoœæ Min " + nowa.wartoscMin() + "\n" );
		
		File plik2 = new File("z1data2.csv");
		
		posortowanaLista nowa2 = new posortowanaLista(plik2);
		
		System.out.println("Lista 2:: ");
		
		System.out.println( "Liczba Elementów " + nowa2.liczbaElementów());
		
		System.out.println( "Mediana " + nowa2.mediana());
		
		System.out.println("Wartoœæ Max " + nowa2.wartoscMax() );
		
		System.out.println("Wartoœæ Min " + nowa2.wartoscMin() + "\n" );
		
		System.out.println("Sprawdzenie dla listy 2 ");
		
		Collections.sort(nowa2.getLista());
		System.out.println("Wartoœæ Max = " + nowa2.getLista().get(nowa2.getLista().size()-1) + " Wartoœæ Min = " + nowa2.getLista().get( 0 ));
		
	}//koniec main

}//koniec klasy


















