package com.example.testpatterns.flux.store;


import com.example.testpatterns.flux.action.Action;
import com.example.testpatterns.flux.action.ActionType;
import com.example.testpatterns.flux.action.Content;
import com.example.testpatterns.flux.action.ContentAction;

/**
 * 
 * ContentStore is a concrete store.
 *
 */
public class ContentStore extends Store {

  private Content content = Content.PRODUCTS;

  @Override
  public void onAction(Action action) {
    if (action.getType().equals(ActionType.CONTENT_CHANGED)) {
      ContentAction contentAction = (ContentAction) action;
      content = contentAction.getContent();
      notifyChange();
    }
  }

  public Content getContent() {
    return content;
  }
}
