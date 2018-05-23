package Pacote;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextComponent;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.text.BadLocationException;
import javax.swing.event.AncestorEvent;
import java.lang.*;
import java.util.Scanner;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;

public class JogoDaForcaSwing {

	
	private JFrame frmJogo;
	private JButton btnJogar;
	private JTextField campoPalavra;
	private JButton btnTentar;	
	private jogoDaForca jogo;
	private JTextField textDica;
	private JTextField Letra;
	private JButton btnReiniciar;
	private JTextField textField;
	private JLabel lblAcertos;
	private JLabel lblErros;
	private JLabel lblPalavra;
	private JLabel lblTam;
	private JLabel imagemF;
	
	String[] nomes = {"forca0.png","forca1.png","forca2.png","forca3.png","forca4.png","forca5.png","forca6.png"};
	
	private JButton btnQ;
	private JButton btnW;
	private JButton btnE;
	private JButton btnR;
	private JButton btnT;
	private JButton btnY;
	private JButton btnU;
	private JButton btnI;
	private JButton btnO;
	private JButton btnP;
	private JButton btnA;
	private JButton btnS;
	private JButton btnD;
	private JButton btnF;
	private JButton btnG;
	private JButton btnH;
	private JButton btnJ;
	private JButton btnK;
	private JButton btnL;
	private JButton btnZ;
	private JButton btnX;
	private JButton btnC;
	private JButton btnV;
	private JButton btnB;
	private JButton btnN;
	private JButton btnM;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoDaForcaSwing window = new JogoDaForcaSwing();
					window.frmJogo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JogoDaForcaSwing() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		jogo = new jogoDaForca("teste.txt");
		
		jogo.inicializar();
		
		//ImageIcon icon = new ImageIcon(jogoDaForca.class.getResource("/img/1.bmp"));
		//Icon.setImage(icon.getImage().getScaledInstance(imagem.getWidth(), imagem.getHeight(), 1));
		//imagem.setIcon(icon);
		
		
		frmJogo = new JFrame();
		frmJogo.getContentPane().setForeground(new Color(255, 255, 255));
		frmJogo.setTitle("JOGO DA FORCA");
		frmJogo.setBounds(100, 100, 940, 541);
		frmJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJogo.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmJogo.getContentPane().setLayout(null);
		
		
		lblAcertos = new JLabel("Acertos:");
		lblAcertos.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblAcertos.setBounds(7, 11, 99, 14);
		frmJogo.getContentPane().add(lblAcertos);
		
		lblErros = new JLabel("Erros:");
		lblErros.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblErros.setBounds(7, 35, 99, 14);
		frmJogo.getContentPane().add(lblErros);
		
