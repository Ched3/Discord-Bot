package events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLOutput;

public class BootyListenerStuff extends ListenerAdapter {
    /* takes every message sent and prints it in console
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);
        String message = event.getMessage().getContentRaw();
        System.out.println(message);
    }
    */

    /* if someone reacts to something, it will say
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        super.onMessageReactionAdd(event);
        event.getChannel().sendMessage(event.getReaction() + " was added to a message").queue();
    }
    */

}
