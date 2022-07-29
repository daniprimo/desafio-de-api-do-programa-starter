package gft.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.ConsumindoAPI.consumindoTheDog.entities.Raca;
import gft.dto.ConsumindoAPI.consumindoTheDog.webclient.RacaService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("v1/raca")
public class RacaController {

	private RacaService racaService;

	public RacaController(RacaService racaService) {
		this.racaService = racaService;
	}

	@GetMapping("{id}")
	public Mono<Raca> getRacaPorId(@PathVariable String id) {
		Mono<Raca> raca = racaService.buscarRacaPorId(id);
		return raca;

	}

	@GetMapping
	public Flux<Raca> getBuscarTodosID() {
		return racaService.buscarTodasAsRacas();
	}

	@GetMapping("/nome/{name}")
	public Flux<Raca> getBuscarPorNome(@PathVariable String name) {
		return racaService.buscarRacaPorNome(name);
	}

}
