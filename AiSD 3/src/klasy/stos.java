package klasy;
import java.util.ArrayList;

public class stos {
	
	private ArrayList<Integer> lista;
	
	public stos () {
		this.lista = new ArrayList<>();
	}//koniec konstruktora
	
	/** zwraca ostatnio dodany element */
	public int pop() {
		int p = lista.get(lista.size()-1);
		lista.remove(lista.size()-1);
		return p ;
	}//koniec pop
	
	public void push( int p ) {
		lista.add(p);
	}//koniec push
	
	public boolean isEmpty() {
		return lista.isEmpty();
	}//koniec is empty
	
	public int size() {
		return lista.size();
	}// koniec size
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//koniec klasy























