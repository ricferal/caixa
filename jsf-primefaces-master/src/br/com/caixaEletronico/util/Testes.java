package br.com.caixaEletronico.util;

import java.util.Scanner;

public class Testes {
	
	public static void main(String[] args) {
		
		int c10,c20,c50,c100,c1;
		int r10,r20,r50,r100,r1;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite quantia:");
		int quantia = sc.nextInt();
		
	    c100 = quantia / 100;
	    r100 = quantia % 100;
	    
	    c50 = r100 / 50;
	    r50 = r100 % 50;
	    
	    c20 = r50 / 20;
	    r20 = r50 % 20;
	    
	    c10 = r20 / 10;
	    r10 = r20 % 10;
	    
	    c1 = r10 /1;
	    r1 = r10 % 1;
	    
		System.out.println("100:"+c100+" 50:"+c50+" 20:"+c20+" 10:"+c10+" 1:"+c1);
	}

}
