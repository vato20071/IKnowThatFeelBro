package core;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class ServerConfigurator extends ServerEndpointConfig.Configurator
{
    @Override
    public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, 
                                HandshakeResponse response){
        HttpSession httpSession = (HttpSession)request.getHttpSession();
        if (httpSession == null) System.out.println("Done");
        if (config.getUserProperties() == null) System.out.println("You silly");
        config.getUserProperties().put(HttpSession.class.getName(), httpSession);
    }
}