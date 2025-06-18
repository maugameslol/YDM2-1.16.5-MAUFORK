package de.cas_ual_ty.ydm.duel.screen.animation;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.YdmSoundEvents;
import de.cas_ual_ty.ydm.clientutil.ClientProxy;
import de.cas_ual_ty.ydm.clientutil.ScreenUtil;
import de.cas_ual_ty.ydm.clientutil.YdmBlitUtil;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

public class PhaseChangeAnimation extends Animation 
{
	public ITextComponent message;
	boolean turnPlayer;
	public float centerPosX;
    public float centerPosY;
    public int size;
    public int endSize;
    
	public PhaseChangeAnimation(ITextComponent message, boolean turnPlayer, float centerPosX, float centerPosY, int size, int endSize) 
	{
		super(ClientProxy.announcementAnimationLength);
		
		this.message = message;
		this.centerPosX = centerPosX;
        this.centerPosY = centerPosY;
        this.turnPlayer = turnPlayer;
        this.size = size;
        this.endSize = endSize;
	}
	
	@Override
    public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks)
    {
        FontRenderer f = ClientProxy.getMinecraft().font;
        
        double relativeTickTime = (tickTime + partialTicks) / maxTickTime;
        
        // [0, 1/2pi]
        double cosTime1 = 0.5D * Math.PI * relativeTickTime;
        // [0, 1]
        float alpha = (float) (Math.cos(cosTime1));
        
        float size = (float) relativeTickTime * (endSize - this.size) + this.size;
        float halfSize = 0.5F * size;
        
        ms.pushPose();
        
        ms.translate(centerPosX, centerPosY - f.lineHeight / 2, 0);
        
        RenderSystem.enableBlend();
        RenderSystem.color4f(1F, 1F, 1F, alpha);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        
        ClientProxy.getMinecraft().textureManager.bind(getTexture());
        YdmBlitUtil.fullBlit(ms, -halfSize, -halfSize , size, size);
        
        int j = 16777215; //See TextWidget
        AbstractGui.drawCenteredString(ms, f, message, 0, 0, j | MathHelper.ceil(alpha * 255.0F) << 24);
        
        RenderSystem.disableBlend();
        ScreenUtil.white();
        
        ms.popPose();
    }
	
	
    public ResourceLocation getTexture()
    {
		if(turnPlayer) 
    	{
			return new ResourceLocation(YDM.MOD_ID, "textures/gui/action_animations/player_blue_banner.png");
    	}
    	else 
    	{
    		return new ResourceLocation(YDM.MOD_ID, "textures/gui/action_animations/player_red_banner.png");
    	}
    }
    
    @Override
    public SoundEvent getSoundEvent()
    {
    	if(turnPlayer) 
    	{
    		return YdmSoundEvents.PHASE_CHANGE_PLAYER1.get();
    	}
    	else 
    	{
    		return YdmSoundEvents.PHASE_CHANGE_PLAYER2.get();
    	}
    }
}
