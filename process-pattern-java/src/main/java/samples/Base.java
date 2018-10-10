package samples;


import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Base {
    @Getter
    @Builder.Default
    private long created = System.currentTimeMillis();
    @Getter
    private String createdBy;
    @Getter
    private String createdSessionId;
}
