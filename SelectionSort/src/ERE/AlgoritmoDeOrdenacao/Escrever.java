package ERE.AlgoritmoDeOrdenacao;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


public class Escrever {
    public Escrever (){}

    /**
     * Método responsável por escrever a arrayList ordenada com todas as colunas
     * em um novo arquivo
     * @param caminho
     * @param cotacao
     * @throws IOException
     */
    public void escrever(String caminho, float cotacao[]) throws IOException {
        File path = new File("cotacaoOrdenada.csv");
        if (!path.exists()) {
            path.createNewFile();
        }

        FileWriter escrever = new FileWriter(path);
        BufferedWriter bEscrever = new BufferedWriter(escrever);

        //Vai ler e salvar o arquivo não ordenado
        ArrayList<String> arquivo = ler(caminho);

        //Vai salvar o arquivo ordenado na arraylist
        ArrayList<String> novoArquivo = iterar(cotacao, arquivo);

        //Pega os valores ordenados e os salva em um arquivo .csv
        //Obs: Não ta salvando a arraylist toda no arquivo, não sei o motivo
        for (String linha: novoArquivo) {
            //System.out.println(linha);
            bEscrever.write(linha);
            bEscrever.newLine();
        }

    }

    /**
     * Método que irá ler o arquivo e o salvar em uma arraylist
     * @param path
     * @return
     * @throws IOException
     */
    private ArrayList<String> ler(String path) throws IOException {

        FileReader ler = new FileReader(new File(path));
        BufferedReader bLer = new BufferedReader(ler);

        ArrayList<String> arquivo = new ArrayList<>();

        int i = -1;
        //Vai iterar e armazenar linha por linha na arraylist
        while (bLer.ready()) {
            //Irá pular a primeira linha do arquivo
            if (i != -1){
                arquivo.add(bLer.readLine());
            } else {
                bLer.readLine();
            }
            i++;
        }

        bLer.close();
        ler.close();
        return arquivo;
    }

    /**
     * Método que irá iterar a arrayList desordenada, e vai procurar os itens que
     * correspondem a cotação passada por parámetro
     * assim criando uma nova arraylist com todos os dados só que agora ela ta ordenada
     * @param cotacao
     * @param arquivo
     * @return
     */
    private ArrayList<String> iterar(float cotacao[], ArrayList<String> arquivo) {

        ArrayList<String> novoArquivo = new ArrayList<>();
        for (int j = 0; j < cotacao.length; j++) {
            Iterator<String> it = arquivo.iterator();
            while (it.hasNext()) {
                //pega a proxima item do iterator
                String linha = it.next();
                //pega o valor da cotação desse item
                float valorCotacao = Float.valueOf(separarLinha(linha, 1, ";"));

                //verifica se o valor da cotação do iterador é igual a cotação na posição j
                if (valorCotacao == cotacao[j]) {
                    //Se os valores forem iguais, adcionara a nova arrayList e removerá a linha do iterator
                    novoArquivo.add(linha);
                    it.remove();
                    break;
                }
            }
        }

        return novoArquivo;
    }


    /**
     * Método que retorna o item especifico de um linha
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

}
