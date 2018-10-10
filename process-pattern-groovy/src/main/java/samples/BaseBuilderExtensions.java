package samples;

import java.util.function.Function;

public class BaseBuilderExtensions {
    public static <B extends Base.BaseBuilder<?, ?>, T> T process(B builder, Function<B, T> body) {
        return body.apply(builder);
    }
}
