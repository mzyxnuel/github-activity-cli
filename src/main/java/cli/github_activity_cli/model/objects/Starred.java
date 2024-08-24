package cli.github_activity_cli.model.objects;

public class Starred {
   private String id;
   private String full_name;
   private String html_url;
   private String description;
   
   public Starred() {}

   public String getId() {
      return id;
   }

   public String getFull_name() {
      return full_name;
   }

   public String getHtml_url() {
      return html_url;
   }

   public String getDescription() {
      return description;
   }

   @Override
   public String toString() {
      String ANSI_RED = "\u001B[31m";
      String ANSI_RESET = "\u001B[0m";
      String ANSI_GREEN = "\u001B[32m";

      return ANSI_RED + full_name + ANSI_RESET + " [" + html_url + "], " + ANSI_GREEN + description;
   }
}
