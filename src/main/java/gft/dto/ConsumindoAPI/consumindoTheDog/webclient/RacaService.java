package gft.dto.ConsumindoAPI.consumindoTheDog.webclient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import gft.dto.ConsumindoAPI.consumindoTheDog.entities.Raca;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RacaService {

	private final WebClient webClient;

	public RacaService(WebClient.Builder builder) {
		webClient = builder.baseUrl("https://api.thedogapi.com/").build();

	}

	public Mono<Raca> buscarRacaPorId(String id) {
		return webClient.get().uri("v1/breeds/" + id + "api_key=5a6a0d16-7b19-4c77-ba60-71f5eb119c8d")
				.accept(APPLICATION_JSON).retrieve().onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parametros")))
				.bodyToMono(Raca.class);

	}

	public Flux<Raca> buscarTodasAsRacas() {
		return webClient.get().uri("v1/breeds").accept(APPLICATION_JSON).retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parametros")))
				.bodyToFlux(Raca.class);
	}

	public Flux<Raca> buscarRacaPorNome(String raca) {
		return webClient.get().uri("v1/breeds/search?q=" + raca).accept(APPLICATION_JSON).retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parametros")))
				.bodyToFlux(Raca.class);
	}
	

}

