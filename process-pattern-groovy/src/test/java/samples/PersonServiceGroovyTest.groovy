package samples

import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNull

class PersonServiceGroovyTest {
    @Test
    void test1() {
        def s = new PersonServiceGroovy()
        def noSession = s.getOptionalProcess(null)
        assertNull(noSession.createdBy)
        assertNull(noSession.createdSessionId)
    }

    @Test
    void test2() {
        def s = new PersonServiceGroovy()
        def session = s.getReuseProcess(new Session("42", "user"))
        assertEquals("user", session.createdBy)
        assertEquals("42", session.createdSessionId)
    }

    @Test
    void test3() {
        def s = new PersonServiceGroovy()
        def session = s.getCustomStage(new Session("42", "user"))
        assertEquals("user", session.createdBy)
        assertEquals("42", session.createdSessionId)
    }

}
