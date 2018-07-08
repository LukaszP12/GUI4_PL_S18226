/**
 *
 *  @author Piwowarski Łukasz S18226
 *
 */

package zad3;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;

public class Main extends JFrame {
	private static final long serialVersionUID = 4319807158566102153L;
	private JTextArea widok;
	private String tytulRamki = "";

	private Map<String, Color> mapaKolorow = new HashMap<String, Color>();

	public class Main {

  public static void main(String[] args) {
 
		setTitle("Prosty edytor - bez tytułu");
		JPanel panel = new JPanel(new GridLayout(1, 1));
		widok = new JTextArea();
		JScrollPane skrol = new JScrollPane(widok);

		JMenu menu = new JMenu("File");
		createFileMenu(menu);
		JMenu menu1 = new JMenu("Edit");
		JMenu m2 = new JMenu("Adresy");
		createAddressInputMenu(menu1, m2);
		JMenu menu2 = new JMenu("Options");
		JMenu fore = new JMenu("Foreground");
		createFontMenu(fore);
		JMenu back = new JMenu("background");
		createBackMenu(back);
		JMenu size = new JMenu("Font Size");
		createSizeMenu(size);
		menu2.add(back);
		menu2.add(size);
		menu2.add(fore);
		JMenuBar mb = new JMenuBar();
		mb.add(menu);
		mb.add(menu1);
		mb.add(menu2);
		setJMenuBar(mb);

		panel.add(skrol);
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void createSizeMenu(JMenu size) {
		size.add(sizeMenuItem("10"));
		size.add(sizeMenuItem("15"));
		size.add(sizeMenuItem("20"));
		size.add(sizeMenuItem("25"));
		size.add(sizeMenuItem("30"));
	}

	private void createBackMenu(JMenu back) {
		back.add(backMenuItem("Tlo czerwone", Color.red));
		back.add(backMenuItem("Tlo biale", Color.white));
		back.add(backMenuItem("Tlo czarne", Color.black));
		back.add(backMenuItem("Tlo niebieskie", Color.blue));
		back.add(backMenuItem("Tlo zolte", Color.yellow));
		back.add(backMenuItem("Tlo zielone", Color.green));

	}

	private void createFontMenu(JMenu fore) {
		fore.add(fontMenuItem("Czcionka czerwona", Color.red));
		fore.add(fontMenuItem("Czcionka biala", Color.white));
		fore.add(fontMenuItem("Czcionka czarna", Color.black));
		fore.add(fontMenuItem("Czcionka niebieska", Color.blue));
		fore.add(fontMenuItem("Czcionka zolta", Color.yellow));
		fore.add(fontMenuItem("Czcionka zielona", Color.green));
	}

	private void createAddressInputMenu(JMenu menu1, JMenu m2) {
		m2.add(standardItem("Szkoła", 'k', "control K"));
		m2.add(standardItem("Dom", 'd', "control D"));
		m2.add(standardItem("Praca", 'p', "control P"));
		menu1.add(m2);
	}

	private void createFileMenu(JMenu menu) {
		menu.add(standardItem("Open", 'o', "control O"));
		menu.add(standardItem("Save", 's', "control S"));
		menu.add(standardItem("Save As", 'v', "control V"));	
		menu.add(new RedSeparator());
		menu.add(standardItem("Exit", 'x', "control X"));
	}

	JMenuItem standardItem(String text, int mnemonic, String shortcut) {
		JMenuItem item = new JMenuItem(text);
		item.setBorder(BorderFactory.createEtchedBorder());
		item.setMnemonic(mnemonic);
		item.setAccelerator(KeyStroke.getKeyStroke(shortcut));
		item.addActionListener(this::action);
		item.setActionCommand(text);
		return item;
	}

	JMenuItem backMenuItem(String txt, Color color) {
		JMenuItem item = new JMenuItem(txt);
		item.setIcon(new Ikona(color));
		item.addActionListener(this::action);
		item.setActionCommand("color;back;" + txt);
		mapaKolorow.put("color;back;" + txt, color);
		return item;
	}

	JMenuItem fontMenuItem(String txt, Color color) {
		JMenuItem item = new JMenuItem(txt);
		item.setIcon(new Ikona(color));
		item.addActionListener(this::action);
		item.setActionCommand("color;fore;" + txt);
		mapaKolorow.put("color;fore;" + txt, color);
		return item;
	}

	JMenuItem sizeMenuItem(String txt) {
		JMenuItem item = new JMenuItem(txt + " pts");
		item.addActionListener(this::action);
		item.setActionCommand("size;" + txt);
		return item;
	}

	public static void main(String[] args) {
		new Main();

	}

	public void action(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		if (actionCommand.equals("Save")) {
			if (tytulRamki != null) {
				save();
			} else {
				saveAs();
			}
		}
		if (actionCommand.equals("Save As")) {
			saveAs();
		}
		if (actionCommand.equals("Open")) {
			open();
		}
		if (actionCommand.equals("Exit")) {
			System.exit(1);
		}

		if (actionCommand.equals("Szkoła")) {
			widok.append("Koszykowa 86");
		}
		if (actionCommand.equals("Dom")) {
			widok.append("Twarda 2/4");
		}
		if (actionCommand.equals("Praca")) {
			widok.append("Sienna 19");
		}
		if (actionCommand.contains(";back;")) {
			widok.setBackground(mapaKolorow.get(actionCommand));
		}
		if (actionCommand.contains(";fore;")) {
			widok.setForeground(mapaKolorow.get(actionCommand));
		}
		if (actionCommand.startsWith("size")) {
			widok.setFont(new Font("Arial", Font.BOLD, Integer.parseInt(actionCommand.split(";")[1])));
		}
	}

	private void open() {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		try (Scanner reader = new Scanner(new FileReader(chooser.getSelectedFile()))) {
			StringBuilder sb = new StringBuilder();
			while (reader.hasNextLine()) {
				sb.append(reader.nextLine()).append("\r\n");
			}
			widok.setText(sb.toString());
			setTitle(chooser.getSelectedFile().getAbsolutePath());
			tytulRamki = chooser.getSelectedFile().getAbsolutePath();
		} catch (Exception e) {
		}
	}

	private void saveAs() {
		JFileChooser chooser = new JFileChooser();
		chooser.showSaveDialog(null);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(chooser.getSelectedFile()))) {
			bw.write(widok.getText());
			setTitle(chooser.getSelectedFile().getAbsolutePath());
			tytulRamki = chooser.getSelectedFile().getAbsolutePath();
		} catch (Exception e) {
		}
	}

	private void save() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(tytulRamki))) {
			bw.write(widok.getText().replaceAll("\n", "\r\n"));
		} catch (Exception e) {
		}
	}

	public static class RedSeparator extends JMenuItem {
		private static final long serialVersionUID = 6439511248345767036L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.red);
			g2d.setStroke(new BasicStroke(4.0f));
			g2d.drawLine(0, 5, 90, 5);
		}

	}

}



 }
}
