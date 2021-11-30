import java.util.ArrayList;
import java.util.Scanner;
public class transformacion {
	public static void main(String[] args) {
		//Hacer un vector que guarde una frase, de forma que cada palabra 
		//ocupe una posici�n, y luego las esta mostrando una por l�nea. Sin espacios.
		//retornar un arreglo
		;
		//Scanner s=new Scanner(System.in);
		//String parrafo_a_comparar;
		//System.out.print("Introduzca parrafo:");
		//parrafo_a_comparar=s.nextLine();
		String[] a = arreglo("HOLA COMO ESTAS");//metodo que retorna un arreglo de string
		imprimir(a);
		//String[] b= palabras(parrafo_a_comparar);//metodo que retorna las palabras ingresadas ya puestas en arreglo
		//imprimir(b);
		String[] c = returnArray("HOLA COMO ESTAS");
		imprimir(c);
	}
	public static void imprimir(String[] a ) {
		for(String i : a ){
			System.out.println(i);
		}
		
	}
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
	public static String [] arreglo(String parrafo) {
		int  i, pos_espacio=0, palabras=0 , prim=0;
		
			parrafo=parrafo.trim();
		
		//Metodo trim:elimina los espacios en blanco en ambos extremos del string.(espacio tabulacion)
		do{
			if ( parrafo.indexOf(" ", pos_espacio)>0 || parrafo.length()>0 ) palabras++;
			// IndexOF Dar posici�n de �ndice para la subcadena dada y comenzar el �ndice  
			pos_espacio=parrafo.indexOf(" ", pos_espacio)+1;
			//System.out.println(palabras + " " +espacios+" "+pos_espacio);
			//La l�nea de arriba es solo para comprobar que iba bien.
		}while(pos_espacio>0);
		//*********************************************************************
		//System.out.println("Palabras: "+palabras);
		//La linea de arriba es para ver cuantas palabras tiene la frase
		String vector[]=new String[palabras];
		pos_espacio=parrafo.indexOf(" ", 0)+1;
		if (palabras==1)
			vector[0]=parrafo;
		else
			for(i=0; i<palabras; i++){
				//System.out.println("i="+i+" prim="+prim+" pos_espacio="+pos_espacio+"--"); //comprobaciones
				vector[i]=parrafo.substring(prim, pos_espacio-1);
				prim=pos_espacio;
				if(parrafo.indexOf(" ", pos_espacio)!=-1) pos_espacio=parrafo.indexOf(" ", pos_espacio+1)+1;
				else pos_espacio= parrafo.length()+1;
			}
		//for(i=0; i<palabras; i++) System.out.println(vector[i]);
		return vector;
	}
	public static String[] palabras(String parrafo_a_comparar) {
		int  i, pos_espacio=0, palabras=0 , prim=0;
			parrafo_a_comparar=parrafo_a_comparar.trim();
		//Metodo trim:elimina los espacios en blanco en ambos extremos del string.(espacio tabulacion)
		do{
			if ( parrafo_a_comparar.indexOf(" ", pos_espacio)>0 || parrafo_a_comparar.length()>0 ) palabras++;
			// IndexOF Dar posici�n de �ndice para la subcadena dada y comenzar el �ndice  
			pos_espacio=parrafo_a_comparar.indexOf(" ", pos_espacio)+1;
			//System.out.println(palabras + " " +espacios+" "+pos_espacio);
			//La l�nea de arriba es solo para comprobar que iba bien.
		}while(pos_espacio>0);
		//*********************************************************************
		
		//System.out.println("Palabras: "+palabras);
		//La linea de arriba es para ver cuantas palabras tiene la frase
		String vector[]=new String[palabras];
		pos_espacio=parrafo_a_comparar.indexOf(" ", 0)+1;

		if (palabras==1)
			vector[0]=parrafo_a_comparar;
		else
			for(i=0; i<palabras; i++){
				//System.out.println("i="+i+" prim="+prim+" pos_espacio="+pos_espacio+"--"); //comprobaciones
				vector[i]=parrafo_a_comparar.substring(prim, pos_espacio-1);
				prim=pos_espacio;
				if(parrafo_a_comparar.indexOf(" ", pos_espacio)!=-1) pos_espacio=parrafo_a_comparar.indexOf(" ", pos_espacio+1)+1;
				else pos_espacio= parrafo_a_comparar.length()+1;
			}
		//for(i=0; i<palabras; i++) System.out.println(vector[i]);
		return vector;
		
	}
}