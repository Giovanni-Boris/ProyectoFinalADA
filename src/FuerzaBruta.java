import java.util.*;

public class FuerzaBruta {
  public static void main(String[] args) {
	  	/*String alfabeto [] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","10"};
		int letras = alfabeto.length;
		System.out.println(letras);
		int tamaño = 200;
		String oracion1 [] = new String [100];
		String oracion2 [] = new String [50];
		for(int i = 0 ; i < 100 ; i++){
			oracion1[i] = alfabeto[(int)(Math.random()*letras)];
		}
		for(int i = 0 ; i < 50 ; i++){
			oracion2[i] = alfabeto[(int)(Math.random()*letras)];
		}
		for(int i = 0 ; i < oracion1.length ; i++){
			System.out.print(oracion1[i]+",");
		}
		System.out.println();
		for(int i = 0 ; i < oracion2.length ; i++){
			System.out.print(oracion2[i]+",");
		}
		System.out.println();
		double resultado = Porcentaje(oracion1,oracion2);
		System.out.println("Resultado "+resultado+"%");
		*/
	  	final String[] X = {"A","C","G","G","A"};
		final String[] Y= {"A","C","T","G"};
		System.out.println();
		double resultado = Porcentaje(X,Y);
		System.out.println("Resultado "+resultado+"%");
		
  }

	public static double Porcentaje(String [] base ,String [] nueva){
		double porcentaje = 0.0;
		for(int i = 0 ; i < base.length ; i++){
			for(int j = 0 ; j < nueva.length ; j++){
				if(base[i].equalsIgnoreCase(nueva[j])){
					System.out.println(base[i] + ":"+nueva[j]);
					porcentaje++;
					//System.out.println(base[i]+"="+nueva[j]+"-"+porcentaje); 
				}
			}
		}	
		System.out.println("->"+porcentaje);
		return porcentaje*100/(base.length*nueva.length);
	}

}