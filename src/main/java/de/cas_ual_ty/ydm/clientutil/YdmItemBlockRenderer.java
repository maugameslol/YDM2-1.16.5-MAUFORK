package de.cas_ual_ty.ydm.clientutil;

import de.cas_ual_ty.ydm.YdmBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class YdmItemBlockRenderer {
	public static void register() {
		registerRenderLayer();
	}
	
	private static void registerRenderLayer() {
		RenderTypeLookup.setRenderLayer(YdmBlocks.CARD_DECRAFTER, RenderType.cutout());
	}
}
