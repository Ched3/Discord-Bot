package events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageEventListener extends ListenerAdapter {
    //This is for whenever a message is sent ever. A command is printed in console
    //dont know what listener adapter is  or the method title is


    //when someone says lol only, replies with heheheha courtesy of david
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event){
        super.onMessageReceived(event);
        if(event.getMessage().getContentRaw().equals("lol"))
            event.getGuildChannel().sendMessage("heheheha").queue();
    }
}
