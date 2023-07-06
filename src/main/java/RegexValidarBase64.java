import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidarBase64 {

    private static final String URL_PATTERN =
            "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";

    private static final Pattern pattern = Pattern.compile(URL_PATTERN, Pattern.CASE_INSENSITIVE);

    public static boolean validar(String texto){
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    public static void main(String[] args) {

        var texto = "ewogICAgInVzdWFyaW8iOiAiSm9zw6kiLAogICAgImRlc2Jsb3F1ZWFkbyI6ICJmYWxzZSIsCiAgICAibWFyY2EiOiAiRGVsbCIsCiAgICAibW9kZWxvIjogIlBsZW5pdHVkZSIsCiAgICAic2lzdGVtYU9wZXJhY2lvbmFsIjogIkxpbnV4IiwKICAgICJhZ2VudGVEZVVzdWFyaW8iOiAiYXBwIiwKICAgICJwcm92ZWRvckludGVybmV0IjogIkNsYXJvIiwKICAgICJpcEVuZGVyZWNvIjogIjEyNy4wLjAuMSIsCiAgICAiY2lkYWRlIjogIkZvcnRhbGV6YSIsCiAgICAiZXN0YWRvIjogIkNlIiwKICAgICJsYXRpdHVkZSI6ICIxMjMxMjMxMjMiLAogICAgImxvbmdpdHVkZSI6ICI1Njc1Njc1NjciCn0KICAgIA==";

        System.out.println(" Resultado: " + validar(texto));
    }
}
