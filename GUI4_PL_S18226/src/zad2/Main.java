/**
 *
 *  @author Piwowarski Łukasz S18226
 *
 */

package zad2;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {
	public int x;
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
		frame.setBounds(100, 100, 310, 152);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		Color[] tablica = {Color.WHITE, Color.BLACK, Color.RED, Color.ORANGE, Color.PINK, Color.BLUE};
		 
		JButton btnButton = new JButton("Button");
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(x==tablica.length){
					x=0;
				}
					
				btnButton.setBackground(tablica[x]);
				x++; 
				 
			}
		});
		btnButton.setBounds(0, 0, 294, 114);
		frame.getContentPane().add(btnButton);
		
	
		
		
		
	}
}
