package samples

class PersonServiceGroovy {

    Person getOptionalProcess(Session session) {
        return Person.builder()
                .name("test")
                .process { b ->
                    session == null ? b : b
                            .createdBy(session.getUser())
                            .createdSessionId(session.getSessionId())
                }
                .age(42)
                .occupation("test")
                .build()
    }

    Person getReuseProcess(Session session) {
        return Person.builder()
                .name("test")
                .process { SecurityUtil.supplySecurityInfo(it, session) }
                .age(42)
                .occupation("test")
                .build()
    }

    Person getCustomStage(Session session) {
        return Person.builder()
                .name("test")
                .supplySecurityInfo(session)
                .age(42)
                .occupation("test")
                .build()
    }
}
