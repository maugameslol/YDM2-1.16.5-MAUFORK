package de.cas_ual_ty.ydm.datagen;

import java.io.IOException;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.clientutil.ImageHandler;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class YDMDataGen
{
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
		try
        {
			ImageHandler.createCustomCardSizedImages("card_overlay_dark_synchro_gray", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_dragon_blue", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_effect_orange", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_fusion_purple", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_link_blue", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_normal_yellow", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_obelisk_blue", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_osiris_red", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_ra_yellow", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_ritual_blue", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_skill_blue", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_spell_green", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_synchro_white", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_token_gray", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_trap_magenta", "png");
    		ImageHandler.createCustomCardSizedImages("card_overlay_xyz_black", "png");
    		
			ImageHandler.createCustomCardSizedImages("pendulum_overlay_dark_synchro_gray", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_dragon_blue", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_effect_orange", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_fusion_purple", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_link_blue", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_normal_yellow", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_obelisk_blue", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_osiris_red", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_ra_yellow", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_ritual_blue", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_skill_blue", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_spell_green", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_synchro_white", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_token_gray", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_trap_magenta", "png");
    		ImageHandler.createCustomCardSizedImages("pendulum_overlay_xyz_black", "png");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new YDMItemModels(generator, YDM.MOD_ID, event.getExistingFileHelper()));
    }
}