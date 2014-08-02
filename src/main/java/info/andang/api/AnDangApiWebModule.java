package info.andang.api;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.hubspot.liveconfig.LiveConfig;

import javax.inject.Named;

public class AnDangApiWebModule extends AbstractModule {

  private final LiveConfig liveConfig = LiveConfig.builder()
      .usingPropertiesFile("/etc/andang.info.properties")
      .usingDefaultProperties("info.andang")
      .build();;

  @Override
  protected void configure() {
  }

  @Provides
  @Named("linkedin.api.key")
  public String provideLinkedInApiKey(AnDangApiWebConfiguration configuration) {
    return liveConfig.getString("linkedin.api.key");
  }

  @Provides
  @Named("linkedin.api.secret")
  public String provideLinkedInApiSecret(AnDangApiWebConfiguration configuration) {
    return liveConfig.getString("linkedin.api.secret");
  }

  @Provides
  @Named("linkedin.oauth.user.token")
  public String provideLinkedInOauthUserToken(AnDangApiWebConfiguration configuration) {
    return liveConfig.getString("linkedin.oauth.user.token");
  }

  @Provides
  @Named("linkedin.oauth.user.secret")
  public String provideLinkedInOauthUserSecret(AnDangApiWebConfiguration configuration) {
    return liveConfig.getString("linkedin.oauth.user.secret");
  }

  @Provides
  @Named("linkedin.base.url")
  public String provideLinkedInBaseUrl(AnDangApiWebConfiguration configuration) {
    return liveConfig.getString("linkedin.base.url");
  }
}