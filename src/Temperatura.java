import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Temperatura extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTem;
	private JTextField textTemp;
	private JPanel cmbTemp2;
	private JLabel lblGrad;
	private JButton btnDivis;
	private JButton btnConver;
	private JButton btnSalir;
	private JComboBox<Grados> comboBox;
	
	public enum Grados{
		Centigrados_Fahrenheit,
		Centigrados_Kelvin,
		Fahrenheit_Centigrados,
		Kelvin_Centigrados,
		
	}
	
	public double Fahrenheit = (1 * 9/5) + 32 ;
	public double Kelvin = 1 + 273.15;
	
	
	
	public double valorInput = 0.00;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperatura frame = new Temperatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Temperatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		cmbTemp2 = new JPanel();
		cmbTemp2.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(cmbTemp2);
		cmbTemp2.setLayout(null);
		
		lblTem = new JLabel("Temperatura");
		lblTem.setHorizontalAlignment(SwingConstants.CENTER);
		lblTem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblTem.setBounds(10, 11, 414, 29);
		cmbTemp2.add(lblTem);
		
		textTemp = new JTextField();
		textTemp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textTemp.setHorizontalAlignment(SwingConstants.CENTER);
		textTemp.setBounds(10, 71, 157, 20);
		cmbTemp2.add(textTemp);
		textTemp.setColumns(10);
		
		
		
		lblGrad = new JLabel("00.00");
		lblGrad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblGrad.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrad.setBounds(159, 110, 112, 20);
		cmbTemp2.add(lblGrad);
		
		btnDivis = new JButton("Divisa");
		btnDivis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Divisa div = new Divisa();
				div.setVisible(true);
				dispose();
			}
		});
		btnDivis.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnDivis.setBounds(10, 175, 414, 23);
		cmbTemp2.add(btnDivis);
		
		btnConver = new JButton("Convertir");
		btnConver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btnConver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnConver.setBounds(171, 141, 89, 23);
		cmbTemp2.add(btnConver);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnSalir.setBounds(171, 209, 89, 23);
		cmbTemp2.add(btnSalir);
		
		comboBox = new JComboBox<Grados>();
		comboBox.setModel(new DefaultComboBoxModel<>(Grados.values()));
		comboBox.setBounds(241, 70, 164, 22);
		cmbTemp2.add(comboBox);
	}
	
public void Convertir() {
		
		if(Validar(textTemp.getText())) {
			Grados grado = (Grados) comboBox.getSelectedItem();
			
			switch (grado) {
			
			case Centigrados_Fahrenheit:
				GradosAGr(Fahrenheit);
				break;
			case Centigrados_Kelvin:
				GradAgra(Kelvin);
				break;
			case Fahrenheit_Centigrados:
				GradAgrado(Fahrenheit);
				break;
			case Kelvin_Centigrados:
				GradAgrados(Kelvin);
				break;
			
				

			default:
				throw new IllegalArgumentException("Unexpected value: " + grado);
			}
		}
	}
	
	public void GradosAGr(double grado) {
		double res = valorInput * 9/5 +32 ;
		lblGrad.setText(Redondear(res));
	}
	
	public void GradAgra(double grado) {
		double res = valorInput + 273.15;
		lblGrad.setText(Redondear(res));
	}
	
	public void GradAgrado(double grado) {
		double res = (valorInput - 32) * 5/9;
		lblGrad.setText(Redondear(res));
	}
	public void GradAgrados(double grado) {
		double res = valorInput -273.15;
		lblGrad.setText(Redondear(res));
	}
	
	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.000");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}
	
	
	
	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if(x > 0);
			valorInput = x;
			return true;
		}catch(NumberFormatException e) {
			lblGrad.setText("Solamente números !!");
			return false;
		}
	}

}
