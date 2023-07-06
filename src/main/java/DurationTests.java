import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class DurationTests {
    public static void main(String[] args) {


        LocalTime localTime = LocalTime.of(9, 30, 19, 18);
        LocalTime start = LocalTime.of(0, 10, 0, 0);
       // LocalTime start = LocalTime.parse("10:00:00");
        long secondOfDay = start.toNanoOfDay();


        long millis = Instant.parse(start.toString()).toEpochMilli();
        System.out.println("millis =" + millis);

        Duration duration = millisegundosToDuration(secondOfDay);

        System.out.println("tempo = " + millisegundosToStringDuration(secondOfDay));
        System.out.println("durationToMillisegundos = " + durationToMillisegundos(duration));
        System.out.println("durationToString = " + durationToString(duration));
        System.out.println("durationToString = " + durationToString(duration));

    }

    /** Recebe uma String de duation PT2S e retrna uma Duration **/
    public static Duration stringToDuration(String stringDuration){
        return Duration.parse(stringDuration);
    }

    /** Recebe uma millisegundos e retorna String de duation PT2S **/
    public static String millisegundosToStringDuration(Long milliseconds){
        long millis =  (milliseconds != null) ? milliseconds : 0L;
        return Duration.ofMillis( millis ).toString();
    }

    /** Recebe uma Duration e retorna Millisegundos **/
    public static long durationToMillisegundos(Duration duration){

        return TimeUnit.MILLISECONDS.convert(duration);
    }

    /** Recebe uma millisegundos e retorna duation PT2S **/
    public static Duration millisegundosToDuration(Long milliseconds){
        long millis =  (milliseconds != null) ? milliseconds : 0L;
        return Duration.ofMillis( millis );
    }

    /** Recebe uma Duration e retorna String de LocalTime **/
    public static String durationToString(Duration duration){

        LocalTime localTime = LocalTime.MIDNIGHT.plus(duration);
        return localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
