import enums.Documentos;

import java.util.Arrays;
import java.util.List;


public class TesteEnumDocumento {

    public static void main(String[] args)  {

        List<String> nomesTermos = Arrays.asList(
                "Termo de Rescisão de Contrato de Trabalho",
                "Termo de Rescisão de Contrato de Trabalho ou eSocial"
        );

        List<String> nomesCarteiras = Arrays.asList(

                "Termo de Rescisão de Contrato de Trabalho",
                "Termo de Rescisão de Contrato de Trabalho ou eSocial",
                "Carteira de Trabalho"
        );

        System.out.println(" Documentos.getByIdProdLife(273L): " + Documentos.getByIdProdLife(273L));
        System.out.println(" Documentos.getByIdBvp(224L): " + Documentos.getByIdBvp(224L));
        System.out.println(" Documentos.getName(\"Termo de Rescisão de Contrato de Trabalho ou eSocial\"): " + Documentos.getByName("Termo de Rescisão de Contrato de Trabalho ou eSocial"));
        System.out.println(" Documentos.existsTermoRescisaoInNamas(nomesTermos): " + Documentos.existsTermoRescisaoInNamas(nomesTermos));
        System.out.println(" Documentos.existsCarteiraTrabalho(nomesCarteiras): " + Documentos.existsCarteiraTrabalho(nomesCarteiras));
    }
}
