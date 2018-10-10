package samples;

import java.util.function.Function;

public class PersonBuilderExt extends Person.PersonBuilder<Person, PersonBuilderExt> {
    public <T> T process(Function<PersonBuilderExt, T> function) {
        return function.apply(this);
    }

    public PersonBuilderExt() {
    }

    protected PersonBuilderExt self() {
        return this;
    }

    public Person build() {
        return new Person(this);
    }
}
