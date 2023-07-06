import javax.swing.text.MaskFormatter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class StringsMascara {

    public static void main(String[] args) throws ParseException {
        System.out.println("formatarString="+formatarString("61608360300", "999.999.999-99"));
        System.out.println("formatarMascaraNumeros="+formatarMascaraNumeros(17185L, 1L));
    }

    public static String formatarString(String texto, String mascara) throws ParseException {

        MaskFormatter mf = new MaskFormatter(mascara.replace('9', '#'));
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(texto);
    }

    public static String formatarMascaraNumeros(Long id, Long complementoId) {

        String formattedId = formatarNumero(id, "000000000");
        formattedId = formattedId.substring(0,8) + "-" + formattedId.substring(8);

        return formattedId + "/" + formatarNumero(complementoId, "00");
    }
    public static String formatarNumero(Long numero, String formato){
        NumberFormat formatador = new DecimalFormat(formato);
        return formatador.format(numero);
    }

}
