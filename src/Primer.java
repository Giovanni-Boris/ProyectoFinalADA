
public class Primer {
	public static void main(String[]args) {
		final String[] X = {"A","C","G","G","A"};
		final String[] Y= {"A","C","T","G"};

		System.out.println("PrimerX");
		mostrar(X);
		System.out.println("SegundoY");
		mostrar(Y);
		LCS(X,Y);
	}
	public static void mostrar(String[] arr) {
		for(String p : arr) 
			System.out.println(p);
	}
	public static void LCS(String[] x , String[] y) {
		int[][] c = new int[x.length+1][y.length+1];
		matriz(c);
		for(int i=1;i<c.length;i++) {
			for(int j=1;i<c[i].length;j++) {
				if(x[i].equals(y[j]))
					c[i][j]=c[i-1][j-1]+1;
			}
		}
		matriz(c);
		
		
	}
	public static void matriz(int[][] c) {
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[i].length;j++) {
				System.out.print(c[i][j]+"    ");
			}
			System.out.println();
		}
		
	}

}
