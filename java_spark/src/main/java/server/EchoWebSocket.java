package server;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by rohitv on 11/03/17.
 */
@WebSocket
public class EchoWebSocket {
    // Store sessions if you want to, for example, broadcast a message to all users
    private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();
    @OnWebSocketConnect
    public void connected(Session session) {

        sessions.add(session);
    }

    @OnWebSocketClose
    public void closed(Session session, int statusCode, String reason) {

        sessions.remove(session);
    }

    @OnWebSocketMessage
    public void binaryMessgae(Session session, byte buf[], int offset, int length) {
        try {            
            session.getRemote().sendBytes(ByteBuffer.wrap(buf, offset, length));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
