package fr.lightnew.shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CategoryEntity {

    private String name;
    private ItemStack item;
    private ItemStack[] contentCategory;
    private int inventory_size;

    public CategoryEntity(String name, ItemStack itemDisplay, int size) {
        if (name == null)
            name = "Défault name category";
        if (itemDisplay == null)
            itemDisplay = new ItemStack(Material.STONE);

        this.name = name;
        this.item = itemDisplay;
        this.inventory_size = size;
    }

    public ItemStack getItem() {
        return item;
    }

    public String getName() {
        return name;
    }

    public ItemStack[] getContentCategory() {
        return contentCategory;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContentCategory(ItemStack[] contentCategory) {
        this.contentCategory = contentCategory;
    }

    public Inventory getInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(player, inventory_size, name);
        for (int i = 0; i < contentCategory.length; i++)
            inventory.setItem(i, contentCategory[i]);
        return inventory;
    }
}
