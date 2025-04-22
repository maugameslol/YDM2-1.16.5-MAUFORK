package de.cas_ual_ty.ydm;

import de.cas_ual_ty.ydm.card.CardItem;
import de.cas_ual_ty.ydm.cardbinder.CardBinderItem;
import de.cas_ual_ty.ydm.deckbox.DeckBoxItem;
import de.cas_ual_ty.ydm.duel.dueldisk.DuelDiskItem;
import de.cas_ual_ty.ydm.item.CardCraftMaterialItem;
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
    public static final Item DUEL_TABLE = null;
    public static final Item CARD_SUPPLY = null;
    
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
    
    public static final DeckBoxItem COPPER_DECK_BOX = null;
    public static final DeckBoxItem IRON_DECK_BOX = null;
    public static final DeckBoxItem GOLD_DECK_BOX = null;
    public static final DeckBoxItem NETHERITE_DECK_BOX = null;
    
    public static final DeckBoxItem AMETHYST_DECK_BOX = null;
    public static final DeckBoxItem DIAMOND_DECK_BOX = null;
    public static final DeckBoxItem EMERALD_DECK_BOX = null;
    
    public static final DeckBoxItem PLATINUM_DECK_BOX = null;
    
    public static final DeckBoxItem BRONZE_DECK_BOX = null;
    
    public static final DeckBoxItem RUBY_DECK_BOX = null;
    public static final DeckBoxItem SAPPHIRE_DECK_BOX = null;
    
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
        registry.register(new BlockItem(YdmBlocks.DUEL_TABLE, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "duel_table"));
        registry.register(new BlockItem(YdmBlocks.CARD_SUPPLY, new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_supply"));
        
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
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "redstone_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "diamond_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "emerald_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "resin_deck_box"));
        
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "tin_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "silver_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "lead_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "platinum_deck_box"));
        registry.register(new DeckBoxItem(new Properties().tab(YDM.ydmItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "uranium_deck_box"));
        
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
        registry.register(new SleeveItem(new Properties().tab(YDM.sleevesItemGroup).stacksTo(1)).setRegistryName(YDM.MOD_ID, "sleeve"));
        
        // TODO: Card Materials for Crafting Cards
        // Card Borders
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_effect_monster"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_fusion_monster"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_link_monster"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_maximum_monster"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_normal_monster"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_pendulum_monster"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_ritual_monster"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_token"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_trap"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_skill"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_spell"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_synchro_monster"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_xyz_monster"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_evolution_monster"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_info"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "card_border_material"));
        
        // Attribute Orbs
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "attribute_orb_dark"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "attribute_orb_divine"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "attribute_orb_earth"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "attribute_orb_fire"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "attribute_orb_light"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "attribute_orb_skill"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "attribute_orb_spell"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "attribute_orb_trap"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "attribute_orb_water"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "attribute_orb_wind"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "attribute_orb_info"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "attribute_orb_material"));
        
        // Level Stars
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_0"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_1"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_2"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_3"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_4"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_5"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_6"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_7"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_8"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_9"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_10"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_11"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_12"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_13"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "level_star_custom"));
        
        // Rank Stars
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_0"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_1"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_2"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_3"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_4"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_5"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_6"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_7"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_8"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_9"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_10"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_11"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_12"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_13"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "rank_star_custom"));
        
        // Link Arrows
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "link_arrow_top_left"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "link_arrow_top"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "link_arrow_top_right"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "link_arrow_right"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "link_arrow_left"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "link_arrow_bottom_left"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "link_arrow_bottom"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "link_arrow_bottom_right"));
        
        // Trait Orbs
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "trait_orb_tuner"));
        
        // Ability Orbs
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "ability_orb_flip"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "ability_orb_toon"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "ability_orb_spirit"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "ability_orb_union"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "ability_orb_gemini"));
        
        // Spell/Trap Icons
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "spelltrap_icon_continuous"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "spelltrap_icon_counter"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "spelltrap_icon_equip"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "spelltrap_icon_field"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "spelltrap_icon_normal"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "spelltrap_icon_quickplay"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "spelltrap_icon_ritual"));
        registry.register(new CardCraftMaterialItem(new Properties().tab(YDM.ydmItemGroup)).setRegistryName(YDM.MOD_ID, "spelltrap_icon_link"));
    }
}