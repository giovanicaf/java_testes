import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsTest {

    public static void main(String[] args) throws ParseException {

//        String teste01 = "     O   nome    é     trololó!   ";
//        String teste02 = "O evento: é / * -- = ! @ # $ % & * ( ) \\ | :; ., '\" hoje de manhã no centro de eventos do estado do ceará";
//        System.out.println("ltrim(teste01)="+ltrim(teste01));
//        System.out.println("rtrim(teste01)="+rtrim(teste01));
//        System.out.println("superTrim(teste01)="+superTrim(teste01));
//        System.out.println("removingBlanks(teste01)="+removingBlanks(teste01));
//
//        System.out.println("replaceStrin(teste01)="+replaceStrin(teste02));
//        System.out.println("parametrosMultiplos="+parametrosMultiplos("tipoMovimentacao, id", "Movimentação de Saida,144"));

        System.out.println("testeString() = "+testeString());
        System.out.println("formatarString="+formatarString("61608360300", "999.999.999-99"));
    }
    public static boolean testeString(){
        String teste = null;
        return "TESTE".equalsIgnoreCase(Objects.nonNull(teste) ? teste : "");
    }
    public static String formatarString(String texto, String mascara) throws ParseException {
        MaskFormatter mf = new MaskFormatter(mascara);
        mf.setPlaceholderCharacter('9');
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(texto);
    }

    public static String replaceStrin(String testeTrim) {
        if (StringUtils.isBlank(testeTrim)) { return ""; }

        final int QUANTIDADE_MAX_CARACTERES = 20;
        String tituloSemEspacos = StringUtils.deleteWhitespace(testeTrim);
        String tituloSemAcentos = StringUtils.stripAccents(tituloSemEspacos);
        String tituloLetrasMinuscolas = StringUtils.lowerCase(tituloSemAcentos);
        String tituloSemCaracteres = tituloLetrasMinuscolas.replaceAll("[^a-zA-Z0-9]", "");
        String tituloReduzido = StringUtils.truncate(tituloSemCaracteres, QUANTIDADE_MAX_CARACTERES);


        return tituloReduzido;
    }

    public static String ltrim(String testeTrim) {
        return testeTrim.replaceAll("^\\s+", "");
    }

    public static String rtrim(String testeTrim) {
        return testeTrim.replaceAll("\\s+$", "");
    }

    public static String superTrim(String testeTrim) {
        return testeTrim.replaceAll("^ +| +$|( )+", "$1");
    }

    public static String removingBlanks(String text) {
        if (!Objects.isNull(text)) {
            String REGEX = "[\\s]+";
            String REPLACE = " ";

            Pattern p = Pattern.compile(REGEX);
            Matcher m = p.matcher(text.trim());
            text = m.replaceAll(REPLACE);
        } else {
            return null;
        }

        return text;
    }

    public static Map<String, String> parametrosMultiplos(String parameterFind, String valuesFind){
        String[] parametros = parameterFind.split(",");
        String[] values = valuesFind.split(",");
        Map<String, String> retorno = new HashMap<>();

        for(int i = 0; i < parametros.length; i++){
            retorno.put(parametros[i], values[i]);
        }

        return retorno;
    }

}
