package service8080;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@RegisterForReflection
@ApplicationScoped
public class RutaMensaje extends RouteBuilder {

    @ConfigProperty(name = "service.8081.url", defaultValue = "https://sercicio8081.onrender.com")
    String service8081Url;

    @Override
    public void configure() throws Exception {
        from("direct:mensaje")
                .log("${body[mensaje]}")
                .log("{{service.8081.url}}/api/mensaje?bridgeEndpoint=true")
                .marshal().json()
                .toD("{{service.8081.url}}/api/mensaje?bridgeEndpoint=true");
    }
}
