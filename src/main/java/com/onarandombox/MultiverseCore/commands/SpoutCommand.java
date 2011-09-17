package com.onarandombox.MultiverseCore.commands;

import com.onarandombox.MultiverseCore.MultiverseCore;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.PopupScreen;
import org.getspout.spoutapi.player.SpoutPlayer;

import java.util.List;

public class SpoutCommand extends MultiverseCommand {

    public SpoutCommand(MultiverseCore plugin) {
        super(plugin);
        this.setName("Edit World with Spout");
        this.setCommandUsage("/mv spout");
        this.setArgRange(0, 0);
        this.addKey("mv spout");
        this.setPermission("multiverse.core.spout", "Edit a world with spout.", PermissionDefault.OP);
        this.addCommandExample("/mv spout");
    }

    @Override
    public void runCommand(CommandSender sender, List<String> args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command must be run as a player!");
            return;
        }
        if (plugin.getSpout() == null) {
            sender.sendMessage(ChatColor.RED + "You need spout installed on this server to use it with Multiverse!");
            return;
        }
        SpoutPlayer p = (SpoutPlayer) sender;
        if (!p.isSpoutCraftEnabled()) {
            sender.sendMessage(ChatColor.RED + p.getName() + "You need to be using the Spoutcraft client to run this command!");
            return;
        }
        PopupScreen pop = new GenericPopup();
        GenericButton button = new GenericButton("Fish");
        button.setX(50);
        button.setY(50);
        button.setWidth(100);
        button.setHeight(40);
        pop.attachWidget(this.plugin, button);
        sender.sendMessage(ChatColor.GREEN + "YAY!");
        p.getMainScreen().attachPopupScreen(pop);
    }
}
