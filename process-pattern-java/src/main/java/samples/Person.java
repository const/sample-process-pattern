package samples;

import lombok.Getter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@SuperBuilder
public class Person extends Base {
    @Getter
    private String name;
    @Getter
    private int age;
    @Getter
    @Singular
    private Set<String> occupations;
}