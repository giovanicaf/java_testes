import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidarEmail {



    public static void main(String[] args) {

        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        List<String> emails = Arrays.asList(
                        "giovani",
                        "giovani teste@gmail.",
                        "giovani_teste@gmail.com",
                        "giovani_teste@gmail.com.br.br",
                        "giovani teste@gmail.com.br.br",
                        "giovani teste@gmail.com.br.br.br.br.br",
                        "giovani_teste@gmail.com.br.br.br.br.br",
                        "giovani_testegmail.com.br",
                        "giovani.teste@gmail.com.br",
                        "giovani+teste@gmail.com.br",
                        "giovani+teste@gmail.c",
                        "giovani.filho@cwi.com.br"
                );

        emails.forEach(e -> {
            if (!Pattern.matches(regex, e)) {
                System.out.println(" Reprovou: " + e);
            }
        });
    }
}