		JLabel lblNewLabel = new JLabel("Dica:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel.setBounds(145, 10, 46, 16);
		frmJogo.getContentPane().add(lblNewLabel);
				
		campoPalavra = new JTextField();
		frmJogo.getContentPane().add(campoPalavra);
		
		
		
		JButton btnIniciar = new JButton("INICIAR JOGO");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tam = jogo.getTamanho();
				
				jogo.inicializar();
				textDica.setText(jogo.getDica());
				
				lblTam.setText("Tamanho: "+jogo.getTamanho());
				btnIniciar.setEnabled(false);
			}
		});
		btnIniciar.setBounds(114, 77, 123, 23);
		frmJogo.getContentPane().add(btnIniciar);
		
		
		btnTentar = new JButton("TENTAR A SORTE");
		btnTentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String palavra = textField.getText();
				
				if(jogo.getPalavraSort().equals(palavra)){
					JOptionPane.showMessageDialog(null, "Você Venceu");
					btnJogar.setEnabled(false);
					btnTentar.setEnabled(false);
					btnIniciar.setEnabled(false);
				//	textArea.getText(jogo.getTamanho());
					lblAcertos.setText("Acertos: "+jogo.getTamanho());
					lblPalavra.setText(jogo.getPalavraSort());
				}				
				else {
					JOptionPane.showMessageDialog(null, "Você perdeu");
					btnJogar.setEnabled(false);
					btnTentar.setEnabled(false);
					btnIniciar.setEnabled(false);
					lblPalavra.setText(jogo.getPalavraSort());
					
					//lblErros.setText("Erros: "+jogo.getTamanho());
					lblErros.setText("Erros: "+palavra.length());
				}										
			}
		});
		btnTentar.setBounds(7, 200, 190, 20);
		frmJogo.getContentPane().add(btnTentar);
		
		btnJogar = new JButton("TENTAR");
		btnJogar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_ENTER) {
					
					
	
				}
			}
		});
		
		btnJogar.addActionListener(new ActionListener() {	
				public void actionPerformed(ActionEvent e) {			
					String letra;
					
					int[] indices;		   
					    letra = Letra.getText();
					    indices = jogo.jogar(letra);
					    
					    lblAcertos.setText("Acertos: "+jogo.getAcertos());
					    
					    lblErros.setText("Erros: "+jogo.getErros());
					    
					   lblPalavra.setText(jogo.getPalavraSort());
					   
					 
					    if(jogo.getErros()>5) {		
					    	lblPalavra.setText(jogo.getPalavraSort());
					    	JOptionPane.showMessageDialog(null, "Você Perdeu");
					    	btnJogar.setEnabled(false);
							btnTentar.setEnabled(false);
					    }
					    if(jogo.getAcertos()==jogo.getTamanho()) {
					    	lblPalavra.setText(jogo.getPalavraSort());
					    	JOptionPane.showMessageDialog(null, "Você venceu!!");
					    	btnJogar.setEnabled(false);
							btnTentar.setEnabled(false);
					    }
					    imagemF.setIcon(new ImageIcon(JogoDaForcaSwing.class.getResource("/img/"+nomes[jogo.getErros()])));
		}		
		});
		btnJogar.setBounds(7, 145, 80, 32);
		frmJogo.getContentPane().add(btnJogar);
		
		//****************************
		btnQ = new JButton("Q");
		btnQ.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_Q) {
					Letra.setText("Q");
					btnQ.setEnabled(false);
	
				}
				
			  
			}
			
		});
		btnQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("Q");
				btnQ.setEnabled(false);
				
			}
		});
		btnQ.setBounds(15, 320, 72, 32);
		frmJogo.getContentPane().add(btnQ);
		
		
		btnW = new JButton("W");
		btnW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("W");
				btnW.setEnabled(false);
			}
		});
		btnW.setBounds(105, 320, 72, 32);
		frmJogo.getContentPane().add(btnW);
		
		
		btnE = new JButton("E");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("E");
				btnE.setEnabled(false);
			}
		});
		btnE.setBounds(197, 320, 72, 32);
		frmJogo.getContentPane().add(btnE);
		
		btnR = new JButton("R");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("R");
				btnR.setEnabled(false);
			}
		});
		btnR.setBounds(289, 320, 72, 32);
		frmJogo.getContentPane().add(btnR);
		
		btnT = new JButton("T");
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("T");
				btnT.setEnabled(false);
			}
		});
		btnT.setBounds(381, 320, 72, 32);
		frmJogo.getContentPane().add(btnT);
		

		btnY = new JButton("Y");
		btnY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("Y");
				btnY.setEnabled(false);
			}
		});
		btnY.setBounds(473, 320, 72, 32);
		frmJogo.getContentPane().add(btnY);
		
		btnU = new JButton("U");
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("U");
				btnU.setEnabled(false);
			}
		});
		btnU.setBounds(565, 320, 72, 32);
		frmJogo.getContentPane().add(btnU);
		
		btnI = new JButton("I");
		btnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("I");
				btnI.setEnabled(false);
			}
		});
		btnI.setBounds(660, 320, 72, 32);
		frmJogo.getContentPane().add(btnI);
		
		
		btnO = new JButton("O");
		btnO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("O");
				btnO.setEnabled(false);
			}
		});
		btnO.setBounds(752, 320, 72, 32);
		frmJogo.getContentPane().add(btnO);
		
		btnP = new JButton("P");
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("P");
				btnP.setEnabled(false);
				
			}
		});
		btnP.setBounds(842, 320, 72, 32);
		frmJogo.getContentPane().add(btnP);
		
		btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("A");
				btnA.setEnabled(false);
			}
		});
		btnA.setBounds(68, 373, 72, 32);
		frmJogo.getContentPane().add(btnA);
		
		btnS = new JButton("S");
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("S");
				btnS.setEnabled(false);
			}
		});
		btnS.setBounds(159, 373, 72, 32);
		frmJogo.getContentPane().add(btnS);
		
		btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("D");
				btnD.setEnabled(false);
			}
		});
		btnD.setBounds(250, 373, 72, 32);
		frmJogo.getContentPane().add(btnD);
		
		btnF = new JButton("F");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("F");
				btnF.setEnabled(false);
			}
		});
		btnF.setBounds(341, 373, 72, 32);
		frmJogo.getContentPane().add(btnF);
		
		btnG = new JButton("G");
		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("G");
				btnG.setEnabled(false);
			}
		});
		btnG.setBounds(431, 373, 72, 32);
		frmJogo.getContentPane().add(btnG);
		
		btnH = new JButton("H");
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("H");
				btnH.setEnabled(false);
			}
		});
		btnH.setBounds(523, 373, 72, 32);
		frmJogo.getContentPane().add(btnH);
		
		btnJ = new JButton("J");
		btnJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("J");
				btnJ.setEnabled(false);
			}
		});
		btnJ.setBounds(614, 373, 72, 32);
		frmJogo.getContentPane().add(btnJ);
		
		btnK = new JButton("K");
		btnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("K");
				btnK.setEnabled(false);
			}
		});
		btnK.setBounds(707, 373, 72, 32);
		frmJogo.getContentPane().add(btnK);
		
		btnL = new JButton("L");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("L");
				btnL.setEnabled(false);
			}
		});
		btnL.setBounds(802, 373, 72, 32);
		frmJogo.getContentPane().add(btnL);
		
		btnZ = new JButton("Z");
		btnZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("Z");
				btnZ.setEnabled(false);
			}
		});
		btnZ.setBounds(145, 426, 72, 32);
		frmJogo.getContentPane().add(btnZ);
		
		btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("X");
				btnX.setEnabled(false);
			}
		});
		btnX.setBounds(248, 426, 72, 32);
		frmJogo.getContentPane().add(btnX);
		
		btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("C");
				btnC.setEnabled(false);
			}
		});
		btnC.setBounds(350, 426, 72, 32);
		frmJogo.getContentPane().add(btnC);
		
		btnV = new JButton("V");
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("V");
				btnV.setEnabled(false);
			}
		});
		btnV.setBounds(448, 426, 72, 32);
		frmJogo.getContentPane().add(btnV);
		
		btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("B");
				btnB.setEnabled(false);
			}
		});
		btnB.setBounds(547, 426, 72, 32);
		frmJogo.getContentPane().add(btnB);
		
		btnN = new JButton("N");
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("N");
				btnN.setEnabled(false);
			}
		});
		btnN.setBounds(644, 426, 72, 32);
		frmJogo.getContentPane().add(btnN);
		
		btnM = new JButton("M");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letra.setText("M");
				btnM.setEnabled(false);
			}
		});
		btnM.setBounds(736, 426, 72, 32);
		frmJogo.getContentPane().add(btnM);
		
		//***********************************************************************************************************************
		
		btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jogo.inicializar();
				textDica.setText("");
				Letra.setText("");
				textField.setText("");
				lblAcertos.setText("Acertos: ");
				lblErros.setText("Erros: ");
				lblPalavra.setText("");
				lblTam.setText("Tamanho: ");
				btnJogar.setEnabled(true);
				btnTentar.setEnabled(true);	
				btnIniciar.setEnabled(true);
				btnQ.setEnabled(true);
				btnW.setEnabled(true);
				btnE.setEnabled(true);
				btnR.setEnabled(true);
				btnT.setEnabled(true);
				btnY.setEnabled(true);
				btnU.setEnabled(true);
				btnI.setEnabled(true);
				btnO.setEnabled(true);
				btnP.setEnabled(true);
				btnA.setEnabled(true);
				btnS.setEnabled(true);
				btnD.setEnabled(true);
				btnF.setEnabled(true);
				btnG.setEnabled(true);
				btnH.setEnabled(true);
				btnJ.setEnabled(true);
				btnK.setEnabled(true);
				btnL.setEnabled(true);
				btnZ.setEnabled(true);
				btnX.setEnabled(true);
				btnC.setEnabled(true);
				btnV.setEnabled(true);
				btnB.setEnabled(true);
				btnN.setEnabled(true);
				btnM.setEnabled(true);
				imagemF.setIcon(new ImageIcon(JogoDaForcaSwing.class.getResource("/img/forca0.png")));
						
				
			}
		});
		btnReiniciar.setBounds(207, 145, 123, 32);
		frmJogo.getContentPane().add(btnReiniciar);
		
		textDica = new JTextField();
		textDica.setBounds(195, 10, 135, 20);
		frmJogo.getContentPane().add(textDica);
		textDica.setColumns(10);
		
		Letra = new JTextField();
		Letra.setBounds(97, 145, 39, 32);
		frmJogo.getContentPane().add(Letra);
		Letra.setColumns(10);
		
		lblPalavra = new JLabel("");
		lblPalavra.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalavra.setBounds(0, 111, 237, 23);
		frmJogo.getContentPane().add(lblPalavra);
		
		textField = new JTextField();
		textField.setBounds(207, 200, 123, 20);
		frmJogo.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblTam = new JLabel("");
		lblTam.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblTam.setBounds(7, 60, 129, 16);
		frmJogo.getContentPane().add(lblTam);
		
		imagemF = new JLabel("");
		imagemF.setBounds(468, 0, 300, 288);
		frmJogo.getContentPane().add(imagemF);
		
		imagemF.setIcon(new ImageIcon(JogoDaForcaSwing.class.getResource("/img/forca0.png")));
				
		//******************************************************************************************************	
	}
}
		






		
	