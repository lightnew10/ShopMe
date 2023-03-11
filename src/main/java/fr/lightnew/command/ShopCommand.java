package fr.lightnew.command;

import fr.lightnew.shop.GuiEdit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class ShopCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {

            }

            if (player.isOp() && args.length == 1) {
                if (args[0].equalsIgnoreCase("edit")) {
                    GuiEdit.send(player);
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender.isOp() && args.length == 1)
            return Arrays.asList("edit");
        return null;
    }
}
