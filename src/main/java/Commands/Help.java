package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.StatusChangeEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ShutdownEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class Help extends ListenerAdapter {
    @Override
    public void onUserUpdateOnlineStatus(UserUpdateOnlineStatusEvent event) {
        super.onUserUpdateOnlineStatus(event);
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);
        /*TextInput name = TextInput.create("sup-name","Name", TextInputStyle.SHORT)
                .setMinLength(1).setRequired(true).build();

        TextInput message = TextInput.create("sup-message", "Message", TextInputStyle.PARAGRAPH)
                .setMinLength(10).setMaxLength(100).setRequired(true)
                .setPlaceholder("Put a cool message here").build();

        Modal modal = Modal.create("sup-modal", "Say Wassup")
                .addActionRow((ItemComponent) ActionRow.of(name), (ItemComponent) ActionRow.of(message))
                .build();*/

        if(event.getName().equals("help")){

            event.reply("helping out...").queue();

        }
        else if (event.getName().equals("food")) {

            OptionMapping option = event.getOption("food-name");
            if(option == null){
                event.reply("for some reason a food name was not provided").queue();
                return;
            }

            String favoriteFood = option.getAsString();
            event.reply("your favorite food is " + favoriteFood).queue();
        }
        else if (event.getName().equals("rps")) {

            OptionMapping option = event.getOption("element");
            if(option == null){
                event.reply("how did you do that").queue();
                return;
            } else {
                int element = option.getAsInt();
                int rng = (int)(Math.random()*3);
                String computerElement = "";
                if(rng == 0)
                    computerElement = "rock";
                else if (rng == 1) {
                    computerElement = "paper";
                } else if (rng == 2) {
                    computerElement = "scissors";
                }

                String playerElement = "";
                if(element == 0)
                    playerElement = "rock";
                else if (element == 1) {
                    playerElement = "paper";
                } else if (element == 2) {
                    playerElement = "scissors";
                }
                if(element == rng) {
                    event.reply("You chose " + playerElement + ".\nComputer Chose " + computerElement + ".\nIt was a tie.").queue();
                }
                else if(element == 0 && rng == 2){
                    event.reply("You chose " + playerElement + ".\nComputer Chose " + computerElement + ".\nYou won!").queue();
                }
                else if (element == 2 && rng == 0) {
                    event.reply("You chose " + playerElement + ".\nComputer Chose " + computerElement + ".\nComputer won!").queue();
                } else if (element < rng) {
                    event.reply("You chose " + playerElement + ".\nComputer Chose " + computerElement + ".\nComputer won!").queue();
                }
                else {
                    event.reply("You chose " + playerElement + ".\nComputer Chose " + computerElement + ".\nYou won!").queue();
                }
            }
        }
        else if(event.getName().equals("sum")){
            OptionMapping firstNum = event.getOption("num1");
            OptionMapping secondNum = event.getOption("num2");
            if(firstNum == null || secondNum == null) {
                event.reply("wtf happened").queue();
                return;
            }
            event.reply("The sum of these 2 numbers is: " + (firstNum.getAsInt() + secondNum.getAsInt())).setEphemeral(true).queue();
        }
        /*else if(event.getName().equals("sup")){
            event.replyModal(modal).queue();
        }*/
        else if(event.getName().equals("elle")){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.blue);
            eb.setTitle("Holy fart its Elle");
            eb.setDescription("Elle shrine Elle shrine Elle shrine Elle shrine");
            eb.addField("Elle","Elle Elle Elle Elle", true);
            eb.setThumbnail("https://static.wikia.nocookie.net/hypixel-skyblock/images/3/37/Elle_of_the_Nether.png/revision/latest?cb=20191210155104");
            eb.setImage("https://hypixel.net/attachments/gfdkgpofdkgopdfkgfdg-png.3115486/");
            event.reply("↓").queue();
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
        else if(event.getName().equals("sum-embed")){
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.RED);
            embed.setTitle("Sum of 2 numbers");
            OptionMapping option1 = event.getOption("num1");
            OptionMapping option2 = event.getOption("num2");
            if(option1 != null && option2 != null){
                embed.setDescription("The sum of these 2 numbers is: " + (option1.getAsInt() + option2.getAsInt()));
                event.getChannel().sendMessageEmbeds(embed.build()).queue();
            }
            else{
                event.getChannel().sendMessage("wtf did you just do?").queue();
            }

        }
        else if(event.getName().equals("info")){
            OptionMapping username = event.getOption("username");
            EmbedBuilder embed = new EmbedBuilder();
            if(username != null){
                User user = event.getGuild().getMembersByName(username.getAsString(), true).get(0).getUser();
                embed.setTitle(username.getAsString() + "'s information");
                embed.addField("Name: ", event.getUser().getName(),false);
                embed.addField("Online Status:", event.getGuild().getMembersByName(username.getAsString(), true).get(0).getOnlineStatus().toString(),false);
                if(event.getGuild().getMembersByName(username.getAsString(),true).get(0).getActivities().toString() != null && !event.getGuild().getMembersByName(username.getAsString(),true).get(0).getActivities().toString().equals("[]")){
                    embed.addField("Custom Status:", event.getGuild().getMembersByName(username.getAsString(),true).get(0).getActivities().toString(),false);
                }
                embed.addField("Profile Picture:" , "↓", false);
                embed.setImage(user.getAvatarUrl());
                embed.setFooter("Date: " + event.getTimeCreated());
                event.replyEmbeds(embed.build()).queue();

            }
            else {
                event.reply("how.").setEphemeral(true).queue();
            }
        }
        else if(event.getName().equals("time")){
            event.reply("The time is: " + event.getTimeCreated()).setEphemeral(true).queue();
        }
    }
}
