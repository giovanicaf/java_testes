import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) {
//        System.out.println(Pattern.matches("(?=.*[}{,.^?~=+\\-_/*-.|])(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}", "As2asaa2/"));
//
//        System.out.println(Pattern.matches("(?=.*[}{()$#%!&:;,.^?~=+\\-_/*|])(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}", "Asasaa*1(("));
//
//
//        System.out.println(Pattern.matches("(?=.*[}{,.^?~=+\\-_/*-.|])(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}", "As2asaa2?"));
//        System.out.println(Pattern.matches("(?=.*[}{,.^?~=+\\-_/*-.|])(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}", "As2asaa2="));
//
//
//        // Retira epaço em branco do inicio e do final da ssstring
//        System.out.println(Pattern.matches("\\S(.*\\S)?", "As2asa a2="));

       // Valida CPF e CNPJ
        String cpfOrCnpj = "23362783000159";
        System.out.println("É válido? " + Pattern.matches("^([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})|([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\\\/]?[0-9]{4}[\\-]?[0-9]{2})$", cpfOrCnpj));
    }
}
