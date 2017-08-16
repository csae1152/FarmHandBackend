package com.farmhand.clustering;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

import java.util.UUID;

/**
 *
 * @author Helmut
 */
public class FarmHandVerticle extends AbstractVerticle {
    private static final String ID = UUID.randomUUID().toString();
    private static final String message = "Hello from here";
    private static final String body = "<h1></h1>";
    
    
   @Override
  public void start(Future<Void> startFuture) throws Exception {
    vertx.eventBus().<String>consumer("hello", message -> {
      message.reply("Hello " + message.body() + " from " + ID);
    }).completionHandler(startFuture.completer());
  }
            
}
