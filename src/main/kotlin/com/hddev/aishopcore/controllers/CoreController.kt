package com.hddev.aishopcore.controllers

import com.hddev.aishopcore.model.InputDTO
import com.hddev.aishopcore.model.PredictionRequestDTO
import com.hddev.aishopcore.model.PredictionStatusDTO
import org.springframework.http.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.util.*


@RestController
class CoreController {

    @GetMapping("/generate")
    fun generate() {
        val endpoint = "https://api.replicate.com/v1/predictions"
    }

    @GetMapping("/status")
    fun getStatus(@RequestParam(value = "id", defaultValue = "123") id: String): PredictionStatusDTO {

//        val restTemplate = RestTemplate()
//        val uri = ""
//
//        val headers = HttpHeaders()
//        headers.accept = Collections.singletonList(MediaType.APPLICATION_JSON)
//        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
//        headers.add("Authorization", )
//
//        val entity: HttpEntity<PredictionRequestDTO> = HttpEntity(PredictionRequestDTO(VERSION, InputDTO("")), headers)
//        val result: ResponseEntity<*> = restTemplate.exchange(uri, HttpMethod.GET, entity, PredictionRequestDTO::class.java)
//        return result.body as PredictionStatusDTO

        return PredictionStatusDTO(id, "", null).apply {
            output = arrayListOf("https://replicate.delivery/pbxt/jXV2JKLaovbmGBVtbrmSBHvh2CIadqaf6fmR3XXizV9233MQA/out-0.png")
        }
    }

    companion object {
        const val VERSION = "e5e1fd333a08c8035974a01dd42f799f1cca4625aec374643d716d9ae40cf2e4"

    }
}