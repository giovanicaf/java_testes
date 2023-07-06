import java.util.Arrays;
import java.util.List;

public class CollectionListNumber {

    public static void main(String[] args) {

        Cliente cliente01 = Cliente.builder()
                .id(1L)
                .nome("José")
                .endereco("Rua tal")
                .build();

        Cliente cliente02 = Cliente.builder()
                .id(2L)
                .nome("Maria")
                .endereco("Rua y")
                .build();

        Cliente cliente03 = Cliente.builder()
                .id(3L)
                .nome("Joana")
                .endereco("Rua k")
                .build();

        List<Cliente> clientes = Arrays.asList(cliente01, cliente02, cliente03);

        List<Long> ids = clientes.stream().map(Cliente::getId).toList();
        System.out.println("ids : " + ids);
    }
}
