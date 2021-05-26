package br.com.projetoCalculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculadora extends JFrame {

	// Display
	static JTextField visor;
	static Boolean igualClicado;

	// Botoes Numericos
	static JButton botao1;
	static JButton botao2;
	static JButton botao3;
	static JButton botao4;
	static JButton botao5;
	static JButton botao6;
	static JButton botao7;
	static JButton botao8;
	static JButton botao9;
	static JButton botao0;

	// Botoes operadores
	static JButton soma;
	static JButton subtrai;
	static JButton multiplica;
	static JButton dividi;
	static JButton igual;
	static JButton limpar;

	// Vairaveis de operação
	Double valor1;
	Double valor2;
	Double resultado;
	String operacao;

	
	
	public static JButton organizadorElementos(JButton elemento, String nomeElemento, Integer gridX, Integer gridY, Boolean isNumber) {


		elemento = new JButton(nomeElemento);
		elemento.setBounds(10 + (gridX * 65), 60 + (gridY * 45), 60, 40);
		
		if (isNumber) {
			elemento.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (igualClicado) {
						visor.setText(null);
					}
					visor.setText(visor.getText() + nomeElemento);
					igualClicado = false;
				}
			});
		}

		return elemento;

	}
	

	public static void main(String[] args) {

		Calculadora janela = new Calculadora();
		janela.setLayout(null);
		
		
		//*------- TELA -------*
		// Visor Calculadora
		visor = new JTextField();
		visor.setBounds(10, 10, 250, 30);
		janela.add(visor);

		igualClicado = false; // Não clicou no igual ainda

		//*------- LN 0 -------*
		// Botão 7
		janela.add(organizadorElementos(botao7, "7", 0, 0, true));
		// Botão 8
		janela.add(organizadorElementos(botao8, "8", 1, 0, true));
		// Botão 9
		janela.add(organizadorElementos(botao9, "9", 2, 0, true));
		// Multiplicar
		multiplica = (organizadorElementos(multiplica, "X", 3, 0, false));
		janela.add(multiplica);
		
		//*------- LN 1 -------*
		// Botão 4
		janela.add(organizadorElementos(botao4, "4", 0, 1, true));
		// Botão 5
		janela.add(organizadorElementos(botao5, "5", 1, 1, true));
		// Botão 6
		janela.add(organizadorElementos(botao6, "6", 2, 1, true));
		// Dividir
		dividi = (organizadorElementos(dividi, "÷", 3, 1, false));
		janela.add(dividi);
		
		//*------- LN 2 -------*
		// Botão 1
		janela.add(organizadorElementos(botao1, "1", 0, 2, true));
		// Botão 2
		janela.add(organizadorElementos(botao2, "2", 1, 2, true));
		// Botão 3
		janela.add(organizadorElementos(botao3, "3", 2, 2, true));
		// Subtrair
		subtrai = (organizadorElementos(subtrai, "-", 3, 2, false));
		janela.add(subtrai);
		
		//------- LN 3 -------*
		// Botão 0
		janela.add(organizadorElementos(botao0, "0", 0, 3, true));
		// Limpar
		limpar = (organizadorElementos(limpar, "CE", 1, 3, false));
		janela.add(limpar);
		// Igual
		igual = (organizadorElementos(igual, "=", 2, 3, false));
		janela.add(igual);
		// Somar
		soma = (organizadorElementos(soma, "+", 3, 3, false));
		janela.add(soma);
		
		
		// Configurações de dimensão da janela
		janela.setTitle("Calculadora");
		janela.setSize(350, 350);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null); // Para que o visor fique fixo e sem referencial
		janela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	
		//*------- Ações de operação -------*
		limpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				visor.setText(null);
			}
		});
		soma.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				janela.operacao = "+";
				janela.valor1 = Double.parseDouble(janela.visor.getText());
				janela.visor.setText("");
			}
		});
		subtrai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				janela.operacao = "-";
				janela.valor1 = Double.parseDouble(janela.visor.getText());
				janela.visor.setText("");
			}
		});
		multiplica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				janela.operacao = "x";
				janela.valor1 = Double.parseDouble(janela.visor.getText());
				janela.visor.setText("");
			}
		});
		dividi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				janela.operacao = "/";
				janela.valor1 = Double.parseDouble(janela.visor.getText());
				janela.visor.setText("");
			}
		});
		//*------- END Ações de operação -------*
		
		
		//*------- Cálculo resultado -------* 
		igual.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				
				janela.igualClicado = true;
				
				if(janela.operacao == "+") {
					janela.valor2 = Double.parseDouble(janela.visor.getText());
					janela.resultado = janela.valor1 + janela.valor2;
					janela.visor.setText(janela.resultado.toString());
				}
				if(janela.operacao == "-") {
					janela.valor2 = Double.parseDouble(janela.visor.getText());
					janela.resultado = janela.valor1 - janela.valor2;
					janela.visor.setText(janela.resultado.toString());
				}
				if(janela.operacao == "x") {
					janela.valor2 = Double.parseDouble(janela.visor.getText());
					janela.resultado = janela.valor1 * janela.valor2;
					janela.visor.setText(janela.resultado.toString());
				}
				if(janela.operacao == "÷" || janela.operacao == "/") {
					janela.valor2 = Double.parseDouble(janela.visor.getText());
					janela.resultado = janela.valor1 / janela.valor2;
					
					// Trata divisão por zero
					if(janela.resultado.toString() == "Infinity") {
						janela.visor.setText("Math Error");
					}else {
						janela.visor.setText(janela.resultado.toString());
					}
				}
			}
		});
		//*------- END Cálculo resultado -------* 

		

	}

}
