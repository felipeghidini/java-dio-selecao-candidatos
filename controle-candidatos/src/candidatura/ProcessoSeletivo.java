package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
        System.out.println("Processo seletivo");

        analisarCandidato(1400.0);
        analisarCandidato(2200.0);
        analisarCandidato(2000.0);

        System.out.println("\n-- Sele��o de candidatos --");
        selecaoCandidatos();

        System.out.println("\n-- Imprimir Selecionados --");
        imprimirSelecionados();
        
		String [] candidatos = {"FELIPE", "THIAGO", "LUAN", "AMANDA", "RAFAEL", "ELOAH", "MARCO", "MARIA"};
		for (String candidato: candidatos) {
			entrandoEmContato(candidato);
		}	
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if (continuarTentando) 
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO");
		} while (continuarTentando && tentativasRealizadas < 3);
		
		if (atendeu) 
			System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa.");
		else
			System.out.println("N�o conseguimos contato com " + candidato + ", numero maximo tentativas " + tentativasRealizadas + " realizada.");
	}
	
	//metodo auxiliar
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"FELIPE", "THIAGO", "LUAN", "AMANDA", "RAFAEL", "ELOAH", "MARCO", "MARIA"};
		System.out.println("Imprimir a lista de candidatos informando o indice do elemento");
		
		for (int indice = 0; indice < candidatos.length; indice++) {
			System.out.println("O candidato de n� " + (indice+1) + " � o " + candidatos[indice]);
		}
		
		System.out.println("Forma abreviada com forEach");
		
		for (String candidato: candidatos) {
			System.out.println("O candidato selecionado foi: " + candidato);
		}
	}
	
	static void selecaoCandidatos() {
		String [] candidatos = {"FELIPE", "THIAGO", "LUAN", "AMANDA", "RAFAEL", "ELOAH", "MARCO", "MARIA"};
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		
		while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("O candidato " + candidato + " Solicitou este valor de salario " + salarioPretendido );
			if (salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if (salarioBase > salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO");
		} else if (salarioBase == salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
		} else {
			System.out.println("AGUARDANDO RESULTADOS DOS DEMAIS CANDIDATOS");
		}
	}
}
