import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ComparandoDataEHora {



    public static void main(String[] args) throws ParseException {

        System.out.println("");
        System.out.println("");

        ZonedDateTime zonedDateTimeFortaleza =
                ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Fortaleza"));
        System.out.println("zonedDateTimeFortaleza =" + zonedDateTimeFortaleza);

        ZonedDateTime zonedDateTimeSaoPaulo =
                ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Sao_Paulo"));
        System.out.println("zonedDateTimeSaoPaulo =" + zonedDateTimeSaoPaulo);

        ZonedDateTime zonedDateTimeEuropeLondon =
                ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/London"));
        System.out.println("zonedDateTimeEuropeLondon =" + zonedDateTimeEuropeLondon);

        ZonedDateTime zonedDateTimePacificApia =
                ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Pacific/Apia"));
        System.out.println("zonedDateTimePacificApia =" + zonedDateTimePacificApia);

        System.out.println("");
        System.out.println("");

        //LocalDateTime dataHoraPedido = LocalDateTime.of(2022, 6, 28, 19, 18);
        LocalDateTime dataHoraPedido = LocalDateTime.now();
        dataHoraPedido.atZone(ZoneId.of("America/Fortaleza"));

        LocalDateTime dataHoralocal = LocalDateTime.now();
        dataHoralocal.atZone(ZoneId.of("America/Sao_Paulo"));

        System.out.println(" Data e Hora Pedido: " + dataHoraPedido);
        System.out.println(" Data e Hora Local: " + dataHoralocal);

        System.out.println(" Compara somente a data Pedido com Local em timezones diferentes: " +
                comparaDatas(dataHoralocal, dataHoraPedido));

        System.out.println(" Compara data e hora Pedido com Local em timezones diferentes: " +
                comparaDataHora(dataHoralocal, dataHoraPedido));

        System.out.println(" Verifica se a dataDoPedido é maior que 11h: " +
                comparaDataHoraDepoisOnze(dataHoralocal, dataHoraPedido));
    }

    private static LocalDateTime ontem(ZonedDateTime localDate){
        if (localDate == null) {return null;}
        ZonedDateTime zonedDateTimeEuropeLondon =
                ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/London"));

        Calendar cal = new GregorianCalendar();
        cal.setTime(Date.from(localDate.toInstant()));
        cal.add(Calendar.DAY_OF_MONTH , -1);

        return cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static boolean comparaDatas(LocalDateTime dataHoralocal, LocalDateTime dataPedido) {
        // comparar somente a data (ignora o horário)
        return (dataHoralocal.toLocalDate().equals(dataPedido.toLocalDate()));
    }

    public static String comparaDataHora(LocalDateTime dataHoralocal, LocalDateTime dataPedido) {

        if (dataPedido.isEqual(dataHoralocal)){
            return "dataPedido: "+dataPedido+" é igual a dataHoralocal: "+dataHoralocal;
        }

        if (dataPedido.isBefore(dataHoralocal)){
            return "dataPedido: "+dataPedido+" é anterior que dataHoralocal: "+dataHoralocal;
        }

        if (dataPedido.isAfter(dataHoralocal)){
            return "dataPedido: "+dataPedido+" é maior que dataHoralocal: "+dataHoralocal;
        }

        return "";
    }

    public static boolean comparaDataHoraDepoisOnze(LocalDateTime dataHoralocal, LocalDateTime dataPedido) {
        // verificar se já passou das 11:00
        // passou das 11:00 - não pode processar
        return (dataHoralocal.toLocalTime().isAfter(LocalTime.of(11, 0)));
    }
}
