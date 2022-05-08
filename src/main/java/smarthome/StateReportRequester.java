package smarthome;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import smarthome.service.ServiceCall;

public class StateReportRequester {

  public String requestState(ServiceCall serviceCall) {
    return ClientBuilder.newClient()
        .register(JacksonJsonProvider.class)
        .register(HttpAuthenticationFeature.basic(Configuration.USERNAME, Configuration.PASSWORD))
        .target(serviceCall.getUrl())
        .request()
        .buildPost(Entity.entity(serviceCall.getPayload(), MediaType.APPLICATION_JSON_TYPE))
        .invoke(String.class);
  }
}
