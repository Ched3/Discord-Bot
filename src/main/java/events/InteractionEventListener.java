package events;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class InteractionEventListener extends ListenerAdapter {
//not sure what extends listener adapter or the @override and onslashcommandinteraction method header is called
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);

        if(event.getName().equals("help")){
            event.reply("no help for you").setEphemeral(true).queue();
        }

        //set ephemeral makes only you be able to see it

        //event.reply("You suck.").setEphemeral(true).queue();
        /*if (event.getName().equals("flash-cards")){
            event.reply("this is a flash card text").queue();
        }
        if (event.getName().equals("slash-cmd")) {
            event.reply("This is a slash command").queue();
        }
        if (event.getName().equals("quiz")) {
            event.reply("This is a quiz").queue();
        }*/

    }
}
