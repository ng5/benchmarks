package server;


import static spark.Spark.init;
import static spark.Spark.port;
import static spark.Spark.threadPool;
import static spark.Spark.webSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by rohitv on 09/03/17.
 */
public class SparkServer {
	  public static final Logger logger = LoggerFactory.getLogger(SparkServer.class);
	  public static final int PORT=8080;
	  public static final int THREADS=Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) {
        threadPool(THREADS);
        port(PORT);
        webSocket("/", EchoWebSocket.class);
				logger.info("==> starting echo server at port:"+PORT + " with threadpool size:"+ THREADS);
			  init();
    }
}
