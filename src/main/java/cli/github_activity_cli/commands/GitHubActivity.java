package cli.github_activity_cli.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.google.gson.Gson;

import cli.github_activity_cli.model.net.HttpHandler;
import cli.github_activity_cli.model.objects.Event;
import cli.github_activity_cli.model.objects.Starred;


@ShellComponent
public class GitHubActivity {
   private HttpHandler http = new HttpHandler();
   private Gson gson = new Gson();

   @ShellMethod(key = "github-activity", value = "GitHub activity")
   public void git(
      @ShellOption(help = "GitHub username") String username,
      @ShellOption(help = "Type of activity: events, starred, or both", defaultValue = "both") String type
      ) {

      if (type.equalsIgnoreCase("events") || type.equalsIgnoreCase("both")) {
         System.out.println("\n--- EVENTS ---");
         String response = this.http.req(username, "/events").body();
         Event[] events = gson.fromJson(response, Event[].class); 

         if (events.length == 0) {
            System.out.println("No activity found");
            return;
         }  

         for(Event event : events)
            System.out.println(event.toString());
      }

      if (type.equalsIgnoreCase("starred") || type.equalsIgnoreCase("both")) {
         System.out.println("\n --- STARRED ---");

         String response = this.http.req(username, "/starred").body();
         Starred[] starred = gson.fromJson(response, Starred[].class); 
         
         if (starred.length == 0) {
            System.out.println("No activity found");
            return;
         }  

         for(Starred star : starred)
            System.out.println(star.toString());
      }
   }
}
