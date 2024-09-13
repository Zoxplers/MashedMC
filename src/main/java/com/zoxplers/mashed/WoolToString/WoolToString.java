package com.zoxplers.mashed.WoolToString;

import com.zoxplers.mashed.MashedMC;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice.MaterialChoice;
import org.bukkit.inventory.ShapelessRecipe;

public class WoolToString
{
    //Variables
    private boolean enabled;

    //Functions
    public void enable()
    {
        enabled = true;
        MashedMC plugin = MashedMC.getInstance();
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(MashedMC.getInstance(), "wool"), new ItemStack(Material.STRING, 4));
        recipe.addIngredient(new MaterialChoice(Material.BLACK_WOOL, Material.BLUE_WOOL, Material.BROWN_WOOL, Material.CYAN_WOOL, Material.GRAY_WOOL, Material.GREEN_WOOL, Material.LIGHT_BLUE_WOOL, Material.LIGHT_GRAY_WOOL, Material.LIME_WOOL, Material.MAGENTA_WOOL, Material.ORANGE_WOOL, Material.PINK_WOOL, Material.PURPLE_WOOL, Material.RED_WOOL, Material.WHITE_WOOL, Material.YELLOW_WOOL));
        plugin.getServer().addRecipe(recipe);
    }

    public void disable()
    {
        enabled = false;
    }
}
