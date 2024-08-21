package cli.github_activity_cli.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.google.gson.Gson;

import cli.github_activity_cli.model.net.HttpHandler;
import cli.github_activity_cli.model.objects.Event;


@ShellComponent
public class GitHubActivity {
   private HttpHandler http = new HttpHandler();
   private Gson gson = new Gson();

   @ShellMethod(key = "github-activity", value = "GitHub activity")
   public void git(@ShellOption(help = "GitHub username") String username) {
      String response = this.http.req(username, "/events").body();

      Event[] events = gson.fromJson(response, Event[].class); 

      if (events.length == 0) {
         System.out.println("No activity found");
         return;
      }  

      for(Event event : events)
         System.out.println(event.toString());
   }
}
