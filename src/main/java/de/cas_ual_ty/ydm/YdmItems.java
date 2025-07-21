package de.cas_ual_ty.ydm;

import de.cas_ual_ty.ydm.card.CardItem;
import de.cas_ual_ty.ydm.cardbinder.CardBinderItem;
import de.cas_ual_ty.ydm.deckbox.DeckBoxItem;
import de.cas_ual_ty.ydm.duel.dueldisk.DuelDiskItem;
import de.cas_ual_ty.ydm.item.CardCraftItem;
import de.cas_ual_ty.ydm.item.CosmeticItem;
import de.cas_ual_ty.ydm.set.CardSetItem;
import de.cas_ual_ty.ydm.set.OpenedCardSetItem;
import de.cas_ual_ty.ydm.simplebinder.SimpleBinderItem;
import de.cas_ual_ty.ydm.sleeve.DefaultSleevesItem;
import de.cas_ual_ty.ydm.sleeve.CardBackType;
import de.cas_ual_ty.ydm.sleeve.SleeveItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = YDM.MOD_ID, bus = Bus.MOD)
@ObjectHolder(YDM.MOD_ID)
public class YdmItems
{
    public static final Item BLANC_CARD = null;
    public static final Item CARD_BACK = null;
    public static final Item BLANC_SET = null;
    public static final Item BLANC_SLEEVE = null;
    public static final CardItem CARD = null;
    public static final CardSetItem SET = null;
    public static final OpenedCardSetItem OPENED_SET = null;
    public static final CardBinderItem CARD_BINDER = null;
    
    public static final Item DUEL_PLAYMAT = null;
    
    public static final Item SANDSTONE_DUEL_PLAYMAT = null;
    public static final Item RED_SANDSTONE_DUEL_PLAYMAT = null;
    
    public static final Item BLACK_DUEL_PLAYMAT = null;
    public static final Item BLUE_DUEL_PLAYMAT = null;
    public static final Item BROWN_DUEL_PLAYMAT = null;
    public static final Item CYAN_DUEL_PLAYMAT = null;
    public static final Item GRAY_DUEL_PLAYMAT = null;
    public static final Item GREEN_DUEL_PLAYMAT = null;
    public static final Item LIGHT_BLUE_DUEL_PLAYMAT = null;
    public static final Item LIGHT_GRAY_DUEL_PLAYMAT = null;
    public static final Item LIME_DUEL_PLAYMAT = null;
    public static final Item MAGENTA_DUEL_PLAYMAT = null;
    public static final Item ORANGE_DUEL_PLAYMAT = null;
    public static final Item PINK_DUEL_PLAYMAT = null;
    public static final Item PURPLE_DUEL_PLAYMAT = null;
    public static final Item RED_DUEL_PLAYMAT = null;
    public static final Item WHITE_DUEL_PLAYMAT = null;
    public static final Item YELLOW_DUEL_PLAYMAT = null;
    
    public static final Item DUEL_TABLE = null;
    
    public static final Item DUEL_BLOCK = null;
    public static final Item SANDSTONE_DUEL_BLOCK = null;
    public static final Item RED_SANDSTONE_DUEL_BLOCK = null;
    
    public static final Item CARD_SUPPLY = null;
    public static final Item CARD_CRAFTER = null;
    public static final Item CARD_DECRAFTER = null;
    //public static final Item RARITY_EXCHANGER = null;
    //public static final Item DOMAIN_GENERATOR = null;
    
    public static final SimpleBinderItem SIMPLE_BINDER_3 = null;
    public static final SimpleBinderItem SIMPLE_BINDER_9 = null;
    public static final SimpleBinderItem SIMPLE_BINDER_27 = null;
    
    public static final Item DUEL_DISK = null;
    public static final Item CHAOS_DISK = null;
    public static final Item ACADEMIA_DISK = null;
    public static final Item ACADEMIA_DISK_RED = null;
    public static final Item ACADEMIA_DISK_BLUE = null;
    public static final Item ACADEMIA_DISK_YELLOW = null;
    public static final Item ROCK_SPIRIT_DISK = null;
    public static final Item CYBER_DESIGN_INTERFACE = null;
    
    public static final DeckBoxItem BLACK_DECK_BOX = null;
    public static final DeckBoxItem RED_DECK_BOX = null;
    public static final DeckBoxItem GREEN_DECK_BOX = null;
    public static final DeckBoxItem BROWN_DECK_BOX = null;
    public static final DeckBoxItem BLUE_DECK_BOX = null;
    public static final DeckBoxItem PURPLE_DECK_BOX = null;
    public static final DeckBoxItem CYAN_DECK_BOX = null;
    public static final DeckBoxItem LIGHT_GRAY_DECK_BOX = null;
    public static final DeckBoxItem GRAY_DECK_BOX = null;
    public static final DeckBoxItem PINK_DECK_BOX = null;
    public static final DeckBoxItem LIME_DECK_BOX = null;
    public static final DeckBoxItem YELLOW_DECK_BOX = null;
    public static final DeckBoxItem LIGHT_BLUE_DECK_BOX = null;
    public static final DeckBoxItem MAGENTA_DECK_BOX = null;
    public static final DeckBoxItem ORANGE_DECK_BOX = null;
    public static final DeckBoxItem WHITE_DECK_BOX = null;
    
