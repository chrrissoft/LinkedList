import org.junit.Test

internal class ReplaceMethodTest {

    data class Data(val data: Int = 0)

    @Test
    fun `replace element and return true`() {
        val element = Data(10000)
        val instance = linkedList(listOf(Data(), element, Data()))
        val new = Data(100)
        val operation = instance.replace(element, new)
        assert(instance.getAt(1) == new && operation)
    }

    @Test
    fun `not increase size and return true`() {
        val element = Data(10000)
        val instance = linkedList(listOf(Data(), element, Data()))
        val before = instance.size()
        val new = Data(100)
        val operation = instance.replace(element, new)
        val after = instance.size()
        assert(before == after && operation)
    }

    @Test
    fun `if element to replace not exist when size is 1, do nothing and return false`() {
        val element = Data()
        val instance = linkedList(listOf(Data()))

        val new = Data(100)
        val operation = instance.replace(element, new)

        assert(instance.getAt(0) !== new && !operation)
    }

    @Test
    fun `if element to replace not exist when size is greater 1, do nothing and return false`() {
        val element = Data()
        val instance = linkedList(listOf(Data(), Data(), Data()))

        val new = Data()
        val operation = instance.replace(element, new)

        assert(instance.getAt(0) !== new && !operation)
    }

    @Test
    fun `replace head when size is 1 and return true`() {
        val instance = linkedList(Data())

        val new = Data()
        val operation = instance.replace(instance.head!!.data, new)
        assert(instance.head!!.data === new && operation)
    }

    @Test
    fun `replace head when size is greater 1 and return true`() {
        val instance = linkedList(listOf(Data(), Data(), Data()))

        val new = Data()
        val operation = instance.replace(instance.head!!.data, new)

        assert(instance.head!!.data == new && operation)
    }

    @Test
    fun `replace last when size is greater 1 and return true`() {
        val instance = linkedList(listOf(Data(), Data(), Data()))

        val new = Data()
        val operation = instance.replace(instance.last!!.data, new)
        assert(instance.last!!.data !== new && operation)
    }

}