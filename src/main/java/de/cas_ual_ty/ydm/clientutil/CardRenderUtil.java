package de.cas_ual_ty.ydm.clientutil;

import com.mojang.blaze3d.matrix.MatrixStack;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.YdmDatabase;
import de.cas_ual_ty.ydm.YdmItems;
import de.cas_ual_ty.ydm.card.CardHolder;
import de.cas_ual_ty.ydm.card.properties.CardColor;
import de.cas_ual_ty.ydm.card.properties.MonsterProperties;
//import de.cas_ual_ty.ydm.card.properties.MonsterProperties;
import de.cas_ual_ty.ydm.card.properties.Properties;
import de.cas_ual_ty.ydm.duel.playfield.CardPosition;
import de.cas_ual_ty.ydm.duel.playfield.DuelCard;
import de.cas_ual_ty.ydm.rarity.RarityEntry;
import de.cas_ual_ty.ydm.rarity.RarityLayer;
import de.cas_ual_ty.ydm.rarity.RarityLayerType;
import de.cas_ual_ty.ydm.sleeve.CardBackType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import java.util.LinkedList;
import java.util.List;

public class CardRenderUtil
{
	public static final ResourceLocation MASK_RL = new ResourceLocation(YDM.MOD_ID, "textures/gui/rarity_mask.png");
	
    private static LimitedTextureBinder infoTextureBinder;
    private static LimitedTextureBinder mainTextureBinder;
    
    // called from ClientProxy
    public static void init(int maxInfoImages, int maxMainImages)
    {
        CardRenderUtil.infoTextureBinder = new LimitedTextureBinder(ClientProxy.getMinecraft(), maxInfoImages);
        CardRenderUtil.mainTextureBinder = new LimitedTextureBinder(ClientProxy.getMinecraft(), maxMainImages);
    }
    
    public static void renderCardInfo(MatrixStack ms, CardHolder card, ContainerScreen<?> screen)
    {
        CardRenderUtil.renderCardInfo(ms, card, screen.getGuiLeft());
    }
    
    public static void renderCardInfo(MatrixStack ms, CardHolder card)
    {
        CardRenderUtil.renderCardInfo(ms, card, 100);
    }
    
    public static void renderCardInfo(MatrixStack ms, CardHolder card, int width)
    {
        CardRenderUtil.renderCardInfo(ms, card, false, width);
    }
    
