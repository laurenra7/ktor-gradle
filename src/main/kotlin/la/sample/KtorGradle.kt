package la.sample

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    // For AWS ElasticBeanstalk, use port 5000
    val server = embeddedServer (Netty, 5000) {
        routing {
            get("/") {
                call.respondText("Greetings, Earthlings! Kotlin, Ktor and Gradle salute you now.", ContentType.Text.Html)
            }
        }
    }
    server.start(wait = true)
}