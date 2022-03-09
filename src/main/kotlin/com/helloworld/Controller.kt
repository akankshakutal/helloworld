package com.helloworld

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.ApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

@RestController
@RefreshScope
class Controller(val applicationContext: ApplicationContext) {
    @Value("\${axis.toggles.toggle1}")
    lateinit var toggle1: String

    @Value("\${axis.toggles.toggle3}")
    lateinit var toggle3: String

    @Value("\${axis.toggles.commonToggle}")
    lateinit var commonToggle: String

    @GetMapping("/v1/dummy/api")
    fun dummyAPI(): Map<String, String> {
        println("*********************${applicationContext.getBean(Controller::class.java)}")
        return mapOf(Pair("toggle1", toggle1), Pair("toggle3", toggle3), Pair("commonToggle", commonToggle))
    }

    @PostConstruct
    fun postConstruct() {
        println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&& calling post construct")
    }
}