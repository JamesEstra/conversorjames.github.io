import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Opciones extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnDivisa;
	private JButton btnTemperatura;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Opciones frame = new Opciones();
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
	public Opciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("CONVERSOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 414, 34);
		contentPane.add(lblNewLabel);
		
		btnDivisa = new JButton("Divisa");
		btnDivisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Divisa div = new Divisa();
				div.setVisible(true);
				dispose();
			}
		});
		btnDivisa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnDivisa.setBounds(45, 181, 140, 23);
		contentPane.add(btnDivisa);
		
		btnTemperatura = new JButton("Temperatura");
		btnTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Temperatura temp = new Temperatura();
				temp.setVisible(true);
				dispose();
			}
		});
		btnTemperatura.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnTemperatura.setBounds(243, 181, 140, 23);
		contentPane.add(btnTemperatura);
	}
}
