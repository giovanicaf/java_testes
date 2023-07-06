import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CaractereRandom {
    static String getRandomString(int qtdCaracteres)
    {
        String caracteres  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";

        return String.valueOf(IntStream.range(0, caracteres.length()).limit(qtdCaracteres)
                .mapToObj(a -> {
                    int index = (int) (caracteres.length() * Math.random());
                    return caracteres.charAt(index);
                }).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append));
    }

    public static void main(String[] args)
    {
        // the random string length
        int i = 8;

        // output
        System.out.println("A random string: " +  getRandomString(i));
    }
}


