package com.example.testpatterns.flux.view;


import com.example.testpatterns.flux.store.Store;

/**
 * 
 * Views define the representation of data.
 *
 */
public interface View {

  void storeChanged(Store store);

  void render();
}
