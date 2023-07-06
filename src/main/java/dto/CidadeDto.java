package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CidadeDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String codigoIbge;
	private Long idEstado;
	private EstadoDto estado;
	private LocalDate dataRegistro;
	private LocalDateTime dataHoraRegistro;
	private ZonedDateTime dataIbge;
	private Float area;
	private Boolean possuePrefeitura;
	public static CidadeDto createMockCidadeDto(){
		CidadeDto cidade = new CidadeDto();
		cidade.setId(1L);
		cidade.setNome("Fortaleza");
		cidade.setCodigoIbge("1238");
		cidade.setIdEstado(1L);
		cidade.setDataRegistro(LocalDate.now());
		cidade.setDataHoraRegistro(LocalDateTime.now());
		cidade.setDataIbge(ZonedDateTime.now());
		cidade.setArea(10.55F);
		cidade.setPossuePrefeitura(Boolean.TRUE);
		cidade.setEstado(EstadoDto.createMockEstadoDto());
		return cidade;
	}
}
