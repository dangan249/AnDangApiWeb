package info.andang.api.v1.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class ProfileService {

  private final String linkedInOauthUserToken;
  private final String linkedInOauthUserSecret;
  private final String linkedInBaseURl;
  private final OAuthService linkedInClient;

  private final String FIELDS = ":(id,first-name,last-name,headline,picture-url," +
      "skills:(skill:(name)),languages:(language:(name))," +
      "location:(name),industry,num-connections,summary,"
      + "positions:(title,summary,is-current,company),"
      + "educations:(school-name,field-of-study,degree)," +
      "recommendations-received:(recommender,recommendation-text))"
      + "?format=json";

  @Inject
  public ProfileService(@Named("linkedin.api.key") String linkedInApiKey,
                        @Named("linkedin.api.secret") String linkedInApiSecret,
                        @Named("linkedin.oauth.user.token") String linkedInOauthUserToken,
                        @Named("linkedin.oauth.user.secret") String linkedInOauthUserSecret,
                        @Named("linkedin.base.url") String linkedInBaseURl) {
    this.linkedInOauthUserToken = linkedInOauthUserToken;
    this.linkedInOauthUserSecret = linkedInOauthUserSecret;
    this.linkedInBaseURl = linkedInBaseURl;
    this.linkedInClient =  new ServiceBuilder()
        .provider(LinkedInApi.class)
        .apiKey(linkedInApiKey)
        .apiSecret(linkedInApiSecret)
        .build();
  }

  public String getMyProfile(){
    OAuthRequest request = new OAuthRequest(Verb.GET, linkedInBaseURl + FIELDS);
    linkedInClient.signRequest(new Token(linkedInOauthUserToken, linkedInOauthUserSecret), request);
    Response response = request.send();
    return response.getBody();
  }
}
