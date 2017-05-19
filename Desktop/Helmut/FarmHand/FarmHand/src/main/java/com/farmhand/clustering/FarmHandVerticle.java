/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
   @Override
  public void start(Future<Void> startFuture) throws Exception {
    vertx.eventBus().<String>consumer("hello", message -> {
      message.reply("Hello " + message.body() + " from " + ID);
    }).completionHandler(startFuture.completer());
  }
            
}
