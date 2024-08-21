package cli.github_activity_cli.model.objects;

public class Actor {
   private String id;
   private String login;
   private String display_login;
   private String gravatar_id;
   private String url;
   private String avatar_url;

   public Actor() {}

   public String getId() {
      return id;
   }

   public String getLogin() {
      return login;
   }

   public String getDisplay_login() {
      return display_login;
   }

   public String getGravatar_id() {
      return gravatar_id;
   }

   public String getUrl() {
      return url;
   }

   public String getAvatar_url() {
      return avatar_url;
   }
}
