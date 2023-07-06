import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dto.CidadeDto;

public class DeserioalizandoComObjectMapper {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("castSafe(String valor)="+safeCast(1, Integer.class));

        String json = convertObjectToJson(CidadeDto.createMockCidadeDto(), CidadeDto.class);
        System.out.println("json="+json);
        CidadeDto cidade = convertJsonToObject(json, new CidadeDto(), CidadeDto.class);
        System.out.println("cidade="+cidade.toString());
    }

    public static <T> T safeCast(Object o, Class<T> clazz) {
        return clazz != null && clazz.isInstance(o) ? clazz.cast(o) : null;
    }

    public static <T> T convertJsonToObject(String json, Object o, Class<T> clazz){
        try {
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
            return (T) objectMapper.readValue(json, clazz.cast(o).getClass());
        }
        catch (Exception e){
            throw new RuntimeException("Erro ao converter json para object." + e.getMessage());
        }
    }
    public static <T> String convertObjectToJson(Object o, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
            return objectMapper.writeValueAsString(clazz.cast(o));
        }
        catch (Exception e){
            throw new RuntimeException("Erro ao converter objeto para json." + e.getMessage());
        }
    }
}
