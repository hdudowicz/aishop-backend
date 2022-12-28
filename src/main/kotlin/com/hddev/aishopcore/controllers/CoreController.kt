package com.hddev.aishopcore.controllers

import com.hddev.aishopcore.model.InputDTO
import com.hddev.aishopcore.model.PredictionRequestDTO
import com.hddev.aishopcore.model.PredictionStatusDTO
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import java.lang.NullPointerException
import java.util.*


@RestController
class CoreController {
//    @GetMapping("/status")
//    fun getStatus(@RequestParam(value = "id", defaultValue = "123") id: String): PredictionStatusDTO {
//
////        val restTemplate = RestTemplate()
////        val uri = ""
////
////        val headers = HttpHeaders()
////        headers.accept = Collections.singletonList(MediaType.APPLICATION_JSON)
////        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
////        headers.add("Authorization", )
////
////        val entity: HttpEntity<PredictionRequestDTO> = HttpEntity(PredictionRequestDTO(VERSION, InputDTO("")), headers)
////        val result: ResponseEntity<*> = restTemplate.exchange(uri, HttpMethod.GET, entity, PredictionRequestDTO::class.java)
////        return result.body as PredictionStatusDTO
//
//        return PredictionStatusDTO(id, "", null).apply {
//            output = arrayListOf("https://replicate.delivery/pbxt/jXV2JKLaovbmGBVtbrmSBHvh2CIadqaf6fmR3XXizV9233MQA/out-0.png")
//        }
//    }
    // TODO: Find why auth token is not being passed
    @PostMapping(path = ["/generate"])
    fun getGenStatus(@RequestBody() prompt: InputDTO?): PredictionStatusDTO {
//        if (prompt == null) throw RequestException
        val restTemplate = RestTemplate()

        val entity: HttpEntity<PredictionRequestDTO> = HttpEntity(PredictionRequestDTO(VERSION, prompt), generateHeaders())
        val result: ResponseEntity<PredictionStatusDTO> = restTemplate.exchange(REPLICATE_URL, HttpMethod.POST, entity, PredictionStatusDTO::class.java)
        return result.body as PredictionStatusDTO
    }

    @GetMapping("/status")
    fun getPredictionStatus(@RequestParam(value = "id") id: String): PredictionStatusDTO {
        val restTemplate = RestTemplate()

        val entity: HttpEntity<PredictionRequestDTO> = HttpEntity(PredictionRequestDTO(VERSION, InputDTO("")), generateHeaders())
        val result: ResponseEntity<PredictionStatusDTO> = restTemplate.exchange("$REPLICATE_URL/$id", HttpMethod.GET, entity, PredictionStatusDTO::class.java)
        return result.body as PredictionStatusDTO
    }

//    @PostMapping("/create-product")
//    fun createProduct(@RequestParam(value = "id") id: String): ResponseEntity<*> {
//        val restTemplate = RestTemplate()
//
//        val entity
//    }

    companion object {
        const val VERSION = "e5e1fd333a08c8035974a01dd42f799f1cca4625aec374643d716d9ae40cf2e4"
        const val REPLICATE_API_TOKEN = "e5dc75b21a33355a30c78a4d3331445d807f9724"
        const val REPLICATE_URL = "https://api.replicate.com/v1/predictions"

        fun generateHeaders(): HttpHeaders {
            return HttpHeaders().apply {
                accept = Collections.singletonList(MediaType.APPLICATION_JSON)
                add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
                add("Authorization", "Token $REPLICATE_API_TOKEN")
                add("Content-Type", "application/json")
            }
        }
    }
}