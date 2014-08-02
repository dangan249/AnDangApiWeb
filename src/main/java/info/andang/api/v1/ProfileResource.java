package info.andang.api.v1;

import com.google.inject.Inject;
import info.andang.api.v1.service.ProfileService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/myprofile")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

  private final ProfileService profileService;
  @Inject
  public ProfileResource(ProfileService profileService) {
    this.profileService = profileService;
  }

  @GET
  public String getmyProfile(){
    return profileService.getMyProfile();
  }

}