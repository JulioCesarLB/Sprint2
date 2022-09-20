package br.com.fiap.sprint3;

import javax.swing.JOptionPane;

public class Sprint {

	public static void main(String[] args) {
		int teams;
		do {
			teams = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Digite a quantidade de equipes que participaram do evento (até 88 equipes):"));
			if (teams < 1) {
				JOptionPane.showMessageDialog(null, teams + " é menor que o limite (1) \n Tente novamente!!");
			} else if (teams > 88) {
				JOptionPane.showMessageDialog(null, teams + " é maior que o limite (88) \n Tente novamente!!");
			}
		} while (teams < 1 && teams > 88);

		int combat;
		do {
			combat = Integer.parseInt(
					JOptionPane.showInputDialog(null, "Digite a quantidade de combates que foram realizados:"));
			if (combat < 1) {
				JOptionPane.showMessageDialog(null, "Não é possível digitar números negativos");
			}
		} while (combat < 1);

		Object[][] tabela = new Object[teams][combat + 3];

		////////      | n da equipe | combate1 | combate2 | combate3 | notaTotal | notaDesign
		//            --------------|----------|----------|----------|-----------|------------
		////////equipe|
		int[] score = new int[teams];
		int[] nota = new int[teams];

		tabela = insertData(combat, teams);

		mostraTabela(tabela, combat, teams);

		tabela = ordenaTabela(tabela, teams, combat);

		mostraTabela(tabela, combat, teams);

	}

	public static Object[][] insertData(int combat, int teams) {
		Object[][] tabela = new Object[teams][combat + 3];

		for (int i = 0; i < teams; i++) {
			int notaTotal = 0;

			for (int j = 0; j < combat + 3; j++) {

				if (j == 0) {
					int result;
					do {
						result = Integer.parseInt(
								JOptionPane.showInputDialog(null, "Digite o número da " + (i + 1) + "º equipe"));

						if (result < 11 || result > 99) {
							JOptionPane.showMessageDialog(null, "Valor inválido");
						}

					} while (result < 1 || result > 99);
					tabela[i][j] = result;

					///// Insere o resultado dos combates
				} else if (j > 0 && j <= combat) {
					char result;
					do {
						result = JOptionPane.showInputDialog(null, "Digite o resultado do " + (j) + "º combate"
								+ "\n V - Vitória" + "\n D - Derrota" + "\n E - Empate").charAt(0);

						if (result != 'V' && result != 'D' && result != 'E' && result != 'v' && result != 'd'
								&& result != 'e') {
							JOptionPane.showMessageDialog(null, "Opção inválida");
						}

					} while (result != 'V' && result != 'D' && result != 'E' && result != 'v' && result != 'd'
							&& result != 'e');

					tabela[i][j] = result;

					// calcula a quantidade de pontos por combate
					if (result == 'V' || result == 'v') {
						notaTotal = notaTotal + 5;

					} else if (result == 'E' || result == 'e') {
						notaTotal = notaTotal + 3;
					} else if (result == 'D' || result == 'd') {
					}
					////// Insere a nota total
				} else if (j == combat + 1) {
					tabela[i][combat + 1] = notaTotal;

					////// Insere a nota de Design
				} else if (j == combat + 2) {
					int result;
					do {
						result = Integer
								.parseInt(JOptionPane.showInputDialog(null, "Digite o valor da nota de Design"));

						if (result < 0 || result > 10) {
							JOptionPane.showMessageDialog(null, "Valor inválido");
						}

					} while (result < 0 || result > 10);
					tabela[i][combat + 2] = result;
				}

			}
		}

		return tabela;
	}

	public static void mostraTabela(Object[][] tabela, int combat, int teams) {
		for (int i = 0; i < teams; i++) {
			for (int j = 0; j < combat + 3; j++) {
				System.out.print(tabela[i][j] + " | ");
			}
			System.out.println("");
		}

	}

	public static Object[][] ordenaTabela(Object[][] tabela, int teams, int combat) {
		
		int index = 0;
		Object[][] ordenada = new Object[teams][combat + 3];

		for (int j = 0; j < teams; j++) {
			int valor = 0;
			for (int i = 0; i < teams; i++) {
				if (valor < (int) (tabela[i][(combat + 1)])) {
					System.out.println(valor);
					valor = (int) (tabela[i][(combat + 1)]);
					index = i;

				}else if(valor == (int) (tabela[i][(combat + 1)])) {
					if((int) tabela[index][combat+2]> (int) (tabela[i][(combat + 2)])){
						
					}else if((int) tabela[index][combat+2]< (int) (tabela[i][(combat + 2)])){
						valor = (int) (tabela[i][(combat + 1)]);
						index =i;
					}else {
						
					}
				}
			}
			
			for (int i = 0; i < combat + 3; i++) {
				ordenada[j][i] = tabela[index][i];
			}
			tabela[index][(combat + 1)] = 0;
		}
		return ordenada;
	}

}
