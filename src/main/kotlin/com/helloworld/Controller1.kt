package com.helloworld

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.ApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

@RestController
@RefreshScope
class Controller1(val applicationContext: ApplicationContext) {
    @Value("\${axis.toggles.toggle5}")
    lateinit var toggle5: String

    @GetMapping("/v2/dummy/api")
    fun dummyAPI(): Map<String, String> {
        println("*********************${applicationContext.getBean(Controller1::class.java)}")
        return mapOf(Pair("toggle5", toggle5))
    }

    @PostConstruct
    fun postConstruct() {
        println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&& calling post construct")
    }
}