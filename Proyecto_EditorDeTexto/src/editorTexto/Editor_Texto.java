package editorTexto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;

public class Editor_Texto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoEditorTexto mimarco = new MarcoEditorTexto();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mimarco.setLocationRelativeTo(null);

		mimarco.setResizable(false);
	}

}

class MarcoEditorTexto extends JFrame {

	public MarcoEditorTexto() {

		setBounds(0, 1, 512, 480);

		setTitle("Editor De Texto");

		Image icono = Toolkit.getDefaultToolkit().getImage("src/editorTexto/icono.jpg");

		this.setIconImage(icono);

		add(new LaminaEditorTexto());

		setVisible(true);
	}
}

class LaminaEditorTexto extends JPanel {

	public LaminaEditorTexto() {

		setLayout(new BorderLayout());

		// Panel 1 Barra

		panelMenu = new JPanel();

		miBarra = new JMenuBar();

		// Menu Fuente

		fuente = new JMenu("Fuente");

		arial = new JMenuItem("Arial");

		courier = new JMenuItem("Courier");

		verdana = new JMenuItem("Verdana");

		arial.addActionListener(new StyledEditorKit.FontFamilyAction("Arial", "Arial"));
		fuente.add(arial);

		courier.addActionListener(new StyledEditorKit.FontFamilyAction("Courier", "Courier"));
		fuente.add(courier);

		verdana.addActionListener(new StyledEditorKit.FontFamilyAction("Verdana", "Verdana"));
		fuente.add(verdana);

		miBarra.add(fuente);

		// Menu Estilo

		estilo = new JMenu("Estilo");

		negrita = new JMenuItem("Negrita", new ImageIcon("src/editorTexto/negrita.jpg"));

		cursiva = new JMenuItem("Cursiva", new ImageIcon("src/editorTexto/cursiva.jpg"));

		negrita.addActionListener(new StyledEditorKit.BoldAction());
		negrita.setToolTipText("ALT N");
		estilo.add(negrita);

		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		cursiva.setToolTipText("ALT C");
		estilo.add(cursiva);

		miBarra.add(estilo);

		// Menu Tamaño

		ButtonGroup radioButton = new ButtonGroup();

		tamano = new JMenu("Tamaño");

		doce = new JRadioButtonMenuItem("12");

		dieciseis = new JRadioButtonMenuItem("16");

		dieciocho = new JRadioButtonMenuItem("18");

		veinte = new JRadioButtonMenuItem("20");

		doce.addActionListener(new StyledEditorKit.FontSizeAction("doce", 12));
		tamano.add(doce);

		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("doce", 16));
		tamano.add(dieciseis);

		dieciocho.addActionListener(new StyledEditorKit.FontSizeAction("doce", 18));
		tamano.add(dieciocho);

		veinte.addActionListener(new StyledEditorKit.FontSizeAction("doce", 20));
		tamano.add(veinte);

		radioButton.add(doce);
		radioButton.add(dieciseis);
		radioButton.add(dieciocho);
		radioButton.add(veinte);

		miBarra.add(tamano);

		// PANEL 2 TEXTO

		panelTexto = new JPanel();

		Texto = new JTextPane();

		Texto.setPreferredSize(new Dimension(425, 384));

