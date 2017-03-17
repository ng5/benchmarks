# benchmarks
built-in echo web socket benchmarks that can be tested using standard text or binary client.

1. java_spark

  requirements - 

  i) java 1.8 installed (preferrable oracle jdk, i've not tested with openjdk)  
  ii) internet connection so that maven repository can be accessed  
  iii) any operating system as long as java is supported  
  step 1) cd benchmarks/java_spark  
  step 2) ./gradlew clean jar  
  step 3) java -cp build/libs/java_spark-1.0-SNAPSHOT.jar server.SparkServer  
  this will start spark server on port 8080, ready to be tested for echo websocket messages.  
  you can change thread pool size or port number inside SparkServer.java. By default it will use total cores/2 threads

<b>coming up</b>  
2. java_servlet_tomcat  
3. cpp_apache_fastcgi  
4. cpp_nginx_fastcgi  
