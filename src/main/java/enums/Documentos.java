package enums;

import java.util.Arrays;
import java.util.List;

public enum Documentos {

    CARTEIRA_TRABALHO(141L, 18L, "Carteira de Trabalho"),
    CARTEIRA_TRABALHO_VALIDACAO_DESEMPREGO(273L, 224L, "Carteira de Trabalho - Validação Desemprego"),
    TERMO_RESCISAO_DE_CONTRATO_DE_TRABALHO(207L, 207L, "Termo de Rescisão de Contrato de Trabalho"),
    TERMO_RESCISAO_DE_CONTRATO_DE_TRABALHO_OU_ESOCIAL(257L, 212L, "Termo de Rescisão de Contrato de Trabalho ou eSocial");

    private static List<Documentos> listCarteirasTrabalhos = Arrays.asList(
            CARTEIRA_TRABALHO,
            CARTEIRA_TRABALHO_VALIDACAO_DESEMPREGO
    );
    private static List<Documentos> listTermosRecisoes = Arrays.asList(
        TERMO_RESCISAO_DE_CONTRATO_DE_TRABALHO,
        TERMO_RESCISAO_DE_CONTRATO_DE_TRABALHO_OU_ESOCIAL
    );

    private final Long idProdLife;
    private final Long idBvp;
    private final String name;

    Documentos(Long idProdLife, Long idBvp, String name) {
        this.idProdLife = idProdLife;
        this.idBvp = idBvp;
        this.name = name;
    }

    public Long getIdProdLife() {
        return this.idProdLife;
    }
    public Long getIdBvp() {
        return this.idBvp;
    }
    public String getName() { return this.name; }

    public static Documentos getByIdProdLife(Long idProdLife){
        return Arrays.stream(Documentos.values())
                .filter(e -> e.getIdProdLife().equals(idProdLife)).findAny().orElse(null);
    }
    public static Documentos getByIdBvp(Long idBvp){
        return Arrays.stream(Documentos.values())
                .filter(e -> e.getIdBvp().equals(idBvp)).findAny().orElse(null);
    }

    public static Documentos getByName(String name){
        return Arrays.stream(Documentos.values())
                .filter(e -> e.getName().equals(name)).findAny().orElse(null);
    }
    public static Boolean existsTermoRescisaoInNamas(List<String> names){
        return names.stream()
                .anyMatch(name -> listTermosRecisoes.stream()
                        .anyMatch(enumTermo -> enumTermo.getName().equals(name)));
    }

    public static Boolean existsCarteiraTrabalho(List<String> names){
        return names.stream()
                .anyMatch(name -> listCarteirasTrabalhos.stream()
                        .anyMatch(enumTermo -> enumTermo.getName().equals(name)));
    }
}
