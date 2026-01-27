import kotlin.reflect.KProperty

//CLASE que hace uso de la delegacion
class IntegerReader {
    var input: String? by UserInput()
    var number: Int = 5
}

//CLASE DELEGADA OARA DELEGAR PROPIEDADES
class UserInput {
    operator fun getValue(thisRef: IntegerReader, property: KProperty<*>): String = thisRef.number.toString()

    operator fun setValue(thisRef: IntegerReader, property: KProperty<*>, value: String?) {
        thisRef.number = value?.toIntOrNull() ?: 0
    }
}//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val reader = IntegerReader()

    print("Digita número:")
    //Se invoca implicitamente a setValue, que realmente asigna valor a number
    reader.input = readLine()

    println("Tu número es:${reader.number}")
    //Se invoca implicitamente a getValue, que realmente accede a number y lo convierte a String
    println("El texto que valor tiene:${reader.input}")
    
    //PROBANDO EL MINILAXY
    //Esto declaración la convierte Kotlin en algo asi:
    //1º Instancia un objeto MiniLazy, a traves de la función miniLazy, a la que se la pasa el
    //inicializador
    //val delegado=miniLazy{ println "Probando minilazy" "Hola mundo"}
    //2º Se invoca al método getValue del objeto instanciado, este provoca
    //3º un acceso a la propiedad value, que a su vez invoca al método get() de la clase Instanciada MiniLazy
   // 4º Dentro de la función get() se comprueba si el valor esta inicializado,
    // y no es asi se ejecuta el inicializador que debe retornar un valor además de ejecutar código, ese
    //valor se asigna al atributo privado _value y es el que se retorna y se asigna a mensaje
    //
    //val mensaje=delegado.getValue()

    //Cada acceso a mensaje es una invocación implicita de getValue
    val mensaje by miniLazy {
        println("Probando minilazy")
    "Hola mundo"}

    val dato by miniLazy {
        println("Probando ota invocacion")
        6
    }

    println(dato.toString())

    //Realmente mensaje accede a el método getValue del delegado
    println(mensaje)



    println(mensaje::class.java) //Devuelve String, porque realmente Kotlin o Java hace
   /* val mensaje by miniLazy { "Hola mundo" }
    Kotlin lo transforma aproximadamente a:


    private val mensajedelegate = miniLazy { "Hola mundo" }
    //Es decir, define un getter de mensaje que invoca a getValue
    val mensaje: String
    get() = mensajedelegate.getValue(this, ::mensaje) */

}

