/**
 *
 *  @author Piwowarski £ukasz S18226
 *
 */

package zad1;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;




public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("                    1 label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setToolTipText("Podpowiedz 1");		
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBorder(BorderFactory.createEmptyBorder());
	 
		
		JLabel lblNewLabel_1 = new JLabel("2 label");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setToolTipText("Podpowiedz 1");
		lblNewLabel_1.setBorder(BorderFactory.createBevelBorder(1));

		
		JLabel lblNewLabel_2 = new JLabel("                       3 label");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setToolTipText("Podpowiedz 3");
		lblNewLabel_2.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel lblNewLabel_3 = new JLabel("                         4 label");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setToolTipText("Podpowiedz 4");
		lblNewLabel_3.setBorder(BorderFactory.createEtchedBorder(0));
		
		JLabel lblNewLabel_4 = new JLabel("5 label");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setToolTipText("Podpowiedz 5");
		lblNewLabel_4.setBorder(BorderFactory.createRaisedBevelBorder());

		
		
		
		
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		frame.getContentPane().add(lblNewLabel_1, BorderLayout.WEST);
		frame.getContentPane().add(lblNewLabel_2, BorderLayout.CENTER);
		frame.getContentPane().add(lblNewLabel_3, BorderLayout.SOUTH);
		frame.getContentPane().add(lblNewLabel_4, BorderLayout.EAST);
	}

}


