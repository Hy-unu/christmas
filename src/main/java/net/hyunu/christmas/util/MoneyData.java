package net.hyunu.christmas.util;

import net.minecraft.nbt.NbtCompound;

public class MoneyData {
    private static final String MONEY_KEY = "money";

    public static int addMoney(IEntityDataSaver player, int amount){
        NbtCompound nbt = player.getPersistentData();
        int money = nbt.getInt(MONEY_KEY);
        money += amount;

        nbt.putInt(MONEY_KEY,money);
        return money;
    }

    public static int removeMoney(IEntityDataSaver player, int amount){
        NbtCompound nbt = player.getPersistentData();
        int money = nbt.getInt(MONEY_KEY);
        money -= amount;

        nbt.putInt(MONEY_KEY,money);
        return money;
    }

    public static int setMoney(IEntityDataSaver player, int amount){
        NbtCompound nbt = player.getPersistentData();

        nbt.putInt(MONEY_KEY,amount);
        return amount;
    }

    public static int getMoney(IEntityDataSaver player){
        NbtCompound nbt = player.getPersistentData();
        int money = nbt.getInt(MONEY_KEY);

        return money;
    }
}
