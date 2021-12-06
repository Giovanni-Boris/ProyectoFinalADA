import java.util.ArrayList;

public class Primer {
	public static void main(String[]args) {
		final String texto ="A C G G A";
		final String patron ="A C T G";
		String[] x = returnArray(texto);
		String[] y = returnArray(patron);
		System.out.println("Primer x");
		mostrar(x);
		System.out.println("Segundo y");
		mostrar(y);
		System.out.println("Por fuerza bruta");
		ArrayList<String> comb = new ArrayList<String>();
	    combinatorias(y, comb,"", 0);
	    System.out.println("Combinacion de patron: ");
	    System.out.println(comb);
	    System.out.println(comb.size());
	    brutaForce(texto,comb);
		System.out.println("Por programacion dinamica");
		LCS(x,y);
	}
	public static void mostrar(String[] arr) {
		for(String p : arr) 
			System.out.println(p);
	}
	//Fuerza bruta
	public static void brutaForce(String x , ArrayList<String> comb){
	    String maxSub="";
	    boolean exp;
	    for(int i= 0; i<comb.size();i++){
	      if(maxSub.length()>=comb.get(i).length())
	        continue;
	      exp = search(x,comb.get(i));
	      //System.out.println(comb.get(i)+" : "+exp);
	      if(exp)
	        maxSub = comb.get(i);
	    }
	    if(maxSub.length()!=0)
	    	System.out.println("Max subsecuencia por fuerza bruta : "+maxSub);
	    else
	    	System.out.println("No hay una subsecuencia");

	    
	  }
	  //Metodo para buscar la el patron en un cadena
	  public static boolean search(String a ,String b){
	    int j=0;
	    for(int i =0;i<a.length();i++){
	      if(a.charAt(i)==b.charAt(j))
	        j++;
	      if(j==b.length())
	        return true;
	    } 
	    return false;
	  }
	  //Registra todas las combinatorios de un arreglo de string en un array list 2^n-1 
	  //- 1 porque esta implicito el vacio
	  public static void combinatorias(String[] a, ArrayList<String> b,String inst,int index ){
	    for(int i = index;i<a.length;i++){
	      String aux= inst;
	      inst += a[i]; 
	      b.add(inst);
	      //System.out.println("b: "+inst + "   :"+b.get(b.size()-1) );
	      combinatorias(a,b,inst,i+1);
	      inst = aux;
	    }
	  }
	//Programacion dinamica
	public static void LCS(String[] x , String[] y) {
		int[][] c = new int[x.length+1][y.length+1];
		System.out.println(c.length);
		System.out.println(c[0].length);

		matriz(c);
		System.out.println("Matriz despues");
		for(int i=1;i<c.length;i++) {
			for(int j=1;j<c[i].length;j++) {
				if(x[i-1].equals(y[j-1]))
					c[i][j]=c[i-1][j-1]+1;
				else
					c[i][j]=Math.max(c[i][j-1],c[i-1][j]);
				
			}
		}
		matriz(c);
		System.out.println("Resultado por PD:  "+cadena(c,5,4,x,y));

		
		
	}
	//Metodo backtrackin para obtener la string que es la subsecuencia max
	public static String cadena(int [][] matriz,int n ,int m,String[] x, String[]y) {
		int i=n; int k=m;
		String str = "";
		while(i>0 && k>0) {
			//System.out.println("i : "+i+" k : "+k);
			//System.out.println("x "+ x[i-1]+" y: "+y[k-1]+"\n");
			if(!x[i-1].equals(y[k-1])) {
				if(matriz[i][k]==matriz[i-1][k])
					i--;
				else if(matriz[i][k]==matriz[i][k-1])
					k--;
			}
			else {
				str= x[i-1]+str;
				//System.out.println("str "+str);
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
		System.out.println(vector);
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
