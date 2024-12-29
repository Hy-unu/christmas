package net.hyunu.christmas.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.text.Text;

public class CucumberDog extends Item {

	public CucumberDog(Item.Settings settings) {
		super(settings);
	};

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        tooltip.add(Text.translatable("item.tooltip.cucumber_dog"));
        super.appendTooltip(stack, world, tooltip, context);
    }
};