import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class kolejka {
	
	private ArrayList<Integer> lista1;
	
	public kolejka(File plik) {
		this.lista1 = new ArrayList<>();
		try( BufferedReader czytnik = new BufferedReader(new FileReader(plik))){
			while(true) {
				String[] tablica;
				tablica = czytnik.readLine().split(",");
				for ( String s : tablica ) {
					lista1.add(Integer.parseInt(s));
				}//koniec for
			}//koniec while
		} catch (Exception e) {
			// TODO: handle exception
		//	e.printStackTrace();
		}//koniec catch
	}//koniec konstruktora
	
	public int rozmiar() { return lista1.size(); }

	public ArrayList<Integer> getLista() { return lista1; }
	
	
	
	
	public void sortujOstatni( ArrayList<Integer> lista, int indexPoczatkowy, int IndexKoncowy ) {
		
		int pivot = lista.get(lista.size()-1);		//pivot wyznaczany z ostatniej pozycji
		int poz = 0;								//pozycja na której bedzie siê znajdowaæ pivot po pierwszym obiegu
		
		
		
		
		
		
		
	}//konice sortujOstatni
	
	
}// koniec klasy




























