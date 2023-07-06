import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OperacoesComDataEHora {



    public static void main(String[] args) throws ParseException {

        LocalDateTime localDateTime = LocalDateTime.of(2023, 1, 17, 12, 30);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/Fortaleza"));


        System.out.println(" Data: " + localDateTime);
        System.out.println(" Dia anterior: " + diaAnteriorLocalDateTime(localDateTime));
        System.out.println(" Dia anterior com ZonedDateTime: " + diaAnteriorZonedDateTime(zonedDateTime));
        System.out.println(" Primeiro dia da semana: " + primeiroDiaSemana(localDateTime));
        System.out.println(" Ultimo dia da semana: " + ultimoDiaSemana(localDateTime));
        System.out.println(" Primeiro dia do mês: " + primeiroDiaMes(localDateTime));
        System.out.println(" Ultimo dia do mês: " + ultimoDiaMes(localDateTime));
        System.out.println(" ontemZonedDateTime: " + ontemZonedDateTime(zonedDateTime));
        System.out.println(" amanhaZonedDateTime: " + amanhaZonedDateTime(zonedDateTime));
        System.out.println(" dataHojeOntemAmanha: " + dataHojeOntemAmanha(zonedDateTime));
        System.out.println(" idade: " + idade());
        System.out.println(" comparaData: " + comparaData());
        System.out.println(" dataHoraFormatada(): " + dataHoraFormatada());
        System.out.println(" acrescrentarEmZonedDateTimeDiasAndMeses(): " + acrescrentarEmZonedDateTimeDiasAndMeses(zonedDateTime));
        System.out.println(" percentualComDatas: " + percentualComDatas());
    }

    private static String percentualComDatas(){
        Date dataOcorrencia = Date.from(LocalDate.of(2022, 2, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dataInicioVigencia = Date.from(LocalDate.of(2023, 3, 3).atStartOfDay(ZoneId.systemDefault()).toInstant());
        LocalDate dataOcorrencia2 = LocalDate.of(2022, 2, 1);
        LocalDate dataInicioVigencia2 = LocalDate.of(2023, 3, 3);
//
        Instant instant = Instant.parse( "2022-01-23T12:34:56.789Z" ) ;
        
//        Date dataFinalVigencia = new Date("2023-03-03");
//        Date dataUltimoPagamento = new Date("2023-03-03");
        Duration dur = Duration.between(dataOcorrencia.toInstant(), dataInicioVigencia.toInstant()); //pega a duração da diferença dos dois

        System.out.println(dur.toDays());

        Period period = Period.between(dataOcorrencia2, dataInicioVigencia2);
        long days = period.getDays();

        return " quantidade dias duration - : " + dur.toDays() + " quantidade dias Period: " + period.getDays();
    }

    private static String acrescrentarEmZonedDateTimeDiasAndMeses(ZonedDateTime zonedDateTime){
        if (zonedDateTime == null) {return null;}

        return " \n \n data hora inicial: " + zonedDateTime
                + " \n \n data hora nova: " + zonedDateTime.plusMonths(9).plusDays(7);
    }

    private static String dataHoraFormatada() {

        return DateTimeFormatter.ofPattern("'Gerado por eMed às' HH'h de' dd 'de' MMM 'de' yyyy").format(LocalDateTime.now());

    }

    private static String comparaData() throws ParseException {
        ZonedDateTime dataCitopatologia = ZonedDateTime.of(LocalDateTime.of(2020, 10, 20, 10, 21), ZoneId.of("America/Fortaleza"));
        LocalDate dataNascimentoPaciente = LocalDate.of(2021, 2, 22);

        LocalDate mesAnoDataCitopatologia = LocalDate.parse(dataCitopatologia.format(DateTimeFormatter.ofPattern("yyyy-MM"))+"-01");
        LocalDate mesAnoDataNascimentoPaciente = LocalDate.parse(dataNascimentoPaciente.format(DateTimeFormatter.ofPattern("yyyy-MM"))+"-01");
        boolean isMenorMesAnoDataCitopatologia = mesAnoDataCitopatologia.compareTo(mesAnoDataNascimentoPaciente) < 0;

        return " \n \n Comparação entre datas. mesAnoDataCitopatologia: " + mesAnoDataCitopatologia
                + " e mesAnoDataNascimentoPaciente: " + mesAnoDataNascimentoPaciente
                + "\n comparacao: mesAnoDataCitopatologia menor que mesAnoDataNascimentoPaciente? " + isMenorMesAnoDataCitopatologia;
    }

    private static String idade(){
        LocalDateTime dataHoraNascimento = LocalDateTime.of(1980, 6, 4, 19, 18);
        dataHoraNascimento.atZone(ZoneId.of("America/Fortaleza"));
        ZonedDateTime dataHoraAgora = ZonedDateTime.of (LocalDateTime.now(), ZoneId.of("America/Fortaleza"));
        LocalDate dataHoje = dataHoraAgora.toLocalDate();

        int idadeAnoPeriod = Period.between(dataHoraNascimento.toLocalDate(), LocalDate.now()).getYears();
        int idadeMesPeriod = Period.between(dataHoraNascimento.toLocalDate(), LocalDate.now()).getMonths();

        return " \n \n idade: " + idadeAnoPeriod + " anos e " + idadeMesPeriod + " meses " +
                " \n dataNascimento: " + dataHoraNascimento.toLocalDate() +
                " \n dataHoje " + dataHoje;
    }


    private static String dataHojeOntemAmanha(ZonedDateTime zonedDateTime){
        if (zonedDateTime == null) {return null;}
        ZonedDateTime dataHoraAgora = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
        ZonedDateTime dataHoraAustralia = ZonedDateTime.now(ZoneId.of("America/Fortaleza"));

        ZonedDateTime dataHoraAustralia1 = dataHoraAustralia.withZoneSameLocal(ZoneId.of("Australia/Sydney"));


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String timestamp = dateTimeFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(dataHoraAgora.getNano()), dataHoraAgora.getZone()));

        ZonedDateTime dateTimeShanghai = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        String timeShanghai = dateTimeShanghai.format(DateTimeFormatter.ofPattern("HH:mm"));

        long segundosHorarioMoscow = LocalTime.ofInstant(dataHoraAgora.toInstant(), dataHoraAgora.getZone()).toNanoOfDay();

        String horaMoscow =  DateTimeFormatter.ofPattern("HH:mm").format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(segundosHorarioMoscow), dataHoraAgora.getZone()));
        String horaFortaleza =  DateTimeFormatter.ofPattern("HH:mm").format(dataHoraAgora);
        String horaAustralia =  dataHoraAustralia1.format(DateTimeFormatter.ofPattern("HH:mm"));
        String horaUtc =  DateTimeFormatter.ofPattern("HH:mm").format(dataHoraAgora);

        LocalDate dataHoje = dataHoraAgora.toLocalDate();
        LocalDate dataAmanha   = dataHoraAgora.minusDays(-1).toLocalDate();
        LocalDate dataOntem   = dataHoraAgora.minusDays(1).toLocalDate();
        return " \n \n dataHoje: " + dataHoje +
                " \n dataOntem: " + dataOntem +
                " \n dataAmanha " + dataAmanha;
    }

    private static String diaAnteriorLocalDateTime(LocalDateTime localDate){
        if (localDate == null) {return null;}
        Calendar cal = new GregorianCalendar();
        cal.setTime(Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant()));
        cal.add(Calendar.DAY_OF_MONTH , -1);
        return " Data: " + localDate + " andterior: " + cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private static String diaAnteriorZonedDateTime(ZonedDateTime zonedDateTime){
        if (zonedDateTime == null) {return null;}
        ZonedDateTime zonedDateTimeNow =
                ZonedDateTime.of(LocalDateTime.now(), zonedDateTime.getZone());

        LocalDate dateNow   = zonedDateTimeNow.toLocalDate();
        LocalDate dateEnviado = zonedDateTime.toLocalDate();

        return " \n \n dateNow: " + dateNow +
                " \n dateEnviado: " + dateEnviado +
                " \n a date enviada " + dateEnviado +" é anterior á " + dateNow +", verdade? -> " + dateEnviado.isBefore(dateNow)+"\n \n \n ";
    }

    private static String ontemZonedDateTime(ZonedDateTime zonedDateTime){
        if (zonedDateTime == null) {return null;}
        ZonedDateTime zonedDateTimeNow =
                ZonedDateTime.of(LocalDateTime.now(), zonedDateTime.getZone());

        LocalDate dateOnten   = zonedDateTimeNow.minusDays(1).toLocalDate();
        LocalDate dateEnviado = zonedDateTime.toLocalDate();

        return " \n \n dateOnten: " + dateOnten +
                " \n dateEnviado: " + dateEnviado +
                " \n equals: " + dateOnten.isEqual(dateEnviado)+"\n \n \n ";
    }
    private static String amanhaZonedDateTime(ZonedDateTime zonedDateTime){
        if (zonedDateTime == null) {return null;}
        ZonedDateTime zonedDateTimeNow =
                ZonedDateTime.of(LocalDateTime.now(), zonedDateTime.getZone());

        LocalDate dateAmanha   = zonedDateTimeNow.minusDays(-1).toLocalDate();
        LocalDate dateEnviado = zonedDateTime.toLocalDate();

        return " \n \n dateOnten: " + dateAmanha +
                " \n dateEnviado: " + dateEnviado +
                " \n equals: " + dateAmanha.isEqual(dateEnviado)+"\n \n \n ";
    }
    private static String compararZonedDateTimeSobtraindoDias(ZonedDateTime zonedDateTime){
        if (zonedDateTime == null) {return null;}
        ZonedDateTime zonedDateTimeEuropeLondon =
                ZonedDateTime.of(LocalDateTime.now(), zonedDateTime.getZone());

        Calendar cal = new GregorianCalendar();
        cal.setTime(Date.from(zonedDateTimeEuropeLondon.toInstant()));
        cal.add(Calendar.DAY_OF_MONTH , -1);
        LocalDateTime localDateOntem = cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        return " \n \n zonedDateTime: " + zonedDateTime +
                " \n zonedDateTimeOntem: " + zonedDateTimeEuropeLondon.minusDays(1) +
                " \n localDateOntem: " + localDateOntem +
                " \n equals: " + zonedDateTimeEuropeLondon.minusDays(1).isEqual(zonedDateTime)+"\n \n \n ";
    }

    private static LocalDateTime primeiroDiaSemana(LocalDateTime localDate){
        if (localDate == null) {return null;}
        Calendar cal = Calendar.getInstance();
        cal.setTime(Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant()));
        cal.setFirstDayOfWeek (Calendar.SUNDAY);
        int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
        cal.add (Calendar.DAY_OF_MONTH, Calendar.SUNDAY - diaSemana);
        return cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    private static LocalDateTime ultimoDiaSemana(LocalDateTime localDate){
        if (localDate == null) {return null;}
        Calendar cal = Calendar.getInstance();
        cal.setTime(Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant()));
        cal.setFirstDayOfWeek (Calendar.SUNDAY);
        int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
        cal.add (Calendar.DAY_OF_MONTH, Calendar.SUNDAY - (diaSemana - 6));
        return cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private static LocalDateTime primeiroDiaMes(LocalDateTime localDate){
        if (localDate == null) {return null;}
        Calendar cal = Calendar.getInstance();
        cal.setTime(Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant()));
        cal.set (Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private static LocalDateTime ultimoDiaMes(LocalDateTime localDate){
        if (localDate == null) {return null;}
        Calendar cal = Calendar.getInstance();
        cal.setTime(Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant()));
        cal.set (Calendar.DAY_OF_MONTH, cal.getActualMaximum (Calendar.DAY_OF_MONTH));
        return cal.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
