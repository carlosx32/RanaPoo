package logica;

import java.util.Random;

import persistenciaAspera.Tableros;

public class Sudokus {
	// se crean los problemas de la siguiente forma:
	//problema[numero de tablero][filas][columnas]
	Tableros objeto;
	int [][] matriz;
	private int  numTablero;
	Random random = new Random();

	// constructor
	public Sudokus() {
	}
		
	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int i, int j, int valorNuevo) {
		this.matriz[i][j] = valorNuevo;
		//verificamos que se modifique		
		vermatriz();
	}

	// obtener problema
	public int[][] obtenerProblema() {
		this.numTablero=(int)( random.nextDouble() * 5 + 1)-1;	
		objeto = new Tableros();		
		this.matriz=objeto.obtenerTablero(this.numTablero);	
		//imprimir
		System.out.println(""+numTablero);
		vermatriz();
		return matriz;
	};

	// obtener solucion
	/*
	public int obtenerSolucion(int tablero, int i, int j) {
		return soluciones[tablero][i][j];
	}
	*/
	
	// verificar solucion
	
	public boolean comprobar() {
		int i, j, k;
		

		// comprobamos que sea solucion
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				if (matriz[i][j] != 0) {
					for(k=0;k<9;k++){
						//controla
						if(k!=i && k!=j){
							//evaluaa
							if(matriz[i][j] == matriz[i][k]){
								return false;
															}
							if(matriz[i][j] == matriz[k][j]){
								return false;								
							}	
						}						
					}					
				}
				else{
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean compararCuadro(int i, int j){
		int k;
		for(k=0;k<9;k++){
			//
			if(k!=i && k!=j){
				//evalua
				if(matriz[i][j] == matriz[i][k]){
					return false;
				}
				if(matriz[i][j] == matriz[k][j]){
					return false;								
				}	
			}						
		}
		return true;
		
	}
	public void vermatriz(){
		System.out.println("_");
		System.out.println("_");
		int x, y;
		for (x = 0; x < 9; x++) {
			for (y = 0; y < 9; y++) {
				System.out.print(" "+ matriz[x][y]);
			}
			System.out.println("_");
			
		}
	
	}

}
