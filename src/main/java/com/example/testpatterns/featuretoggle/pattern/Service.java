package com.example.testpatterns.featuretoggle.pattern;


import com.example.testpatterns.featuretoggle.pattern.tieredversion.TieredFeatureToggleVersion;
import com.example.testpatterns.featuretoggle.user.User;

/**
 * Simple interfaces to allow the calling of the method to generate the welcome message for a given user. While there is
 * a helper method to gather the the status of the feature toggle. In some cases there is no need for the
 * {@link Service#isEnhanced()} in {@link TieredFeatureToggleVersion}
 * where the toggle is determined by the actual {@link User}.
 *
 */
public interface Service {

  /**
   * Generates a welcome message for the passed user.
   *
   * @param user the {@link User} to be used if the message is to be personalised.
   * @return Generated {@link String} welcome message
   */
  String getWelcomeMessage(User user);

  /**
   * Returns if the welcome message to be displayed will be the enhanced version.
   *
   * @return Boolean {@code true} if enhanced.
   */
  boolean isEnhanced();

}