		JScrollPane scroll = new JScrollPane(Texto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		panelTexto.add(Box.createGlue());

		panelTexto.add(scroll);

		add(panelTexto, BorderLayout.CENTER);

		panelMenu.add(miBarra);

		add(panelMenu, BorderLayout.NORTH);

		// PANEL 3 MENU HERRAMIENTAS
		// ---------------------------------

		panelJMenu = new JPanel();

		herramientas = new JToolBar(JToolBar.VERTICAL);

		negritaM = new JButton(new ImageIcon("src/editorTexto/negrita.jpg"));

		cursivaM = new JButton(new ImageIcon("src/editorTexto/cursiva.jpg"));

		subrayadoM = new JButton(new ImageIcon("src/editorTexto/subrayado.jpg"));

		/////////////////////////////////////////

		azulM = new JButton(new ImageIcon("src/editorTexto/azul.jpg"));

		rojoM = new JButton(new ImageIcon("src/editorTexto/rojo.jpg"));

		amarilloM = new JButton(new ImageIcon("src/editorTexto/amarillo.jpg"));

		negroM = new JButton(new ImageIcon("src/editorTexto/negro.jpg"));

		////////////////////////////////////////////

		alineacion1M = new JButton(new ImageIcon("src/editorTexto/libre.jpg"));

		alineacion2M = new JButton(new ImageIcon("src/editorTexto/centrado.jpg"));

		alineacion3M = new JButton(new ImageIcon("src/editorTexto/derecha.jpg"));

		alineacion4M = new JButton(new ImageIcon("src/editorTexto/izquierda.jpg"));

		// AGREGANDO A LA BARRA DE HERRAMIENTAS

		negritaM.addActionListener(new StyledEditorKit.BoldAction());
		negritaM.setMnemonic(KeyEvent.VK_N);
		negritaM.setToolTipText("ALT N");
		herramientas.add(negritaM);

		cursivaM.addActionListener(new StyledEditorKit.ItalicAction());
		cursivaM.setMnemonic(KeyEvent.VK_C);
		cursivaM.setToolTipText("ALT C");
		herramientas.add(cursivaM);

		subrayadoM.addActionListener(new StyledEditorKit.UnderlineAction());
		subrayadoM.setMnemonic(KeyEvent.VK_S);
		subrayadoM.setToolTipText("ALT S");
		herramientas.add(subrayadoM);

		herramientas.addSeparator();
		// --------------------------------

		azulM.addActionListener(new StyledEditorKit.ForegroundAction("cambia_color", Color.BLUE));
		azulM.setToolTipText("Pone El Texto En Azul");
		herramientas.add(azulM);

		rojoM.addActionListener(new StyledEditorKit.ForegroundAction("cambia_color", Color.red));
		rojoM.setToolTipText("Pone El Texto En Rojo");
		herramientas.add(rojoM);

		amarilloM.addActionListener(new StyledEditorKit.ForegroundAction("cambia_color", Color.yellow));
		amarilloM.setToolTipText("Pone El Texto En Amarillo");
		herramientas.add(amarilloM);

		negroM.addActionListener(new StyledEditorKit.ForegroundAction("cambia_color", Color.black));
		negroM.setToolTipText("Pone El Texto En negro");
		herramientas.add(negroM);

		herramientas.addSeparator();
		// --------------------------------

		alineacion1M.addActionListener(new StyledEditorKit.AlignmentAction("alinea", 0));
		alineacion1M.setToolTipText("Texto En Alineacion Libre");
		herramientas.add(alineacion1M);

		alineacion2M.addActionListener(new StyledEditorKit.AlignmentAction("alinea", 1));
		alineacion2M.setToolTipText("Texto En Alineacion Centrado");
		herramientas.add(alineacion2M);

		alineacion3M.addActionListener(new StyledEditorKit.AlignmentAction("alinea", 2));
		alineacion3M.setToolTipText("Texto En Alineacion Derecha");
		herramientas.add(alineacion3M);

		alineacion4M.addActionListener(new StyledEditorKit.AlignmentAction("alinea", 3));
		alineacion4M.setToolTipText("Texto En Alineacion Izquierda");
		herramientas.add(alineacion4M);

		// ACCESO RAPIDO HERRAMIENTAS ALINEACION

		acceso = new JPopupMenu();

		aDEF = new JMenuItem("Alineacion Default");

		aC = new JMenuItem("Alineacion Centrado");

		aD = new JMenuItem("Alineacion Derecha");

		aI = new JMenuItem("Alineacion Izquierda");

		aDEF.addActionListener(new StyledEditorKit.AlignmentAction("alinea", 0));
		acceso.add(aDEF);

		aC.addActionListener(new StyledEditorKit.AlignmentAction("alinea", 1));
		acceso.add(aC);

		aD.addActionListener(new StyledEditorKit.AlignmentAction("alinea", 2));
		acceso.add(aD);

		aI.addActionListener(new StyledEditorKit.AlignmentAction("alinea", 3));
		acceso.add(aI);

		Texto.setComponentPopupMenu(acceso);

		// AGREGO HERRAMIENTAS A PANEL

		panelJMenu.add(herramientas);

		add(panelJMenu, BorderLayout.WEST);

	}

	JPanel panelMenu, panelTexto, panelJMenu;

	JTextPane Texto;

	JScrollPane pane;

	JMenuBar miBarra, miBarra2;

	JMenu fuente, estilo, tamano, ColoresFondoTexto;

	JMenuItem arial, courier, verdana, negrita, cursiva, aDEF, aC, aD, aI;

	JRadioButtonMenuItem doce, dieciseis, dieciocho, veinte;

	JButton negritaM, cursivaM, subrayadoM, negroM, azulM, rojoM, amarilloM, alineacion1M, alineacion2M, alineacion3M,
			alineacion4M;

	JToolBar herramientas;

	JPopupMenu acceso;

}
