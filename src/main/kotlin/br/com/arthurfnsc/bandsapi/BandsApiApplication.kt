package br.com.arthurfnsc.bandsapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BandsApiApplication

fun main(args: Array<String>) {
	runApplication<BandsApiApplication>(*args)
}
