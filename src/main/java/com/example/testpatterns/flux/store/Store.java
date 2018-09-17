package com.example.testpatterns.flux.store;

import com.example.testpatterns.flux.action.Action;
import com.example.testpatterns.flux.view.View;

import java.util.LinkedList;
import java.util.List;


/**
 * 
 * Store is a data model.
 *
 */
public abstract class Store {

  private List<View> views = new LinkedList<>();

  public abstract void onAction(Action action);

  public void registerView(View view) {
    views.add(view);
  }

  protected void notifyChange() {
    views.forEach(view -> view.storeChanged(this));
  }
}
