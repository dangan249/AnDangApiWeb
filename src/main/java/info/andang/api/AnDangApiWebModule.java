package info.andang.api;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Named;

public class AnDangApiWebModule extends AbstractModule {

  @Override
  protected void configure() {

  }

  @Provides
  @Named("template")
  public String provideTemplate(AnDangApiWebConfiguration configuration) {
    return configuration.getTemplate();
  }

  @Provides
  @Named("defaultName")
  public String provideDefaultName(AnDangApiWebConfiguration configuration) {
    return configuration.getDefaultName();
  }

}