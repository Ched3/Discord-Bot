import Commands.Help;
import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import javax.security.auth.login.LoginException;

public class Main  {
    public static void main(String[] args) throws LoginException {
        final String TOKEN = System.getenv("DiscordBotToken");
        JDABuilder bot = JDABuilder.createDefault(TOKEN);

        //make a new bot, adds event listeners, that check for events that happen, messages, bot getting online, slash command being used
            JDA jda = bot
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new JoinEventListener(), new Help(), new BootyListenerStuff(), new HelloEvent(), new ReadyEventListener(), new MessageEventListener(), new InteractionEventListener())
                .build();


            //The slash commands that are being used. Remember that setguildonly true makes things update fast
            //setguild false makes update take maybe an hour when restart
            //examples:
            //jda.upsertCommand("slashcmd", "This is a slash command").setGuildOnly(true).queue();
            jda.upsertCommand("elle","Elle.").setGuildOnly(true).queue();
            jda.upsertCommand("sum-embed","sum command but in an embed").setGuildOnly(true)
                    .addOptions(
                            new OptionData(OptionType.INTEGER,"num1","first number you are adding", true)
                                .setRequiredRange(0,Integer.MAX_VALUE),
                            new OptionData(OptionType.INTEGER,"num2","second number you are adding",true)
                                .setRequiredRange(0,Integer.MAX_VALUE))
                    .queue();
            jda.upsertCommand("info","gets the information of a person").setGuildOnly(true)
                    .addOptions(
                            new OptionData(OptionType.STRING, "username", "enter the username of the person", true)
                                    .setMinLength(1))
                    .queue();

        Guild guildID = jda.getGuildById("729410921075572748");
        //when developing a command, set as a guild command first so it updates faster, then after, you can make it a global command
        if(guildID != null) {
            jda.upsertCommand("help", "Lists the features of the bot").setGuildOnly(true).queue();
            jda.upsertCommand("food", "Names your favorite food").setGuildOnly(true)
                    .addOption(OptionType.STRING, "food-name", "the name of your favorite food", true)
                    .queue();
            jda.upsertCommand("rps", "play a completely unrigged game of rock paper scissors").setGuildOnly(true)
                    .addOptions(
                            new OptionData(OptionType.INTEGER, "element", "choose between rock = 0, paper = 1, or scissors = 2", true)
                                    .setRequiredRange(0, 2))
                    .queue();
            jda.upsertCommand("sum", "add 2 numbers together wwwww").setGuildOnly(true)
                    .addOptions(
                            new OptionData(OptionType.INTEGER, "num1", "the first number you are adding", true)
                                    .setRequiredRange(0, Integer.MAX_VALUE),
                            new OptionData(OptionType.INTEGER, "num2", "the second number you are adding", true)
                                    .setRequiredRange(0, Integer.MAX_VALUE))
                    .queue();
            //doesnt work idk why: jda.upsertCommand("sup", "say wassup to someone").setGuildOnly(true).queue();
            jda.upsertCommand("time","get the time right now").setGuildOnly(true).queue();
        }
        /*this is another way to add commands
        CommandListUpdateAction commands = jda.updateCommands();

        commands.addCommands(
                Commands.slash("food", "Names your favorite food"));
        commands.queue();*/

    }
}