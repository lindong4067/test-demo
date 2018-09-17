package com.example.testpatterns.featuretoggle;

import com.example.testpatterns.featuretoggle.pattern.Service;
import com.example.testpatterns.featuretoggle.pattern.propertiesversion.PropertiesFeatureToggleVersion;
import com.example.testpatterns.featuretoggle.pattern.tieredversion.TieredFeatureToggleVersion;
import com.example.testpatterns.featuretoggle.user.User;
import com.example.testpatterns.featuretoggle.user.UserGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * The Feature Toggle pattern allows for complete code executions to be turned on or off with ease. This allows features
 * to be controlled by either dynamic methods just as {@link User} information or by {@link Properties}. In the App
 * below there are two examples. Firstly the {@link Properties} version of the feature toggle, where the enhanced
 * version of the welcome message which is personalised is turned either on or off at instance creation. This method
 * is not as dynamic as the {@link User} driven version where the feature of the personalised welcome message is
 * dependant on the {@link UserGroup} the {@link User} is in. So if the user is a memeber of the
 * {@link UserGroup#isPaid(User)} then they get an ehanced version of the welcome message.
 *
 * Note that this pattern can easily introduce code complexity, and if not kept in check can result in redundant
 * unmaintained code within the codebase.
 *
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   *  Block 1 shows the {@link PropertiesFeatureToggleVersion} being run with {@link Properties} setting the feature
   *  toggle to enabled.
   *
   *  Block 2 shows the {@link PropertiesFeatureToggleVersion} being run with {@link Properties} setting the feature
   *  toggle to disabled. Notice the difference with the printed welcome message the username is not included.
   *
   *  Block 3 shows the {@link TieredFeatureToggleVersion} being
   *  set up with two users on who is on the free level, while the other is on the paid level. When the
   *  {@link Service#getWelcomeMessage(User)} is called with the paid {@link User} note that the welcome message
   *  contains their username, while the same service call with the free tier user is more generic. No username is
   *  printed.
   *
   */
  public static void main(String[] args) {

    final Properties properties = new Properties();
    properties.put("enhancedWelcome", true);
    Service service = new PropertiesFeatureToggleVersion(properties);
    final String welcomeMessage = service.getWelcomeMessage(new User("Jamie No Code"));
    LOGGER.info(welcomeMessage);

    // ---------------------------------------------

    final Properties turnedOff = new Properties();
    turnedOff.put("enhancedWelcome", false);
    Service turnedOffService = new PropertiesFeatureToggleVersion(turnedOff);
    final String welcomeMessageturnedOff = turnedOffService.getWelcomeMessage(new User("Jamie No Code"));
    LOGGER.info(welcomeMessageturnedOff);

    // --------------------------------------------
    
    Service service2 = new TieredFeatureToggleVersion();

    final User paidUser = new User("Jamie Coder");
    final User freeUser = new User("Alan Defect");

    UserGroup.addUserToPaidGroup(paidUser);
    UserGroup.addUserToFreeGroup(freeUser);

    final String welcomeMessagePaidUser = service2.getWelcomeMessage(paidUser);
    final String welcomeMessageFreeUser = service2.getWelcomeMessage(freeUser);
    LOGGER.info(welcomeMessageFreeUser);
    LOGGER.info(welcomeMessagePaidUser);
  }
}
