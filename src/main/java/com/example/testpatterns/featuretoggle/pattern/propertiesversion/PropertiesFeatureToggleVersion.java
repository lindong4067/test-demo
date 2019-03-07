package com.example.testpatterns.featuretoggle.pattern.propertiesversion;


import com.example.testpatterns.featuretoggle.pattern.Service;
import com.example.testpatterns.featuretoggle.user.User;

import java.util.Properties;

/**
 * This example of the Feature Toogle pattern is less dynamic version than
 * or off at the time of creation of the service. This example uses simple Java {@link Properties} however it could as
 * easily be done with an external configuration FileNIO loaded by Spring and so on. A good example of when to use this
 * version of the feature toggle is when new features are being developed. So you could have a configuration property
 * boolean named development or some sort of system environment variable.
 *
 * @see Service
 */
public class PropertiesFeatureToggleVersion implements Service {

  private boolean isEnhanced;

  /**
   * Creates an instance of {@link PropertiesFeatureToggleVersion} using the passed {@link Properties} to determine,
   * the status of the feature toggle {@link PropertiesFeatureToggleVersion#isEnhanced()}. There is also some defensive
   * code to ensure the {@link Properties} passed are as expected.
   *
   * @param properties {@link Properties} used to configure the service and toggle features.
   * @throws IllegalArgumentException when the passed {@link Properties} is not as expected
   * @see Properties
   */
  public PropertiesFeatureToggleVersion(final Properties properties) {
    if (properties == null) {
      throw new IllegalArgumentException("No Properties Provided.");
    } else {
      try {
        isEnhanced = (boolean) properties.get("enhancedWelcome");
      } catch (Exception e) {
        throw new IllegalArgumentException("Invalid Enhancement Settings Provided.");
      }
    }
  }

  /**
   * Generate a welcome message based on the user being passed and the status of the feature toggle. If the enhanced
   * version is enabled, then the message will be personalised with the name of the passed {@link User}. However if
   * disabled then a generic version fo the message is returned.
   *
   * @param user the {@link User} to be displayed in the message if the enhanced version is enabled see
   *             {@link PropertiesFeatureToggleVersion#isEnhanced()}. If the enhanced version is enabled, then the
   *             message will be personalised with the name of the passed {@link User}. However if disabled then a
   *             generic version fo the message is returned.
   * @return Resulting welcome message.
   * @see User
   */
  @Override
  public String getWelcomeMessage(final User user) {

    if (isEnhanced()) {
      return "Welcome " + user + ". You're using the enhanced welcome message.";
    }

    return "Welcome to the application.";
  }

  /**
   * Method that checks if the welcome message to be returned is the enhanced venison or not. For this service it will
   * see the value of the boolean that was set in the constructor
   * {@link PropertiesFeatureToggleVersion#PropertiesFeatureToggleVersion(Properties)}
   *
   * @return Boolean value {@code true} if enhanced.
   */
  @Override
  public boolean isEnhanced() {
    return isEnhanced;
  }
}
