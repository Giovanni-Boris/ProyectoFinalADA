import java.util.ArrayList;

public class Primer {
	public static void main(String[]args) {
		String texto ="A C G G A";
		String patron ="A C T G";
		init(texto,patron);
		texto = "Señor Presidente del Congreso de la República, señoras y señores congresistas, señoras "
				+ "y señores ministros de Estado, autoridades civiles y militares, representantes de los "
				+ "cuerpos diplomáticos, compatriotas de todo el Perú. Conforme a la Constitución de la "
				+ "República, me presento ante el país para exponer ante todos los peruanos el estado de la "
				+ "administración que presido, así como los avances, metas y desafíos en los que estamos "
				+ "comprometidos para hacer del Perú un país mejor. Hace cuatro meses asumí la Presidencia "
				+ "en el marco de una grave crisis política e institucional. Las denuncias por corrupción "
				+ "y el enfrentamiento político habían dado lugar a una situación insostenible que afectó "
				+ "gravemente la convivencia política, la institucionalidad y generó un importante impacto en "
				+ "la economía del Perú. La prioridad inicial fue preservar la institucionalidad ante la crisis, "
				+ "asumir la Presidencia y conformar un nuevo gabinete en un tiempo muy corto. Desde el primer "
				+ "día tuvimos claro la magnitud del desafío y también el camino que debemos emprender para superar "
				+ "la crisis. Ya en el discurso de asunción marcamos los principales ejes de nuestro gobierno, "
				+ "que luego desarrollamos, y por primera vez en la historia del Perú los dejamos plasmados, "
				+ "mediante decreto supremo, en la política general del Gobierno al 2021, para que todos los "
				+ "peruanos tengamos muy claro el rumbo de este gobierno. Los cinco ejes que constituyen la "
				+ "base de nuestra gestión, y que el día de hoy ratifico, son: 1. Integridad y lucha contra "
				+ "la corrupción. 2. Fortalecimiento institucional para la gobernabilidad. 3. Crecimiento económico "
				+ "equitativo, competitivo y sostenible. 4. Desarrollo social y bienestar de la población. "
				+ "5. Descentralización efectiva para el desarrollo. Este es el camino que trazamos desde un "
				+ "inicio, el camino que nos llevará a construir el Perú con el que soñaron nuestros padres "
				+ "y abuelos, y el Perú que merecen nuestros hijos. Debe quedar claro, el nuestro es un gobierno "
				+ "que está dispuesto a jugársela por el futuro del Perú. No estamos aquí solo para ocupar "
				+ "un cargo, estamos para brindar un servicio, para liderar las transformaciones que necesita "
				+ "el país, para llevar a cabo las reformas que los peruanos reclaman y no nos va a temblar "
				+ "la mano para tomar las decisiones que sean necesarias para cumplir con estos objetivos.";
		
		 patron = "Señor Presidente del Congreso de la República; Señoras y señores congresistas; Señoras y "
		 		+ "señores ministros de Estado; Distinguidas autoridades civiles y militares; Miembros del "
		 		+ "cuerpo diplomático acreditado en el Perú; Compatriotas, a lo largo y ancho del país: De "
		 		+ "conformidad al artículo 118 de la Constitución Política del Estado, me dirijo al país al "
		 		+ "cumplir un año y cuatro meses al frente del gobierno, para hacer un balance del camino "
		 		+ "recorrido hasta hoy y compartir con todos los peruanos las próximas acciones en el marco "
		 		+ "de la ruta trazada y expresada en los cinco ejes de nuestra política de gobierno. Al "
		 		+ "pronunciar este mensaje desde la sede del Congreso, no puedo dejar de recordar ante todos "
		 		+ "los peruanos las circunstancias en que asumimos la conducción del gobierno: una grave crisis "
		 		+ "política y un escenario de zozobra institucional que habían trastocado las bases del Estado y "
		 		+ "fastidiado a nuestros ciudadanos. Conscientes del enorme desafío, en estos dieciséis meses hemos "
		 		+ "logrado conducir una transición ordenada y pacífica dentro de los cauces legales y "
		 		+ "constitucionales. En el Perú no se produjo un escenario de convulsión social ni política, "
		 		+ "como ha ocurrido en otros países en similares situaciones. Es la democracia y la fe de los "
		 		+ "peruanos que se vienen imponiendo frente a los privilegios y los compadrazgos. Es la voluntad "
		 		+ "de un pueblo valiente y luchador que alienta y estimula la construcción de un verdadero "
		 		+ "Estado de derecho. Por eso, no solo hemos garantizado una transición democrática sino, "
		 		+ "escuchando el clamor de la ciudadanía, hemos emprendido las reformas judicial y política, "
		 		+ "y una lucha frontal contra la corrupción y la impunidad. Desde un inicio tuvimos claro que "
		 		+ "esta no era una tarea sencilla. Siempre fuimos conscientes de que era, y es, un desafío "
		 		+ "complejo conducir al Perú desde la crisis que atraviesa hacia una nueva etapa de crecimiento "
		 		+ "sostenido y estabilidad institucional, la que conduce este camino de fortalecimiento de la "
		 		+ "República. El objetivo común es generar instituciones sólidas, representativas y "
		 		+ "confiables, que promuevan un crecimiento equitativo, competitivo y sostenible, y nos "
		 		+ "permita cerrar brechas sociales y de infraestructura. Por eso, hoy anunciaré un conjunto de "
		 		+ "medidas para impulsar el crecimiento productivo y el progreso del país.";
			init(texto,patron);




	}
	public static void init(String text,String ptr) {
		final String texto = text;
		final String patron =ptr;
		String[] x = returnArray(texto);
		String[] y = returnArray(patron);
		//System.out.println("Primer x");
		//mostrar(x);
		//System.out.println("Segundo y");
		//mostrar(y);
		System.out.println("Por fuerza bruta");
		ArrayList<String> comb = new ArrayList<String>();
	    combinatorias(y, comb,"", 0);
	    System.out.println("Combinacion de patron: ");
	    System.out.println(comb);
	    //System.out.println(comb.size());
	    brutaForce(texto,comb,x);
		System.out.println("Por programacion dinamica");
		LCS(x,y);
	}
	public static void mostrar(String[] arr) {
		for(String p : arr) 
			System.out.println(p);
	}
	//Fuerza bruta
	public static void brutaForce(String x , ArrayList<String> comb,String[] a){
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
	    if(maxSub.length()!=0) {
	    	System.out.println("Max subsecuencia por fuerza bruta : "+maxSub);
	    	//System.out.println(maxSub.length());
	    	//System.out.println(a.length);
	    	double ptge = ((double)maxSub.length()/a.length)*100;	    	
	    	System.out.println("Porcentaje de coincidencias : "+ptge+"%");

	    }
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
		//System.out.println(c.length);
		//System.out.println(c[0].length);

		//matriz(c);
		//System.out.println("Matriz despues");
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
		double ptge = ((double)cadena.length()/x.length)*100;	    	
    	System.out.println("Porcentaje de coincidencias : "+ptge+"%");

		
		
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
