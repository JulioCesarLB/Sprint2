package br.com.fiap.sprint3;

import javax.swing.JOptionPane;

public class Sprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int teams;
		do {
			teams = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Digite a quantidade de equipes que participaram do evento (entre 11 e 99):"));
			if (teams < 11) {
				JOptionPane.showMessageDialog(null, teams + " é menor que o limite (11) \\n Tente novamente!!");
			} else {
				JOptionPane.showMessageDialog(null, teams + " é maior que o limite (99) \n Tente novamente!!");
			}
		} while (teams < 11 && teams > 99);

		int combat;
		do {
			combat = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Digite a quantidade de equipes que participaram do evento (entre 11 e 99):"));
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
	}

	public static Object[] insertData(int combat, int teams) {
		Object[][] tabela = new Object[teams][combat + 3];

		for (int i = 0; i < teams; i++) {
			int notaTotal = 0;

			for (int j = 0; j < combat; j++) {

				if (j == 0) {
					int result;
					do {
						result = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da equipe"));

						if (result < 11 || result > 99) {
							JOptionPane.showMessageDialog(null, "Valor inválido");
						}

					} while (result < 11 || result > 99);
					tabela[i][j] = result;

					///// Insere o resultado dos combates
				} else if (j < combat - 3) {
					char result;
					do {
						result = JOptionPane.showInputDialog(null, "Digite o resultado do " + (j + 1) + "º combate"
								+ "\n V - Vitória" + "\n D - Derrota" + "\n E - Empate").charAt(0);

						if (result != 'V' || result != 'D' || result != 'E' || result != 'v' || result != 'd'
								|| result != 'e') {
							JOptionPane.showMessageDialog(null, "Opção inválida");
						}

					} while (result != 'V' || result != 'D' || result != 'E' || result != 'v' || result != 'd'
							|| result != 'e');
					tabela[i][j] = result;

					// calcula a quantidade de pontos por combate
					if (result == 'V' || result == 'v') {
						notaTotal = +5;

					} else if (result == 'E' || result == 'e') {
						notaTotal = +3;
					} else if (result == 'D' || result == 'd') {
					}
					////// Insere a nota total
				} else if (j == combat - 2) {
					tabela[i][combat - 2] = notaTotal;

					////// Insere a nota de Design
				} else if (j == combat - 1) {
					int result;
					do {
						result = Integer
								.parseInt(JOptionPane.showInputDialog(null, "Digite o valor da nota de Design"));

						if (result < 0 || result > 10) {
							JOptionPane.showMessageDialog(null, "Valor inválido");
						}

					} while (result < 0 || result > 10);
					tabela[i][combat - 1] = result;
				}

			}
		}

		return null;
	}

}
