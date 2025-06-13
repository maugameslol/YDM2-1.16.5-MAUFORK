package de.cas_ual_ty.ydm.duel.screen.animation;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.duel.playfield.ZoneOwner;
import de.cas_ual_ty.ydm.duel.screen.widget.ZoneWidget;
import net.minecraft.util.ResourceLocation;

public class DarkAttackProjectileAnimation extends AttackProjectileAnimation
{
	public DarkAttackProjectileAnimation(ZoneOwner view, ZoneWidget sourceZone, ZoneWidget destinationZone, int size, int endSize) 
	{
		super(view, sourceZone, destinationZone, size, endSize);
	}
	
	@Override
    public ResourceLocation getTexture()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/action_animations/dark_attack_projectile.png");
    }
}
