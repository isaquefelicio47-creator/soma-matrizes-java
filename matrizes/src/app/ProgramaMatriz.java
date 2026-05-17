package app;

import javax.swing.JOptionPane;
import service.MatrizService;


public class ProgramaMatriz {
    public static void main(String[] args) {
        // array de duas dimenções 
        int[][] matrizA = new int[2][2];
        int[][] matrizB = new int[2][2];

        // Loops aninhados para ler os dados da Matriz A, passando por cada linha (i) e coluna (j)
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrizA[i][j] = lerNumeroInteiroValido("Matriz A - Digite o elemento [" + i + "][" + j + "]:");
            }
        }
        // Repete o mesmo processo de varredura (linhas e colunas) e validação para preencher a Matriz B
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrizB[i][j] = lerNumeroInteiroValido("Matriz B - Digite o elemento [" + i + "][" + j + "]:");
            }
        }
        // Instancia a classe de serviço passando as duas matrizes preenchidas pelo usuário
        MatrizService service = new MatrizService(matrizA, matrizB);
        
        // Aciona o método do serviço para calcular a soma e armazena a matriz resultante
        int[][] matrizResultado = service.calcularSoma();

        String textoResultado = "--- MATRIZ RESULTADO (SOMA) ---\n\n";

        // Percorre a matriz resultado para montá-la em formato visual de grade (linhas e colunas)
        for (int i = 0; i < 2; i++) {
            textoResultado += "[ ";
            for (int j = 0; j < 2; j++) {
                textoResultado += matrizResultado[i][j] + " ";
            }
            textoResultado += "]\n"; 
        }
        // Exibe uma janela gráfica na tela mostrando a matriz resultante já formatada em texto
        JOptionPane.showMessageDialog(
            null,
            textoResultado,
            "Resultado da Soma",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    

    public static int lerNumeroInteiroValido(String mensagem) {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(
                    null, 
                    mensagem, 
                    "Entrada de Dados", 
                    JOptionPane.QUESTION_MESSAGE
                );

                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Programa encerrado pelo usuário.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    System.exit(0);
                }

                return Integer.parseInt(entrada); 

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    null, 
                    "Erro: Entrada inválida!\nPor favor, digite apenas números inteiros (sem letras ou pontos).", 
                    "Erro de Digitação", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}

