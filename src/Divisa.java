import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Divisa extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblDiv;
	private JTextField textF;
	private JLabel lblD;
	private JComboBox<?> cmbD;
	private JButton btnCon;
	private JButton btnSalir;
	private JButton btnTempe;
	
	
	
	public enum Moneda{
		pesosMX_Dolar,
		pesosMX_Euro,
		pesosMX_Libra,
		pesosMX_Yen,
		pesosMX_Won,
		Dolar_pesosMX,
		Euro_pesosMX,
		Libra_pesosMX,
		Yen_pesosMX,
		Won_pesosMX,
	}
	
	public double Dolar = 16.75;
	public double Euro = 18.83;
	public double Libra = 21.92;
	public double Yen = 8.28;
	public double Won = 75.50;
	
	public double valorInput = 0.00;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Divisa frame = new Divisa();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Divisa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDiv = new JLabel("Divisa");
		lblDiv.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiv.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblDiv.setBounds(10, 10, 414, 29);
		contentPane.add(lblDiv);
		
		textF = new JTextField();
		textF.setBounds(10, 82, 153, 20);
		contentPane.add(textF);
		textF.setColumns(10);
		
		lblD = new JLabel("00.00");
		lblD.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setBounds(174, 117, 84, 20);
		contentPane.add(lblD);
		
		cmbD = new JComboBox<Moneda>();
		cmbD.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		cmbD.setModel(new DefaultComboBoxModel(Moneda.values()));
		cmbD.setBounds(262, 81, 140, 22);
		contentPane.add(cmbD);
		
		btnCon = new JButton("Convertir");
		btnCon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Convertir();
			}
		});
		btnCon.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCon.setBounds(169, 148, 89, 23);
		contentPane.add(btnCon);
		
		btnTempe = new JButton("Temperatura");
		btnTempe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Temperatura temp = new Temperatura();
				temp.setVisible(true);
				dispose();
			}
		});
		btnTempe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnTempe.setBounds(10, 180, 414, 23);
		contentPane.add(btnTempe);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnSalir.setBounds(174, 214, 89, 23);
		contentPane.add(btnSalir);
	}
	
	public void Convertir() {
		if(Validar(textF.getText())) {
		Moneda moneda = (Moneda)cmbD.getSelectedItem();
		
		switch (moneda) {
		case pesosMX_Dolar:
			PesosAMoneda(Dolar);
			break;
		case pesosMX_Euro:
			PesosAMoneda(Euro);
			break;
		case pesosMX_Libra:
			PesosAMoneda(Libra);
			break;
		case pesosMX_Yen:
			PesosAMoneda(Yen);
			break;
		case pesosMX_Won:
			PesosAMoneda(Won);
			break;
		case Dolar_pesosMX:
			MonedaAPesos(Dolar);
			break;
		case Euro_pesosMX:
			MonedaAPesos(Euro);
			break;
		case Libra_pesosMX:
			MonedaAPesos(Libra);
			break;
		case Yen_pesosMX:
			MonedaAPesos(Yen);
			break;
		case Won_pesosMX:
			MonedaAPesos(Won);
			break;
			

		default:
			throw new IllegalArgumentException("Unexpected value: " + moneda);
	}
	}		
	}
	public void PesosAMoneda(double moneda) {
		double res = valorInput / moneda;
		lblD.setText(Redondear(res));
	}
	
	public void MonedaAPesos(double moneda) {
		double res = valorInput * moneda;
		lblD.setText(Redondear(res));
	}
	
	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
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
			lblD.setText("Solamente números");
			return false;
		}
	}
}
