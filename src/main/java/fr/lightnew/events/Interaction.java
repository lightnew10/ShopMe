package fr.lightnew.events;

import fr.lightnew.shop.GuiEdit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Interaction implements Listener {

    @EventHandler
    public void interactionInventory(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String title = event.getView().getTitle();
        ItemStack item = event.getCurrentItem();

        if (item == null)
            return;

        if (title.equalsIgnoreCase(ChatColor.YELLOW + "Menu de modification du shop")) {
            if (item.isSimilar(GuiEdit.ITEM_EDIT_GUI)) {
                // TODO OPEN GUI FOR EDIT CATEGORY
            }
            if (item.isSimilar(GuiEdit.ITEM_NAME_SHOP)) {
                // TODO CLOSE INV AND SEND NEW NAME IN CHAT
            }
            if (item.isSimilar(GuiEdit.ITEM_CREATE_CATEGORY)) {
                // TODO CREATE NEW CATEGORY
            }
        }
    }
}
