import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class posortowanaLista {
	
	private ArrayList<Integer> lista;
	
	public ArrayList<Integer> getLista(){
		return lista;
	}
	
	public posortowanaLista(File f) {
		
		lista = new ArrayList<>();
		
		try( BufferedReader czytnik = new BufferedReader( new FileReader(f) )){
			
			String[] tablica;
			
			while (true) {
				tablica = czytnik.readLine().split(",");
				for ( String s : tablica ) {
					lista.add(Integer.parseInt(s));
				}
			}//koniec while
		} catch (Exception e) {
			//System.out.println("koniec pliku");
		}
	}//koniec konstruktora
	
	
	public int liczbaElementów() { return lista.size(); }
	
	public int wartoscMin() {
		sortujBabelkowo();
		return lista.get(0);
	}
	
	public int wartoscMax() {
		sortujBabelkowo();
		return lista.get(lista.size()-1);
	}
	
	public double mediana() {
		sortujBabelkowo();
		if ( lista.size()%2 == 1 ) {
			return lista.get(lista.size()/2 );
		} else {
			return (double) ( lista.get( lista.size()/2 -1 ) + lista.get( lista.size()/2 ) ) /2;
		}
	}
	
	public void wyswietl() {
		sortujBabelkowo();
		for ( Integer i : lista ) {
			System.out.print(i + " " );
		}
	}
	
	
	//SORTOWANIE BABELKOWE
	private void sortujBabelkowo() {
		
		for ( int i = 0; i < lista.size(); i++ ) {
			for (int j = 0; j < lista.size(); j++) {
				if ( lista.get(i) < lista.get(j) ) {
					int zmienna = lista.get(i);
					lista.remove(i);
					lista.add(j,zmienna);
				}//koniec if
			}//koniec wewnêtrznego for
		}//koniec zewnetrznego for
		
	}
	
}//koniec klasy


















