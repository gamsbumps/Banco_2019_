package com.qualiti.banco.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BancoTelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BancoTelaPrincipal window = new BancoTelaPrincipal();
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
	public BancoTelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//para aparecer na tela(frame) principal
				
				ClienteCadastrarPanel cadastrarPanel = new ClienteCadastrarPanel();
				frame.setContentPane(cadastrarPanel);;
				frame.revalidate();
			}
		});
		mnClientes.add(mntmCadastrar);
		
		JMenu mnContas = new JMenu("Contas");
		menuBar.add(mnContas);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener() {//para aparecer na tela(frame) principal
			public void actionPerformed(ActionEvent e) {
				ContaCadastrarPanel cadastrarpanel1 = new ContaCadastrarPanel();
				frame.setContentPane(cadastrarpanel1);
				frame.revalidate();
			}
		});
		mnContas.add(mntmCadastrar_1);
		
		JMenu mnTransaes = new JMenu("Transa\u00E7\u00F5es");
		menuBar.add(mnTransaes);
		
		JMenuItem mntmMovimentaes = new JMenuItem("Movimenta\u00E7\u00F5es");
		mnTransaes.add(mntmMovimentaes);
		
		JMenuItem mntmExtrato = new JMenuItem("Extrato");
		mnTransaes.add(mntmExtrato);
		
		frame.setLocationRelativeTo(null);
	}
}
