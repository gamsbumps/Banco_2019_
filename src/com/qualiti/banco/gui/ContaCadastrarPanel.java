package com.qualiti.banco.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.fachada.Fachada;
import com.qualiti.banco.modelo.Cliente;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.ContaBonus;
import com.qualiti.banco.modelo.Poupança;
import com.qualiti.banco.modelo.TipoConta;
import javax.swing.ButtonGroup;

public class ContaCadastrarPanel extends JPanel {
	private JTextField numeroTxt;
	private JLabel lblCpf;
	private JLabel lblTipo;
	private JLabel lblNumero;
	private JRadioButton rdbtnCorrente;
	private JRadioButton rdbtnPoupanca;
	private JRadioButton rdbtnBonus;
	private JButton btnProcurar;
	private JButton btnRemover;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JTextField saldoTxt;
	private JLabel lblSaldo;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public ContaCadastrarPanel() {
		setLayout(null);

		lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(10, 27, 46, 14);
		add(lblNumero);

		lblCpf = new JLabel("CPF:");
		lblCpf.setEnabled(false);
		lblCpf.setBounds(10, 61, 46, 14);
		add(lblCpf);

		JFormattedTextField cpfTxt = new JFormattedTextField();
		cpfTxt.setEnabled(false);
		cpfTxt.setBounds(66, 58, 115, 20);
		add(cpfTxt);

		lblTipo = new JLabel("Tipo:");
		lblTipo.setEnabled(false);
		lblTipo.setBounds(10, 147, 46, 14);
		add(lblTipo);

		rdbtnCorrente = new JRadioButton("Corrente");
		buttonGroup.add(rdbtnCorrente);
		rdbtnCorrente.setEnabled(false);
		rdbtnCorrente.setSelected(true);
		rdbtnCorrente.setBounds(10, 185, 109, 23);
		add(rdbtnCorrente);

		rdbtnPoupanca = new JRadioButton("Poupan\u00E7a");
		buttonGroup.add(rdbtnPoupanca);
		rdbtnPoupanca.setEnabled(false);
		rdbtnPoupanca.setBounds(131, 185, 121, 23);
		add(rdbtnPoupanca);

		rdbtnBonus = new JRadioButton("Bonus");
		buttonGroup.add(rdbtnBonus);
		rdbtnBonus.setEnabled(false);
		rdbtnBonus.setBounds(254, 185, 109, 23);
		add(rdbtnBonus);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String cpf = cpfTxt.getText();
				String numero = numeroTxt.getText();
				String saldoTexto = saldoTxt.getText();

				TipoConta tipo = null;

				Conta conta = null;

				if (rdbtnCorrente.isSelected()) {
					tipo = TipoConta.CORRENTE;
					conta = new Conta();
				}

				if (rdbtnPoupanca.isSelected()) {
					tipo = TipoConta.POUPANÇA;
					conta = new Poupança();
				}

				if (rdbtnBonus.isSelected()) {
					tipo = TipoConta.BONUS;
					conta = new ContaBonus();
				}
				try {
					Cliente cliente = Fachada.getFachada().procurar(cpf);

					if (cliente != null) {

						conta.setCliente(cliente);
						conta.setNumero(numero);

						double saldo = Double.parseDouble(saldoTexto);

						conta.setSaldo(saldo);
						conta.setTipo(tipo);

						Fachada.getFachada().inserirConta(conta);
						JOptionPane.showMessageDialog(null, "Conta inserida com sucesso.", "Cadastrar conta",
								JOptionPane.INFORMATION_MESSAGE);

						cpfTxt.setText("");
						numeroTxt.setText("");
						saldoTxt.setText("");
						rdbtnCorrente.setSelected(true);

						lblCpf.setEnabled(false);
						lblSaldo.setEnabled(false);
						lblTipo.setEnabled(false);

						cpfTxt.setEnabled(false);
						saldoTxt.setEnabled(false);

						rdbtnCorrente.setEnabled(false);
						rdbtnBonus.setEnabled(false);
						rdbtnPoupanca.setEnabled(false);

						btnCadastrar.setEnabled(true);
						btnAtualizar.setEnabled(false);
						btnRemover.setEnabled(false);

					} else {
						JOptionPane.showInternalMessageDialog(null, "CPF não cadastrado", "Cadastrar conta",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (BancoException e) {

					JOptionPane.showInternalMessageDialog(null, e.getMessage(), "Cadastrar conta",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(131, 231, 89, 23);
		add(btnCadastrar);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String cpf = cpfTxt.getText();
				String numero = numeroTxt.getText();
				String saldoTexto = saldoTxt.getText();

				TipoConta tipo = null;

				Conta conta = null;

				if (rdbtnCorrente.isSelected()) {
					tipo = TipoConta.CORRENTE;
					conta = new Conta();
				}

				if (rdbtnPoupanca.isSelected()) {
					tipo = TipoConta.POUPANÇA;
					conta = new Poupança();
				}

				if (rdbtnBonus.isSelected()) {
					tipo = TipoConta.BONUS;
					conta = new ContaBonus();
				}
				try {
					Cliente cliente = Fachada.getFachada().procurar(cpf);

					if (cliente != null) {

						conta.setCliente(cliente);
						conta.setNumero(numero);

						double saldo = Double.parseDouble(saldoTexto);

						conta.setSaldo(saldo);
						conta.setTipo(tipo);

						Fachada.getFachada().atualizarConta(conta);
						JOptionPane.showMessageDialog(null, "Conta atualizada com sucesso.", "Atualizar conta",
								JOptionPane.INFORMATION_MESSAGE);

						cpfTxt.setText("");
						numeroTxt.setText("");
						saldoTxt.setText("");
						rdbtnCorrente.setSelected(true);

						lblCpf.setEnabled(false);
						lblSaldo.setEnabled(false);
						lblTipo.setEnabled(false);

						cpfTxt.setEnabled(false);
						saldoTxt.setEnabled(false);

						rdbtnCorrente.setEnabled(false);
						rdbtnBonus.setEnabled(false);
						rdbtnPoupanca.setEnabled(false);

						btnCadastrar.setEnabled(true);
						btnAtualizar.setEnabled(false);
						btnRemover.setEnabled(false);

					} else {
						JOptionPane.showInternalMessageDialog(null, "CPF não cadastrado", "Cadastrar conta",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (BancoException e) {

					JOptionPane.showInternalMessageDialog(null, e.getMessage(), "Cadastrar conta",
							JOptionPane.ERROR_MESSAGE);
				}
			
			}
		});
		btnAtualizar.setEnabled(false);
		btnAtualizar.setBounds(275, 231, 89, 23);
		add(btnAtualizar);

		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String numero = numeroTxt.getText();

				try {
					Conta contaBusca = Fachada.getFachada().procurarConta(numero);

					if (contaBusca != null) {

						cpfTxt.setText(contaBusca.getCliente().getCpf());

						String saldoTexto = Double.toString(contaBusca.getSaldo());

						saldoTxt.setText(saldoTexto);

						TipoConta tipo = contaBusca.getTipo();

						if (tipo.equals(TipoConta.CORRENTE)) {
							rdbtnCorrente.setSelected(true);
						}
						if (tipo.equals(TipoConta.POUPANÇA)) {
							rdbtnPoupanca.setSelected(true);
						}
						if (tipo.equals(TipoConta.BONUS)) {
							rdbtnBonus.setSelected(true);
						}

						lblCpf.setEnabled(true);
						lblSaldo.setEnabled(true);
						lblTipo.setEnabled(true);

						cpfTxt.setEnabled(true);
						saldoTxt.setEnabled(true);

						rdbtnCorrente.setEnabled(true);
						rdbtnBonus.setEnabled(true);
						rdbtnPoupanca.setEnabled(true);

						btnAtualizar.setEnabled(true);
						btnRemover.setEnabled(true);
						btnCadastrar.setEnabled(false);

					} else {
						int escolha = JOptionPane.showConfirmDialog(null, "Conta nao cadastrada. Deseja cadastrar?",
								"Cadastrar conta", JOptionPane.YES_NO_OPTION);
						if (escolha == JOptionPane.YES_OPTION) {
							lblCpf.setEnabled(true);
							lblSaldo.setEnabled(true);
							lblTipo.setEnabled(true);

							cpfTxt.setEnabled(true);
							saldoTxt.setEnabled(true);

							rdbtnCorrente.setEnabled(true);
							rdbtnBonus.setEnabled(true);
							rdbtnPoupanca.setEnabled(true);

							btnAtualizar.setEnabled(false);
							btnRemover.setEnabled(false);
							btnCadastrar.setEnabled(true);
						}
					}

				} catch (BancoException e) {
					JOptionPane.showInternalMessageDialog(null, e.getMessage(), "Procurar conta",
							JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnProcurar.setBounds(223, 23, 89, 23);
		add(btnProcurar);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = numeroTxt.getText();
				
				int escolha = JOptionPane.showConfirmDialog(
						null, "Cliente cadastrado. Deseja remover",
						"Remover cliente",
						JOptionPane.YES_NO_OPTION);
				
				if (escolha == JOptionPane.YES_OPTION) {
					try {
						Fachada.getFachada().removerConta(numero);
						JOptionPane.showMessageDialog(
								null, "Conta removida com sucesso",
								"Remover cliente",
								JOptionPane.INFORMATION_MESSAGE);
						
						
						cpfTxt.setText("");
						numeroTxt.setText("");
						saldoTxt.setText("");
						rdbtnCorrente.setSelected(true);

						lblCpf.setEnabled(false);
						lblSaldo.setEnabled(false);
						lblTipo.setEnabled(false);

						cpfTxt.setEnabled(false);
						saldoTxt.setEnabled(false);

						rdbtnCorrente.setEnabled(false);
						rdbtnBonus.setEnabled(false);
						rdbtnPoupanca.setEnabled(false);

						btnCadastrar.setEnabled(true);
						btnAtualizar.setEnabled(false);
						btnRemover.setEnabled(false);
						
					} catch (BancoException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Remover conta",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnRemover.setEnabled(false);
		btnRemover.setBounds(351, 23, 89, 23);
		add(btnRemover);

		numeroTxt = new JTextField();
		numeroTxt.setBounds(66, 24, 115, 20);
		add(numeroTxt);
		numeroTxt.setColumns(10);

		lblSaldo = new JLabel("Saldo:");
		lblSaldo.setEnabled(false);
		lblSaldo.setBounds(10, 106, 46, 14);
		add(lblSaldo);

		saldoTxt = new JTextField();
		saldoTxt.setEnabled(false);
		saldoTxt.setBounds(66, 103, 86, 20);
		add(saldoTxt);
		saldoTxt.setColumns(10);

	}
}
