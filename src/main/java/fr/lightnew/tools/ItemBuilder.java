package fr.lightnew.tools;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.*;

import java.util.Arrays;

public class ItemBuilder {

    ItemBuilder items;

    public ItemBuilder(ItemBuilder itemBuilder) {
        this.items = itemBuilder;
    }

    public ItemStack ShopItemBuilder(Material material, int amount, Enchantment[] enchantments, int[] enchantmentLevels, String name, String... lores) {
        return create(material, amount, enchantments, enchantmentLevels, name, lores);
    }

    public static ItemStack create(Material material, int amount, Enchantment[] enchantments, int[] enchantmentLevels, String name, String... lores) {
        if (material == null) {
            return null;
        } else {
            ItemStack itemStack = new ItemStack(material, amount);
            if (enchantments != null && enchantmentLevels != null && enchantments.length == enchantmentLevels.length) {
                for(int i = 0; i < enchantments.length; ++i) {
                    itemStack.addEnchantment(enchantments[i], enchantmentLevels[i]);
                }
            }

            if (name == null && (lores == null || lores.length < 1)) {
                return itemStack;
            } else {
                ItemMeta itemMeta = itemStack.getItemMeta();
                if (name != null) {
                    itemMeta.setDisplayName(name);
                }

                if (lores != null) {
                    itemMeta.setLore(Arrays.asList(lores));
                }

                itemStack.setItemMeta(itemMeta);
                return itemStack;
            }
        }
    }

    public static ItemStack create(Material material, int amount, String name, String... lores) {
        return create(material, amount, (Enchantment[])null, (int[])null, name, lores);
    }

    public static ItemStack createItemShop(Material material, int amount, String name) {
        return create(material, amount, null, (int[])null, name, "");
    }

    public static ItemStack createPotion(Material material, PotionType potionType, boolean extended, boolean upgraded, String name, String... lore) {
        // time POTION ->
        // 1:30 (extended : false, upgraded : true)
        // 3:00 (extended : false, upgraded : false)
        // 8:00 (extended : true, upgraded : false)
        ItemStack itemStack = new ItemStack(material, 1);
        PotionMeta meta = (PotionMeta) itemStack.getItemMeta();
        PotionData data;
        if (extended && upgraded)
            data = new PotionData(potionType, false, false);
        else
            data = new PotionData(potionType, extended, upgraded);
        meta.setBasePotionData(data);
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack skull(int amount, String name, String owner, String... lores) {
        if (name != null && lores != null) {
            ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD, amount, (short)3);
            SkullMeta itemMeta = (SkullMeta)itemStack.getItemMeta();
            itemMeta.setDisplayName(name);
            itemMeta.setLore(Arrays.asList(lores));
            itemMeta.setOwner(owner);
            itemStack.setItemMeta(itemMeta);
            return itemStack;
        } else {
            return null;
        }
    }
}