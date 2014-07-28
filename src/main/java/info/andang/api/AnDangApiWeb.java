package info.andang.api;

import com.hubspot.dropwizard.guice.GuiceBundle;
import info.andang.api.v1.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class AnDangApiWeb extends Application<AnDangApiWebConfiguration> {

  public static void main(String[] args) throws Exception {
    new AnDangApiWeb().run(args);
  }

  @Override
  public void initialize(Bootstrap<AnDangApiWebConfiguration> bootstrap) {

    GuiceBundle<AnDangApiWebConfiguration> guiceBundle = GuiceBundle.<AnDangApiWebConfiguration>newBuilder()
        .addModule(new AnDangApiWebModule())
        .enableAutoConfig(getClass().getPackage().getName())
        .setConfigClass(AnDangApiWebConfiguration.class)
        .build();

    bootstrap.addBundle(guiceBundle);
  }

  @Override
  public String getName() {
    return "andang-api-web";
  }

  @Override
  public void run(AnDangApiWebConfiguration anDangApiWebConfiguration, Environment environment) throws Exception {
    final HelloWorldResource resource = new HelloWorldResource(
        anDangApiWebConfiguration.getTemplate(),
        anDangApiWebConfiguration.getDefaultName());
    environment.jersey().register(resource);
  }
}