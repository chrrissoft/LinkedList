import org.junit.Test

internal class RemoveMethodTest {

    data class Data(val data: Int = 0)

    @Test
    fun `remove head when size is 1 and return true`() {
        val head = Data()
        val instance = linkedList(head)
        val operation = instance.remove(head)
        assert(instance.head == null && operation)
    }

    @Test
    fun `remove head when size is great 1 and return true`() {
        val head = Data()
        val instance = linkedList(listOf(head, Data(), Data()))
        val operation = instance.remove(head)
        assert(instance.head!!.data !== head && operation)
    }

    @Test
    fun `if element does not exist when size is 1, do nothing and return false`() {
        val element = Data()
        val instance = linkedList(Data())
        val operation = instance.remove(element)
        assert(instance.head!!.data !== element && !operation)
    }

    @Test
    fun `if element does not exist when size is great 1, do nothing and return false`() {
        val element = Data()
        val instance = linkedList(listOf(Data(), Data(), Data()))
        val operation = instance.remove(element)
        assert(instance.head!!.data !== element && !operation)
    }
}