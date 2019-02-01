import com.edu.keddit.NewsManagerTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import rx.observers.TestSubscriber
import java.lang.reflect.Field

class SolutionTest {
    private var testNewsManagerTest: NewsManagerTest? = null
    private var testSub: Field? = null

    @Before
    fun setup() {
        testNewsManagerTest = NewsManagerTest()
    }
    @Test
    fun testNewsSubscriberDeclared() {
        testSub = NewsManagerTest::class.java.getDeclaredField("testSub")
        testSub?.isAccessible = true
        val actualResult = testSub?.get(testNewsManagerTest)
        Assert.assertTrue("Checkout If you used TestSubscriber<> correctly, the testSub is not declared properly.", TestSubscriber::class.java.isInstance(actualResult))
    }
}
