package cli.github_activity_cli.model.objects;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
   private String id;
   private String type;
   private Repo repo;
   private String created_at;

   public Event() {}

   public String getId() {
      return id;
   }

   public String getType() {
      return type;
   }

   public Repo getRepo() {
      return repo;
   }

   public String getCreated_at() {
      return created_at;
   }

   @Override
   public String toString() {
      String ANSI_RED = "\u001B[31m";
      String ANSI_RESET = "\u001B[0m";
      String ANSI_GREEN = "\u001B[32m";

      return ANSI_GREEN + type + ANSI_RESET + " in " + ANSI_RED + repo.getName() + ANSI_RESET + ", " + parseDate(created_at) + " [" + parseRepoUrl(repo.getUrl()) + "]";
   }
   
   private String parseDate(String date) {
      ZonedDateTime zonedDateTime = ZonedDateTime.parse(date);

      // Format the date-time to a different pattern
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");
      return zonedDateTime.format(formatter);
   }

   private String parseRepoUrl(String url) {
      try {
         String[] parts = url.split("api.");
         String firstParsing = parts[0] + parts[1];
         String[] partsUrl = firstParsing.split("repos/");
         return partsUrl[0] + partsUrl[1];
      } catch (Exception e) {
         e.printStackTrace();
      }
      return url;
   }
}
