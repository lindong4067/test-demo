package com.example.testpatterns.flux.view;

import com.example.testpatterns.flux.action.Content;
import com.example.testpatterns.flux.store.ContentStore;
import com.example.testpatterns.flux.store.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ContentView is a concrete view.
 *
 */
public class ContentView implements View {

  private static final Logger LOGGER = LoggerFactory.getLogger(ContentView.class);

  private Content content = Content.PRODUCTS;

  @Override
  public void storeChanged(Store store) {
    ContentStore contentStore = (ContentStore) store;
    content = contentStore.getContent();
    render();
  }

  @Override
  public void render() {
    LOGGER.info(content.toString());
  }
}
