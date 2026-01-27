class Persona {
    val nombre by miniLazy {
        println("Inicializando nombre ")
        "Roberto" }
}