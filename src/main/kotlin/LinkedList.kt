interface LinkedList<T> {

    var head: Node<T>?
    var last: Node<T>?

    fun remove(element: T): Boolean

    fun removeAll(): Boolean

    fun removeAt(index: Int): Boolean

    fun add(element: T): Boolean

    fun addAt(index: Int, element: T): Boolean

    fun addAll(elements: List<T>): Boolean

    fun replace(oldElement: T, newElement: T): Boolean

    fun replaceHead(newElement: T): Boolean

    fun replaceAt(index: Int, element: T): Boolean

    fun getAt(index: Int): T?

    fun getAll(): List<T>

    fun isEmpty(): Boolean

    fun isNotEmpty(): Boolean

    fun size(): Int
}