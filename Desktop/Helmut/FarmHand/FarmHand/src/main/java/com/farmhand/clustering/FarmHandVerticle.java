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
    private static final String message = "Here";
    private static final String body = "<h4>From port 80</h4>";
    
    
   @Override
  public void start(Future<Void> startFuture) throws Exception {
    vertx.eventBus().<String>consumer("hello", name -> {
      message.reply("Hello " + message.body() + " from " + ID);
    }).completionHandler(startFuture.completer());
  }
            
}
