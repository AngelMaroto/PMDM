import kotlin.reflect.KProperty

interface MiniLazy<T>{
    val valor:T
/*Version con sintaxis Java, para que se entienda
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }
    */
    //La invocación a esta función provoca la llamada al método get() de la propiedad valor
    //que se implementa en la clase que implemente la interface

  operator fun getValue(thisRef:Any?,propiedad: KProperty<*>):T=valor
}

//Clase delegada
class MiniLazyImpl<T>(private val inicializador: () -> T) : MiniLazy<T> {
    private var _value: T? = null
    private var inicializado = false
    override val valor:T
        get(){
            if(!inicializado)
            {
                _value=inicializador()
                inicializado=true
            }
            return _value as T
        }





}

// Función constructora como lazy { ... }
fun <T> miniLazy(initializer: () -> T): MiniLazy<T> = MiniLazyImpl(initializer)