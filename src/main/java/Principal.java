import org.example.boleto.ProcessarBoletos;
import org.example.boleto.leituraretornostraegies.LeituraRetornoBancoBrasil;
import org.example.boleto.leituraretornostraegies.LeituraRetornoBradesco;

import java.net.URISyntaxException;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        final ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        var caminhoArquivo = Principal.class.getResource("banco-brasil-1.csv").toURI();
        System.out.println("\n\n### lendo arquivo:"+caminhoArquivo+"\n");
        processador.processar(caminhoArquivo);

        processador.setLeituraRetorno(new LeituraRetornoBradesco());
        caminhoArquivo = Principal.class.getResource("bradesco-1.csv").toURI();
        System.out.println("\n\n### lendo arquivo:"+caminhoArquivo+"\n");
        processador.processar(caminhoArquivo);

    }
}
