
public class Primer {
	public static void main(String[]args) {
		final String[] X = {"A","C","G","G","T"};
		final String[] Y= {"A","C","G","C","T","T","A"};

		System.out.println("PrimerX");
		mostrar(X);
		System.out.println("SegundoY");
		mostrar(Y);
	}
	public static void mostrar(String[] arr) {
		for(String p : arr) 
			System.out.println(p);
	}

}