    public static final DeckBoxItem AMETHYST_DECK_BOX = null;
    public static final DeckBoxItem BRASS_DECK_BOX = null;
    public static final DeckBoxItem BRONZE_DECK_BOX = null;
    public static final DeckBoxItem COPPER_DECK_BOX = null;
    public static final DeckBoxItem DIAMOND_DECK_BOX = null;
    public static final DeckBoxItem EMERALD_DECK_BOX = null;
    public static final DeckBoxItem GOLD_DECK_BOX = null;
    public static final DeckBoxItem IRON_DECK_BOX = null;
    public static final DeckBoxItem LAPIS_DECK_BOX = null;
    public static final DeckBoxItem LEAD_DECK_BOX = null;
    public static final DeckBoxItem NETHERITE_DECK_BOX = null;
    public static final DeckBoxItem OSMIUM_DECK_BOX = null;
    public static final DeckBoxItem PLATINUM_DECK_BOX = null;
    public static final DeckBoxItem QUARTZ_DECK_BOX = null;
    public static final DeckBoxItem REDSTONE_DECK_BOX = null;
    public static final DeckBoxItem RESIN_DECK_BOX = null;
    public static final DeckBoxItem RUBY_DECK_BOX = null;
    public static final DeckBoxItem SAPPHIRE_DECK_BOX = null;
    public static final DeckBoxItem SILVER_DECK_BOX = null;
    public static final DeckBoxItem URANIUM_DECK_BOX = null;
    
    public static final DeckBoxItem PATREON_DECK_BOX = null;
    
