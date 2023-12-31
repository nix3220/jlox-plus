package com.nix.lox;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.nix.lox.LoxType.TypeEnum;

public class LoxMap extends LoxNative{
  private Map<Object, Object> items = new HashMap<Object, Object>();


  LoxMap(Environment environment, Interpreter interpreter, LoxClass type){
    super(null, null, null, null, type);
    setDetails("Map", new LoxObject(environment, interpreter, "Map", this.type), defineFunctions(environment), interpreter);
  }

  private Map<String, LoxFunction> defineFunctions(Environment environment) {
    Map<String, LoxFunction> methods = new HashMap<>();
    methods.put("put", put(environment));
    methods.put("get", get(environment));
    methods.put("keys", keys(environment));
    methods.put("values", values(environment));
    return methods;
  }

 private LoxFunction get(Environment environment) {
    return new LoxFunction(new LoxCallable() {

      @Override
      public int arity() {
        return 1;
      }

      @Override
      public Object call(Interpreter interpreter, List<Object> arguments, List<LoxClass> templates) {
        return items.get(arguments.get(0));
      }
      
    }, environment, false, new LoxType(name, TypeEnum.OBJECT), new Modifiers());
}

private LoxFunction put(Environment environment) {
    return new LoxFunction(new LoxCallable() {

      @Override
      public int arity() {
        return 2;
      }

      @Override
      public Object call(Interpreter interpreter, List<Object> arguments, List<LoxClass> templates) {
        items.put(arguments.get(0), arguments.get(1));
        return null;
      }
      
    }, environment, false, new LoxType(name, TypeEnum.OBJECT), new Modifiers());
}

private LoxFunction keys(Environment environment) {
    return new LoxFunction(new LoxCallable() {

      @Override
      public int arity() {
        return 0;
      }

      @Override
      public Object call(Interpreter interpreter, List<Object> arguments, List<LoxClass> templates) {
        LoxInstance list = new LoxInstance(new LoxList(environment, interpreter, type), interpreter);
        for(Object o : items.keySet()){
          ArrayList<Object> objs = new ArrayList<>();
          objs.add(o);
          list.klass.findMethod("add",false).call(interpreter, objs, templates);
        }
        return list;
      }
      
    }, environment, false, new LoxType(name, TypeEnum.OBJECT), new Modifiers());
}

private LoxFunction values(Environment environment) {
    return new LoxFunction(new LoxCallable() {

      @Override
      public int arity() {
        return 0;
      }

      @Override
      public Object call(Interpreter interpreter, List<Object> arguments, List<LoxClass> templates) {
        LoxInstance list = new LoxInstance(new LoxList(environment, interpreter, type), interpreter);
        for(Object o : items.values()){
          ArrayList<Object> objs = new ArrayList<>();
          objs.add(o);
          list.klass.findMethod("add", false).call(interpreter, objs, templates);
        }
        return list;
      }
      
    }, environment, false, new LoxType(name, TypeEnum.OBJECT), new Modifiers());
}


 @Override
  public void defineFields() {
    
  }
}
