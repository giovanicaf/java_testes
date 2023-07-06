package dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(callSuper = true)
public class EstadoDto implements Serializable {

	@Serial
	private static final long serialVersionUID = -1L;

	private Long id;
	private String nome;
	private String sigla;
	private String codigoIbge;
	private Long idPais;
	public static EstadoDto createMockEstadoDto(){
		EstadoDto estado = new EstadoDto();
		estado.setId(1L);
		estado.setNome("Ceará");
		estado.setSigla("CE");
		estado.setCodigoIbge("25sd");
		estado.setIdPais(2L);
		return estado;
	}
}
