import org.junit.Test

internal class AddMethodTest {

    data class Data(val data: Int = 0)

    @Test
    fun `if head is null, create element as head and return true`() {
        val instance = linkedList<Data>()
        val operation = instance.add(Data(0))
        assert(instance.head != null && operation)
    }

    @Test
    fun `increase the size of list and return true`() {
        val instance = linkedList(Data(0))
        val beforeElements = instance.getAll().size
        val operation = instance.add(Data(0))
        val afterElements = instance.getAll().size
        assert(beforeElements + 1 == afterElements && operation)
    }

    @Test
    fun `add the element in the last position and return true`() {

        val instance = linkedList<Data>()
        instance.addAll(listOf(Data(0), Data(0), Data(0)))

        val element = Data(1000)
        val operation = instance.add(element)

        assert(instance.last?.data == element && operation)
    }

    @Test
    fun `if removed elements and add after, it does add and return true`() {
        val instance = linkedList<Data>()
        instance.addAll(listOf(Data(), Data(), Data()))
        instance.removeAll()
        val operation = instance.add(Data())
        assert(operation && instance.getAll().size == 1)
    }

}