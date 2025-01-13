package service8080;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

@RegisterForReflection
@ApplicationScoped
public class ConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .bindingMode(RestBindingMode.auto);

        rest("/api")
                .post("/mensaje")
                .enableCORS(true)
                .consumes("application/json")
                .produces("application/json")
                .apiDocs(true)
                .to("direct:mensaje");
    }
}
