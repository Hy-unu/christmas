package net.hyunu.christmas.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hyunu.christmas.Hyunu;
import net.hyunu.christmas.item.custom.RawStar;
import net.hyunu.christmas.item.custom.HyunuCookie;
import net.hyunu.christmas.item.custom.MuiBurger;
import net.hyunu.christmas.item.custom.CucumberDog;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems extends ItemGroups{
    // 혀누쿠키
    public static final FoodComponent HYUNU_COOKIE_FOOD_COMPONENT = new FoodComponent.Builder()
        .hunger(3)
        .saturationModifier(0.3f)
		.snack() // 간식으로 선언
		.build();

    // 경무이버거
    public static final FoodComponent MUI_BURGER_FOOD_COMPONENT = new FoodComponent.Builder()
        .saturationModifier(0.3f)
        .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 6000), 1.0f)
        .build();
    
    // 오이핫도그
    public static final FoodComponent CUCUMBER_DOG_FOOD_COMPONENT = new FoodComponent.Builder()
        .hunger(2)
        .saturationModifier(0.3f)
        .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300), 1.0f)
        .build();
    
    public static final Item HyunuCookie = registerItem("cookie", new HyunuCookie(new FabricItemSettings().food(HYUNU_COOKIE_FOOD_COMPONENT)));
    public static final Item MuiBurger = registerItem("mui_burger", new MuiBurger(new FabricItemSettings().food(MUI_BURGER_FOOD_COMPONENT)));
    public static final Item CucumberDog = registerItem("cucumber_dog", new CucumberDog(new FabricItemSettings().food(CUCUMBER_DOG_FOOD_COMPONENT)));
    public static final Item RawStar = registerItem("raw_star", new RawStar(new FabricItemSettings()));

    // 재료
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RawStar);
    }

    // 음식 및 음료
    private static void addItemsToFoodTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(HyunuCookie);
        entries.add(MuiBurger);
        entries.add(CucumberDog);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Hyunu.MOD_ID,name), item);
    }

    public static void registerModItems() {
        Hyunu.LOGGER.info("Registering Mod Items for " + Hyunu.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodTabItemGroup);
    }
}
