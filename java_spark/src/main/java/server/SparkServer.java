package server;


import static spark.Spark.init;
import static spark.Spark.port;
import static spark.Spark.webSocket;

/**
 * Created by rohitv on 09/03/17.
 */
public class SparkServer {
    public static void main(String[] args) {
        port(8080);
        webSocket("/", EchoWebSocket.class);
        init();
    }
}
