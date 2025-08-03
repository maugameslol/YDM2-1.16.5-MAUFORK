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
    public static final DuelBlock RED_SANDSTONE_DUEL_PLAYMAT = null;
    
    public static final DuelBlock OAK_DUEL_PLAYMAT = null;
    public static final DuelBlock SPRUCE_DUEL_PLAYMAT = null;
    public static final DuelBlock BIRCH_DUEL_PLAYMAT = null;
    public static final DuelBlock JUNGLE_DUEL_PLAYMAT = null;
    public static final DuelBlock ACACIA_DUEL_PLAYMAT = null;
    public static final DuelBlock DARK_OAK_DUEL_PLAYMAT = null;
    
    public static final DuelBlock CRIMSON_DUEL_PLAYMAT = null;
    public static final DuelBlock WARPED_DUEL_PLAYMAT = null;
    
    public static final DuelBlock MANGROVE_DUEL_PLAYMAT = null;
    public static final DuelBlock CHERRY_DUEL_PLAYMAT = null;
    public static final DuelBlock PALE_OAK_DUEL_PLAYMAT = null;
    public static final DuelBlock BAMBOO_DUEL_PLAYMAT = null;
    
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
    
    public static final DuelBlock DUEL_BLOCK = null;
    public static final DuelBlock SANDSTONE_DUEL_BLOCK = null;
    public static final DuelBlock RED_SANDSTONE_DUEL_BLOCK = null;
    
    public static final CardSupplyBlock CARD_SUPPLY = null;
    public static final CosmeticBlock CARD_CRAFTER = null;
    public static final CardDecrafterBlock CARD_DECRAFTER = null;
    public static final CosmeticBlock RARITY_EXCHANGER = null;
    public static final CosmeticBlock DOMAIN_GENERATOR = null;
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "duel_playmat"));
        
        registry.register(new DuelBlock(Block.Properties.of(Material.STONE, MaterialColor.SAND).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(5.0F, 6.0F).sound(SoundType.STONE), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "sandstone_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(5.0F, 6.0F).sound(SoundType.STONE), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "red_sandstone_duel_playmat"));
        
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).harvestTool(ToolType.AXE).strength(5.0F, 6.0F).sound(SoundType.WOOD), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "oak_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOD, MaterialColor.PODZOL).harvestTool(ToolType.AXE).strength(5.0F, 6.0F).sound(SoundType.WOOD), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "spruce_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOD, MaterialColor.SAND).harvestTool(ToolType.AXE).strength(5.0F, 6.0F).sound(SoundType.WOOD), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "birch_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOD, MaterialColor.DIRT).harvestTool(ToolType.AXE).strength(5.0F, 6.0F).sound(SoundType.WOOD), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "jungle_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).harvestTool(ToolType.AXE).strength(5.0F, 6.0F).sound(SoundType.WOOD), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "acacia_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).harvestTool(ToolType.AXE).strength(5.0F, 6.0F).sound(SoundType.WOOD), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "dark_oak_duel_playmat"));
        
        registry.register(new DuelBlock(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.WARPED_HYPHAE).harvestTool(ToolType.AXE).strength(5.0F, 6.0F).sound(SoundType.STEM), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "warped_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.NETHER_WOOD, MaterialColor.CRIMSON_HYPHAE).harvestTool(ToolType.AXE).strength(5.0F, 6.0F).sound(SoundType.STEM), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "crimson_duel_playmat"));
        
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).harvestTool(ToolType.AXE).strength(5.0F, 6.0F).sound(SoundType.WOOD), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "mangrove_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_WHITE).harvestTool(ToolType.AXE).strength(5.0F, 6.0F).sound(SoundType.WOOD), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "cherry_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOD, MaterialColor.QUARTZ).harvestTool(ToolType.AXE).strength(5.0F, 6.0F).sound(SoundType.WOOD), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "pale_oak_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).harvestTool(ToolType.AXE).strength(5.0F, 6.0F).sound(SoundType.BAMBOO), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "bamboo_duel_playmat"));
        
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "black_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "blue_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "brown_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_CYAN).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "cyan_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "gray_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_GREEN).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "green_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_BLUE).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "light_blue_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "light_gray_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GREEN).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "lime_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_MAGENTA).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "magenta_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "orange_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_PINK).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "pink_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "purple_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_RED).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "red_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.SNOW).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "white_duel_playmat"));
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).harvestTool(ToolType.HOE).strength(5.0F, 6.0F).sound(SoundType.WOOL), Block.box(2D, 0, 2D, 14D, 1D, 14D)).setRegistryName(YDM.MOD_ID, "yellow_duel_playmat"));
        
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(5.0F, 6.0F).sound(SoundType.METAL), VoxelShapes.or(
                Block.box(4, 3, 4, 12, 12.5, 12),
                Block.box(1, 0, 1, 15, 3, 15),
                Block.box(0, 13, 0, 16, 15, 16),
                Block.box(1, 12.5, 1, 15, 15.5, 15))).setRegistryName(YDM.MOD_ID, "duel_table"));
        
        registry.register(new DuelBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(5.0F, 6.0F).sound(SoundType.METAL), Block.box(0, 0, 0, 16, 16, 16)).setRegistryName(YDM.MOD_ID, "duel_block"));
        registry.register(new DuelBlock(Block.Properties.of(Material.STONE, MaterialColor.SAND).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(5.0F, 6.0F).sound(SoundType.STONE), Block.box(0, 0, 0, 16, 16, 16)).setRegistryName(YDM.MOD_ID, "sandstone_duel_block"));
        registry.register(new DuelBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(5.0F, 6.0F).sound(SoundType.STONE), Block.box(0, 0, 0, 16, 16, 16)).setRegistryName(YDM.MOD_ID, "red_sandstone_duel_block"));
        
        registry.register(new CardSupplyBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)).setRegistryName(YDM.MOD_ID, "card_supply"));
        registry.register(new CosmeticBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(3.5F, 3.5F).sound(SoundType.METAL)).setRegistryName(YDM.MOD_ID, "card_crafter"));
        registry.register(new CardDecrafterBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(3.5F, 3.5F).sound(SoundType.METAL)).setRegistryName(YDM.MOD_ID, "card_decrafter"));
        registry.register(new CosmeticBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).strength(3.5F, 3.5F).sound(SoundType.METAL)).setRegistryName(YDM.MOD_ID, "rarity_exchanger"));
        registry.register(new CosmeticBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.5F, 3.5F).sound(SoundType.METAL)).setRegistryName(YDM.MOD_ID, "domain_generator"));
    }
}