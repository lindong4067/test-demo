package com.example.testpatterns.flux.store;


import com.example.testpatterns.flux.action.Action;
import com.example.testpatterns.flux.action.ActionType;
import com.example.testpatterns.flux.action.MenuAction;
import com.example.testpatterns.flux.action.MenuItem;

/**
 * 
 * MenuStore is a concrete store.
 *
 */
public class MenuStore extends Store {

  private MenuItem selected = MenuItem.HOME;

  @Override
  public void onAction(Action action) {
    if (action.getType().equals(ActionType.MENU_ITEM_SELECTED)) {
      MenuAction menuAction = (MenuAction) action;
      selected = menuAction.getMenuItem();
      notifyChange();
    }
  }

  public MenuItem getSelected() {
    return selected;
  }
}
