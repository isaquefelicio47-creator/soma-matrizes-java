package service;

public class MatrizService {
    //criação das variaveis
    private int matrizA[][] = new int[2][2];
    private int matrizB[][] = new int[2][2];
    
    // Construtor que inicializa os valores
    public MatrizService(){
 matrizA = new int[][] {{0, 0},{0, 0}};
 matrizB = new int[][] {{0, 0},{0, 0}};

    }
    
    // Construtor: Recebe as duas matrizes 2x2 de fora e as armazena nos atributos da classe para o cálculo da soma
    public MatrizService(int[][] matrizA, int[][] matrizB) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
    }
    
    // Método que realiza a soma das matrizes elemento por elemento e retorna a matriz resultante
    public int[][] calcularSoma() {
        int[][] resultado = new int[2][2];

        // Loops aninhados para percorrer as linhas (i) e as colunas (j) das matrizes
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        
        return resultado;
        }
    
}

