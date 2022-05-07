package me.tpc.raven.bot.Helpers;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class EmbedBuilderHelper extends EmbedBuilder {

    public EmbedBuilderHelper(final Color color, final String title, final String description) {
        setColor(color);
        setTitle(title);
        setDescription(description);
    }

    // newField() and newBlankField() are not needed as this class inherits from EmbedBuilder, we can call
    // addField() and addBlankField() on any instance of EmbedBuilderHelper
    public void newField(final String name, final String value, final boolean inline) {
        addField(name, value, inline);
    }

    public void newBlankField(boolean inline){
        addBlankField(inline);
    }
}
