import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class timeZone {

    public static void main(String[] args) {

        // hora atual no timezone America/Sao_Paulo
        ZonedDateTime horaAtual = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
// definir o formato (hora:minuto:segundo)
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println(fmt.format(horaAtual));

    }
}