    public static void renderCardInfo(MatrixStack ms, CardHolder card, boolean token, int width)
    {
        if(card == null || card.getCard() == null)
        {
            return;
        }
        
        final float f = 0.5f;
        final int imageSize = 64;
        int margin = 2;
        
        int maxWidth = width - margin * 2;
        
        ms.pushPose();
        ScreenUtil.white();
        
        int x = margin;
        
        if(maxWidth < imageSize)
        {
            // draw it centered if the space we got is limited
            // to make sure the image is NOT rendered more to the right of the center
            x = (maxWidth - imageSize) / 2 + margin;
        }
        
        int legalityIconSize = 16;
    	int legalityIconLeft = x + 7;
    	int legalityIconTop = margin;
        
        // card texture
        
        CardRenderUtil.bindInfoResourceLocation(card);
        YdmBlitUtil.fullBlit(ms, x, margin, imageSize, imageSize);
        
        
        // TODO: card color overlay
        // Eventually want the mod to handle the card's border color and to eventually separate the artwork and symbols
        /*
        CardColor cardColor = card.getCard().getCardColor();
        
        if(cardColor != null)
        {
        	if(card.getCard() instanceof MonsterProperties && !token) 
            {
            	if(((MonsterProperties) card.card).getIsPendulum()) 
            	{
            		ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getInfoCardPendulumColorOverlay(CardColor.fromString(card.getCard().getCardColor().name)));
                    YdmBlitUtil.fullBlit(ms, x, margin, imageSize, imageSize);
            	}
            	else 
            	{
            		ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getInfoCardColorOverlay(CardColor.fromString(card.getCard().getCardColor().name)));
                    YdmBlitUtil.fullBlit(ms, x, margin, imageSize, imageSize);
            	}
            }
        	else 
        	{
        		ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getInfoCardColorOverlay(CardColor.fromString(card.getCard().getCardColor().name)));
                YdmBlitUtil.fullBlit(ms, x, margin, imageSize, imageSize);
        	}
        }
        else if(cardColor == null) 
        {
        	if(card.getCard() instanceof MonsterProperties && !token) 
            {
            	if(((MonsterProperties) card.card).getIsPendulum()) 
            	{
            		ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getInfoCardPendulumColorOverlay(CardColor.fromString(card.getCard().getDefaultCardColor().name)));
                    YdmBlitUtil.fullBlit(ms, x, margin, imageSize, imageSize);
            	}
            	else 
            	{
            		ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getInfoCardColorOverlay(CardColor.fromString(card.getCard().getDefaultCardColor().name)));
                    YdmBlitUtil.fullBlit(ms, x, margin, imageSize, imageSize);
            	}
            }
        	else 
        	{
        		ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getInfoCardColorOverlay(CardColor.fromString(card.getCard().getDefaultCardColor().name)));
                YdmBlitUtil.fullBlit(ms, x, margin, imageSize, imageSize);
        	}
        }
        
        if(card.getCard() instanceof MonsterProperties && !token) 
        {
        	if(((MonsterProperties) card.card).getIsPendulum()) 
        	{
        		ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getInfoPendulumBottomOverlay());
                YdmBlitUtil.fullBlit(ms, x, margin, imageSize, imageSize);
        	}
        }
        */
        
        // token created by Duel Action
        
        if(token)
        {
            ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getInfoTokenOverlay());
            YdmBlitUtil.fullBlit(ms, x, margin, imageSize, imageSize);
        }
        
        // card limitations
        
