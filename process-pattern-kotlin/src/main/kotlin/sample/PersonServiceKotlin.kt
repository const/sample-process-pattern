package sample

import samples.Person
import samples.Base.BaseBuilder
import samples.SecurityUtil
import samples.Session


class PersonServiceKotlin {
    fun <B : BaseBuilder<*, *>?, T> B.process(ext: (b: B) -> T): T = ext(this)

    fun getOptional(session: Session?): Person {
        return Person.builder()
                .name("test")
                .process { b ->
                    if (session == null) b
                    else b.createdBy(session.user)
                            .createdSessionId(session.sessionId)
                }
                .age(42)
                .occupation("test")
                .build()
    }

    fun getReuse(session: Session?): Person {
        return Person.builder()
                .name("test")
                .process { SecurityUtil.supplySecurityInfo(it, session) }
                .age(42)
                .occupation("test")
                .build()
    }

    fun getReuseLet(session: Session?): Person {
        return Person.builder()
                .name("test")
                .let { b -> SecurityUtil.supplySecurityInfo(b, session) }
                .age(42)
                .occupation("test")
                .build()
    }

    fun <B : BaseBuilder<*, *>?> B.supplySecurityInfo(session: Session?): B =
            SecurityUtil.supplySecurityInfo(this, session)

    fun getCustomStage(session: Session?): Person {
        return Person.builder()
                .name("test")
                .supplySecurityInfo(session)
                .age(42)
                .occupation("test")
                .build()
    }
}
