package gft.dto.atendimento;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import br.ce.wcaquino.utils.DataUtils;
import gft.entities.Atendimento;

public class AtendimentoMappersDTO {

	public static Atendimento fromDTO(RegstraAtendimentoDTO dto) {
		Date data = DataUtils.obterData(LocalDateTime.now().getDayOfYear(),
				LocalDateTime.now().getMonthValue(), LocalDateTime.now().getYear());
		Date hora = Calendar.getInstance().getTime();
		return new Atendimento(null, dto.getPeso(),data,hora);
	}

	public static ConsultaAtendimentoDTO fromEntity(Atendimento atendimento) {
		return new ConsultaAtendimentoDTO(atendimento.getId(), atendimento.getPet(), atendimento.getPeso(),
				atendimento.getVeterinario(), atendimento.getData(), atendimento.getHora());
	}

}
