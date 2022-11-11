import org.junit.Test
import kotlin.random.Random

internal class AddAtMethodTest {

    data class Data(val data: Int = 0)

    @Test
    fun `if head is null and index is 0, create element as head and return true`() {
        val instance = linkedList<Data>()
        val operation = instance.addAt(0, Data())
        assert(instance.head != null && operation)
    }

    @Test
    fun `if head is null and index is greater 0, not create element as head and return false`() {
        val instance = linkedList<Data>()
        val operation = instance.addAt(Random(1).nextInt(), Data())
        assert(instance.getAll().isEmpty() && !operation)
    }

    @Test
    fun `if size is 1 and index 0, create element as head and move head at next and return true`() {
        val oldHead = Data()
        val instance = linkedList(Data())
        val newHead = Data()
        val operation = instance.addAt(0, newHead)
        assert(instance.getAt(0) == newHead && instance.getAt(1) == oldHead && operation)
    }

    @Test
    fun `if size is 1 and index greater 1, not create element and return false`() {
        val instance = linkedList(Data())
        val operation = instance.addAt(2, Data())
        assert(instance.getAll().size == 1 && !operation)
    }

    @Test
    fun `if index is next to last element, create that element`() {
        val instance = linkedList(Data(0))
        val beforeElements = instance.getAll()
        instance.addAt(1, Data(0))
        val afterElements = instance.getAll()
        assert(beforeElements.size + 1 == afterElements.size)
    }

    @Test
    fun `add the element in the correct position`() {

        val instance = linkedList<Data>()
        instance.addAll(listOf(Data(0), Data(0), Data(0)))

        val element = Data(1000)
        instance.addAt(1, element)

        instance.getAll().forEachIndexed { i, e ->
            if (i == 1) assert(e.hashCode() == element.hashCode())
        }
    }

    @Test
    fun `if element is created return true else return false`() {
        val instance = linkedList<Data>()

        val canBeCreated0 = instance.addAt(0, Data(0))
        val canBeCreated1 = instance.addAt(0, Data(1))
        val canBeCreated2 = instance.addAt(1, Data(2))
        val canBeCreated3 = instance.addAt(3, Data(2))

        val canNotBeCreated0 = instance.addAt(5, Data(3))
        val canNotBeCreated1 = instance.addAt(6, Data(4))
        val canNotBeCreated2 = instance.addAt(-5, Data(3))
        val canNotBeCreated3 = instance.addAt(-1, Data(3))

        val canBeCreate = canBeCreated0 && canBeCreated1 && canBeCreated2 && canBeCreated3
        val canNotBeCreate = !canNotBeCreated0 && !canNotBeCreated1 && !canNotBeCreated2 && !canNotBeCreated3

        assert(canBeCreate && canNotBeCreate)
    }

}