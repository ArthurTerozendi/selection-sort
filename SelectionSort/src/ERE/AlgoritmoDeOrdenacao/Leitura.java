package ERE.AlgoritmoDeOrdenacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Leitura {
    private File path;
    public Leitura(){

    }

    /**
     * Lê o arquivo das cotações
     * retornando uma array de float
     * @return
     * @throws IOException
     */
    public float[] lerCotacao() throws IOException {
        path = new File("cotacaoEMBR3.csv");
        FileReader lerArquivo = new FileReader(path);
        BufferedReader bLerArquivo = new BufferedReader(lerArquivo);
        float cotacoes[] = new float[2732];

        int i = -1;
        while (bLerArquivo.ready()){
            String linha;
            //Pula a primeira linha do arquivo
            if (i == -1) {
                linha = bLerArquivo.readLine();
            } else {
                linha = bLerArquivo.readLine();
                cotacoes[i] = Float.valueOf(separarLinha(linha, 1, ";"));
            }
            i++;
        }
        bLerArquivo.close();
        lerArquivo.close();
        return cotacoes;
    }

    /**
     * Método que separa uma linha
     * Retornando um item especifico dessa linha
     * @param linha
     * @param coluna
     * @param separador
     * @return
     */
    private String separarLinha(String linha, int coluna, String separador) {

        String linhaSeparada[] = linha.split(separador);
        linha = linhaSeparada[coluna];
        return linha;
    }

    /**
     * Lê o arquivo dos nomes
     * retorna uma array de string
     * @return
     * @throws IOException
     */
    public String[] lerNomes() throws IOException {
        path = new File("nomes-caracteres.csv");
        FileReader lerArquivo = new FileReader(path);
        BufferedReader bLerArquivo = new BufferedReader(lerArquivo);
        String nomes[] = new String[100787];

        int i = -1;
        while (bLerArquivo.ready()){
            String linha;
            //Pula a primeira linha do arquivo
            if (i == -1) {
                linha = bLerArquivo.readLine();
            } else {
                linha = bLerArquivo.readLine();
                nomes[i] = separarLinha(linha, 2, ",");
            }
            i++;
        }
        bLerArquivo.close();
        lerArquivo.close();
        return nomes;
    }
}
