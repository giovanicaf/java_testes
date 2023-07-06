package enums;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TipoQuestao {

    TEXTO("TEXTO", "Texto"),
    ESCOLHA_UNICA("ESCOLHA_UNICA", "Escolha Única"),
    MULTIPLA_ESCOLHA("MULTIPLA_ESCOLHA", "Múltiplas Escolhas");

    private final String codigo;
    private final String descricao;

    TipoQuestao(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getDescricao() { return descricao; }

    @Override
    public String toString() {
        return descricao;
    }

    public static Map<String, String> getDadosEnum() {
        return Stream.of(TipoQuestao.values()).collect(Collectors.toMap(TipoQuestao::getCodigo, TipoQuestao::getDescricao));
    }
}
