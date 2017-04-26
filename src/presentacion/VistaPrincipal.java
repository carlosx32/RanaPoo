package presentacion;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VistaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel cuadros[][];
	private JButton btnTeclado[];
	//
	private JButton btnGenerar;

	
	private final Modelo modelo;
	private Controlador control;
	//constructor
	public VistaPrincipal(Modelo aThis) {
		modelo = aThis;
		setResizable(false);
		initComponents();
		initCajones();
		//iniciar botones
		initbotones();
		capturarEventos();
	}
	// Este inicia la ventana
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	// who are you, Label?, en el controlador
		
	// Este inicia los cajones
	private void initCajones() {
		int i, j, posx = 45, posy = 22;
		cuadros = new JLabel[9][9];
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				cuadros[i][j] = new JLabel();
				cuadros[i][j].setBackground(Color.WHITE);
				cuadros[i][j].setBounds(posx, posy, 30, 30);
				cuadros[i][j].setOpaque(true);
				cuadros[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				cuadros[i][j].setName(i+","+j);
				contentPane.add(cuadros[i][j]);
				if ((j + 1) % 3 == 0) {
					posx += 20;
				}
				posx += 40;
			}
			if ((i + 1) % 3 == 0) {
				posy += 20;
			}
			posx = 45;
			posy += 45;
		}
	}	
	private void initbotones() {		
		int i, posx = 15, posy = 485;
		btnTeclado = new JButton[9];
		for (i = 0; i < 9; i++) {
			btnTeclado[i] = new JButton();			
			btnTeclado[i].setBounds(posx, posy, 45, 30);
			btnTeclado[i].setOpaque(true);
			btnTeclado[i].setName(""+(i+1));
			btnTeclado[i].setText(""+(i+1));
			btnTeclado[i].setHorizontalAlignment(SwingConstants.LEFT);
			btnTeclado[i].setEnabled(false);
			contentPane.add(btnTeclado[i]);
				posx += 50;
		}
		btnGenerar = new JButton();
		
		btnGenerar.setBounds(15, 535 , 445, 30);
		btnGenerar.setText("Generar nuevo");
		btnGenerar.setName("Generar");
		contentPane.add(btnGenerar);

	}

	//getters	
    public Modelo getModelo() {
        return modelo;
    }     
	public JLabel getCuadro(int i, int j) {
		return cuadros[i][j];
	}

		
	public JButton getBtnTeclado(int i) {
		return btnTeclado[i];
	}
	//controlador
    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }   
	
	// eventos
    private void capturarEventos() {
    	//agregamos el evento de click del mouse al panel para ver que seleccionamos
    	//contentPane.addMouseListener(getControl());
    	    	//AGREGAR EVENTOS    	
    	int i, j;
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {	
			cuadros[i][j].addMouseListener(getControl());				
				}
		}
		for (i = 0; i < 9; i++) {
			btnTeclado[i].addActionListener(getControl());
		}

		btnGenerar.addActionListener(getControl());
		    	
    }

    
}
