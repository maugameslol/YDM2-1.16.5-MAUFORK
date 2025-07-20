package de.cas_ual_ty.ydm;

import de.cas_ual_ty.ydm.block.CardDecrafterBlock;
import de.cas_ual_ty.ydm.block.CosmeticBlock;
import de.cas_ual_ty.ydm.cardsupply.CardSupplyBlock;
import de.cas_ual_ty.ydm.duel.block.DuelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = YDM.MOD_ID, bus = Bus.MOD)
@ObjectHolder(YDM.MOD_ID)
public class YdmBlocks
{
    public static final DuelBlock DUEL_PLAYMAT = null;
    public static final DuelBlock SANDSTONE_DUEL_PLAYMAT = null;
    public static final DuelBlock BLACK_DUEL_PLAYMAT = null;
    public static final DuelBlock BLUE_DUEL_PLAYMAT = null;
    public static final DuelBlock BROWN_DUEL_PLAYMAT = null;
    public static final DuelBlock CYAN_DUEL_PLAYMAT = null;
    public static final DuelBlock GRAY_DUEL_PLAYMAT = null;
    public static final DuelBlock GREEN_DUEL_PLAYMAT = null;
    public static final DuelBlock LIGHT_BLUE_DUEL_PLAYMAT = null;
    public static final DuelBlock LIGHT_GRAY_DUEL_PLAYMAT = null;
    public static final DuelBlock LIME_DUEL_PLAYMAT = null;
    public static final DuelBlock MAGENTA_DUEL_PLAYMAT = null;
    public static final DuelBlock ORANGE_DUEL_PLAYMAT = null;
    public static final DuelBlock PINK_DUEL_PLAYMAT = null;
    public static final DuelBlock PURPLE_DUEL_PLAYMAT = null;
    public static final DuelBlock RED_DUEL_PLAYMAT = null;
    public static final DuelBlock WHITE_DUEL_PLAYMAT = null;
    public static final DuelBlock YELLOW_DUEL_PLAYMAT = null;
    
    public static final DuelBlock DUEL_TABLE = null;
    public static final CardSupplyBlock CARD_SUPPLY = null;
    public static final CosmeticBlock CARD_CRAFTER = null;
    public static final CardDecrafterBlock CARD_DECRAFTER = null;
    //public static final CosmeticBlock RARITY_EXCHANGER = null;
    //public static final CosmeticBlock DOMAIN_GENERATOR = null;
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.STONE, MaterialColor.SAND).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(5.0F, 6.0F).sound(SoundType.STONE), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "sandstone_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_BLACK).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "black_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_BLUE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "blue_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_BROWN).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "brown_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_CYAN).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "cyan_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_GRAY).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "gray_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_GREEN).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "green_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_LIGHT_BLUE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "light_blue_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_LIGHT_GRAY).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "light_gray_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_LIGHT_GREEN).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "lime_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_MAGENTA).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "magenta_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_ORANGE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "orange_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_PINK).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "pink_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_PURPLE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "purple_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_RED).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "red_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.SNOW).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "white_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOL, MaterialColor.COLOR_YELLOW).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "yellow_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(5.0F, 6.0F).sound(SoundType.METAL), VoxelShapes.or(
                Block.box(4, 3, 4, 12, 12.5, 12),
                Block.box(1, 0, 1, 15, 3, 15),
                Block.box(0, 13, 0, 16, 15, 16),
                Block.box(1, 12.5, 1, 15, 15.5, 15))).setRegistryName(YDM.MOD_ID, "duel_table"));
        registry.register(new CardSupplyBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)).setRegistryName(YDM.MOD_ID, "card_supply"));
        registry.register(new CosmeticBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(3.5F, 3.5F).sound(SoundType.METAL)).setRegistryName(YDM.MOD_ID, "card_crafter"));
        registry.register(new CardDecrafterBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(3.5F, 3.5F).sound(SoundType.METAL)).setRegistryName(YDM.MOD_ID, "card_decrafter"));
        //registry.register(new CosmeticBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(3.5F, 3.5F).sound(SoundType.METAL)).setRegistryName(YDM.MOD_ID, "rarity_exchanger"));
        //registry.register(new CosmeticBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.5F, 3.5F).sound(SoundType.METAL)).setRegistryName(YDM.MOD_ID, "domain_generator"));
    }
}