package pack;

import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class NotePad {

	private JFrame frmNotepad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotePad window = new NotePad();
					window.frmNotepad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public NotePad() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNotepad = new JFrame();
		frmNotepad.setTitle("Notepad");
		frmNotepad.setBounds(100, 100, 450, 300);
		frmNotepad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNotepad.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 261);
		frmNotepad.getContentPane().add(scrollPane);
		JTextArea txtNote = new JTextArea();
		scrollPane.setViewportView(txtNote);
		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);
		JMenu FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		JMenuItem newitem = new JMenuItem("New File");
		newitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNote.setText("");
			}
		});
		FileMenu.add(newitem);
		JMenuItem openitem = new JMenuItem("Open File");
		openitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser open = new JFileChooser();
				int choice = open.showOpenDialog(openitem);
				if(choice == JFileChooser.APPROVE_OPTION)
				{
					try {
						Scanner sc = new Scanner(new FileReader(open.getSelectedFile().getPath()));
						
						JOptionPane.showMessageDialog(null, "File opened");
						
						while (sc.hasNext()) {
							txtNote.append(sc.nextLine() +"\n");
						}
					} 
					catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		FileMenu.add(openitem);
		JMenuItem saveitem = new JMenuItem("Save");
		saveitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser save = new JFileChooser();
				int choice = save.showOpenDialog(saveitem);
				if(choice == JFileChooser.APPROVE_OPTION)
				{
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
						bw.write(txtNote.getText());
						bw.close();
						JOptionPane.showMessageDialog(null, "File saved");
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		FileMenu.add(saveitem);
		JMenu FormatMenu = new JMenu("Format");
		menuBar.add(FormatMenu);
		JMenuItem textsytlitem = new JMenuItem("Text  Style");
		FormatMenu.add(textsytlitem);
		JMenuItem pasteitem = new JMenuItem("Paste");
		FormatMenu.add(pasteitem);
		JMenuItem copyitem = new JMenuItem("Copy");
		FormatMenu.add(copyitem);
	}

}
