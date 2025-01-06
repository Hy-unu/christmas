package net.hyunu.christmas.command;

// 명령어 등록
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.hyunu.christmas.util.IEntityDataSaver;
import net.hyunu.christmas.util.MoneyData;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class CommandInit {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            registerAddMoneyCommand(dispatcher);
            registerGetMoneyCommand(dispatcher);
        });
    }

    private static void registerAddMoneyCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("addmoney")
                .requires(source -> source.hasPermissionLevel(2)) // OP 권한 레벨 2 이상 필요
                .then(CommandManager.argument("amount", IntegerArgumentType.integer())
                        .executes(CommandInit::executeAddMoney)));
    }

    private static int executeAddMoney(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();
        ServerPlayerEntity player = source.getPlayer();
        int amount = IntegerArgumentType.getInteger(context, "amount");

        int currentMoney = MoneyData.getMoney(((IEntityDataSaver) player));
        MoneyData.addMoney(((IEntityDataSaver) player), amount);

        player.sendMessage(Text.literal("Added " + amount + " money. New balance: " + (currentMoney + amount)), false);
        return 1;
    }

    private static void registerGetMoneyCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("getmoney")
                        .executes(CommandInit::executeGetMoney));
    }

    private static int executeGetMoney(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();
        ServerPlayerEntity player = source.getPlayer();

        int currentMoney = MoneyData.getMoney(((IEntityDataSaver) player));
        System.out.println("PlayerMoney :" + currentMoney);
        System.out.println("Player :" + player );

        player.sendMessage(Text.literal("Balance: " + currentMoney), false);
        return 1;
    }
}
