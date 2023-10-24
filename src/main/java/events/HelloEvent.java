package events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {
    //when someone says hello, the bot says hi
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);
        String messageSent = event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("hello")){
            event.getChannel().sendMessage("hi").queue();
        }

    }
}
