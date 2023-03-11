package fr.lightnew.shop;

import fr.lightnew.tools.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiEdit {

    public static ItemStack ITEM_EDIT_GUI = ItemBuilder.create(Material.CHEST, 1, ChatColor.YELLOW + "Éditer le shop");
    public static ItemStack ITEM_NAME_SHOP = ItemBuilder.create(Material.NAME_TAG, 1, ChatColor.GREEN + "Changer le nom du shop");
    public static ItemStack ITEM_CREATE_CATEGORY = ItemBuilder.create(Material.ENDER_CHEST, 1, ChatColor.GOLD + "Créer une §lCATÉGORIE");

    public static void send(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 9, ChatColor.YELLOW + "Menu de modification du shop");
        inventory.setItem(3, ITEM_NAME_SHOP);
        inventory.setItem(5, ITEM_EDIT_GUI);
        inventory.setItem(6, ITEM_CREATE_CATEGORY);
        player.openInventory(inventory);
    }

}
