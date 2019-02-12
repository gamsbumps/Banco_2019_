package com.qualiti.banco.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.fachada.Fachada;
import com.qualiti.banco.modelo.Cliente;
import com.qualiti.banco.modelo.Endereco;
import com.qualiti.banco.util.DateUtil;

public class ClienteCadastrarPanel extends JPanel {
	private JTextField nomeTxt;
	private JTextField loginTxt;
	private JPasswordField senhaTxt;
	private JTextField emailTxt;
	private JTextField telefoneTxt;
	private JTextField logradouroTxt;
	private JTextField numeroTxt;
	private JTextField complementoTxt;
	private JTextField bairroTxt;
	private JTextField cidadeTxt;
	private JFormattedTextField cpfTxt;
	private JComboBox<String> ufcb;
	private JFormattedTextField cepTxt;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JButton btnProcurar;
	private JButton btnRemover;
	private JTextField dataNascimentoTxt;

	/**
	 * Create the panel.
	 */
	public ClienteCadastrarPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(29, 42, 46, 14);
		add(lblNewLabel);

		nomeTxt = new JTextField();
		nomeTxt.setBounds(85, 39, 247, 20);
		add(nomeTxt);
		nomeTxt.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(29, 11, 46, 14);
		add(lblCpf);

		cpfTxt = new JFormattedTextField();
		cpfTxt.setBounds(85, 8, 128, 20);
		add(cpfTxt);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(29, 73, 32, 14);
		add(lblLogin);

		loginTxt = new JTextField();
		loginTxt.setBounds(85, 70, 184, 20);
		add(loginTxt);
		loginTxt.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(336, 73, 37, 14);
		add(lblSenha);

		senhaTxt = new JPasswordField();
		senhaTxt.setBounds(383, 70, 129, 20);
		add(senhaTxt);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(29, 104, 46, 14);
		add(lblEmail);

		emailTxt = new JTextField();
		emailTxt.setBounds(85, 101, 247, 20);
		add(emailTxt);
		emailTxt.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(29, 135, 46, 14);
		add(lblTelefone);

		telefoneTxt = new JTextField();
		telefoneTxt.setBounds(85, 132, 117, 20);
		add(telefoneTxt);
		telefoneTxt.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(230, 267, -185, 2);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(29, 227, 509, 2);
		add(separator_1);

		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o");
		lblNewLabel_1.setBounds(29, 227, 46, 14);
		add(lblNewLabel_1);

		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(42, 267, 64, 14);
		add(lblLogradouro);

		logradouroTxt = new JTextField();
		logradouroTxt.setBounds(116, 264, 347, 20);
		add(logradouroTxt);
		logradouroTxt.setColumns(10);

		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(60, 299, 46, 14);
		add(lblNmero);

		numeroTxt = new JTextField();
		numeroTxt.setBounds(116, 296, 86, 20);
		add(numeroTxt);
		numeroTxt.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(330, 299, 75, 14);
		add(lblComplemento);

		complementoTxt = new JTextField();
		complementoTxt.setBounds(415, 295, 97, 20);
		add(complementoTxt);
		complementoTxt.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(74, 339, 32, 14);
		add(lblBairro);

		bairroTxt = new JTextField();
		bairroTxt.setBounds(116, 336, 86, 20);
		add(bairroTxt);
		bairroTxt.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(379, 339, 37, 14);
		add(lblCidade);

		cidadeTxt = new JTextField();
		cidadeTxt.setBounds(426, 336, 86, 20);
		add(cidadeTxt);
		cidadeTxt.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(78, 382, 28, 14);
		add(lblCep);

		cepTxt = new JFormattedTextField();
		cepTxt.setBounds(116, 379, 86, 20);
		add(cepTxt);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(443, 339, 46, 14);
		add(lblUf);

		ufcb = new JComboBox<>();

		ufcb.addItem("");
		ufcb.addItem("AL");
		ufcb.addItem("PE");
		ufcb.addItem("SP");
		ufcb.addItem("MG");
		ufcb.setBounds(426, 379, 86, 20);
		add(ufcb);

		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String cpf = cpfTxt.getText();

				try {
					Cliente clienteBusca = Fachada.getFachada().procurar(cpf);

					if (clienteBusca != null) {
						nomeTxt.setText(clienteBusca.getNome());
						emailTxt.setText(clienteBusca.getEmail());
					} else {
						JOptionPane.showMessageDialog(null, "CPF não cadastrado", "Cadastrar Cliente",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (BancoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Cadastrar Cliente", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
		btnProcurar.setBounds(243, 5, 89, 23);
		add(btnProcurar);

		btnRemover = new JButton("Remover");
		btnRemover.setBounds(357, 7, 89, 23);
		add(btnRemover);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String cpf = cpfTxt.getText();
				String nome = nomeTxt.getText();
				String login = loginTxt.getText();
				String senha = new String(senhaTxt.getPassword());
				String telefone = telefoneTxt.getText();
				String email = emailTxt.getText();
				String dataNascimento = dataNascimentoTxt.getText();

				try {
					LocalDate dataNascimentoDate = DateUtil.converterTextoData(dataNascimento);

					String logradouro = logradouroTxt.getText();
					String numero = numeroTxt.getText();
					String complemento = complementoTxt.getText();
					String bairro = bairroTxt.getText();
					String cidade = cidadeTxt.getText();
					String cep = cepTxt.getText();
					String uf = (String) ufcb.getSelectedItem();

					Endereco end = new Endereco();
					end.setLogradouro(logradouro);
					end.setNumero(numero);
					end.setComplemento(complemento);
					end.setBairro(bairro);
					end.setCidade(cidade);
					end.setCep(cep);
					end.setUf(uf);

					Cliente cliente = new Cliente();
					cliente.setCpf(cpf);
					cliente.setNome(nome);
					cliente.setDataNascimento(dataNascimentoDate);
					cliente.setLogin(login);
					cliente.setSenha(senha);
					cliente.setEmail(email);
					cliente.setTelefone(telefone);

					cliente.setEndereco(end);

					Fachada.getFachada().inserirCliente(cliente);
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Cadastrar cliente",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (BancoException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Cadastrar Cliente",
							JOptionPane.ERROR_MESSAGE);

				} catch (DateTimeParseException ex) {
					JOptionPane.showMessageDialog(null, "Data inválida", "Cadastrar Cliente",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btnCadastrar.setBounds(124, 430, 89, 23);
		add(btnCadastrar);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(357, 430, 89, 23);
		add(btnAtualizar);

		JLabel lblNewLabel_2 = new JLabel("Data de nascimento:");
		lblNewLabel_2.setBounds(29, 176, 104, 14);
		add(lblNewLabel_2);

		dataNascimentoTxt = new JTextField();
		dataNascimentoTxt.setBounds(143, 170, 104, 20);
		add(dataNascimentoTxt);
		dataNascimentoTxt.setColumns(10);

	}
}
