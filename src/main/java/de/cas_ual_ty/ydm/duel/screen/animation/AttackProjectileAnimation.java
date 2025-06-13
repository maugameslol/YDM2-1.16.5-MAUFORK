package de.cas_ual_ty.ydm.duel.screen.animation;

import com.mojang.blaze3d.matrix.MatrixStack;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.clientutil.ClientProxy;
import de.cas_ual_ty.ydm.clientutil.YdmBlitUtil;
import de.cas_ual_ty.ydm.duel.playfield.CardPosition;
import de.cas_ual_ty.ydm.duel.playfield.ZoneOwner;
import de.cas_ual_ty.ydm.duel.screen.widget.ZoneWidget;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;

public class AttackProjectileAnimation extends Animation
{
	public final ZoneOwner view;
    public final ZoneWidget sourceZone;
    public final ZoneWidget destinationZone;
    
    public int sourceX;
    public int sourceY;
    public int destX;
    public int destY;
    public int size;
    public int endSize;
    
    public AttackProjectileAnimation(ZoneOwner view, ZoneWidget sourceZone, ZoneWidget destinationZone, int size, int endSize)
    {
        super(ClientProxy.attackAnimationLength);
        
        this.view = view;
        this.sourceZone = sourceZone;
        this.destinationZone = destinationZone;
        
        sourceX = this.sourceZone.getAnimationSourceX();
        sourceY = this.sourceZone.getAnimationSourceY();
        destX = this.destinationZone.getAnimationDestX();
        destY = this.destinationZone.getAnimationDestY();
        this.size = size;
        this.endSize = endSize;
    }
    
    @Override
    public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks)
    {
    	double relativeTickTime = (tickTime + partialTicks) / maxTickTime;
        
        // [1pi, 2pi]
        double cosTime1 = Math.PI * relativeTickTime + Math.PI;
        // [0, 1]
        float relativePositionRotation = (float) ((Math.cos(cosTime1) + 1) * 0.5D);
        
        float deltaX = destX - sourceX;
        float deltaY = destY - sourceY;
        
        //float maxSize = MathHelper.sqrt(deltaX * deltaX + deltaY * deltaY);
        
        float rotation;
        
        float size = (float) relativeTickTime * (endSize - this.size) + this.size;
        float halfSize = 0.5F * size;
        
        if(deltaX != 0)
        {
            rotation = (float) (Math.atan(deltaY / deltaX) + 0.5D * Math.PI);
        }
        else
        {
            if(deltaY > 0)
            {
                rotation = 0F;
            }
            else
            {
                rotation = (float) Math.PI;
            }
        }
        
        if(deltaX > 0)
        {
            rotation += Math.PI;
        }
        
        float posX = sourceX;
        float posY = sourceY;
        
        posX += (destX - sourceX) * relativePositionRotation;
        posY += (destY - sourceY) * relativePositionRotation;
        rotation += Math.PI;
        relativePositionRotation = 1 - relativePositionRotation;
        
        ms.pushPose();
        
        ms.translate(posX, posY, 0);
        ms.mulPose(new Quaternion(0, 0, rotation, false));
        
        ClientProxy.getMinecraft().textureManager.bind(getTexture());
        YdmBlitUtil.fullBlit(ms, -halfSize, -halfSize * relativePositionRotation, size, size);
        
        ms.popPose();
    }
    
    public static float getRotationForPositionAndView(boolean isOpponentView, CardPosition position)
    {
        if(position.isStraight)
        {
            if(!isOpponentView)
            {
                return 180;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            if(!isOpponentView)
            {
                return 90;
            }
            else
            {
                return 270;
            }
        }
    }
    
	public ResourceLocation getTexture()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/action_animations/default_attack_projectile.png");
    }
}
