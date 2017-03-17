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
	  public static final int MIN_THREADS=6;
	  public static final int MAX_THREADS=8;
	  public static final int THREAD_POOL_TIMEOUT = 30000;
    public static void main(String[] args) {
        //threadPool(MAX_THREADS, MIN_THREADS,THREAD_POOL_TIMEOUT);
        port(PORT);
        webSocket("/", EchoWebSocket.class);
				logger.info("==> starting echo server at port:"+PORT);
			  init();
    }
}
