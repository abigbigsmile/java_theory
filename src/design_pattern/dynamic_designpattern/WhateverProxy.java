package design_pattern.dynamic_designpattern;

import java.lang.reflect.Method;

public class WhateverProxy implements design_pattern.dynamic_designpattern.Transactable{

   private InnovationHandler innovationHandler;

   public WhateverProxy(InnovationHandler innovationHandler) {

       this.innovationHandler = innovationHandler;

   }

  @Override

      public void saveSomething(){

      try{

      Method md = design_pattern.dynamic_designpattern.Transactable.class.getMethod("saveSomething");

      innovationHandler.invoke(this, md);

      }catch(Exception e){e.printStackTrace();}

  }

}

