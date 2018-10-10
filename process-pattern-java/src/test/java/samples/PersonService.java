package samples;

public class PersonService {

    public Person get(Session session) {
        return Person.builder()
                .name("test")
                .createdBy(session.getUser())
                .createdSessionId(session.getSessionId())
                .age(42)
                .occupation("test")
                .build();
    }


    public Person getDefaultValue(Session session) {
        return Person.builder()
                .name("test")
                .createdBy(session == null ? null : session.getUser())
                .createdSessionId(session == null ? null : session.getSessionId())
                .age(42)
                .occupation("test")
                .build();
    }

    public Person getOptional(Session session) {
        Person.PersonBuilder<?, ?> b = Person.builder()
                .name("test");
        if (session != null) {
            b = b
                    .createdBy(session.getUser())
                    .createdSessionId(session.getSessionId());
        }
        return b
                .age(42)
                .occupation("test")
                .build();
    }


    public Person getReuseVariable(Session session) {
        Person.PersonBuilder<?, ?> b = Person.builder()
                .name("test");
        b = SecurityUtil.supplySecurityInfo(b, session);
        return b.age(42)
                .occupation("test")
                .build();
    }

    public Person getReuseWrap(Session session) {
        return SecurityUtil.supplySecurityInfo(Person.builder()
                        .name("test")
                , session)
                .age(42)
                .occupation("test")
                .build();
    }


    public static PersonBuilderExt personBuilderExt() {
        return new PersonBuilderExt();
    }

    public Person getOptionalProcess(Session session) {
        return personBuilderExt()
                .name("test")
                .process(b -> session == null ? b : b
                        .createdBy(session.getUser())
                        .createdSessionId(session.getSessionId())
                )
                .age(42)
                .occupation("test")
                .build();
    }

    public Person getReuseProcess(Session session) {
        return personBuilderExt()
                .name("test")
                .process(b -> SecurityUtil.supplySecurityInfo(b, session))
                .age(42)
                .occupation("test")
                .build();
    }

}