        if(card.getCard().getLimit() < 0) 
        {
        	ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getInfiniteLimitIcon());
            YdmBlitUtil.fullBlit(ms, legalityIconLeft, legalityIconTop, legalityIconSize, legalityIconSize);
        }
        if(card.getCard().getLimit() >= 0 && !card.getCard().getIsIllegal()) 
        {
        	boolean sharedLimit = card.getCard().getIsLimitShared();
        	boolean isUnlimited = card.getCard().getLimit() == 3 && !sharedLimit;
        	
        	if(card.getCard().getLimit() == 0) 
        	{
        		ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getForbiddenIcon());
                YdmBlitUtil.fullBlit(ms, legalityIconLeft, legalityIconTop, legalityIconSize, legalityIconSize);
        	}
        	else 
        	{
        		if(!isUnlimited) 
        		{
        			if(sharedLimit) 
            		{
            			ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getSharedLimitIcon());
                        YdmBlitUtil.fullBlit(ms, legalityIconLeft, legalityIconTop, legalityIconSize, legalityIconSize);
            		}
            		else 
            		{
            			ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getLimitIcon());
                        YdmBlitUtil.fullBlit(ms, legalityIconLeft, legalityIconTop, legalityIconSize, legalityIconSize);
            		}
            		
                    List<ITextComponent> limitNumber = new LinkedList<>();
                    card.getCard().addLimitNumber(limitNumber);
                    
                    ScreenUtil.drawSplitString(ms, ClientProxy.getMinecraft().font, limitNumber, legalityIconLeft + 5, legalityIconTop + 4, legalityIconSize, 0xFFAA00);
        		}
        	}
        }
        if(card.getCard().getIsIllegal()) 
    	{
    		ClientProxy.getMinecraft().textureManager.bind(CardRenderUtil.getIllegalIcon());
            YdmBlitUtil.fullBlit(ms, legalityIconLeft, legalityIconTop, legalityIconSize, legalityIconSize);
    	}
        
        // need to multiply x2 because we are scaling the text to x0.5
        maxWidth *= 2;
        margin *= 2;
        ms.scale(f, f, f);
        
        // card description text
        
        @SuppressWarnings("resource")
        FontRenderer fontRenderer = ClientProxy.getMinecraft().font;
        
        List<ITextComponent> list = new LinkedList<>();
        card.getCard().addInformation(list);
        
        ScreenUtil.drawSplitString(ms, fontRenderer, list, margin, imageSize * 2 + margin * 2, maxWidth, 0xFFFFFF);
        
        ms.popPose();
    }
    
    public static void bindInfoResourceLocation(CardHolder c)
    {
        CardRenderUtil.infoTextureBinder.bind(c.getInfoImageResourceLocation());
    }
    
    public static void bindMainResourceLocation(CardHolder c)
    {
        CardRenderUtil.mainTextureBinder.bind(c.getMainImageResourceLocation());
    }
    
    public static void bindInfoResourceLocation(Properties p, byte imageIndex)
    {
        CardRenderUtil.infoTextureBinder.bind(p.getInfoImageResourceLocation(imageIndex));
    }
    
    public static void bindMainResourceLocation(Properties p, byte imageIndex)
    {
        CardRenderUtil.mainTextureBinder.bind(p.getMainImageResourceLocation(imageIndex));
    }
    
    public static void bindInfoResourceLocation(ResourceLocation r)
    {
        CardRenderUtil.infoTextureBinder.bind(r);
    }
    
    public static void bindMainResourceLocation(ResourceLocation r)
    {
        CardRenderUtil.mainTextureBinder.bind(r);
    }
    
    public static void bindSleeves(CardBackType s)
    {
        ClientProxy.getMinecraft().textureManager.bind(s.getMainRL(ClientProxy.activeCardMainImageSize));
    }
    
    public static ResourceLocation getInfoCardBack()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/item/" + ClientProxy.activeCardInfoImageSize + "/" + YdmItems.CARD_BACK.getRegistryName().getPath() + ".png");
    }
    
    public static ResourceLocation getMainCardBack()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/item/" + ClientProxy.activeCardMainImageSize + "/" + YdmItems.CARD_BACK.getRegistryName().getPath() + ".png");
    }
    
    public static ResourceLocation getInfoTokenOverlay()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/card_overlays/" + ClientProxy.activeCardInfoImageSize + "/" + "token_overlay" + ".png");
    }
    
    public static ResourceLocation getMainTokenOverlay()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/card_overlays/" + ClientProxy.activeCardMainImageSize + "/" + "token_overlay" + ".png");
    }
    
    public static ResourceLocation getRarityOverlay()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/card_overlays/" + ClientProxy.activeCardInfoImageSize + "/" + "token_overlay" + ".png");
    }
    
    public static ResourceLocation getInfoCardColorOverlay(CardColor cardColor)
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/card_overlays/" + ClientProxy.activeCardInfoImageSize + "/" + "card_overlay_" + cardColor.name + ".png");
    }
    
    public static ResourceLocation getInfoCardPendulumColorOverlay(CardColor cardColor)
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/card_overlays/" + ClientProxy.activeCardInfoImageSize + "/" + "pendulum_overlay_" + cardColor.name + ".png");
    }
    
    public static ResourceLocation getInfoPendulumBottomOverlay()
    {
    	// TODO: Change this to accept different colored halves
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/card_overlays/" + ClientProxy.activeCardInfoImageSize + "/" + "pendulum_bottom_overlay_" + "spell_green" + ".png");
    }
    
    public static ResourceLocation getLimitIcon()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/card_overlays/" + "limit_icon" + ".png");
    }
    
    public static ResourceLocation getSharedLimitIcon()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/card_overlays/" + "limit_icon" + ".png");
    }
    
    public static ResourceLocation getForbiddenIcon()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/card_overlays/" + "forbidden_icon" + ".png");
    }
    
    public static ResourceLocation getIllegalIcon()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/card_overlays/" + "illegal_icon" + ".png");
    }
    
    public static ResourceLocation getLegendIcon()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/card_overlays/" + "legend_icon" + ".png");
    }
    
    public static ResourceLocation getInfiniteLimitIcon()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/gui/card_overlays/" + "infinite_limit_icon" + ".png");
    }
    
    public static void renderInfoCardWithRarity(MatrixStack ms, int mouseX, int mouseY, float x, float y, float width, float height, CardHolder card)
    {
        Minecraft mc = ClientProxy.getMinecraft();
        
        // bind the texture depending on faceup or facedown
        CardRenderUtil.bindInfoResourceLocation(card);
        YdmBlitUtil.fullBlit(ms, x - width / 2, y - height / 2, width, height);
        
        RarityEntry rarity = YdmDatabase.getRarity(card.getRarity());
        
        if(rarity != null)
        {
            for(RarityLayer layer : rarity.layers)
            {
                if(layer.type == RarityLayerType.INVERTED)
                {
                }
                
                Runnable mask = () ->
                {
                	mc.getTextureManager().bind(MASK_RL); //RenderSystem.setShaderTexture(0, MASK_RL);
                    YdmBlitUtil.fullBlit(ms, mouseX - width / 2, mouseY - height / 2, width, height);
                };
                
                Runnable renderer = () ->
                {
                	mc.getTextureManager().bind(layer.getInfoImageResourceLocation()); //RenderSystem.setShaderTexture(0, layer.getInfoImageResourceLocation());
                    YdmBlitUtil.fullBlit(ms, x - width / 2, y - height / 2, width, height);
                };
                
                YdmBlitUtil.advancedMaskedBlit(ms, x, y, width, height, mask, renderer, layer.type.invertedRendering);
            }
        }
    }
    
    public static void renderInfoCardWithRarityAndInfo(MatrixStack ms, int mouseX, int mouseY, float x, float y, float width, float height, CardHolder card)
    {
    	// TODO: Make UI that includes a close up of the card + its info.
    	
        Minecraft mc = ClientProxy.getMinecraft();
        
        // bind the texture depending on faceup or facedown
        CardRenderUtil.bindInfoResourceLocation(card);
        YdmBlitUtil.fullBlit(ms, x - width / 2, y - height / 2, width, height);
        
        RarityEntry rarity = YdmDatabase.getRarity(card.getRarity());
        
        if(rarity != null)
        {
            for(RarityLayer layer : rarity.layers)
            {
                if(layer.type == RarityLayerType.INVERTED)
                {
                }
                
                Runnable mask = () ->
                {
                	mc.getTextureManager().bind(MASK_RL); //RenderSystem.setShaderTexture(0, MASK_RL);
                    YdmBlitUtil.fullBlit(ms, mouseX - width / 2, mouseY - height / 2, width, height);
                };
                
                Runnable renderer = () ->
                {
                	mc.getTextureManager().bind(layer.getInfoImageResourceLocation()); //RenderSystem.setShaderTexture(0, layer.getInfoImageResourceLocation());
                    YdmBlitUtil.fullBlit(ms, x - width / 2, y - height / 2, width, height);
                };
                
                YdmBlitUtil.advancedMaskedBlit(ms, x, y, width, height, mask, renderer, layer.type.invertedRendering);
            }
        }
    }
    
    public static void renderDuelCardAdvanced(MatrixStack ms, CardBackType back, int mouseX, int mouseY, float x, float y, float width, float height, DuelCard card, YdmBlitUtil.FullBlitMethod blitMethod, boolean forceFaceUp)
    {
        CardPosition position = card.getCardPosition();
        
        // bind the texture depending on faceup or facedown
        if(!card.getCardPosition().isFaceUp && forceFaceUp)
        {
            position = position.flip();
        }
        
        CardRenderUtil.renderDuelCardAdvanced(ms, back, mouseX, mouseY, x, y, width, height, card, position, blitMethod);
    }
    
    public static void renderDuelCardAdvanced(MatrixStack ms, CardBackType back, int mouseX, int mouseY, float x, float y, float width, float height, DuelCard card, CardPosition position, YdmBlitUtil.FullBlitMethod blitMethod)
    {
        Minecraft mc = ClientProxy.getMinecraft();
        
        // bind the texture depending on faceup or facedown
        if(position.isFaceUp)
        {
            CardRenderUtil.bindMainResourceLocation(card.getCardHolder());
        }
        else
        {
            mc.getTextureManager().bind(back.getMainRL(ClientProxy.activeCardMainImageSize));
        }
        
        blitMethod.fullBlit(ms, x, y, width, height);
        
        if(card.getIsToken())
        {
            mc.getTextureManager().bind(CardRenderUtil.getMainTokenOverlay());
            blitMethod.fullBlit(ms, x, y, width, height);
        }
        
        if(position.isFaceUp && !card.getIsToken())
        {
            RarityEntry rarity = YdmDatabase.getRarity(card.getCardHolder().getRarity());
            
            if(rarity != null)
            {
                for(RarityLayer layer : rarity.layers)
                {
                    Runnable mask = () ->
                    {
                    	mc.getTextureManager().bind(MASK_RL); //RenderSystem.setShaderTexture(0, MASK_RL);
                        blitMethod.fullBlit(ms, mouseX - width / 2, mouseY - height / 2, width, height);
                    };
                    
                    Runnable renderer = () ->
                    {
                    	mc.getTextureManager().bind(layer.getMainImageResourceLocation()); //RenderSystem.setShaderTexture(0, layer.getMainImageResourceLocation());
                        blitMethod.fullBlit(ms, x, y, width, height);
                    };
                    
                    YdmBlitUtil.advancedMaskedBlit(ms, x, y, width, height, mask, renderer, layer.type.invertedRendering);
                }
            }
        }
    }
    
    public static void renderDuelCard(MatrixStack ms, CardBackType back, int mouseX, int mouseY, float x, float y, float width, float height, DuelCard card, boolean forceFaceUp)
    {
        CardRenderUtil.renderDuelCardAdvanced(ms, back, mouseX, mouseY, x, y, width, height, card,
                card.getCardPosition().isStraight
                        ? YdmBlitUtil::fullBlit
                        : YdmBlitUtil::fullBlit90Degree, forceFaceUp);
    }
    
    public static void renderDuelCardReversed(MatrixStack ms, CardBackType back, int mouseX, int mouseY, float x, float y, float width, float height, DuelCard card, boolean forceFaceUp)
    {
        CardRenderUtil.renderDuelCardAdvanced(ms, back, mouseX, mouseY, x, y, width, height, card,
                card.getCardPosition().isStraight
                        ? YdmBlitUtil::fullBlit180Degree
                        : YdmBlitUtil::fullBlit270Degree, forceFaceUp);
    }
    
    public static void renderDuelCardCentered(MatrixStack ms, CardBackType back, int mouseX, int mouseY, float x, float y, float width, float height, DuelCard card, boolean forceFaceUp)
    {
        // if width and height are more of a rectangle, this centers the texture horizontally
        x -= (height - width) / 2;
        width = height;
        
        CardRenderUtil.renderDuelCard(ms, back, mouseX, mouseY, x, y, width, height, card, forceFaceUp);
    }
    
    public static void renderDuelCardReversedCentered(MatrixStack ms, CardBackType back, int mouseX, int mouseY, float x, float y, float width, float height, DuelCard card, boolean forceFaceUp)
    {
        // if width and height are more of a rectangle, this centers the texture horizontally
        x -= (height - width) / 2;
        width = height;
        
        CardRenderUtil.renderDuelCardReversed(ms, back, mouseX, mouseY, x, y, width, height, card, forceFaceUp);
    }
}
