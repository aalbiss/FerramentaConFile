import java.util.Scanner;

public class Articolo {

	private int codiceArticolo;
	private String nomeArticolo;
	private double giacenza;
	
	public Articolo() {
		codiceArticolo=0;
		nomeArticolo="";
		giacenza=0;
	}
	
	public Articolo(int codiceArticolo, String nomeArticolo, double giacenza) {
		this.codiceArticolo = codiceArticolo;
		this.nomeArticolo = nomeArticolo;
		this.giacenza = giacenza;
	}

	public int getCodiceArticolo() {
		return codiceArticolo;
	}

	public void setCodiceArticolo(int codiceArticolo) {
		this.codiceArticolo = codiceArticolo;
	}

	public String getNomeArticolo() {
		return nomeArticolo;
	}

	public void setNomeArticolo(String nomeArticolo) {
		this.nomeArticolo = nomeArticolo;
	}

	public double getGiacenza() {
		return giacenza;
	}

	public void setGiacenza(double giacenza) {
		this.giacenza = giacenza;
	}

	public void acquisto() {
		Scanner KB = new Scanner(System.in);	
		int n = 0;
		
		do {
			System.out.println("Inserisci il numero di elementi da comprare");
			n = KB.nextInt();
			if(n<=0) {
				System.out.println("Inserire pi� di 0 articoli");
			}
		}while(n<=0);
		setGiacenza(n+getGiacenza());
	}
	
	public void vendita() {
		Scanner KB = new Scanner(System.in);	
		int n = 0;
		do {
			System.out.println("Inserisci il numero di elementi da vendere");
			n = KB.nextInt();
			if(n<=0) {
				System.out.println("Inserire pi� di 0 articoli");
			}
		}while(n<=0);
		setGiacenza(getGiacenza()-n);
	}

	public void visualizza() {
		System.out.println("Codice prodotto: " + codiceArticolo + " giacenza: " + giacenza + " articolo " + nomeArticolo);
	}
}