    public static final SleeveItem SLEEVE = null;
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(new CosmeticItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "blanc_card"));
        registry.register(new CosmeticItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_back"));
        registry.register(new CosmeticItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "blanc_set"));
        registry.register(new CosmeticItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "blanc_sleeve"));
        registry.register(new CardItem(new Properties().tab(YDM.cardsItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "card"));
        registry.register(new CardSetItem(new Properties().tab(YDM.setsItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "set"));
        registry.register(new OpenedCardSetItem(new Properties().stacksTo(1)).setRegistryName(YDM.MOD_ID, "opened_set"));
        registry.register(new CardBinderItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "card_binder"));
        registry.register(new BlockItem(YdmBlocks.DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "duel_playmat"));
        
        registry.register(new BlockItem(YdmBlocks.SANDSTONE_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "sandstone_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.RED_SANDSTONE_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "red_sandstone_duel_playmat"));
        
        registry.register(new BlockItem(YdmBlocks.BLACK_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "black_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.BLUE_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "blue_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.BROWN_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "brown_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.CYAN_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "cyan_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.GRAY_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "gray_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.GREEN_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "green_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.LIGHT_BLUE_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "light_blue_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.LIGHT_GRAY_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "light_gray_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.LIME_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "lime_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.MAGENTA_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "magenta_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.ORANGE_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "orange_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.PINK_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "pink_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.PURPLE_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "purple_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.RED_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "red_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.WHITE_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "white_duel_playmat"));
        registry.register(new BlockItem(YdmBlocks.YELLOW_DUEL_PLAYMAT, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "yellow_duel_playmat"));
        
        registry.register(new BlockItem(YdmBlocks.DUEL_TABLE, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "duel_table"));
        
        registry.register(new BlockItem(YdmBlocks.DUEL_BLOCK, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "duel_block"));
        registry.register(new BlockItem(YdmBlocks.SANDSTONE_DUEL_BLOCK, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "sandstone_duel_block"));
        registry.register(new BlockItem(YdmBlocks.RED_SANDSTONE_DUEL_BLOCK, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "red_sandstone_duel_block"));
        
        registry.register(new BlockItem(YdmBlocks.CARD_SUPPLY, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_supply"));
        registry.register(new BlockItem(YdmBlocks.CARD_CRAFTER, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_crafter"));
        registry.register(new BlockItem(YdmBlocks.CARD_DECRAFTER, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_decrafter"));
        //registry.register(new BlockItem(YdmBlocks.RARITY_EXCHANGER, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rarity_exchanger"));
        //registry.register(new BlockItem(YdmBlocks.DOMAIN_GENERATOR, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "domain_generator"));
        
        registry.register(SimpleBinderItem.makeItem(YDM.MOD_ID, YDM.ydmItemGroup, 3));
        registry.register(SimpleBinderItem.makeItem(YDM.MOD_ID, YDM.ydmItemGroup, 9));
        registry.register(SimpleBinderItem.makeItem(YDM.MOD_ID, YDM.ydmItemGroup, 27));
        
        registry.register(new CosmeticItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "millennium_eye"));
        registry.register(new CosmeticItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "millennium_key"));
        registry.register(new CosmeticItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "millennium_necklace"));
        registry.register(new CosmeticItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "millennium_puzzle"));
        registry.register(new CosmeticItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "millennium_ring"));
        registry.register(new CosmeticItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "millennium_rod"));
        registry.register(new CosmeticItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "millennium_scale"));
        
        registry.register(new DuelDiskItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "duel_disk"));
        registry.register(new DuelDiskItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "chaos_disk"));
        registry.register(new DuelDiskItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "academia_disk"));
        registry.register(new DuelDiskItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "academia_disk_red"));
        registry.register(new DuelDiskItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "academia_disk_blue"));
        registry.register(new DuelDiskItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "academia_disk_yellow"));
        registry.register(new DuelDiskItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "rock_spirit_disk"));
        registry.register(new DuelDiskItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "trueman_disk"));
        registry.register(new DuelDiskItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "jewel_disk"));
        registry.register(new DuelDiskItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "kaibaman_disk"));
        registry.register(new DuelDiskItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "cyber_design_interface"));
        
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "black_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "red_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "green_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "brown_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "blue_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "purple_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "cyan_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "light_gray_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "gray_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "pink_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "lime_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "yellow_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "light_blue_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "magenta_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "orange_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "white_deck_box"));
        
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "copper_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "iron_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "gold_deck_box"));
        registry.register(new DeckBoxItem(new Properties().fireResistant().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "netherite_deck_box"));
        
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "amethyst_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "quartz_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "lapis_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "redstone_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "diamond_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "emerald_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "resin_deck_box"));
        
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "tin_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "silver_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "lead_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "osmium_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "platinum_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "uranium_deck_box"));
        
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "brass_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "bronze_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "electrum_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "steel_deck_box"));
        
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "ruby_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "sapphire_deck_box"));
        
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "patreon_deck_box"));
        
        for(CardBackType sleeve : CardBackType.VALUES)
        {
            if(!sleeve.isCardBack())
            {
            	if(sleeve.isFireProof())
                {
                    registry.register(new DefaultSleevesItem(new Properties().fireResistant().tab(YDM.sleevesItemGroup).stacksTo(1), sleeve).setRegistryName(YDM.MOD_ID, sleeve.getResourceName()));
                }
            	else 
            	{
            		registry.register(new DefaultSleevesItem(new Properties().tab(YDM.sleevesItemGroup).stacksTo(1), sleeve).setRegistryName(YDM.MOD_ID, sleeve.getResourceName()));
            	}
            }
        }
        
        registry.register(new SleeveItem(new Properties().tab(YDM.sleevesItemGroup).stacksTo(1), CardBackType.CARD_BACK).setRegistryName(YDM.MOD_ID, "sleeve"));
        
        // TODO: Card Materials for Crafting Cards
        // Card Borders
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "effect_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "fusion_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "link_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "maximum_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "normal_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "pendulum_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "ritual_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "token_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "trap_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "skill_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "spell_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "synchro_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "xyz_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "dark_synchro_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "evolution_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "info_card_border"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "material_card_border"));
        
        // Attribute Orbs
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "dark_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "divine_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "earth_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "fire_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "light_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "skill_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "spell_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "trap_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "water_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "wind_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "laugh_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "dreams_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "fiend_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "thunder_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "wood_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "chaos_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "info_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "material_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "metal_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "neutral_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rainbow_attribute_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "void_attribute_orb"));
        
        // Level Stars
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "negative_level_star"));
        
        // Rank Stars
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star"));
        
        // Pendulum Scale
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "blue_pendulum_scale"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "red_pendulum_scale"));
        
        // Link Rating
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "link_rating"));
        
        // Link Arrows
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "top_left_link_arrow"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "top_link_arrow"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "top_right_link_arrow"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "right_link_arrow"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "left_link_arrow"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "bottom_left_link_arrow"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "bottom_link_arrow"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "bottom_right_link_arrow"));
        
        // Ability Orbs
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "flip_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "toon_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "spirit_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "union_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "gemini_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "tuner_orb"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "dark_tuner_orb"));
        
        // Spell/Trap Icons
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "continuous_spelltrap_icon"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "counter_spelltrap_icon"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "equip_spelltrap_icon"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "field_spelltrap_icon"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "normal_spelltrap_icon"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "quickplay_spelltrap_icon"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "ritual_spelltrap_icon"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "link_spelltrap_icon"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "speed_spelltrap_icon"));
        
        // Species Essence
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "aqua_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "beast_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "beast_warrior_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "creator_god_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "cyberse_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "dinosaur_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "divine_beast_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "dragon_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "fairy_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "fiend_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "fish_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "illusion_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "insect_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "machine_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "plant_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "psychic_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "pyro_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "reptile_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rock_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "sea_serpent_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "spellcaster_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "thunder_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "warrior_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "winged_beast_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "wyrm_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "zombie_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "celestial_warrior_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "cyborg_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "galaxy_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "high_dragon_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "magical_knight_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "omega_psychic_esscence"));
        registry.register(new CardCraftItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "immortal_esscence"));
    }
}