package presentacion;

import java.awt.Color;


import javax.swing.JOptionPane;


import logica.Sudokus;

public class Modelo {
	// variables

	// insatnciuamos la vista principal y la logica
	private VistaPrincipal ventanaInicial;
	private Sudokus sistema;
	
	public VistaPrincipal getVentanaInicial() {
		if (ventanaInicial == null) {
			ventanaInicial = new VistaPrincipal(this);
		}
		return ventanaInicial;
	}
	
	public void iniciar() {
		getVentanaInicial().setVisible(true);
	}
	
	public Sudokus getSistema() {
		// si no hay objeto crearlo
		if (sistema == null) {
			sistema = new Sudokus();
		}
		return sistema;
	}

	// metodos a implementar por sistema
	public void generarSudoku() {
		// copiamos el tablero problema en la vista
		int i, j;
		int numImprimir[][] = this.getSistema().obtenerProblema();
				
		for (i = 0; i < 9; i++) {			
			for (j = 0; j < 9; j++) {	
				
				if (numImprimir[i][j] != 0) {
					ventanaInicial.getCuadro(i,j).setText("" + numImprimir[i][j]);
					// fondo de color
					ventanaInicial.getCuadro(i,j).setBackground(Color.lightGray);
				}
				else{
					ventanaInicial.getCuadro(i,j).setText("");
					ventanaInicial.getCuadro(i,j).setBackground(Color.white);
				}
			}
		}
	}

	//eliminar esto cuando acabemmos
	public void compobarSudoku() {
		int[][] matriz=new int[9][9];
		int i,j;
		// En este mètodo, tomamos los datos de la vista y los pasamos a la
		// logica
		// Luego tomamnos los resultados generados por la logica y los mostramos
		// en la vista
		//toma la matriz de la vista(label) y la convierte en una matriz de enteros
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				
				if(ventanaInicial.getCuadro(i, j).getText()!=""){
					matriz[i][j]=Integer.parseInt(""+ventanaInicial.getCuadro(i,j).getText());
				}
				else{
					matriz[i][j]=0;
				}
			}
		}
	}
	
	public void modificarlogica(int i, int j, int valoraGuardar){
		sistema.setMatriz( i, j, valoraGuardar ); 

	}

	public void compararCuadro(int i, int j) {
		if( sistema.compararCuadro( i, j)){
			ventanaInicial.getCuadro(i,j).setBackground(Color.white);
		}
		else{
			ventanaInicial.getCuadro(i,j).setBackground(Color.red);
		}
		//verifica si ya acabo el juego
		if(sistema.comprobar()){
			JOptionPane.showMessageDialog(getVentanaInicial(), "has finalizado el sudoku con exito");			
		}
	}
	//activa los botones para modificar los numeros
	public void activarBotones() {
		int i;
		for (i = 0; i < 9; i++) {
			ventanaInicial.getBtnTeclado(i).setEnabled(true);
		}
		
		
	}
	
	
	

}
