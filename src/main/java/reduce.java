import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;

public class reduce {
    public static void main(String[] args) {

        String frase = "Teste de reduce";
        String[] splitFrase = frase.split(" ");
        List<String> palavras = Arrays.asList(splitFrase);
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numerosVazio = new ArrayList<>();

        // 1 + 2 + 3 + 4 + 5 + 6
        Optional<Integer> soma = numeros.stream().reduce((n1, n2) -> n1 + n2);
        System.out.println(soma.get());

        // 1 * 2 * 3 * 4 * 5 * 6
        Optional<Integer> multiplicacao = numeros.stream().reduce((n1, n2) -> n1 * n2);
        System.out.println(multiplicacao.get());

        // Teste+" "+de+" "+reduce
        Optional<String> concatenacao = palavras.stream().reduce((n1, n2) -> n1.concat(" ").concat(n2));
        System.out.println(concatenacao.get());

        // valor de identidade é um parâmetro passado como default para a operação

        // Valor de identidade para soma é 0 pq 0 somado a qualquer número é igual ao próprio número
        Integer soma2 = numerosVazio.stream().reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(soma2);

        // Valor de identidade para soma é 0 pq 0 somado a qualquer número é igual ao próprio número
        Integer soma3 = numeros.stream().reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(soma3);

        // Valor de identidade para multiplicacao é 1 pq 1 multiplicado a qualquer número é igual ao próprio número
        Integer multiplicacao2 = numeros.stream().reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(multiplicacao2);

        // Valor de identidade para String é ""(String vazia) pq "" concatenado a qualquer string é igual a própria string
        String concatenacao2 = palavras.stream().reduce("", (n1, n2) -> n1.concat(" ").concat(n2));
        System.out.println(concatenacao2);

        OptionalDouble fracao = DoubleStream.of(1.5, 2.9, 6.7)
                .reduce((d1, d2) -> Math.min(d1, d2));
        System.out.println(fracao);

        double fracao2 = DoubleStream.of(1.5, 2.9, 6.7)
                .reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
        System.out.println(fracao2);

        // Passando terceiro argumento com função de combinação
        // Primeiro argumento é a função de acumulação e o segundo combinaçãono caso da soma serão os mesmos
        // Serve para paralelismo
        Integer soma4 = numeros.stream().reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
        System.out.println(soma4);

        Optional<String> concatenacaoNumeros = numeros.stream()
                .map(Object::toString)
                .reduce((n1, n2) -> n1.concat(n2));
        System.out.println(concatenacaoNumeros.get());

        String concatenacaoNumeros2 = numeros.stream()
                .reduce(
                        "",
                        (n1, n2) -> n1.toString().concat(n2.toString()),
                        (n1, n2) -> n1.concat(n2)
                );
        System.out.println(concatenacaoNumeros2);
    }
}
