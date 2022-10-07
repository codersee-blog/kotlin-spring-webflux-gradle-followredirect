package com.codersee.webclientredirect

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient

@Configuration
class Config {

    companion object {
        private const val BASE_URL = "http://localhost:8090"
    }

    @Bean
    fun webClientOne(httpClientOne: HttpClient): WebClient =
        WebClient.builder()
            .clientConnector(ReactorClientHttpConnector(httpClientOne))
            .baseUrl(BASE_URL)
            .build()

    @Bean
    fun webClientTwo(httpClientTwo: HttpClient): WebClient =
        WebClient.builder()
            .clientConnector(ReactorClientHttpConnector(httpClientTwo))
            .baseUrl(BASE_URL)
            .build()

    @Bean
    fun webClientThree(httpClientThree: HttpClient): WebClient =
        WebClient.builder()
            .clientConnector(ReactorClientHttpConnector(httpClientThree))
            .baseUrl(BASE_URL)
            .build()

    @Bean
    fun webClientFour(httpClientFour: HttpClient): WebClient =
        WebClient.builder()
            .clientConnector(ReactorClientHttpConnector(httpClientFour))
            .baseUrl(BASE_URL)
            .build()

    @Bean
    fun webClientFive(httpClientFive: HttpClient): WebClient =
        WebClient.builder()
            .clientConnector(ReactorClientHttpConnector(httpClientFive))
            .baseUrl(BASE_URL)
            .build()

    @Bean
    fun httpClientOne(): HttpClient =
        HttpClient.create()

    // Removes sensitive headers
    @Bean
    fun httpClientTwo(): HttpClient =
        HttpClient.create()
            .followRedirect(true)

    // Print request info and add a new header
    @Bean
    fun httpClientThree(): HttpClient =
        HttpClient.create()
            .followRedirect(true) { redirectRequest ->
                println("URI: ${redirectRequest.uri()}")
                println("Is follow redirect: ${redirectRequest.isFollowRedirect}")
                println("Redirected from: ${redirectRequest.redirectedFrom().firstOrNull()}")
                println("Resource URL: ${redirectRequest.resourceUrl()}")
                println("Request headers: ${redirectRequest.requestHeaders()}")
                redirectRequest.addHeader("another-header", "another-value")
            }

    // Redirect only when a given conditions are met
    @Bean
    fun httpClientFour(): HttpClient =
        HttpClient.create()
            .followRedirect { clientRequest, clientResponse ->
                clientRequest.requestHeaders().contains("custom-header")
                    && clientResponse.status().code() == 302
            }

    // Re-add all headers. Use with caution!
    @Bean
    fun httpClientFive(): HttpClient =
        HttpClient.create()
            .followRedirect(true) { headers, request ->
                request.headers(headers)
            }
}