package CatCatalog

import io.ktor.application.*
import io.ktor.html.respondHtml
import io.ktor.http.*
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.html.*

fun main() {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            static("/static") {
                resources("static")
            }

            get("/") {

                call.respondHtml {
                    head {
                        link(rel = "stylesheet", href = "/static/styles.css")
                    }
                    body {
                        div {
                            classes = setOf("some_block")
                            h2 { +"Hello! My name is Guusia" }
                            p {
                                +"Want to know "
                                a {
                                    href = "details"
                                    +"about me?"
                                }
                            }

                        }
                        img {
                            src = "/static/photo_2020-02-15.jpg"
                            width = "250"
                        }
                    }
                }
            }

            get("/details") {

                call.respondHtml {
                    head {
                        link(rel = "stylesheet", href = "/static/styles.css")
                    }
                    body {
                        div {
                            classes = setOf("some_block")
                            h2 { +"Hello! My name is Guusia" }

                        }
                        img {
                            src = "/static/photo_2020-02-15.jpg"
                            width = "250"
                        }
                    }
                }
            }


            /*
            get("/demo") {
                call.respondText("HELLO WORLD!")
            }

             */
        }
    }
    server.start(wait = true)

}


/*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.html.*
import kotlinx.html.*
import kotlinx.css.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val client = HttpClient(Apache) {
    }

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        get("/html-dsl") {
            call.respondHtml {
                body {
                    h1 { +"HTML" }
                    ul {
                        for (n in 1..10) {
                            li { +"$n" }
                        }
                    }
                }
            }
        }

        get("/styles.css") {
            call.respondCss {
                body {
                    backgroundColor = Color.red
                }
                p {
                    fontSize = 2.em
                }
                rule("p.myclass") {
                    color = Color.blue
                }
            }
        }
    }
}

fun FlowOrMetaDataContent.styleCss(builder: CSSBuilder.() -> Unit) {
    style(type = ContentType.Text.CSS.toString()) {
        +CSSBuilder().apply(builder).toString()
    }
}

fun CommonAttributeGroupFacade.style(builder: CSSBuilder.() -> Unit) {
    this.style = CSSBuilder().apply(builder).toString().trim()
}

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
    this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}
*/