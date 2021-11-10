package PROYECTO;
import java.util.Scanner;
public class transformacion {
	public static void main(String[] args) {
		//Hacer un vector que guarde una frase, de forma que cada palabra 
		//ocupe una posición, y luego las esta mostrando una por línea. Sin espacios.
		//retornar un arreglo
		;
		Scanner s=new Scanner(System.in);
		String parrafo_a_comparar;
		System.out.println("Introduzca parrafo:");
		parrafo_a_comparar=s.nextLine();
		arreglo(parrafo_a_comparar);//metodo que retorna un arreglo de string
		palabras(parrafo_a_comparar);//metodo que retorna las palabras ingresadas ya puestas en arreglo
	}
	
	public static String [] arreglo(String parrafo) {
		int  i, pos_espacio=0, palabras=0 , prim=0;
		
			parrafo=parrafo.trim();
		
		//Metodo trim:elimina los espacios en blanco en ambos extremos del string.(espacio tabulacion)
		do{
			if ( parrafo.indexOf(" ", pos_espacio)>0 || parrafo.length()>0 ) palabras++;
			// IndexOF Dar posición de índice para la subcadena dada y comenzar el índice  
			pos_espacio=parrafo.indexOf(" ", pos_espacio)+1;
			//System.out.println(palabras + " " +espacios+" "+pos_espacio);
			//La línea de arriba es solo para comprobar que iba bien.
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
	public static void palabras(String parrafo_a_comparar) {
		int  i, pos_espacio=0, palabras=0 , prim=0;
			parrafo_a_comparar=parrafo_a_comparar.trim();
		//Metodo trim:elimina los espacios en blanco en ambos extremos del string.(espacio tabulacion)
		do{
			if ( parrafo_a_comparar.indexOf(" ", pos_espacio)>0 || parrafo_a_comparar.length()>0 ) palabras++;
			// IndexOF Dar posición de índice para la subcadena dada y comenzar el índice  
			pos_espacio=parrafo_a_comparar.indexOf(" ", pos_espacio)+1;
			//System.out.println(palabras + " " +espacios+" "+pos_espacio);
			//La línea de arriba es solo para comprobar que iba bien.
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
		for(i=0; i<palabras; i++) System.out.println(vector[i]);
		
	}
}