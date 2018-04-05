
public class para {
	
	private int indexPocztkowy;
	private int indexKoncowy;
	
	public para( int poczatek, int koniec ) {
		this.indexPocztkowy = poczatek;
		this.indexKoncowy = koniec;
	}//koniec konstruktora

	
	//GETERY
	public int getIndexPocztkowy() {
		return indexPocztkowy;
	}
	
	public int getIndexKoncowy() {
		return indexKoncowy;
	}
	
	//SETERY
	public void setIndexPocztkowy(int indexPocztkowy) {
		this.indexPocztkowy = indexPocztkowy;
	}

	public void setIndexKoncowy(int indexKoncowy) {
		this.indexKoncowy = indexKoncowy;
	}
	
	
	//TO STRING
	@Override
	public String toString() {
		return "para [indexPocztkowy=" + indexPocztkowy + ", indexKoncowy=" + indexKoncowy + "]";
	}
	
	
	
	
}//koniec klasy






















