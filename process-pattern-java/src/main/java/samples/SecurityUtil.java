package samples;

public class SecurityUtil {
    @SuppressWarnings("unchecked")
    public static <B extends Base.BaseBuilder<?, ?>> B supplySecurityInfo(B builder, Session session) {
        return session == null ? builder : (B) builder
                .createdBy(session.getUser())
                .createdSessionId(session.getSessionId());
    }
}
