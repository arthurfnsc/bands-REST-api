package br.com.arthurfnsc.bandsapi

import br.com.arthurfnsc.bandsapi.configs.AppProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableConfigurationProperties(AppProperties::class)
@EnableSwagger2
@SpringBootApplication
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}