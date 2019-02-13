package com.qualiti.banco.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class ContaCadastrarPanel extends JPanel {
	private JTextField numeroTxt;
	private JLabel lblCpf;
	private JLabel lblTipo;
	private JLabel lblNumero;
	private JRadioButton rdbtnCorrente;
	private JRadioButton rdbtnPoupana;
	private JRadioButton rdbtnBonus;
	private JButton btnProcurar;
	private JButton btnRemover;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JTextField saldoTxt;
	private JLabel lblSaldo;

	/**
	 * Create the panel.
	 */
	public ContaCadastrarPanel() {
		setLayout(null);
		
		lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(10, 27, 46, 14);
		add(lblNumero);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 61, 46, 14);
		add(lblCpf);
		
		JFormattedTextField cpfTxt = new JFormattedTextField();
		cpfTxt.setBounds(66, 58, 115, 20);
		add(cpfTxt);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 147, 46, 14);
		add(lblTipo);
		
		rdbtnCorrente = new JRadioButton("Corrente");
		rdbtnCorrente.setSelected(true);
		rdbtnCorrente.setBounds(10, 185, 109, 23);
		add(rdbtnCorrente);
		
		rdbtnPoupana = new JRadioButton("Poupan\u00E7a");
		rdbtnPoupana.setBounds(131, 185, 121, 23);
		add(rdbtnPoupana);
		
		rdbtnBonus = new JRadioButton("Bonus");
		rdbtnBonus.setBounds(254, 185, 109, 23);
		add(rdbtnBonus);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(131, 231, 89, 23);
		add(btnCadastrar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(275, 231, 89, 23);
		add(btnAtualizar);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(223, 23, 89, 23);
		add(btnProcurar);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(351, 23, 89, 23);
		add(btnRemover);
		
		numeroTxt = new JTextField();
		numeroTxt.setBounds(66, 24, 115, 20);
		add(numeroTxt);
		numeroTxt.setColumns(10);
		
		lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(10, 106, 46, 14);
		add(lblSaldo);
		
		saldoTxt = new JTextField();
		saldoTxt.setBounds(66, 103, 86, 20);
		add(saldoTxt);
		saldoTxt.setColumns(10);

	}
}
