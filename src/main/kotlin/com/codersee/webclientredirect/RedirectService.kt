package com.codersee.webclientredirect

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class RedirectService(
    private val webClientOne: WebClient,
    private val webClientTwo: WebClient,
    private val webClientThree: WebClient,
    private val webClientFour: WebClient,
    private val webClientFive: WebClient
) {

    fun one(): Mono<ResponseBodyDto> =
        webClientOne.get()
            .uri("/some-endpoint")
            .header("custom-header", "custom-header-value")
            .header("Authorization", "Bearer value")
            .retrieve()
            .bodyToMono(ResponseBodyDto::class.java)


    fun two(): Mono<ResponseBodyDto> =
        webClientTwo.get()
            .uri("/some-endpoint")
            .header("custom-header", "custom-header-value")
            .header("Authorization", "Bearer value")
            .retrieve()
            .bodyToMono(ResponseBodyDto::class.java)

    fun three(): Mono<ResponseBodyDto> =
        webClientThree.get()
            .uri("/some-endpoint")
            .header("custom-header", "custom-header-value")
            .header("Authorization", "Bearer value")
            .retrieve()
            .bodyToMono(ResponseBodyDto::class.java)

    fun four(): Mono<ResponseBodyDto> =
        webClientFour.get()
            .uri("/some-endpoint")
            .header("custom-header", "custom-header-value")
            .header("Authorization", "Bearer value")
            .retrieve()
            .bodyToMono(ResponseBodyDto::class.java)

    fun five(): Mono<ResponseBodyDto> =
        webClientFive.get()
            .uri("/some-endpoint")
            .header("custom-header", "custom-header-value")
            .header("Authorization", "Bearer value")
            .retrieve()
            .bodyToMono(ResponseBodyDto::class.java)


    data class ResponseBodyDto(val message: String)
}

