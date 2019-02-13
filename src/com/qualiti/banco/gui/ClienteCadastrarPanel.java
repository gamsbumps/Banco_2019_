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
	private JLabel lblNome;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JLabel lblEmail;
	private JLabel lblTelefone;
	private JLabel lbldataNascimento;
	private JLabel lblLogradouro;
	private JLabel lblNmero;
	private JLabel lblComplemento;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblCep;
	private JLabel lblUf;
	private JLabel lblEndereco;
	private JLabel lblCpf;

	/**
	 * Create the panel.
	 */
	public ClienteCadastrarPanel() {
		setLayout(null);

		lblNome = new JLabel("Nome:");
		lblNome.setEnabled(false);
		lblNome.setBounds(29, 42, 46, 14);
		add(lblNome);

		nomeTxt = new JTextField();
		nomeTxt.setEnabled(false);
		nomeTxt.setBounds(85, 39, 247, 20);
		add(nomeTxt);
		nomeTxt.setColumns(10);

		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(29, 11, 46, 14);
		add(lblCpf);

		cpfTxt = new JFormattedTextField();
		cpfTxt.setBounds(85, 8, 128, 20);
		add(cpfTxt);

		lblLogin = new JLabel("Login:");
		lblLogin.setEnabled(false);
		lblLogin.setBounds(29, 73, 32, 14);
		add(lblLogin);

		loginTxt = new JTextField();
		loginTxt.setEnabled(false);
		loginTxt.setBounds(85, 70, 184, 20);
		add(loginTxt);
		loginTxt.setColumns(10);

		lblSenha = new JLabel("Senha:");
		lblSenha.setEnabled(false);
		lblSenha.setBounds(336, 73, 37, 14);
		add(lblSenha);

		senhaTxt = new JPasswordField();
		senhaTxt.setEnabled(false);
		senhaTxt.setBounds(383, 70, 129, 20);
		add(senhaTxt);

		lblEmail = new JLabel("Email:");
		lblEmail.setEnabled(false);
		lblEmail.setBounds(29, 104, 46, 14);
		add(lblEmail);

		emailTxt = new JTextField();
		emailTxt.setEnabled(false);
		emailTxt.setBounds(85, 101, 247, 20);
		add(emailTxt);
		emailTxt.setColumns(10);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setEnabled(false);
		lblTelefone.setBounds(29, 135, 46, 14);
		add(lblTelefone);

		telefoneTxt = new JTextField();
		telefoneTxt.setEnabled(false);
		telefoneTxt.setBounds(85, 132, 117, 20);
		add(telefoneTxt);
		telefoneTxt.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(230, 267, -185, 2);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(29, 227, 509, 2);
		add(separator_1);

		lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setEnabled(false);
		lblEndereco.setBounds(29, 227, 46, 14);
		add(lblEndereco);

		lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setEnabled(false);
		lblLogradouro.setBounds(42, 267, 64, 14);
		add(lblLogradouro);

		logradouroTxt = new JTextField();
		logradouroTxt.setEnabled(false);
		logradouroTxt.setBounds(116, 264, 347, 20);
		add(logradouroTxt);
		logradouroTxt.setColumns(10);

		lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setEnabled(false);
		lblNmero.setBounds(60, 299, 46, 14);
		add(lblNmero);

		numeroTxt = new JTextField();
		numeroTxt.setEnabled(false);
		numeroTxt.setBounds(116, 296, 86, 20);
		add(numeroTxt);
		numeroTxt.setColumns(10);

		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setEnabled(false);
		lblComplemento.setBounds(330, 299, 75, 14);
		add(lblComplemento);

		complementoTxt = new JTextField();
		complementoTxt.setEnabled(false);
		complementoTxt.setBounds(415, 295, 97, 20);
		add(complementoTxt);
		complementoTxt.setColumns(10);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setEnabled(false);
		lblBairro.setBounds(74, 339, 32, 14);
		add(lblBairro);

		bairroTxt = new JTextField();
		bairroTxt.setEnabled(false);
		bairroTxt.setBounds(116, 336, 86, 20);
		add(bairroTxt);
		bairroTxt.setColumns(10);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setEnabled(false);
		lblCidade.setBounds(379, 339, 37, 14);
		add(lblCidade);

		cidadeTxt = new JTextField();
		cidadeTxt.setEnabled(false);
		cidadeTxt.setBounds(426, 336, 86, 20);
		add(cidadeTxt);
		cidadeTxt.setColumns(10);

		lblCep = new JLabel("CEP:");
		lblCep.setEnabled(false);
		lblCep.setBounds(78, 382, 28, 14);
		add(lblCep);

		cepTxt = new JFormattedTextField();
		cepTxt.setEnabled(false);
		cepTxt.setBounds(116, 379, 86, 20);
		add(cepTxt);

		lblUf = new JLabel("UF:");
		lblUf.setEnabled(false);
		lblUf.setBounds(379, 382, 46, 14);
		add(lblUf);

		ufcb = new JComboBox<>();
		ufcb.setEnabled(false);

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
						loginTxt.setText(clienteBusca.getLogin());
						senhaTxt.setText(clienteBusca.getSenha());
						telefoneTxt.setText(clienteBusca.getTelefone());

						LocalDate data = clienteBusca.getDataNascimento();
						String dataTexto = DateUtil.converterDataTexto(data);

						dataNascimentoTxt.setText(dataTexto);

						Endereco end = clienteBusca.getEndereco();

						if (end != null) {
							logradouroTxt.setText(end.getLogradouro());
							numeroTxt.setText(end.getNumero());
							complementoTxt.setText(end.getComplemento());
							cepTxt.setText(end.getCep());
							cidadeTxt.setText(end.getCidade());
							bairroTxt.setText(end.getBairro());
							ufcb.setSelectedItem(end.getUf());
						}

						habilitarDesabilitarCampos(true);
						btnAtualizar.setEnabled(true);
						btnRemover.setEnabled(true);
						btnCadastrar.setEnabled(false);

					} else {

						int escolha = JOptionPane.showConfirmDialog(null, "CPF não cadastrado. Deseja cadastrar?",
								"Cadastrar cliente", JOptionPane.YES_NO_OPTION);

						if (escolha == JOptionPane.YES_OPTION) {

							habilitarDesabilitarCampos(true);

						}

						// JOptionPane.showMessageDialog(null, "CPF não
						// cadastrado", "Cadastrar Cliente",
						// JOptionPane.INFORMATION_MESSAGE);

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
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = cpfTxt.getText();

				int escolha = JOptionPane.showConfirmDialog(
						null, "Cliente cadastrado. Deseja remover",
						"Remover cliente",
						JOptionPane.YES_NO_OPTION);
				
				if (escolha == JOptionPane.YES_OPTION) {
					try {
						Fachada.getFachada().removerCliente(cpf);
						JOptionPane.showMessageDialog(
								null, "Cliente removido com sucesso",
								"Remover cliente",
								JOptionPane.INFORMATION_MESSAGE);
						limparCampos();
						habilitarDesabilitarCampos(false);

						btnRemover.setEnabled(false);
						btnAtualizar.setEnabled(false);
					} catch (BancoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "remover cliente",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btnRemover.setEnabled(false);
		btnRemover.setBounds(357, 7, 89, 23);
		add(btnRemover);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
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
					JOptionPane.showMessageDialog(
							null, "Cliente cadastrado com sucesso",
							"Cadastrar cliente",
							JOptionPane.INFORMATION_MESSAGE);

					limparCampos();

					habilitarDesabilitarCampos(false);

				} catch (BancoException ex) {
					JOptionPane.showMessageDialog(
							null, ex.getMessage(),
							"Cadastrar Cliente",
							JOptionPane.ERROR_MESSAGE);

				} catch (DateTimeParseException ex) {
					JOptionPane.showMessageDialog(
							null, "Data inválida",
							"Cadastrar Cliente",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btnCadastrar.setBounds(124, 430, 89, 23);
		add(btnCadastrar);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// pegar todos os campos digitados. valida a data e recebe o
				// endereço. adiciona novos dados do endereço, procura o
				// cliente para alterar os dados
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

					Cliente cliente = Fachada.getFachada().procurar(cpf);
					if (cliente != null) {
						cliente.setCpf(cpf);
						cliente.setNome(nome);
						cliente.setDataNascimento(dataNascimentoDate);
						cliente.setLogin(login);
						cliente.setSenha(senha);
						cliente.setEmail(email);
						cliente.setTelefone(telefone);

						cliente.setEndereco(end);

						Fachada.getFachada().atualizarCliente(cliente);
						JOptionPane.showMessageDialog(
								null, "Cliente atualizado com sucesso",
								"Atualizar cliente",
								JOptionPane.INFORMATION_MESSAGE);

						limparCampos();

						habilitarDesabilitarCampos(false);
					}else{
						JOptionPane.showMessageDialog(
								null, "Cliente nao existe",
								"Atualizar cliente",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (BancoException ex) {
					JOptionPane.showMessageDialog
					(null, ex.getMessage(), "Atualizar cliente",
							JOptionPane.ERROR_MESSAGE);

				} catch (DateTimeParseException ex) {
					JOptionPane.showMessageDialog(
							null, "Data inválida", "Atualizar cliente",
							JOptionPane.ERROR_MESSAGE);

				}
				
				btnAtualizar.setEnabled(false);
				btnRemover.setEnabled(false);

			}
		});
		btnAtualizar.setEnabled(false);
		btnAtualizar.setBounds(357, 430, 89, 23);
		add(btnAtualizar);

		lbldataNascimento = new JLabel("Data de nascimento:");
		lbldataNascimento.setEnabled(false);
		lbldataNascimento.setBounds(29, 176, 104, 14);
		add(lbldataNascimento);

		dataNascimentoTxt = new JTextField();
		dataNascimentoTxt.setEnabled(false);
		dataNascimentoTxt.setBounds(143, 170, 104, 20);
		add(dataNascimentoTxt);
		dataNascimentoTxt.setColumns(10);

	}

	private void limparCampos() {
		cpfTxt.setText("");
		nomeTxt.setText("");
		emailTxt.setText("");
		loginTxt.setText("");
		senhaTxt.setText("");
		telefoneTxt.setText("");
		dataNascimentoTxt.setText("");

		logradouroTxt.setText("");
		numeroTxt.setText("");
		complementoTxt.setText("");
		cepTxt.setText("");
		cidadeTxt.setText("");
		bairroTxt.setText("");
		ufcb.setSelectedItem("");

	}

	private void habilitarDesabilitarCampos(boolean habilitar) {

		nomeTxt.setEnabled(habilitar);
		emailTxt.setEnabled(habilitar);
		loginTxt.setEnabled(habilitar);
		senhaTxt.setEnabled(habilitar);
		telefoneTxt.setEnabled(habilitar);
		dataNascimentoTxt.setEnabled(habilitar);

		logradouroTxt.setEnabled(habilitar);
		numeroTxt.setEnabled(habilitar);
		complementoTxt.setEnabled(habilitar);
		cepTxt.setEnabled(habilitar);
		cidadeTxt.setEnabled(habilitar);
		bairroTxt.setEnabled(habilitar);
		ufcb.setEnabled(habilitar);

		lblNome.setEnabled(habilitar);
		lblLogin.setEnabled(habilitar);
		lblSenha.setEnabled(habilitar);
		lblEmail.setEnabled(habilitar);
		lblTelefone.setEnabled(habilitar);
		lbldataNascimento.setEnabled(habilitar);
		lblLogradouro.setEnabled(habilitar);
		lblNmero.setEnabled(habilitar);
		lblComplemento.setEnabled(habilitar);
		lblBairro.setEnabled(habilitar);
		lblCidade.setEnabled(habilitar);
		lblCep.setEnabled(habilitar);
		lblUf.setEnabled(habilitar);
		lblEndereco.setEnabled(habilitar);

		btnCadastrar.setEnabled(habilitar);
	}
}
