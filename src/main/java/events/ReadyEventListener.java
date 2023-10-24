package events;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ReadyEventListener extends ListenerAdapter {
//this class is for when the bot turns on, dont know what event listener is, dont know what onevent or override is
//dont know what event instanceof ReadyEvent is

    //whenever the bot turns on, it prints the bot is ready
    /*@Override
    public void onEvent(@NotNull GenericEvent event){
        if (event instanceof ReadyEvent){
            System.out.println("The bot is ready, and online!");
        }
    }*/
    @Override
    public void onReady(ReadyEvent event) {
        super.onReady(event);
        System.out.println("The bot is ready, and online!");
    }


}
