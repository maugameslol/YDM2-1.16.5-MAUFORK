package de.cas_ual_ty.ydm;

import de.cas_ual_ty.ydm.duel.block.DuelTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = YDM.MOD_ID, bus = Bus.MOD)
@ObjectHolder(YDM.MOD_ID)
public class YdmTileEntityTypes
{
    public static final TileEntityType<?> DUEL = null;
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<TileEntityType<?>> event)
    {
        IForgeRegistry<TileEntityType<?>> registry = event.getRegistry();
        registry.register(TileEntityType.Builder.of(() -> new DuelTileEntity(YdmTileEntityTypes.DUEL), YdmBlocks.DUEL_PLAYMAT, YdmBlocks.SANDSTONE_DUEL_PLAYMAT, YdmBlocks.RED_SANDSTONE_DUEL_PLAYMAT, YdmBlocks.BLACK_DUEL_PLAYMAT, YdmBlocks.BLUE_DUEL_PLAYMAT, YdmBlocks.BROWN_DUEL_PLAYMAT, YdmBlocks.CYAN_DUEL_PLAYMAT, YdmBlocks.GRAY_DUEL_PLAYMAT, YdmBlocks.GREEN_DUEL_PLAYMAT, YdmBlocks.LIGHT_BLUE_DUEL_PLAYMAT, YdmBlocks.LIGHT_GRAY_DUEL_PLAYMAT, YdmBlocks.LIME_DUEL_PLAYMAT, YdmBlocks.MAGENTA_DUEL_PLAYMAT, YdmBlocks.ORANGE_DUEL_PLAYMAT, YdmBlocks.PINK_DUEL_PLAYMAT, YdmBlocks.PURPLE_DUEL_PLAYMAT, YdmBlocks.RED_DUEL_PLAYMAT, YdmBlocks.WHITE_DUEL_PLAYMAT, YdmBlocks.YELLOW_DUEL_PLAYMAT, YdmBlocks.DUEL_TABLE, YdmBlocks.DUEL_BLOCK, YdmBlocks.SANDSTONE_DUEL_BLOCK, YdmBlocks.RED_SANDSTONE_DUEL_BLOCK).build(null).setRegistryName(YDM.MOD_ID, "duel"));
    }
}