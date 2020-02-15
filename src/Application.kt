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
import java.util.*

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
                            classes = setOf("greeting")
                            h2 { +"Hello! My name is Guusia" }
                            p {
                                +"Want to know "
                                a {
                                    href = "details"
                                    +"about me?"
                                }
                            }
                        }
                        div {
                            classes = setOf("images")
                            img {
                                src = "/static/photo_2020-02-15.jpg"
                                width = "250"
                            }
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
                                classes = setOf("greeting")
                                h2 { +"I am Guusia" }

                            }

                            div {
                                classes = setOf("images")
                                img {
                                    src = "/static/photo_2020-02-15.jpg"
                                    width = "250"
                                }
                            }

                            div {
                                classes = setOf("info")
                                p { +"Age: ${(Calendar.getInstance().get(Calendar.YEAR)) - 2016}" }
                                p { +"Color: black-white-red" }
                                p { +"Breed: mongrel" }
                                p { +"Hair: shorthair" }
                                p { +"Favorite phrase: meow" }
                            }

                        }
                    }
                }


            }
        }
        server.start(wait = true)

    }