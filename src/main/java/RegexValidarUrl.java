import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RegexValidarUrl {



    public static void main(String[] args) {

        String regex = "(https?://|www\\.)[-a-zA-Z0-9+&@#/%?=~_|!:.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        List<String> emails = Arrays.asList(
                        "giovani",
                        "http://teste1.com",
                        "http://teste2.com.br.br.br",
                        "https://teste3.com.br.br.br",
                        "https://www.teste4.com.br.br.br",
                        "http://www.teste5.com.br",
                        "giovani.filho@cwi.com.br"
                );

        emails.forEach(e -> {
            if (!Pattern.matches(regex, e)) {
                System.out.println(" Reprovou: " + e);
            }
        });
    }
}
