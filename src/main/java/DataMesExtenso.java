import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DataMesExtenso {

    public static void main(String[] args) {

        Date data =  new Date();
        Locale local = new Locale("pt","BR");
        DateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy hh:mm:ss",local);
        System.out.println(formato.format(data));

        //Obtém LocalDate de hoje
        LocalDate hoje = LocalDate.now();
        System.out.println("LocalDate antes de formatar: " + hoje);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String hojeFormatado = hoje.format(formatter);
        System.out.println("LocalDate depois de formatar: " + hojeFormatado);

        //Obtém LocalDateTime de agora
        LocalDateTime agora = LocalDateTime.now();
        System.out.println("LocalDateTime antes de formatar: " + agora);
        formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy 'às' hh:mm:ss");
        String agoraFormatado = agora.format(formatter);
        System.out.println("LocalDateTime depois de formatar: " + agoraFormatado);

        System.out.println("Teste LocalDateTime depois de formatar: " + agoraFormatado);

        //Obtém ZonedDateTime de agora
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
        System.out.println("ZonedDateTime antes de formatar: " + zonedDateTime);
        formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy hh:mm:ss");
        String zonedDateTimeFormatado = zonedDateTime.format(formatter);
        System.out.println("ZonedDateTime depois de formatar: " + zonedDateTimeFormatado);
    }
}
