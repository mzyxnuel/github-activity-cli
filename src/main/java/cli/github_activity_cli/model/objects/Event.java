package cli.github_activity_cli.model.objects;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
   private String id;
   private String type;
   private Actor actor;
   private Repo repo;
   private String created_at;
   private Payload payload;

   public Event() {}

   public String getId() {
      return id;
   }

   public String getType() {
      return type;
   }

   public Actor getActor() {
      return actor;
   }

   public Repo getRepo() {
      return repo;
   }

   public String getCreated_at() {
      return created_at;
   }

   public Payload getPayload() {
      return payload;
   }

   @Override
   public String toString() {
      String ANSI_RED = "\u001B[31m";
      String ANSI_RESET = "\u001B[0m";
      String ANSI_GREEN = "\u001B[32m";

      return ANSI_GREEN + type + ANSI_RESET + " in " + ANSI_RED + repo.getName() + ANSI_RESET + ", " + parseDate(created_at) + " [" + repo.getUrl() + "]";
   }
   
   private String parseDate(String date) {
      ZonedDateTime zonedDateTime = ZonedDateTime.parse(date);

      // Format the date-time to a different pattern
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");
      return zonedDateTime.format(formatter);
   }
}
