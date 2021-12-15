import java.util.ArrayList;

public class Primer {
	public static void main(String[]args) {
		String texto ="A C G G A";
		String patr ="A C T G";
		init(texto,patr);
		texto = "Señor Presidente del Congreso de la República, señoras y señores congresistas, señoras "
				+ "y señores ministros de Estado, autoridades civiles y militares, representantes de los "
				+ "cuerpos diplomáticos, compatriotas de todo el Perú. Conforme a la Constitución de la "
				;
		
		 patr = "Señor Presidente del Congreso de la República; Señoras y señores congresistas; Señoras y ";
		init(texto,patr);

	}
	public static void init(String text,String ptr) {
		final String texto = text;
		final String patr =ptr;
		String[] x = returnArray(texto);
		String[] y = returnArray(patr);
		System.out.println("Por fuerza bruta");
		ArrayList<String> comb = new ArrayList<String>();
	    combinatorias(y, comb,"", 0);
	    System.out.println("Combinacion de patron: ");
	    System.out.println(comb);
	    brutaForce(comb,x);
		System.out.println("Por programacion dinamica");
		LCS(x,y);
	}
	public static void mostrar(String[] arr) {
		for(String p : arr) 
			System.out.println(p+"");
	}
	//Fuerza bruta
	public static void brutaForce(ArrayList<String> comb,String[] a){
	    String maxSub="";
	    String[] c = null;
	    boolean exp;
	    for(int i= 0; i<comb.size();i++){
	      if(maxSub.length()>=comb.get(i).length())
	        continue;
		  c = returnArray(comb.get(i));
	      exp = search(a,c);
	      if(exp)
	        maxSub = comb.get(i);
	    }
	    if(maxSub.length()!=0) {
	    	System.out.println("Max subsecuencia por fuerza bruta : "+maxSub);
	    	double ptge = ((double)(returnArray(maxSub)).length/a.length)*100;	    	
	    	System.out.println("Porcentaje de coincidencias : "+ptge+"%");
	    }
	    else
	    	System.out.println("No hay una subsecuencia");

	    
	  }
	  //Metodo para buscar la el patron en un cadena
	  public static boolean search(String[] a ,String[] b){
	    int j=0;
	    for(int i =0;i<a.length;i++){
	      if(a[i].equals(b[j]))
	        j++;
	      if(j==b.length)
	        return true;
	    } 
	    return false;
	  }
	  //Registra todas las combinatorios de un arreglo de string en un array list 2^n-1 
	  //- 1 porque esta implicito el vacio
	  public static void combinatorias(String[] a, ArrayList<String> b,String inst,int index ){
	    for(int i = index;i<a.length;i++){
	      String aux= inst;
	      inst += a[i]+" "; 
	      b.add(inst);
	      combinatorias(a,b,inst,i+1);
	      inst = aux;
	    }
	  }
	//Programacion dinamica
	public static void LCS(String[] x , String[] y) {
		int[][] c = new int[x.length+1][y.length+1];
		for(int i=1;i<c.length;i++) {
			for(int j=1;j<c[i].length;j++) {
				if(x[i-1].equals(y[j-1]))
					c[i][j]=c[i-1][j-1]+1;
				else
					c[i][j]=Math.max(c[i][j-1],c[i-1][j]);			
			}
		}
		matriz(c);
		String cadena = cadena(c,x.length,y.length,x,y);
		System.out.println("Resultado por PD:  "+cadena);
		double ptge = ((double)c[x.length][y.length]/x.length)*100;	    	
    	System.out.println("Porcentaje de coincidencias : "+ptge+"%");	
	}
	//Metodo backtrackin para obtener la string que es la subsecuencia max
	public static String cadena(int [][] matriz,int n ,int m,String[] x, String[]y) {
		int i=n; int k=m;
		String str = "";
		while(i>0 && k>0) {
			if(!x[i-1].equals(y[k-1])) {
				if(matriz[i][k]==matriz[i-1][k])
					i--;
				else if(matriz[i][k]==matriz[i][k-1])
					k--;
			}
			else {
				str= x[i-1]+str;
				i--;
				k--;
			}			
				
		}
		return str;
	}
	public static void matriz(int[][] c) {
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[i].length;j++) {
				System.out.print(c[i][j]+"    ");
			}
			System.out.println();
		}
		
	}
	//Metodo que me permite convertir un texto en un  array
	public static String[] returnArray(String parrafo) {
		ArrayList<String> vector = new ArrayList<String>();
		int  i = 0;
		parrafo = parrafo.trim();
		String palabra = "";
		while(i<parrafo.length()) {
			if(!parrafo.substring(i,i+1).equals(" ")) 
				palabra += parrafo.substring(i,i+1);
			else {
				vector.add(palabra);
				palabra = "";
			}
			if(i==parrafo.length()-1)
				vector.add(palabra);
			i++;		
		}
		String[] vec = convertir(vector);
		return vec;
	}
	public static String[] convertir(ArrayList<String> arr) {
		String[] newArr = new String[arr.size()];
		for(int i= 0;i < arr.size() ;i++)
			newArr[i] = arr.get(i);
		return newArr;
		
	}

}
