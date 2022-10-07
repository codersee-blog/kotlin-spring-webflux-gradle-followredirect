package com.codersee.webclientredirect

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/test")
class TestController(
    private val redirectService: RedirectService
) {

    @GetMapping("/one")
    fun one(): Mono<RedirectService.ResponseBodyDto> =
        redirectService.one()

    @GetMapping("/two")
    fun two(): Mono<RedirectService.ResponseBodyDto> =
        redirectService.two()

    @GetMapping("/three")
    fun three(): Mono<RedirectService.ResponseBodyDto> =
        redirectService.three()

    @GetMapping("/four")
    fun four(): Mono<RedirectService.ResponseBodyDto> =
        redirectService.four()

    @GetMapping("/five")
    fun five(): Mono<RedirectService.ResponseBodyDto> =
        redirectService.five()

}