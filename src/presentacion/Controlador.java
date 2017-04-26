package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Controlador implements MouseListener, ActionListener{
	// se guradan en las variables los posibles generadores de eventos
	JLabel guardarEtq = new JLabel();
	JLabel lblSeleccionado = new JLabel();
	boolean puedoActivar;
	
	JButton boton;
	private final VistaPrincipal ventana;
	
	private int i;
	private int j;
	
	
	public Controlador(VistaPrincipal aThis) {
		ventana = aThis;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {

	}
	@Override
	public void mouseExited(MouseEvent e) {

	}
	@Override	
	// guardan lo seleccionado
	public void mousePressed(MouseEvent e) {
		
		if (e.getSource() instanceof JLabel ) {
			// guarda la etiqueta
			guardarEtq =(JLabel) e.getSource();
			if(puedoActivar){
				ventana.getModelo().activarBotones();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof JButton) {
			boton = (JButton) e.getSource();
			// si el boton es el de generar nuevo:
			if (boton.getName().equals("Generar")) {
				ventana.getModelo().generarSudoku();
				puedoActivar=true;			
			}
			// si se ha seleccionado uno de los otros botones:
			else if (!boton.getName().equals("Comprobar") && !boton.getName().equals("Generar")) {
			
			i=Integer.parseInt(""+guardarEtq.getName().charAt(0));
			j=Integer.parseInt(""+guardarEtq.getName().charAt(2));
				
				if (!guardarEtq.equals(null)) {		
					if (!guardarEtq.getBackground().equals(Color.lightGray) ) {
							//poner un metodo que nos guarde todo
							guardarEtq.setText("" + boton.getName());
							ventana.getModelo().modificarlogica(i, j, Integer.parseInt(""+guardarEtq.getText()));
							ventana.getModelo().compararCuadro(i,j);
						}					
				}
			}

		}
	}

}
