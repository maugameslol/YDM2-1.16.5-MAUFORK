package de.cas_ual_ty.ydm;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class YdmSoundEvents {
	/* 
	 * TODO: Make a sound registry and place SFX in certain Duel actions such as drawing, shuffling, summoning, etc.
	 */
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, YDM.MOD_ID);
	
	// card stuff
	public static final RegistryObject<SoundEvent> CARD_DRAW = registerSoundEvent("card_draw");
	public static final RegistryObject<SoundEvent> CARD_ATK_POSITION = registerSoundEvent("card_atk_position");
	public static final RegistryObject<SoundEvent> CARD_DEF_POSITION = registerSoundEvent("card_def_position");
	public static final RegistryObject<SoundEvent> CARD_SET_POSITION = registerSoundEvent("card_set_position");
	public static final RegistryObject<SoundEvent> CARD_SET_BACKROW = registerSoundEvent("card_set_backrow");
	public static final RegistryObject<SoundEvent> CARD_DESTROY = registerSoundEvent("card_destroy");
	public static final RegistryObject<SoundEvent> CARD_ATTACH = registerSoundEvent("card_attach");
	public static final RegistryObject<SoundEvent> CARD_DETACH = registerSoundEvent("card_detach");
	public static final RegistryObject<SoundEvent> CARD_SHUFFLE = registerSoundEvent("card_shuffle");
	public static final RegistryObject<SoundEvent> CARD_MOVE = registerSoundEvent("card_move");
	
	// coin and dice
	public static final RegistryObject<SoundEvent> DICE_ROLL = registerSoundEvent("dice_roll");
	public static final RegistryObject<SoundEvent> COIN_THROW = registerSoundEvent("coin_throw");
	
	// token
	public static final RegistryObject<SoundEvent> TOKEN_SUMMON = registerSoundEvent("token_summon");
	public static final RegistryObject<SoundEvent> TOKEN_REMOVE = registerSoundEvent("token_remove");
	
	// summons
	public static final RegistryObject<SoundEvent> SUMMON_NORMAL = registerSoundEvent("summon_normal");
	public static final RegistryObject<SoundEvent> SUMMON_NORMAL_MIDDLE = registerSoundEvent("summon_normal_middle");
	public static final RegistryObject<SoundEvent> SUMMON_NORMAL_HIGH = registerSoundEvent("summon_normal_high");
	public static final RegistryObject<SoundEvent> SUMMON_TRIBUTE = registerSoundEvent("summon_tribute");
	public static final RegistryObject<SoundEvent> SUMMON_TRIBUTE_MIDDLE = registerSoundEvent("summon_tribute_middle");
	public static final RegistryObject<SoundEvent> SUMMON_TRIBUTE_HIGH = registerSoundEvent("summon_tribute_high");
	public static final RegistryObject<SoundEvent> SUMMON_FUSION = registerSoundEvent("summon_fusion");
	public static final RegistryObject<SoundEvent> SUMMON_FUSION_MIDDLE = registerSoundEvent("summon_fusion_middle");
	public static final RegistryObject<SoundEvent> SUMMON_FUSION_HIGH = registerSoundEvent("summon_fusion_high");
	public static final RegistryObject<SoundEvent> SUMMON_RITUAL = registerSoundEvent("summon_ritual");
	public static final RegistryObject<SoundEvent> SUMMON_RITUAL_MIDDLE = registerSoundEvent("summon_ritual_middle");
	public static final RegistryObject<SoundEvent> SUMMON_RITUAL_HIGH = registerSoundEvent("summon_ritual_high");
	public static final RegistryObject<SoundEvent> SUMMON_SYNCHRO = registerSoundEvent("summon_synchro");
	public static final RegistryObject<SoundEvent> SUMMON_SYNCHRO_MIDDLE = registerSoundEvent("summon_synchro_middle");
	public static final RegistryObject<SoundEvent> SUMMON_SYNCHRO_HIGH = registerSoundEvent("summon_synchro_high");
	public static final RegistryObject<SoundEvent> SUMMON_XYZ = registerSoundEvent("summon_xyz");
	public static final RegistryObject<SoundEvent> SUMMON_XYZ_MIDDLE = registerSoundEvent("summon_xyz_middle");
	public static final RegistryObject<SoundEvent> SUMMON_XYZ_HIGH = registerSoundEvent("summon_xyz_high");
	public static final RegistryObject<SoundEvent> SUMMON_PENDULUM = registerSoundEvent("summon_pendulum");
	public static final RegistryObject<SoundEvent> SUMMON_PENDULUM_MIDDLE = registerSoundEvent("summon_pendulum_middle");
	public static final RegistryObject<SoundEvent> SUMMON_PENDULUM_HIGH = registerSoundEvent("summon_pendulum_high");
	public static final RegistryObject<SoundEvent> SUMMON_LINK = registerSoundEvent("summon_link");
	public static final RegistryObject<SoundEvent> SUMMON_LINK_MIDDLE = registerSoundEvent("summon_link_middle");
	public static final RegistryObject<SoundEvent> SUMMON_LINK_HIGH = registerSoundEvent("summon_link_high");
	// TODO: Custom Summoning Types, Maximum Summons, etc.
	
	// counters
	public static final RegistryObject<SoundEvent> COUNTER_PLACE = registerSoundEvent("counter_place");
	
	// LP
	public static final RegistryObject<SoundEvent> LP_COUNT = registerSoundEvent("lp_count");
	
	// GY
	public static final RegistryObject<SoundEvent> GY_ENTER = registerSoundEvent("gy_enter");
	public static final RegistryObject<SoundEvent> GY_EXIT = registerSoundEvent("gy_exit");
	
	// Banishment
	public static final RegistryObject<SoundEvent> BANISHMENT_ENTER = registerSoundEvent("banishment_enter");
	public static final RegistryObject<SoundEvent> BANISHMENT_EXIT = registerSoundEvent("banishment_exit");
	
	// Duel
	public static final RegistryObject<SoundEvent> DUEL_START = registerSoundEvent("duel_start");
	public static final RegistryObject<SoundEvent> DUEL_WIN = registerSoundEvent("duel_win");
	public static final RegistryObject<SoundEvent> DUEL_LOSE = registerSoundEvent("duel_lose");
	public static final RegistryObject<SoundEvent> DUEL_DRAW = registerSoundEvent("duel_draw");
	public static final RegistryObject<SoundEvent> DIRECT_ATTACK_DECLARE = registerSoundEvent("direct_attack_declare");
	public static final RegistryObject<SoundEvent> DIRECT_ATTACK_PLAYER1 = registerSoundEvent("direct_attack_player1");
	public static final RegistryObject<SoundEvent> DIRECT_ATTACK_PLAYER2 = registerSoundEvent("direct_attack_player2");
	public static final RegistryObject<SoundEvent> PHASE_CHANGE_PLAYER1 = registerSoundEvent("phase_change_player1");
	public static final RegistryObject<SoundEvent> PHASE_CHANGE_PLAYER2 = registerSoundEvent("phase_change_player2");
	public static final RegistryObject<SoundEvent> TURN_SWITCH_PLAYER1 = registerSoundEvent("turn_switch_player1");
	public static final RegistryObject<SoundEvent> TURN_SWITCH_PLAYER2 = registerSoundEvent("turn_switch_player2");
	
	private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
		return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(YDM.MOD_ID, name)));
	}
	
	public static void register(IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}
}
