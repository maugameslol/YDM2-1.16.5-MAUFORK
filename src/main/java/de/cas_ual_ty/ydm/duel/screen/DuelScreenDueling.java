package de.cas_ual_ty.ydm.duel.screen;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.YdmSoundEvents;
import de.cas_ual_ty.ydm.card.properties.DefMonsterProperties;
import de.cas_ual_ty.ydm.card.properties.LevelMonsterProperties;
import de.cas_ual_ty.ydm.card.properties.LinkMonsterProperties;
//import de.cas_ual_ty.ydm.card.properties.LinkMonsterProperties;
import de.cas_ual_ty.ydm.card.properties.MonsterProperties;
import de.cas_ual_ty.ydm.card.properties.Properties;
import de.cas_ual_ty.ydm.card.properties.XyzMonsterProperties;
//import de.cas_ual_ty.ydm.card.properties.XyzMonsterProperties;
import de.cas_ual_ty.ydm.clientutil.CardRenderUtil;
import de.cas_ual_ty.ydm.clientutil.ScreenUtil;
import de.cas_ual_ty.ydm.clientutil.widget.*;
import de.cas_ual_ty.ydm.duel.DuelContainer;
import de.cas_ual_ty.ydm.duel.DuelPhase;
import de.cas_ual_ty.ydm.duel.action.*;
import de.cas_ual_ty.ydm.duel.network.DuelMessages;
import de.cas_ual_ty.ydm.duel.playfield.*;
import de.cas_ual_ty.ydm.duel.screen.animation.*;
import de.cas_ual_ty.ydm.duel.screen.widget.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraftforge.fml.network.PacketDistributor;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DuelScreenDueling<E extends DuelContainer> extends DuelContainerScreen<E> implements IDuelScreenContext
{
    public static final int CARDS_WIDTH = 24;
    public static final int CARDS_HEIGHT = 32;
    
    protected TextWidget cardStackNameWidget;
    protected ITextComponent nameShown;
    protected ViewCardStackWidget viewCardStackWidget;
    protected Button scrollUpButton;
    protected Button scrollDownButton;
    
    protected ZoneWidget clickedZoneWidget;
    protected DuelCard clickedCard;
    
    protected List<ZoneWidget> zoneWidgets;
    protected List<InteractionWidget> interactionWidgets;
    protected boolean isAdvanced;
    
    protected Button coinFlipButton;
    protected Button diceRollButton;
    protected Button addCounterButton;
    protected Button removeCounterButton;
    protected Button advancedOptionsButton;
    
    protected Button reloadButton;
    protected Button flipViewButton;
    protected Button offerDrawButton;
    protected Button admitDefeatButton;
    protected LPTextFieldWidget lifePointsWidget;
    
    protected ColoredButton prevPhaseButton;
    protected ColoredButton nextPhaseButton;
    protected ColoredTextWidget phaseWidget;
    
    protected ZoneOwner view;
    protected AnimationsWidget animationsWidget;
    
    protected DuelCard cardInfo;
    
    // need to store these seperately
    // to make sure that we keep them
    // in case a player leaves
    protected IFormattableTextComponent player1Name;
    protected IFormattableTextComponent player2Name;
    
    public DuelScreenDueling(E screenContainer, PlayerInventory inv, ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn);
        interactionWidgets = new ArrayList<>(); // Need to temporarily initialize with placeholder this to make sure no clear() call gets NPEd
        isAdvanced = false;
        
        viewCardStackWidget = null;
        nameShown = null;
        clickedZoneWidget = null;
        clickedCard = null;
        
        coinFlipButton = null;
        diceRollButton = null;
        addCounterButton = null;
        removeCounterButton = null;
        advancedOptionsButton = null;
        reloadButton = null;
        flipViewButton = null;
        offerDrawButton = null;
        admitDefeatButton = null;
        lifePointsWidget = null;
        prevPhaseButton = null;
        nextPhaseButton = null;
        phaseWidget = null;
        
        view = getZoneOwner();
        if(view == ZoneOwner.NONE)
        {
            view = ZoneOwner.PLAYER1;
        }
        animationsWidget = null;
        cardInfo = null;
        player1Name = null;
        player2Name = null;
    }
    
    @Override
    public void init(Minecraft minecraft, int width, int height)
    {
        super.init(minecraft, width, height);
        
        ViewCardStackWidget previousViewStack = viewCardStackWidget;
        
        if(animationsWidget != null)
        {
            animationsWidget.forceFinish();
        }
        
        initDefaultChat(width, height);
        
        int x, y;
        
        final int zoneSize = 32;
        final int halfSize = zoneSize / 2;
        final int quarterSize = zoneSize / 4;
        final int zonesMargin = 2;
        
        //middle
        x = (width - zoneSize) / 2;
        y = (height - zoneSize) / 2;
        
        addButton(reloadButton = new TextureButton(x, y, quarterSize, quarterSize, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.reload"), this::middleButtonClicked, this::middleButtonHovered)
                .setTexture(new ResourceLocation(YDM.MOD_ID, "textures/gui/duel_widgets.png"), 64, 0, 16, 16));
        addButton(flipViewButton = new TextureButton(x + quarterSize, y, quarterSize, quarterSize, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.flip_view"), this::middleButtonClicked, this::middleButtonHovered)
                .setTexture(new ResourceLocation(YDM.MOD_ID, "textures/gui/duel_widgets.png"), 80, 0, 16, 16));
        addButton(offerDrawButton = new TextureButton(x + 2 * quarterSize, y, quarterSize, quarterSize, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.offer_draw"), this::middleButtonClicked, this::middleButtonHovered)
                .setTexture(new ResourceLocation(YDM.MOD_ID, "textures/gui/duel_widgets.png"), 96, 0, 16, 16));
        addButton(admitDefeatButton = new TextureButton(x + 3 * quarterSize, y, quarterSize, quarterSize, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.admit_defeat"), this::middleButtonClicked, this::middleButtonHovered)
                .setTexture(new ResourceLocation(YDM.MOD_ID, "textures/gui/duel_widgets.png"), 112, 0, 16, 16));
        
        // lp text field for players, "Spectator" text for spectators
        if(getZoneOwner() != ZoneOwner.NONE)
        {
            addButton(lifePointsWidget = new LPTextFieldWidget(font, x, y + 3 * quarterSize, zoneSize, quarterSize, this::lpTextFieldWidget));
        }
        else
        {
            addButton(new SmallTextWidget(x, y + 3 * quarterSize, zoneSize, quarterSize, () -> new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.spectating")));
        }
        
        if(getZoneOwner() == ZoneOwner.NONE)
        {
            admitDefeatButton.active = false;
            offerDrawButton.active = false;
        }
        
        addButton(new LifePointsWidget(x, y + quarterSize, zoneSize, quarterSize,
                () -> getPlayField().getLifePoints(getView().opponent()), getPlayField().playFieldType.startingLifePoints, this::lpTooltipViewOpponent));
        addButton(new LifePointsWidget(x, y + 2 * quarterSize, zoneSize, quarterSize,
                () -> getPlayField().getLifePoints(getView()), getPlayField().playFieldType.startingLifePoints, this::lpTooltipView));
        
        //left
        x = (width - zoneSize) / 2 - (zoneSize + zonesMargin) * 2;
        
        addButton(coinFlipButton = new TextureButton(x, y, halfSize, halfSize, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.coin_flip"), this::leftButtonClicked, this::leftButtonHovered)
                .setTexture(new ResourceLocation(YDM.MOD_ID, "textures/gui/duel_widgets.png"), 32, 0, 16, 16));
        addButton(diceRollButton = new TextureButton(x + halfSize, y, halfSize, halfSize, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.dice_roll"), this::leftButtonClicked, this::leftButtonHovered)
                .setTexture(new ResourceLocation(YDM.MOD_ID, "textures/gui/duel_widgets.png"), 48, 0, 16, 16));
        addButton(addCounterButton = new TextureButton(x, y + halfSize, halfSize, quarterSize, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.add_counter"), this::leftButtonClicked, this::leftButtonHovered)
                .setTexture(new ResourceLocation(YDM.MOD_ID, "textures/gui/duel_widgets.png"), 128, 0, 16, 8));
        addButton(removeCounterButton = new TextureButton(x, y + halfSize + quarterSize, halfSize, quarterSize, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.remove_counter"), this::leftButtonClicked, this::leftButtonHovered)
                .setTexture(new ResourceLocation(YDM.MOD_ID, "textures/gui/duel_widgets.png"), 128, 8, 16, 8));
        addButton(advancedOptionsButton = new TextureButton(x + halfSize, y + halfSize, halfSize, halfSize, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.advanced_options"), this::leftButtonClicked, this::leftButtonHovered)
                .setTexture(new ResourceLocation(YDM.MOD_ID, "textures/gui/duel_widgets.png"), 144, 0, 16, 16));
        
        if(getZoneOwner() == ZoneOwner.NONE)
        {
            coinFlipButton.active = false;
            diceRollButton.active = false;
            addCounterButton.active = false;
            removeCounterButton.active = false;
            advancedOptionsButton.active = false;
        }
        
        // right
        x = (width - zoneSize) / 2 + (zoneSize + zonesMargin) * 2;
        
        addButton(phaseWidget = new ColoredTextWidget(x, y, zoneSize, halfSize, this::getPhaseShort, this::phaseWidgetHovered));
        phaseWidget.active = false;
        addButton(prevPhaseButton = new ColoredButton(x, y + halfSize, halfSize, halfSize, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.left_arrow"), this::rightButtonClicked, this::rightButtonHovered));
        addButton(nextPhaseButton = new ColoredButton(x + halfSize, y + halfSize, halfSize, halfSize, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.right_arrow"), this::rightButtonClicked, this::rightButtonHovered));
        
        if(getZoneOwner() == ZoneOwner.NONE)
        {
            prevPhaseButton.active = false;
            nextPhaseButton.active = false;
        }
        
        zoneWidgets = new ArrayList<>(getDuelManager().getPlayField().getZones().size());
        interactionWidgets.clear();
        
        ZoneWidget widget;
        
        for(Zone zone : getDuelManager().getPlayField().getZones())
        {
            addButton(widget = createZoneWidgetForZone(zone));
            
            if(getView() == ZoneOwner.PLAYER2)
            {
                widget.setPositionRelativeFlipped(zone.x, zone.y, width, height);
            }
            else
            {
                widget.setPositionRelative(zone.x, zone.y, width, height);
            }
            
            zoneWidgets.add(widget);
        }
        
        zoneWidgets.sort((z1, z2) -> Byte.compare(z1.zone.index, z2.zone.index));
        
        if(animationsWidget != null)
        {
            animationsWidget.onInit();
        }
        addButton(animationsWidget = new AnimationsWidget(0, 0, 0, 0));
        
        // in case we init again, buttons is cleared, thus all interaction widgets are removed
        // just act like we click on the last widget again
        if(clickedZoneWidget != null)
        {
            for(ZoneWidget match : zoneWidgets)
            {
                if(match.zone == clickedZoneWidget.zone)
                {
                    setClickedZoneWidgetAndCard(match, clickedCard);
                    break;
                }
            }
            
            clickedZoneWidget.hoverCard = clickedCard;
            zoneClicked(clickedZoneWidget);
        }
        
        if(previousViewStack != null && previousViewStack.getCards() != null)
        {
            viewCards(previousViewStack.getCards(), nameShown, previousViewStack.getForceFaceUp());
        }
        
        updateScrollButtonStatus();
        updateLeftButtonStatus();
        updateRightButtonStatus();
    }
    
    @Override
    protected void initChat(int width, int height, int x, int y, int w, int h, int chatWidth, int chatHeight, int margin, int buttonHeight)
    {
        super.initChat(width, height, x, y, w, h, chatWidth, chatHeight, margin, buttonHeight);
        
        // 4* -> 3*
        // because we dont have a text box at the bottom
        // so more space for cards
        chatHeight = (h - 3 * (buttonHeight + margin) - 2 * margin);
        
        final int cardsSize = 32;
        final int offset = buttonHeight + margin;
        
        int widgetWidth = Math.max(cardsSize, (chatWidth / cardsSize) * cardsSize);
        int widgetHeight = Math.max(cardsSize, (chatHeight / cardsSize) * cardsSize);
        
        addButton(cardStackNameWidget = new TextWidget(x, y, w, buttonHeight, this::getShownZoneName));
        y += offset;
        
        addButton(scrollUpButton = new Button(x, y, w, buttonHeight, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.up_arrow"), this::scrollButtonClicked, this::scrollButtonHovered));
        y += offset;
        
        int columns = chatWidth / cardsSize;
        int rows = chatHeight / cardsSize;
        addButton(viewCardStackWidget = new ViewCardStackWidget(this, x + (w - widgetWidth) / 2, y + (chatHeight - widgetHeight) / 2, chatWidth, chatHeight, StringTextComponent.EMPTY, this::viewCardStackClicked, this::viewCardStackTooltip)
                .setRowsAndColumns(cardsSize, rows, columns));
        y += chatHeight + margin;
        
        addButton(scrollDownButton = new Button(x, y, w, buttonHeight, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.down_arrow"), this::scrollButtonClicked, this::scrollButtonHovered));
        y += offset;
    }
    
    @Override
    public void tick()
    {
        animationsWidget.tick();
        super.tick();
    }
    
    protected ZoneWidget createZoneWidgetForZone(Zone zone)
    {
        if(zone.getType() == ZoneTypes.MONSTER ||
                zone.getType() == ZoneTypes.EXTRA_MONSTER_RIGHT ||
                zone.getType() == ZoneTypes.EXTRA_MONSTER_LEFT)
        {
            return new MonsterZoneWidget(zone, this, zone.width, zone.height, zone.getType().getLocal(), this::zoneClicked, this::zoneTooltip);
        }
        else if(zone.getType() == ZoneTypes.HAND)
        {
            return new HandZoneWidget(zone, this, zone.width, zone.height, zone.getType().getLocal(), this::zoneClicked, this::zoneTooltip);
        }
        else if(zone.getType() == ZoneTypes.EXTRA_DECK ||
                zone.getType() == ZoneTypes.GRAVEYARD ||
                zone.getType() == ZoneTypes.BANISHED ||
                zone.getType() == ZoneTypes.EXTRA)
        {
            return new NonSecretStackZoneWidget(zone, this, zone.width, zone.height, zone.getType().getLocal(), this::zoneClicked, this::zoneTooltip);
        }
        else if(zone.getType() == ZoneTypes.DECK)
        {
            return new StackZoneWidget(zone, this, zone.width, zone.height, zone.getType().getLocal(), this::zoneClicked, this::zoneTooltip);
        }
        else
        {
            return new ZoneWidget(zone, this, zone.width, zone.height, zone.getType().getLocal(), this::zoneClicked, this::zoneTooltip);
        }
    }
    
    @Override
    protected void renderBg(MatrixStack ms, float partialTicks, int mouseX, int mouseY)
    {
        super.renderBg(ms, partialTicks, mouseX, mouseY);
        
        ScreenUtil.white();
        minecraft.getTextureManager().bind(DuelContainerScreen.DUEL_BACKGROUND_GUI_TEXTURE);
        blit(ms, leftPos, topPos, 0, 0, imageWidth, imageHeight);
        minecraft.getTextureManager().bind(DuelContainerScreen.DUEL_FOREGROUND_GUI_TEXTURE);
        blit(ms, leftPos, topPos, 0, 0, imageWidth, imageHeight);
        
        if(cardInfo != null)
        {
            CardRenderUtil.renderCardInfo(ms, cardInfo.getCardHolder(), cardInfo.getIsToken(), (width - imageWidth) / 2);
        }
    }
    
    @Override
    protected void renderLabels(MatrixStack ms, int x, int y)
    {
    }
    
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        forceFinishAnimations(mouseX, mouseY);
        
        if(lifePointsWidget != null && lifePointsWidget.isFocused() && !lifePointsWidget.isMouseOver(mouseX, mouseY))
        {
            lifePointsWidget.setFocus(false);
        }
        
        if(button == GLFW.GLFW_MOUSE_BUTTON_2)
        {
            resetToNormalZoneWidgets();
        }
        
        return super.mouseClicked(mouseX, mouseY, button);
    }
    
    @Override
    public void handleAction(Action action)
    {
        action.initClient(getDuelManager().getPlayField());
        getDuelManager().actions.add(action);
        
        // all actions must return an animation
        // otherwise, their order might be disrupted
        // eg Action1 still in animation, then Action2 (without animation) gets done before Action1 finishes
        // so, by default a dummy animation is returned, doing nothing, lasting 1 tick, just doing the Action
        Animation animation = getAnimationForAction(action);
        playAnimation(animation);
    }
    
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers)
    {
        if(lifePointsWidget != null && lifePointsWidget.isFocused())
        {
            if(keyCode == GLFW.GLFW_KEY_ENTER)
            {
                parseAndSendLPChange();
                return true;
            }
            else
            {
                return lifePointsWidget.keyPressed(keyCode, scanCode, modifiers);
            }
        }
        else
        {
            return super.keyPressed(keyCode, scanCode, modifiers);
        }
    }
    
    public void flip()
    {
        view = view.opponent();
        
        /*//re-init anyways, this is not needed
        for(ZoneWidget w : this.zoneWidgets)
        {
            w.flip(this.width, this.height);
        }
        */
        
        reInit();
    }
    
    public void reload()
    {
        getMenu().requestFullUpdate();
    }
    
    public void resetToNormalZoneWidgets()
    {
        removeClickedZone();
        removeInteractionWidgets();
        
        for(ZoneWidget w : zoneWidgets)
        {
            w.active = true;
        }
        
        makeChatVisible();
        isAdvanced = false;
    }
    
    protected void viewZone(ZoneWidget w, boolean forceFaceUp)
    {
        IFormattableTextComponent t = new StringTextComponent("").append(w.getMessage());
        
        if(w.zone.getCardsAmount() > 0)
        {
            t.append(" (" + w.zone.getCardsAmount() + ")");
        }
        
        viewCards(w.zone.getCardsList(), t, forceFaceUp);
    }
    
    protected void viewCards(List<DuelCard> cards, ITextComponent name, boolean forceFaceUp)
    {
        viewCardStackWidget.activate(cards, forceFaceUp);
        nameShown = name;
        
        updateScrollButtonStatus();
        makeChatInvisible();
    }
    
    protected void updateScrollButtonStatus()
    {
        scrollUpButton.active = false;
        scrollUpButton.visible = false;
        scrollDownButton.active = false;
        scrollDownButton.visible = false;
        cardStackNameWidget.visible = false;
        
        if(viewCardStackWidget.active)
        {
            scrollUpButton.visible = true;
            scrollDownButton.visible = true;
            cardStackNameWidget.visible = true;
            
            if(viewCardStackWidget.getCurrentRow() > 0)
            {
                scrollUpButton.active = true;
            }
            
            if(viewCardStackWidget.getCurrentRow() < viewCardStackWidget.getMaxRows())
            {
                scrollDownButton.active = true;
            }
        }
    }
    
    protected void updateLeftButtonStatus()
    {
        if(clickedZoneWidget != null &&
                clickedZoneWidget.zone.getType().getCanHaveCounters() &&
                clickedZoneWidget.zone.getCardsAmount() > 0 &&
                clickedZoneWidget.zone.getOwner() == getZoneOwner())
        {
            addCounterButton.active = true;
            removeCounterButton.active = true;
        }
        else
        {
            addCounterButton.active = false;
            removeCounterButton.active = false;
        }
        
        if(clickedZoneWidget != null)
        {
            advancedOptionsButton.active = true;
        }
        else
        {
            advancedOptionsButton.active = false;
        }
    }
    
    protected void updateRightButtonStatus()
    {
        boolean isTurn;
        
        if(getZoneOwner() == ZoneOwner.NONE)
        {
            isTurn = getPlayField().isPlayerTurn(ZoneOwner.PLAYER1);
        }
        else
        {
            isTurn = getPlayField().isPlayerTurn(getZoneOwner());
        }
        
        if(isTurn)
        {
            phaseWidget.setBlue();
            prevPhaseButton.setBlue();
            nextPhaseButton.setBlue();
        }
        else
        {
            phaseWidget.setRed();
            prevPhaseButton.setRed();
            nextPhaseButton.setRed();
        }
        
        isTurn = getZoneOwner() != ZoneOwner.NONE && getPlayField().isPlayerTurn(getZoneOwner());
        
        if(isTurn)
        {
            prevPhaseButton.active = !getPlayField().getPhase().isFirst();
            nextPhaseButton.active = true;
            // next phase button is always active
            // if last phase: we end turn
        }
        else
        {
            prevPhaseButton.active = false;
            nextPhaseButton.active = false;
        }
    }
    
    protected ZoneWidget getZoneWidget(Zone zone)
    {
        return zoneWidgets.get(zone.index);
    }
    
    protected void playAnimation(Animation a)
    {
        if(a != null)
        {
            animationsWidget.addAnimation(a);
        }
    }
    
    //TODO: Probably should find a way better way of doing some of these animations and sounds. There is a lot of what I assume is really bad code from me lol
    @Nullable
    public Animation getAnimationForAction(Action action0)
    {
        if(action0 instanceof MoveAction)
        {
            MoveAction action = (MoveAction) action0;
            
            CardPosition sourcePosition = action.sourceCardPosition;
            
            if(!sourcePosition.isFaceUp && action.sourceZone.getOwner() == getZoneOwner() && action.sourceZone.type.getShowFaceDownCardsToOwner())
            {
                sourcePosition = sourcePosition.flip();
            }
            
            CardPosition destinationPosition = action.destinationCardPosition;
            
            if(!destinationPosition.isFaceUp && action.destinationZone.getOwner() == getZoneOwner() && action.destinationZone.type.getShowFaceDownCardsToOwner())
            {
                destinationPosition = destinationPosition.flip();
            }
            
            ZoneWidget dZ = getZoneWidget(action.destinationZone);
            ZoneWidget sZ = getZoneWidget(action.sourceZone);
            int dSize = Math.max(dZ.getWidth(), dZ.getHeight());
            int sSize = Math.max(sZ.getWidth(), sZ.getHeight());
            Animation moveAnimation = new MoveAnimation(
                    getView(),
                    action.card,
                    getZoneWidget(action.sourceZone),
                    getZoneWidget(action.destinationZone),
                    sourcePosition,
                    destinationPosition)
                    .setOnStart(action::removeCardFromZone)
                    .setOnEnd(() ->
                    {
                        action.addCard();
                        action.finish();
                        repopulateInteractions();
                    });
            Animation atkPosAnimation = new AttackPositionAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize / 2);
            Animation defPosAnimation = new DefensePositionAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize / 2);
            Animation gyOutAnimation = new ExitGraveyardAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize / 2);
            Animation gyInAnimation = new EnterGraveyardAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize + dSize / 2, dSize);
            Animation banishOutAnimation = new ExitBanishmentAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize / 2);
            Animation banishInAnimation = new EnterBanishmentAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize + dSize / 2, dSize);
            Animation normalSummonAnimation = new NormalSummonAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize / 2);
            Animation normalSummonMidAnimation = new NormalSummonMiddleAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize);
            Animation normalSummonHeavyAnimation = new NormalSummonHeavyAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize * 2);
            Animation normalSetAnimation = new SetMonsterAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize / 2);
            Animation setBackrowAnimation = new SetSpellTrapAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize / 2);
            Animation specialSetAnimation = new SpecialSetMonsterAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize / 2);
            
            Queue<Animation> queue = new LinkedList<>();
            
            Properties card = action.card.getCardHolder().getCard();
            
            // Exit GY
            if(action.sourceZone.type == ZoneTypes.GRAVEYARD && !(action.actionType == ActionTypes.SPECIAL_SUMMON_OVERLAY)) 
            {
            	queue.add(gyOutAnimation);
            }
            
            // Exit Banishment
            if(action.sourceZone.type == ZoneTypes.BANISHED && !(action.actionType == ActionTypes.SPECIAL_SUMMON_OVERLAY)) 
            {
            	queue.add(banishOutAnimation);
            }
            
            if(action.actionType == ActionTypes.SPECIAL_SUMMON)
            {
                Animation specialSummonRingAnimation = new SpecialSummonAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize / 2);
                Animation specialSummonRingMidAnimation = new SpecialSummonAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize);
                Animation specialSummonRingHeavyAnimation = new SpecialSummonAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize * 2);
                //Animation fusionSummonAnimation = new SpecialSummonFusionAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), size, size + size / 2);
                //Animation fusionMidSummonAnimation = new SpecialSummonFusionAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), size, size + size);
                //Animation fusionHighSummonAnimation = new SpecialSummonFusionAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), size, size + size * 2);
                //Animation ritualSummonAnimation = new SpecialSummonRitualAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), size, size + size / 2);
                //Animation ritualMidSummonAnimation = new SpecialSummonRitualAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), size, size + size);
                //Animation ritualHighSummonAnimation = new SpecialSummonRitualAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), size, size + size * 2);
                //Animation synchroSummonAnimation = new SpecialSummonSynchroAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), size, size + size / 2);
                //Animation synchroMidSummonAnimation = new SpecialSummonSynchroAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), size, size + size);
                //Animation synchroHighSummonAnimation = new SpecialSummonSynchroAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), size, size + size * 2);
                Animation xyzRingAnimation = new SpecialSummonOverlayAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize / 2);
                Animation xyzRingMidAnimation = new SpecialSummonOverlayAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize);
                Animation xyzRingHeavyAnimation = new SpecialSummonOverlayAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize * 2);
                //Animation pendulumSummonAnimation = new SpecialSummonPendulumAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), size, size + size / 2);
                //Animation pendulumMidSummonAnimation = new SpecialSummonPendulumAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), size, size + size);
                //Animation pendulumHighSummonAnimation = new SpecialSummonPendulumAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), size, size + size * 2);
                Animation linkSummonAnimation = new SpecialSummonLinkAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize / 2);
                Animation linkMidSummonAnimation = new SpecialSummonLinkAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize);
                Animation linkHighSummonAnimation = new SpecialSummonLinkAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize * 2);
                
                queue.add(moveAnimation);
                
                if(card instanceof MonsterProperties && destinationPosition.isFaceUp) 
                {
                	boolean isMidWeight;
            		boolean isHeavyWeight;
            		isMidWeight = ((MonsterProperties) card).getAtk() >= 2000;
            		isHeavyWeight = ((MonsterProperties) card).getAtk() >= 2500;
            		
            		if(card instanceof DefMonsterProperties) 
            		{
            			if((((DefMonsterProperties) card).getAtk() < ((DefMonsterProperties)card).getDef())) 
            			{
            				isMidWeight = ((DefMonsterProperties) card).getDef() >= 2000;
                    		isHeavyWeight = ((DefMonsterProperties) card).getDef() >= 2500;
            			}
            			else 
            			{
            				isMidWeight = ((DefMonsterProperties) card).getAtk() >= 2000;
                    		isHeavyWeight = ((DefMonsterProperties) card).getAtk() >= 2500;
            			}
            		}
            		
                	if(card instanceof LevelMonsterProperties) 
                	{
                    	if(isMidWeight && !isHeavyWeight) 
                        {
                    		queue.add(specialSummonRingMidAnimation);
                    		
                        }
                    	else if(isHeavyWeight) 
                    	{
                    		queue.add(specialSummonRingHeavyAnimation);
                    	}
                    	else 
                    	{
                    		queue.add(specialSummonRingAnimation);
                    		
                    	}
                	}
                	else if(card instanceof XyzMonsterProperties) 
                	{
                		if(isMidWeight && !isHeavyWeight) 
                        {
                    		queue.add(xyzRingMidAnimation);
                        }
                		else if(isHeavyWeight) 
                        {
                			queue.add(xyzRingHeavyAnimation);
                        }
                    	else 
                    	{
                    		queue.add(xyzRingAnimation);
                    	}
                	}
                	else if(card instanceof LinkMonsterProperties) 
                	{
                		if(isMidWeight && !isHeavyWeight) 
                        {
                    		queue.add(linkMidSummonAnimation);
                        }
                		else if(isHeavyWeight) 
                        {
                			queue.add(linkHighSummonAnimation);
                        }
                    	else 
                    	{
                    		queue.add(linkSummonAnimation);
                    	}
                	}
                }
                else 
                {
                	if(destinationPosition == CardPosition.SET) 
                    {
                    	queue.add(specialSetAnimation);
                    }
                    else 
                    {
                    	queue.add(specialSummonRingAnimation);
                    }
                }
                
                if(destinationPosition == CardPosition.ATK) 
                {
                	queue.add(atkPosAnimation);
                }
                
                if(destinationPosition == CardPosition.DEF) 
                {
                	queue.add(defPosAnimation);
                }
                
                return new QueueAnimation(queue);
            }
            
            // Normal Summon
            if(action.actionType == ActionTypes.NORMAL_SUMMON) 
            {
            	Animation tributeRingAnimation = new TributeSummonAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize / 2);
            	Animation tributeRingMidAnimation = new TributeSummonAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize * 2);
                Animation tributeRingHeavyAnimation = new TributeSummonHeavyAnimation(dZ.getAnimationDestX(), dZ.getAnimationDestY(), dSize, dSize + dSize * 2);
                
            	queue.add(moveAnimation);
            	
            	if(card instanceof MonsterProperties) 
            	{
            		boolean isMidWeight;
            		boolean isHeavyWeight;
            		isMidWeight = ((MonsterProperties) card).getAtk() >= 2000;
            		isHeavyWeight = ((MonsterProperties) card).getAtk() >= 2500;
            		
            		if(card instanceof DefMonsterProperties) 
            		{
            			if((((DefMonsterProperties) card).getAtk() < ((DefMonsterProperties)card).getDef())) 
            			{
            				isMidWeight = ((DefMonsterProperties) card).getDef() >= 2000;
                    		isHeavyWeight = ((DefMonsterProperties) card).getDef() >= 2500;
            			}
            			else 
            			{
            				isMidWeight = ((DefMonsterProperties) card).getAtk() >= 2000;
                    		isHeavyWeight = ((DefMonsterProperties) card).getAtk() >= 2500;
            			}
            		}
                	
            		if(card instanceof LevelMonsterProperties) 
                    {
                		boolean isTributeSummon;
                    	isTributeSummon = ((LevelMonsterProperties) card).getLevel() >= 5;
                    	if(isTributeSummon) 
                        {
                    		if(isMidWeight && !isHeavyWeight) 
                            {
                        		queue.add(tributeRingMidAnimation);
                            }
                        	else if(isHeavyWeight) 
                        	{
                        		queue.add(tributeRingHeavyAnimation);
                        	}
                        	else 
                        	{
                        		queue.add(tributeRingAnimation);
                        	}
                        }
                    	else 
                    	{
                    		if(isMidWeight && !isHeavyWeight) 
                            {
                        		queue.add(normalSummonMidAnimation);
                            }
                        	else if(isHeavyWeight) 
                        	{
                        		queue.add(normalSummonHeavyAnimation);
                        	}
                        	else 
                        	{
                        		queue.add(normalSummonAnimation);
                        	}
                    	}
                    }
            	}
            	else 
            	{
            		queue.add(normalSummonAnimation);
            	}
            	
            	if(destinationPosition == CardPosition.ATK) 
                {
                	queue.add(atkPosAnimation);
                }
            	if(destinationPosition == CardPosition.DEF) 
                {
                	queue.add(defPosAnimation);
                }
            	
            	return new QueueAnimation(queue);
            }
            
            if(action.actionType == ActionTypes.SET) 
            {
            	queue.add(moveAnimation);
            	queue.add(normalSetAnimation);
            	return new QueueAnimation(queue);
            }
            
            //if(action.actionType == ActionTypes.DESTROY)
            
            // Enter GY
            if(action.destinationZone.type == ZoneTypes.GRAVEYARD) 
            {
            	queue.add(moveAnimation);
            	queue.add(gyInAnimation);
            	return new QueueAnimation(queue);
            }
            
            // Enter Banishment
            if(action.destinationZone.type == ZoneTypes.BANISHED) 
            {
            	queue.add(moveAnimation);
            	queue.add(banishInAnimation);
            	return new QueueAnimation(queue);
            }
            
            //set spell/trap
            if(action.destinationZone.type == ZoneTypes.SPELL_TRAP || action.destinationZone.type == ZoneTypes.FIELD_SPELL) 
            {
            	queue.add(moveAnimation);
            	if(destinationPosition == CardPosition.FD) 
                {
            		queue.add(setBackrowAnimation);
                }
            	return new QueueAnimation(queue);
            }
            
            //draw card
            if(action.destinationZone.type == ZoneTypes.HAND && action.sourceZone.type == ZoneTypes.DECK) 
            {
            	//queue.add(drawCardSFX); TODO: Draw Sound Effect Animation
            	queue.add(moveAnimation);
            	return new QueueAnimation(queue);
            }
            
            else
            {
            	return moveAnimation;
            }
        }
        else if(action0 instanceof ChangePositionAction)
        {
            ChangePositionAction action = (ChangePositionAction) action0;
            ZoneOwner owner = action.sourceZone.getOwner();
            ZoneWidget w = getZoneWidget(action.sourceZone);
            int size = Math.max(w.getWidth(), w.getHeight());
            Animation moveAnimation = new MoveAnimation(
                    getView(),
                    action.card,
                    getZoneWidget(action.sourceZone),
                    getZoneWidget(action.sourceZone),
                    action.sourceCardPosition,
                    action.destinationCardPosition)
                    .setOnStart(() ->
                    {
                        action.sourceZone.removeCardKeepCounters(action.sourceCardIndex);
                    })
                    .setOnEnd(() ->
                    {
                        action.sourceZone.addCard(owner, action.card, action.sourceCardIndex);
                        action.sourceZone.getCard(action.sourceCardIndex).setPosition(action.destinationCardPosition);
                        repopulateInteractions();
                    });
            Animation atkPosAnimation = new AttackPositionAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2);
            Animation defPosAnimation = new DefensePositionAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2);
            
            boolean isInMonsterZone = (action.sourceZone.getType() == ZoneTypes.MONSTER || action.sourceZone.getType() == ZoneTypes.EXTRA_MONSTER_LEFT || action.sourceZone.getType() == ZoneTypes.EXTRA_MONSTER_RIGHT);
            
            if(isInMonsterZone && action.actionType == ActionTypes.CHANGE_POSITION)
            {
            	Queue<Animation> queue = new LinkedList<>();
            	// From ATK to DEF
            	if(action.sourceCardPosition == CardPosition.ATK && action.destinationCardPosition == CardPosition.DEF) 
                {
                    queue.add(moveAnimation);
                	queue.add(defPosAnimation);
                    return new QueueAnimation(queue);
                    
                }
            	// From DEF to ATK
                if(action.sourceCardPosition == CardPosition.DEF && action.destinationCardPosition == CardPosition.ATK) 
                {
                	queue.add(moveAnimation);
                	queue.add(atkPosAnimation);
                	return new QueueAnimation(queue);
                }
                // From Set to ATK/DEF
                if(action.sourceCardPosition == CardPosition.SET) 
                {
                	queue.add(moveAnimation);
                	if(action.destinationCardPosition == CardPosition.ATK) 
                	{
                		queue.add(atkPosAnimation);
                	}
                	if(action.destinationCardPosition == CardPosition.DEF) 
                	{
                		queue.add(defPosAnimation);
                	}
                	return new QueueAnimation(queue);
                }
                else 
                {
                	return moveAnimation;
                }
            }
            else if(action.card == action.sourceZone.getTopCardSafely() && action.actionType != ActionTypes.CHANGE_POSITION) 
            {
            	return moveAnimation;
            }
            else 
            {
            	return moveAnimation;
            }
        }
        else if(action0 instanceof ListAction)
        {
            ListAction action = (ListAction) action0;
            
            if(!action.actions.isEmpty())
            {
                List<Animation> animations = new ArrayList<>(action.actions.size());
                
                Animation animation;
                for(Action a : action.actions)
                {
                    animation = getAnimationForAction(a);
                    
                    if(animation != null)
                    {
                        animations.add(animation);
                    }
                }
                
                ParallelListAnimation listAnimation = new ParallelListAnimation(animations);
                
                if(action.actionType == ActionTypes.SPECIAL_SUMMON_OVERLAY)
                {
                    Queue<Animation> queue = new LinkedList<>();
                    queue.add(listAnimation);
                    
                    MoveTopAction moveAction = (MoveTopAction) action.actions.get(action.actions.size() - 1);
                    
                    ZoneWidget w = getZoneWidget(moveAction.destinationZone);
                    
                    int size = Math.max(w.getWidth(), w.getHeight());
                    Animation atkPosAnimation = new AttackPositionAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2);
                    Animation defPosAnimation = new DefensePositionAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2);
                    
                    queue.add(new SpecialSummonOverlayAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2));
                    
                    if(moveAction.destinationCardPosition == CardPosition.ATK) 
                    {
                    	queue.add(atkPosAnimation);
                    }
                	if(moveAction.destinationCardPosition == CardPosition.DEF) 
                    {
                    	queue.add(defPosAnimation);
                    }
                    
                    return new QueueAnimation(queue);
                }
                else if(action.actionType == ActionTypes.OVERLAY)
                {
                    Queue<Animation> queue = new LinkedList<>();
                    queue.add(listAnimation);
                    
                    MoveTopAction moveAction = (MoveTopAction) action.actions.get(action.actions.size() - 1);
                    
                    ZoneWidget w = getZoneWidget(moveAction.destinationZone);
                    
                    int size = Math.max(w.getWidth(), w.getHeight());
                    Animation atkPosAnimation = new AttackPositionAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2);
                    Animation defPosAnimation = new DefensePositionAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2);
                    
                    queue.add(new SpecialSummonOverlayAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2));
                    
                    if(moveAction.destinationCardPosition == CardPosition.ATK) 
                    {
                    	queue.add(atkPosAnimation);
                    }
                	if(moveAction.destinationCardPosition == CardPosition.DEF) 
                    {
                    	queue.add(defPosAnimation);
                    }
                    
                    return new QueueAnimation(queue);
                }
                else
                {
                    return listAnimation;
                }
            }
        }
        else if(action0 instanceof AttackAction)
        {
        	//TODO: Clean this mess up somehow
            AttackAction action = (AttackAction) action0;
            
            Animation burnSFX = new DummyAnimation().setOnStart(() ->{ Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.BURN_DAMAGE.get(), 1.0F, 0.25F)); });
            Animation attackAnimation = new AttackAnimation(getView(), getZoneWidget(action.sourceZone), getZoneWidget(action.attackedZone));
            ZoneWidget aZ = getZoneWidget(action.attackedZone);
            ZoneWidget sZ = getZoneWidget(action.sourceZone);
            int aSize = Math.max(aZ.getWidth(), aZ.getHeight());
            int sSize = Math.max(sZ.getWidth(), sZ.getHeight());
            Animation darkWindupAnimation = new WindUpDarkAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize / 2).setOnStart(() ->{ Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_DARK.get(), 1.0F, 0.25F)); });
            Animation darkMidWindupAnimation = new WindUpDarkAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize).setOnStart(() ->{ Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_DARK_HIGH.get(), 1.0F, 0.25F)); });
            Animation darkStrongWindupAnimation = new WindUpDarkAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize * 2).setOnStart(() ->{ Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_DARK_HIGH.get(), 1.0F, 0.25F)); });
            Animation divineWindupAnimation = new WindUpDivineAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_DIVINE.get(), 1.0F, 0.25F)); });
            Animation divineStrongWindupAnimation = new WindUpDivineAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_DIVINE_HIGH.get(), 1.0F, 0.25F)); });
            Animation earthWindupAnimation = new WindUpEarthAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_EARTH.get(), 1.0F, 0.25F)); });
            Animation earthStrongWindupAnimation = new WindUpEarthAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_EARTH_HIGH.get(), 1.0F, 0.25F)); });
            Animation fireWindupAnimation = new WindUpFireAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_FIRE.get(), 1.0F, 0.25F)); });
            Animation fireStrongWindupAnimation = new WindUpFireAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_FIRE_HIGH.get(), 1.0F, 0.25F)); });
            Animation lightWindupAnimation = new WindUpLightAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_LIGHT.get(), 1.0F, 0.25F)); });
            Animation lightStrongWindupAnimation = new WindUpLightAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_LIGHT_HIGH.get(), 1.0F, 0.25F)); });
            Animation waterWindupAnimation = new WindUpWaterAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_WATER.get(), 1.0F, 0.25F)); });
            Animation waterStrongWindupAnimation = new WindUpWaterAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_WATER_HIGH.get(), 1.0F, 0.25F)); });
            Animation windWindupAnimation = new WindUpWindAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_WIND.get(), 1.0F, 0.25F)); });
            Animation windStrongWindupAnimation = new WindUpWindAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_WIND_HIGH.get(), 1.0F, 0.25F)); });
            Animation defaultWindupAnimation = new WindUpDefaultAnimation(sZ.getAnimationDestX(), sZ.getAnimationDestY(), sSize, sSize + sSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.ATTACK_FIRE.get(), 1.0F, 0.25F)); });;
            Animation textDirectAttackAnimation = new TextAnimation((new StringTextComponent("DIRECT ATTACK").setStyle(Style.EMPTY.applyFormat(TextFormatting.BOLD))), sZ.getAnimationDestX(), sZ.getAnimationDestY())
            .setOnStart(() -> 
            { 
            	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.DIRECT_ATTACK_DECLARE.get(), 1.0F, 0.25F)); 
            });
            Animation directImpactAnimation = new DamagePlayerAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize / 4, aSize / 2);
            Animation directImpactMidAnimation = new DamagePlayerAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize / 4, aSize);
            Animation directImpactHeavyAnimation = new DamagePlayerAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize / 4, aSize + aSize / 2);
            Animation directImpactDummySFX = new DummyAnimation();
            Animation darkImpactAnimation = new ImpactDarkAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize / 2, aSize + aSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_DARK.get(), 1.0F, 0.25F)); });
            Animation darkMidImpactAnimation = new ImpactDarkAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize / 2, aSize + aSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_DARK_HIGH.get(), 1.0F, 0.25F)); });
            Animation darkStrongImpactAnimation = new ImpactDarkAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize / 2, aSize + aSize * 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_DARK_HIGH.get(), 1.0F, 0.25F)); });
            Animation divineImpactAnimation = new ImpactDivineAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_DIVINE.get(), 1.0F, 0.25F)); });
            Animation divineStrongImpactAnimation = new ImpactDivineAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_DIVINE_HIGH.get(), 1.0F, 0.25F)); });
            Animation earthImpactAnimation = new ImpactEarthAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_EARTH.get(), 1.0F, 0.25F)); });
            Animation earthStrongImpactAnimation = new ImpactEarthAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_EARTH_HIGH.get(), 1.0F, 0.25F)); });
            Animation fireImpactAnimation = new ImpactFireAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_FIRE.get(), 1.0F, 0.25F)); });
            Animation fireStrongImpactAnimation = new ImpactFireAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_FIRE_HIGH.get(), 1.0F, 0.25F)); });
            Animation lightImpactAnimation = new ImpactLightAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_LIGHT.get(), 1.0F, 0.25F)); });
            Animation lightStrongImpactAnimation = new ImpactLightAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_LIGHT_HIGH.get(), 1.0F, 0.25F)); });
            Animation waterImpactAnimation = new ImpactWaterAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_WATER.get(), 1.0F, 0.25F)); });
            Animation waterStrongImpactAnimation = new ImpactWaterAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_WATER_HIGH.get(), 1.0F, 0.25F)); });
            Animation windImpactAnimation = new ImpactWindAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_WIND.get(), 1.0F, 0.25F)); });
            Animation windStrongImpactAnimation = new ImpactWindAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_WIND_HIGH.get(), 1.0F, 0.25F)); });
            Animation defaultImpactAnimation = new ImpactDefaultAnimation(aZ.getAnimationDestX(), aZ.getAnimationDestY(), aSize, aSize + aSize / 2).setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.IMPACT_FIRE.get(), 1.0F, 0.25F)); });
            Queue<Animation> queue = new LinkedList<>();
            
            Properties card = action.sourceZone.getTopCardSafely().cardHolder.card;
            CardPosition cardPosition = action.sourceZone.getTopCardSafely().getCardPosition();
            boolean isFaceUpCard = action.sourceZone.getTopCardSafely().getCardPosition().isFaceUp;
            
            //Wind-up animation
            if(!card.getAttribute().isEmpty() && card.getAttribute() != null && isFaceUpCard) 
        	{
            	boolean isMidAttack;
            	boolean isStrongAttack;
            	isMidAttack = false;
            	isStrongAttack = false;
            	
            	if(card instanceof MonsterProperties) 
            	{
            		if(card instanceof DefMonsterProperties && cardPosition == CardPosition.DEF) 
            		{
            			isMidAttack = ((DefMonsterProperties) card).getDef() >= 2000;
            			isStrongAttack = ((DefMonsterProperties) card).getDef() >= 2500;
            		}
            		else if(cardPosition == CardPosition.ATK) 
            		{
            			isMidAttack = ((MonsterProperties) card).getAtk() >= 2000;
            			isStrongAttack = ((MonsterProperties) card).getAtk() >= 2500;
            		}
            		else 
            		{
            			isMidAttack = ((MonsterProperties) card).getAtk() >= 2000;
            			isStrongAttack = ((MonsterProperties) card).getAtk() >= 2500;
            		}
            	}
            	
            	if(action.actionType == ActionTypes.ATTACK_DIRECT) 
            	{
            		queue.add(textDirectAttackAnimation);
            	}
            	
            	if(card.getAttribute().equals("DARK")) 
            	{
            		if(isMidAttack && !isStrongAttack) 
            		{
            			queue.add(darkMidWindupAnimation);
            		}
            		else if(isStrongAttack) 
            		{
            			queue.add(darkStrongWindupAnimation);
            		}
            		else 
            		{
            			queue.add(darkWindupAnimation);
            		}
            	}
            	else if(card.getAttribute().equals("DIVINE")) 
            	{
            		if(card instanceof MonsterProperties && (((MonsterProperties) card).getAtk() >= 2500)) 
            		{
            			queue.add(divineStrongWindupAnimation);
            		}
            		else 
            		{
            			queue.add(divineWindupAnimation);
            		}
            	}
                else if(card.getAttribute().equals("EARTH")) 
            	{
                	if(card instanceof MonsterProperties && (((MonsterProperties) card).getAtk() >= 2500)) 
            		{
            			queue.add(earthStrongWindupAnimation);
            		}
            		else 
            		{
            			queue.add(earthWindupAnimation);
            		}
            	}
                else if(card.getAttribute().equals("FIRE")) 
            	{
                	if(card instanceof MonsterProperties && (((MonsterProperties) card).getAtk() >= 2500)) 
            		{
            			queue.add(fireStrongWindupAnimation);
            		}
            		else 
            		{
            			queue.add(fireWindupAnimation);
            		}
            	}
                else if(card.getAttribute().equals("LIGHT")) 
            	{
                	if(card instanceof MonsterProperties && (((MonsterProperties) card).getAtk() >= 2500)) 
            		{
            			queue.add(lightStrongWindupAnimation);
            		}
            		else 
            		{
            			queue.add(lightWindupAnimation);
            		}
            	}
                else if(card.getAttribute().equals("WATER")) 
            	{
                	if(card instanceof MonsterProperties && (((MonsterProperties) card).getAtk() >= 2500)) 
            		{
            			queue.add(waterStrongWindupAnimation);
            		}
            		else 
            		{
            			queue.add(waterWindupAnimation);
            		}
            	}
                else if(card.getAttribute().equals("WIND")) 
            	{
                	if(card instanceof MonsterProperties && (((MonsterProperties) card).getAtk() >= 2500)) 
            		{
            			queue.add(windStrongWindupAnimation);
            		}
            		else 
            		{
            			queue.add(windWindupAnimation);
            		}
            	}
                else
            	{
                	if(action.actionType == ActionTypes.ATTACK_DIRECT) 
                	{
                		queue.add(textDirectAttackAnimation);
                	}
            		queue.add(defaultWindupAnimation);
            	}
        	}
            
            // Burn
            if(action.actionType == ActionTypes.BURN) 
            {
            	queue.add(attackAnimation);
            	queue.add(burnSFX);
            	queue.add(directImpactAnimation);
            }
            
            //Direct Attack animation
            if(action.actionType == ActionTypes.ATTACK_DIRECT) 
            {
            	//Attack Line animation
                queue.add(attackAnimation);
            	
            	if(action.attackedZone.getOwner() == getZoneOwner())
                {
            		directImpactDummySFX.setOnStart(() ->
                    {
                    	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.DIRECT_ATTACK_PLAYER1.get(), 1.0F, 0.25F));
                    });;
                }
                else
                {
                	directImpactDummySFX.setOnStart(() ->
                    {
                    	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.DIRECT_ATTACK_PLAYER2.get(), 1.0F, 0.25F));
                    });;
                }
            	
            	queue.add(directImpactDummySFX);
            	
            	if(card instanceof MonsterProperties && isFaceUpCard) 
            	{
            		boolean isMidAttack;
                	boolean isStrongAttack;
                	isMidAttack = false;
                	isStrongAttack = false;
                	
                	if(card instanceof MonsterProperties) 
                	{
                		if(card instanceof DefMonsterProperties && cardPosition == CardPosition.DEF) 
                		{
                			isMidAttack = ((DefMonsterProperties) card).getDef() >= 2000;
                			isStrongAttack = ((DefMonsterProperties) card).getDef() >= 2500;
                		}
                		else if(cardPosition == CardPosition.ATK) 
                		{
                			isMidAttack = ((MonsterProperties) card).getAtk() >= 2000;
                			isStrongAttack = ((MonsterProperties) card).getAtk() >= 2500;
                		}
                		else 
                		{
                			isMidAttack = ((MonsterProperties) card).getAtk() >= 2000;
                			isStrongAttack = ((MonsterProperties) card).getAtk() >= 2500;
                		}
                	}
                	
            		if(isMidAttack && !isStrongAttack) 
            		{
            			queue.add(directImpactHeavyAnimation);
            		}
            		else if(isMidAttack) 
            		{
            			queue.add(directImpactMidAnimation);
            		}
            		else 
            		{
            			queue.add(directImpactAnimation);
            		}
            	}
            	else 
            	{
            		queue.add(directImpactAnimation);
            	}
            	
            }
            
            // Regular attack
            if(!(action.actionType == ActionTypes.ATTACK_DIRECT) && !(action.actionType == ActionTypes.BURN)) 
            {
                //Attack Line animation
                queue.add(attackAnimation);
                
                if(!card.getAttribute().isEmpty() && card.getAttribute() != null && isFaceUpCard) 
                {
                	boolean isMidAttack;
                	boolean isStrongAttack;
                	isMidAttack = false;
                	isStrongAttack = false;
                	
                	if(card instanceof MonsterProperties) 
                	{
                		if(card instanceof DefMonsterProperties && cardPosition == CardPosition.DEF) 
                		{
                			isMidAttack = ((DefMonsterProperties) card).getDef() >= 2000;
                			isStrongAttack = ((DefMonsterProperties) card).getDef() >= 2500;
                		}
                		else if(cardPosition == CardPosition.ATK) 
                		{
                			isMidAttack = ((MonsterProperties) card).getAtk() >= 2000;
                			isStrongAttack = ((MonsterProperties) card).getAtk() >= 2500;
                		}
                		else 
                		{
                			isMidAttack = ((MonsterProperties) card).getAtk() >= 2000;
                			isStrongAttack = ((MonsterProperties) card).getAtk() >= 2500;
                		}
                	}
                	
                	if(card.getAttribute().equals("DARK")) 
                	{
                		if(isMidAttack && !isStrongAttack) 
                		{
                			queue.add(darkMidImpactAnimation);
                		}
                		else if(isStrongAttack) 
                		{
                			queue.add(darkStrongImpactAnimation);
                		}
                		else 
                		{
                			queue.add(darkImpactAnimation);
                		}
                	}
                	else if(card.getAttribute().equals("DIVINE")) 
                	{
                		if(card instanceof MonsterProperties && (((MonsterProperties) card).getAtk() >= 2500)) 
                		{
                			queue.add(divineStrongImpactAnimation);
                		}
                		else 
                		{
                			queue.add(divineImpactAnimation);
                		}
                	}
                	else if(card.getAttribute().equals("EARTH")) 
                	{
                		if(card instanceof MonsterProperties && (((MonsterProperties) card).getAtk() >= 2500)) 
                		{
                			queue.add(earthStrongImpactAnimation);
                		}
                		else 
                		{
                			queue.add(earthImpactAnimation);
                		}
                	}
                	else if(card.getAttribute().equals("FIRE")) 
                	{
                		if(card instanceof MonsterProperties && (((MonsterProperties) card).getAtk() >= 2500)) 
                		{
                			queue.add(fireStrongImpactAnimation);
                		}
                		else 
                		{
                			queue.add(fireImpactAnimation);
                		}
                	}
                	else if(card.getAttribute().equals("LIGHT")) 
                	{
                		if(card instanceof MonsterProperties && (((MonsterProperties) card).getAtk() >= 2500)) 
                		{
                			queue.add(lightStrongImpactAnimation);
                		}
                		else 
                		{
                			queue.add(lightImpactAnimation);
                		}
                	}
                	else if(card.getAttribute().equals("WATER")) 
                	{
                		if(card instanceof MonsterProperties && (((MonsterProperties) card).getAtk() >= 2500)) 
                		{
                			queue.add(waterStrongImpactAnimation);
                		}
                		else 
                		{
                			queue.add(waterImpactAnimation);
                		}
                	}
                	else if(card.getAttribute().equals("WIND")) 
                	{
                		if(card instanceof MonsterProperties && (((MonsterProperties) card).getAtk() >= 2500)) 
                		{
                			queue.add(windStrongImpactAnimation);
                		}
                		else 
                		{
                			queue.add(windImpactAnimation);
                		}
                	}
                	else 
                	{
                		queue.add(defaultImpactAnimation);
                	}
                }
            	else 
            	{
            		queue.add(defaultImpactAnimation);
            	}
            }
            
            return new QueueAnimation(queue);
        }
        else if(action0 instanceof CreateTokenAction)
        {
            CreateTokenAction action = (CreateTokenAction) action0;
            ZoneWidget w = getZoneWidget(action.destinationZone);
            int size = Math.max(w.getWidth(), w.getHeight());
            Animation atkPosAnimation = new AttackPositionAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2).setOnStart(() -> 
            { 
            	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.CARD_ATK_POSITION.get(), 1.0F, 0.25F)); 
            });
            Animation defPosAnimation = new DefensePositionAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2).setOnStart(() ->
            {
            	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.CARD_DEF_POSITION.get(), 1.0F, 0.25F));
            });
            Animation summonTokenAnimation = new SpecialSummonTokenAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2).setOnStart(() ->
            {
                Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.TOKEN_SUMMON.get(), 1.0F, 0.25F)); 
                action.doAction();
                repopulateInteractions();
            });
            Queue<Animation> queue = new LinkedList<>();
            
            queue.add(summonTokenAnimation);
            if(action.destinationCardPosition == CardPosition.ATK) 
        	{
        		queue.add(atkPosAnimation);
        	}
        	if(action.destinationCardPosition == CardPosition.DEF) 
        	{
        		queue.add(defPosAnimation);
        	}
            return new QueueAnimation(queue);
        }
        else if(action0 instanceof RemoveTokenAction)
        {
            RemoveTokenAction action = (RemoveTokenAction) action0;
            
            ZoneWidget w = getZoneWidget(action.destinationZone);
            int size = Math.max(w.getWidth(), w.getHeight());
            Animation removeTokenAnimation = new RemoveTokenAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2)
            		.setOnStart(() ->
                    {
                    	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.TOKEN_REMOVE.get(), 1.0F, 0.25F)); 
                    })
                    .setOnEnd(() ->
                    {
                        action.doAction();
                        repopulateInteractions();
                    });
            Animation destroyTokenAnimation = new DestroyTokenAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size / 2, size + size)
            		.setOnStart(() ->
                    {
                    	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.TOKEN_REMOVE.get(), 1.0F, 0.25F)); 
                    })
                    .setOnEnd(() ->
                    {
                        action.doAction();
                        repopulateInteractions();
                    });
            
            if(action.actionType == ActionTypes.DESTROY_TOKEN) 
            {
            	return destroyTokenAnimation;
            }
            else 
            {
            	return removeTokenAnimation;
            }
        }
        else if(action0 instanceof IAnnouncedAction)
        {
            IAnnouncedAction action = (IAnnouncedAction) action0;
            Queue<Animation> queue = new LinkedList<>();
            
            
            if(action.announceOnField())
            {
                ZoneWidget w = getZoneWidget(action.getFieldAnnouncementZone());
                Animation textAnimation = new TextAnimation(action0.getActionType().getLocal(), w.getAnimationDestX(), w.getAnimationDestY()).setOnStart(() -> handleAnnouncedAction(action0));
                if(action0.actionType == ActionTypes.SHUFFLE_ZONE) 
                {
                	//TODO: Make a more advanced shuffle Animation.
                	//Animation shuffleSFX = new DummyAnimation().setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.CARD_SHUFFLE.get(), 1.0F, 0.25F)); });
                	//if(action.getFieldAnnouncementZone().type == ZoneTypes.DECK || action.getFieldAnnouncementZone().type == ZoneTypes.EXTRA_DECK) {deck specific animation}
                	//queue.add(shuffleSFX);
                	queue.add(textAnimation);
                	return new QueueAnimation(queue);
                }
                if(action0.actionType == ActionTypes.ACTIVATE_EFFECT) 
                {
                	int size = Math.max(w.getWidth(), w.getHeight());
                	Animation effectAnimation = new EffectActivateAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2)
                			.setOnStart(() -> 
                			{ 
                				Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.EFFECT_ACTIVATE.get(), 1.0F, 0.25F)); 
                			})
                        	.setOnEnd(() ->
                            {
                            	action0.doAction();
                                repopulateInteractions();
                            });
                        	queue.add(effectAnimation);
                        	return new QueueAnimation(queue);
                }
                if(action0.actionType == ActionTypes.CONTINUE_EFFECT) 
                {
                	int size = Math.max(w.getWidth(), w.getHeight());
                	Animation effectAnimation = new EffectContinueAnimation(w.getAnimationDestX(), w.getAnimationDestY(), size, size + size / 2)
                			.setOnStart(() -> 
                			{ 
                				Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.EFFECT_CONTINUE.get(), 1.0F, 0.25F)); 
                			})
                        	.setOnEnd(() ->
                            {
                            	action0.doAction();
                                repopulateInteractions();
                            });
                        	queue.add(effectAnimation);
                        	return new QueueAnimation(queue);
                }
                if(action0.actionType == ActionTypes.NEGATE_EFFECT) 
                {
                	EffectNegateAction negateAction = (EffectNegateAction) action0;
                	ZoneWidget nZ = getZoneWidget(negateAction.negatedZone);
                	int size = Math.max(nZ.getWidth(), nZ.getHeight());
                	Animation negateEffectAnimation = new EffectNegateAnimation(nZ.getAnimationDestX(), nZ.getAnimationDestY(), size + size, size)
                			.setOnStart(() -> 
                			{ 
                				Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.EFFECT_NEGATE.get(), 1.0F, 0.25F)); 
                			})
                        	.setOnEnd(() ->
                            {
                            	action0.doAction();
                                repopulateInteractions();
                            });
                        	queue.add(negateEffectAnimation);
                        	return new QueueAnimation(queue);
                }
                else 
                {
                	return textAnimation;
                } 
            }
            if(action0.actionType == ActionTypes.CHANGE_LP) 
            {
            	//TODO: Improve code here, either by changing the Change LP action or something else
            	//ChangeLPAction lpAction = (ChangeLPAction) action0;
            	Animation lpCountDownSFX = new DummyAnimation().setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.LP_COUNT.get(), 1.0F, 0.25F)); });
            	//Animation lpCountUpSFX = new DummyAnimation().setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.LP_HEAL.get(), 1.0F, 0.25F)); });
            	Animation lpChangeDummyAnimation = new DummyAnimation().setOnEnd(() -> 
            	{ 
            		action0.doAction();
                    repopulateInteractions();
                });
            	
            	queue.add(lpCountDownSFX);
            	queue.add(lpChangeDummyAnimation);
            	
            	return new QueueAnimation(queue);
            }
            if(action0.actionType == ActionTypes.COIN_FLIP) 
            {
            	//TODO: Make a proper coin toss, and separate animations for the result. Likely will include changing the coin toss action code.
            	Animation coinThrowAnimation = new DummyAnimation()
            	.setOnStart(() -> 
                { 
                	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.COIN_THROW.get(), 1.0F, 0.25F)); 
                })
            	.setOnEnd(() ->
                {
                	action0.doAction();
                    repopulateInteractions();
                });
            	queue.add(coinThrowAnimation);
            	return new QueueAnimation(queue);
            }
            if(action0.actionType == ActionTypes.DICE_ROLL) 
            {
            	//TODO: Make a proper dice roll, and separate animations for the results. Likely will include changing the dice roll action code.
            	Animation diceRollAnimation = new DummyAnimation()
            	.setOnStart(() -> 
                { 
                	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.DICE_ROLL.get(), 1.0F, 0.25F)); 
                })
            	.setOnEnd(() ->
                {
                	action0.doAction();
                    repopulateInteractions();
                });
            	queue.add(diceRollAnimation);
            	return new QueueAnimation(queue);
            }
        }
        else if(action0.actionType == ActionTypes.CHANGE_PHASE)
        {
            Animation defaultAnimation = getDefaultAnimation(action0);
            Animation phaseChangeAnimation = new DummyAnimation();
            boolean isTurn;
            if(getZoneOwner() == ZoneOwner.NONE)
            {
                isTurn = getPlayField().isPlayerTurn(ZoneOwner.PLAYER1);
            }
            else
            {
                isTurn = getPlayField().isPlayerTurn(getZoneOwner());
            }
            isTurn = getZoneOwner() != ZoneOwner.NONE && getPlayField().isPlayerTurn(getZoneOwner());
            Queue<Animation> queue = new LinkedList<>();
            
            if(isTurn) 
            {
            	phaseChangeAnimation.setOnStart(() ->
                {
                	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.PHASE_CHANGE_PLAYER1.get(), 1.0F, 0.25F));
                });
            }
            else 
            {
            	phaseChangeAnimation.setOnStart(() ->
                {
                	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.PHASE_CHANGE_PLAYER2.get(), 1.0F, 0.25F));
                });
            }
            defaultAnimation.setOnEnd(() ->
            {
                updateRightButtonStatus();
            });
            
            queue.add(phaseChangeAnimation);
            queue.add(defaultAnimation);
            return new QueueAnimation(queue);
        }
        else if(action0.actionType == ActionTypes.END_TURN)
        {
            Animation defaultAnimation = getDefaultAnimation(action0);
            Animation endTurnAnimation = new DummyAnimation();
            Animation refreshDummyAnimation = new DummyAnimation().setOnEnd(() -> { reload(); });;
            boolean isTurn;
            if(getZoneOwner() == ZoneOwner.NONE)
            {
                isTurn = getPlayField().isPlayerTurn(ZoneOwner.PLAYER1);
            }
            else
            {
                isTurn = getPlayField().isPlayerTurn(getZoneOwner());
            }
            isTurn = getZoneOwner() != ZoneOwner.NONE && getPlayField().isPlayerTurn(getZoneOwner());
            Queue<Animation> queue = new LinkedList<>();
            
            if(isTurn) 
            {
            	endTurnAnimation.setOnStart(() ->
                {
                	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.TURN_SWITCH_PLAYER1.get(), 1.0F, 0.25F));
                });
            }
            else 
            {
            	endTurnAnimation.setOnStart(() ->
                {
                	Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.TURN_SWITCH_PLAYER2.get(), 1.0F, 0.25F));
                });
            }
            
            defaultAnimation.setOnEnd(() ->
            {
                updateRightButtonStatus();
            });
            
            queue.add(endTurnAnimation);
            queue.add(defaultAnimation);
            // Hopefully this reload here does not break something
            queue.add(refreshDummyAnimation);
            return new QueueAnimation(queue);
        }
        else if(action0.actionType == ActionTypes.CHANGE_COUNTERS) 
        {
        	Animation defaultAnimation = getDefaultAnimation(action0);
        	Animation changeCountersSFX = new DummyAnimation().setOnStart(() -> { Minecraft.getInstance().getSoundManager().play(SimpleSound.forUI(YdmSoundEvents.COUNTER_PLACE.get(), 1.0F, 0.25F)); });
        	Queue<Animation> queue = new LinkedList<>();
        	
            queue.add(changeCountersSFX);
            queue.add(defaultAnimation);
            return new QueueAnimation(queue);
        }
        
        return getDefaultAnimation(action0);
    }
    
    protected Animation getDefaultAnimation(Action action)
    {
        return new DummyAnimation().setOnStart(() ->
        {
            action.doAction();
        });
    }
    
    protected void handleAnnouncedAction(Action action)
    {
        if(action instanceof ViewZoneAction)
        {
            ViewZoneAction a = (ViewZoneAction) action;
            if(getZoneOwner() == a.sourceZone.getOwner())
            {
                viewZone(a.sourceZone);
            }
        }
        else if(action instanceof ShowZoneAction)
        {
            ShowZoneAction a = (ShowZoneAction) action;
            if(getZoneOwner() != a.sourceZone.getOwner())
            {
                viewZone(a.sourceZone);
            }
        }
        else if(action instanceof ShowCardAction)
        {
            ShowCardAction a = (ShowCardAction) action;
            if(getZoneOwner() != a.sourceZone.getOwner())
            {
                viewCards(a.sourceZone, ImmutableList.of(a.card));
            }
        }
        else if(action instanceof ShuffleAction)
        {
            ShuffleAction a = (ShuffleAction) action;
            
            // if we have a zone selected/viewed and it is shuffled, we gotta deselect it / stop viewing it
            if(clickedZoneWidget != null &&
                    clickedZoneWidget.zone == a.sourceZone)
            {
                resetToNormalZoneWidgets();
            }
            
            a.doAction();
        }
    }
    
    protected void forceFinishAnimations(double mouseX, double mouseY)
    {
        animationsWidget.forceFinish();
    }
    
    protected void viewZone(Zone zone)
    {
        for(ZoneWidget w : zoneWidgets)
        {
            if(w.zone == zone)
            {
                resetToNormalZoneWidgets();
                
                w.hoverCard = null;
                
                zoneClicked(w);
                clickedCard = null;
                viewZone(w, true);
                return;
            }
        }
    }
    
    protected void viewCards(Zone zone, List<DuelCard> cards)
    {
        for(ZoneWidget w : zoneWidgets)
        {
            if(w.zone == zone)
            {
                resetToNormalZoneWidgets();
                
                w.hoverCard = null;
                
                zoneClicked(w);
                viewCards(cards, w.getMessage(), true);
                return;
            }
        }
    }
    
    protected void zoneClicked(ZoneWidget widget)
    {
        if(!widget.active)
        {
            return;
        }
        
        ZoneOwner owner = getZoneOwner();
        
        if(owner != ZoneOwner.NONE)
        {
            setClickedZoneWidgetAndCard(widget, widget.hoverCard);
            findAndPopulateInteractions(widget, false);
        }
        
        if(widget.openAdvancedZoneView())
        {
            viewZone(widget, owner == widget.zone.getOwner() && widget.zone.type.getShowFaceDownCardsToOwner());
        }
        
        updateLeftButtonStatus();
    }
    
    protected void findAndPopulateInteractions(ZoneWidget widget, boolean isAdvanced)
    {
        ZoneOwner owner = getZoneOwner();
        
        removeInteractionWidgets();
        
        interactionWidgets = new ArrayList<>();
        
        for(ZoneWidget w : zoneWidgets)
        {
            w.addInteractionWidgets(owner, clickedZoneWidget.zone, clickedCard, getDuelManager(), interactionWidgets, this::interactionClicked, this::interactionTooltip, isAdvanced);
            w.active = false;
        }
        
        buttons.addAll(interactionWidgets);
        children.addAll(interactionWidgets);
    }
    
    protected void interactionClicked(InteractionWidget widget)
    {
        Action action = widget.interaction.action;
        
        ZoneType interactorType = widget.interaction.interactor.getType();
        
        if(interactorType.getKeepFocusedAfterInteraction() &&
                (interactorType.getIsSecret() ? viewCardStackWidget.active : true))
        {
            clickedCard = null;
            repopulateInteractions();
        }
        else if(shouldRepopulateInteractions(widget))
        {
            repopulateInteractions();
        }
        else
        {
            resetToNormalZoneWidgets();
        }
        
        requestDuelAction(action);
    }
    
    protected boolean shouldRepopulateInteractions(InteractionWidget clickedWidget)
    {
        return clickedWidget.interaction.action.getActionType() == ActionTypes.CREATE_TOKEN;
    }
    
    protected void repopulateInteractions()
    {
        if(clickedZoneWidget != null)
        {
            findAndPopulateInteractions(clickedZoneWidget, isAdvanced);
        }
        else
        {
            resetToNormalZoneWidgets();
        }
    }
    
    protected void requestDuelAction(Action action)
    {
        YDM.channel.send(PacketDistributor.SERVER.noArg(), new DuelMessages.RequestDuelAction(getDuelManager().headerFactory.get(), action));
    }
    
    protected ITextComponent getShownZoneName()
    {
        return nameShown == null ? StringTextComponent.EMPTY : nameShown;
    }
    
    protected void viewCardStackClicked(ViewCardStackWidget widget)
    {
        ZoneWidget w = clickedZoneWidget;
        boolean forceFaceUp = widget.getForceFaceUp();
        
        if(w != null)
        {
            w.active = true;
            w.hoverCard = widget.hoverCard;
            zoneClicked(w);
            
            if(forceFaceUp)
            {
                widget.forceFaceUp();
            }
        }
    }
    
    protected void parseAndSendLPChange()
    {
        if(getZoneOwner().isPlayer())
        {
            String text = lifePointsWidget.getValue();
            lifePointsWidget.setValue("");
            
            if(text.length() > 1)
            {
                if(text.startsWith("+"))
                {
                    text = text.substring(1);
                }
                
                int lp = Integer.valueOf(text);
                requestDuelAction(new ChangeLPAction(ActionTypes.CHANGE_LP, lp, getZoneOwner()));
            }
        }
    }
    
    protected void scrollButtonClicked(Button button)
    {
        if(viewCardStackWidget.active)
        {
            if(button == scrollUpButton)
            {
                viewCardStackWidget.decreaseCurrentRow();
            }
            else if(button == scrollDownButton)
            {
                viewCardStackWidget.increaseCurrentRow();
            }
        }
        
        updateScrollButtonStatus();
    }
    
    protected void middleButtonClicked(Widget w)
    {
        if(w == reloadButton)
        {
            reload();
        }
        else if(w == flipViewButton)
        {
            flip();
        }
        else if(w == admitDefeatButton)
        {
            YDM.channel.send(PacketDistributor.SERVER.noArg(), new DuelMessages.SendAdmitDefeat(getHeader()));
        }
        else if(w == offerDrawButton)
        {
            YDM.channel.send(PacketDistributor.SERVER.noArg(), new DuelMessages.SendOfferDraw(getHeader()));
        }
    }
    
    protected void leftButtonClicked(Button button)
    {
        if(button == coinFlipButton)
        {
        	requestDuelAction(new CoinFlipAction(ActionTypes.COIN_FLIP));
        }
        else if(button == diceRollButton)
        {
            requestDuelAction(new DiceRollAction(ActionTypes.DICE_ROLL));
        }
        else if(getClickedZone() != null && clickedZoneWidget.zone.getOwner() == getZoneOwner() && button == addCounterButton)
        {
            requestDuelAction(new ChangeCountersAction(ActionTypes.CHANGE_COUNTERS, getClickedZone().index, +1));
        }
        else if(getClickedZone() != null && clickedZoneWidget.zone.getOwner() == getZoneOwner() && button == removeCounterButton)
        {
            requestDuelAction(new ChangeCountersAction(ActionTypes.CHANGE_COUNTERS, getClickedZone().index, -1));
        }
        else if(button == advancedOptionsButton)
        {
            isAdvanced = !isAdvanced;
            repopulateInteractions();
        }
    }
    
    protected void rightButtonClicked(Widget w)
    {
        DuelPhase phase = getPlayField().getPhase();
        
        if(w == prevPhaseButton)
        {
            if(!phase.isFirst())
            {
                DuelPhase prevPhase = DuelPhase.getFromIndex((byte) (phase.getIndex() - 1));
                requestDuelAction(new ChangePhaseAction(ActionTypes.CHANGE_PHASE, prevPhase));
            }
        }
        else if(w == nextPhaseButton)
        {
            if(phase.isLast())
            {
                requestDuelAction(new EndTurnAction(ActionTypes.END_TURN));
            }
            else
            {
                DuelPhase nextPhase = DuelPhase.getFromIndex((byte) (phase.getIndex() + 1));
                requestDuelAction(new ChangePhaseAction(ActionTypes.CHANGE_PHASE, nextPhase));
            }
        }
    }
    
    protected void zoneTooltip(Widget w0, MatrixStack ms, int mouseX, int mouseY)
    {
        List<IReorderingProcessor> tooltip = new LinkedList<>();
        
        ZoneWidget w = (ZoneWidget) w0;
        
        IFormattableTextComponent t = new StringTextComponent("").append(w.getMessage());
        
        
        //TODO: Simple tooltips for card info
        
        if(w.zone.getCardsAmount() > 0)
        {
            t.append(" (" + w.zone.getCardsAmount() + ")");
        }
        
        tooltip.add(t.getVisualOrderText());
        
        if(w.zone.getType().getCanHaveCounters() && w.zone.getCounters() > 0)
        {
            tooltip.add(new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.counters").append(": " + w.zone.getCounters()).getVisualOrderText());
        }
        
        renderTooltip(ms, tooltip, mouseX, mouseY);
    }
    
    protected void interactionTooltip(Widget w, MatrixStack ms, int mouseX, int mouseY)
    {
        renderTooltip(ms, w.getMessage(), mouseX, mouseY);
    }
    
    protected void viewCardStackTooltip(Widget w, MatrixStack ms, int mouseX, int mouseY)
    {
    }
    
    protected void lpTooltip(ZoneOwner owner, @Nullable IFormattableTextComponent playerName, Widget w, MatrixStack ms, int mouseX, int mouseY)
    {
        List<IReorderingProcessor> list = new LinkedList<>();
        
        list.add(new StringTextComponent(String.valueOf(getPlayField().getLifePoints(owner))).getVisualOrderText());
        
        if(playerName != null)
        {
            list.add(playerName.getVisualOrderText());
        }
        else
        {
            list.add(getUnknownPlayerName().getVisualOrderText());
        }
        
        renderTooltip(ms, list, mouseX, mouseY);
    }
    
    protected void lpTooltipView(Widget w, MatrixStack ms, int mouseX, int mouseY)
    {
        lpTooltip(getView(), getViewName(), w, ms, mouseX, mouseY);
    }
    
    protected void lpTooltipViewOpponent(Widget w, MatrixStack ms, int mouseX, int mouseY)
    {
        lpTooltip(getView().opponent(), getViewOpponentName(), w, ms, mouseX, mouseY);
    }
    
    protected void lpTextFieldWidget(Widget w, MatrixStack ms, int mouseX, int mouseY)
    {
        List<IReorderingProcessor> list = new LinkedList<>();
        
        list.add(new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.change_lp_tooltip1").getVisualOrderText());
        list.add(new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.change_lp_tooltip2").getVisualOrderText());
        list.add(new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.change_lp_tooltip3").getVisualOrderText());
        
        renderTooltip(ms, list, mouseX, mouseY);
    }
    
    protected void phaseWidgetHovered(Widget w, MatrixStack ms, int mouseX, int mouseY)
    {
        renderTooltip(ms, getCurrentPhaseTooltip(), mouseX, mouseY);
    }
    
    protected void scrollButtonHovered(Widget w, MatrixStack ms, int mouseX, int mouseY)
    {
    }
    
    protected void middleButtonHovered(Widget w, MatrixStack ms, int mouseX, int mouseY)
    {
        if(w == reloadButton)
        {
            renderTooltip(ms, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.reload"), mouseX, mouseY);
        }
        else if(w == flipViewButton)
        {
            renderTooltip(ms, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.flip_view"), mouseX, mouseY);
        }
        else if(w == offerDrawButton)
        {
            renderTooltip(ms, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.offer_draw"), mouseX, mouseY);
        }
        else if(w == admitDefeatButton)
        {
            renderTooltip(ms, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.admit_defeat"), mouseX, mouseY);
        }
    }
    
    protected void leftButtonHovered(Widget w, MatrixStack ms, int mouseX, int mouseY)
    {
        if(w == coinFlipButton)
        {
            renderTooltip(ms, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.coin_flip"), mouseX, mouseY);
        }
        else if(w == diceRollButton)
        {
            renderTooltip(ms, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.dice_roll"), mouseX, mouseY);
        }
        else if(w == addCounterButton)
        {
            renderTooltip(ms, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.add_counter"), mouseX, mouseY);
        }
        else if(w == removeCounterButton)
        {
            renderTooltip(ms, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.remove_counter"), mouseX, mouseY);
        }
        else if(w == advancedOptionsButton)
        {
            if(!isAdvanced)
            {
                renderTooltip(ms, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.advanced_options"), mouseX, mouseY);
            }
            else
            {
                renderTooltip(ms, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.basic_options"), mouseX, mouseY);
            }
        }
    }
    
    protected void rightButtonHovered(Widget w, MatrixStack ms, int mouseX, int mouseY)
    {
        DuelPhase phase = getPlayField().getPhase();
        
        if(w == prevPhaseButton)
        {
            if(!phase.isFirst())
            {
                DuelPhase prevPhase = DuelPhase.getFromIndex((byte) (phase.getIndex() - 1));
                renderTooltip(ms, (getPhaseTooltip(prevPhase).append(" ").append(new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.left_arrow"))), mouseX, mouseY);
            }
        }
        else if(w == nextPhaseButton)
        {
            if(phase.isLast())
            {
                renderTooltip(ms, new TranslationTextComponent("action." + YDM.MOD_ID + ".end_turn"), mouseX, mouseY);
            }
            else
            {
                DuelPhase nextPhase = DuelPhase.getFromIndex((byte) (phase.getIndex() + 1));
                renderTooltip(ms, new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.right_arrow").append(" ").append(getPhaseTooltip(nextPhase)), mouseX, mouseY);
            }
        }
    }
    
    public IFormattableTextComponent getPhaseShort()
    {
        return new TranslationTextComponent("container." + YDM.MOD_ID + ".duel." + getPlayField().getPhase().local + ".short");
    }
    
    public IFormattableTextComponent getCurrentPhaseTooltip()
    {
        return getPhaseTooltip(getPlayField().getPhase());
    }
    
    public IFormattableTextComponent getPhaseTooltip(DuelPhase phase)
    {
        return new TranslationTextComponent("container." + YDM.MOD_ID + ".duel." + phase.local);
    }
    
    protected void removeInteractionWidgets()
    {
        buttons.removeIf((w) -> w instanceof InteractionWidget);
        children.removeIf((w) -> w instanceof InteractionWidget);
    }
    
    protected void removeClickedZone()
    {
        setClickedZoneWidgetAndCard(null, null);
        viewCardStackWidget.deactivate();
        nameShown = null;
        updateScrollButtonStatus();
        updateLeftButtonStatus();
    }
    
    protected void setClickedZoneWidgetAndCard(ZoneWidget zone, DuelCard card)
    {
        clickedZoneWidget = zone;
        clickedCard = card;
        
        if(getZoneOwner().isPlayer())
        {
            getPlayField().setClickedForPlayer(getZoneOwner(), zone != null ? zone.zone : null, card);
            requestDuelAction(new SelectAction(ActionTypes.SELECT, getClickedZone(), getClickedCard(), getZoneOwner()));
        }
    }
    
    protected IFormattableTextComponent getUnknownPlayerName()
    {
        return new TranslationTextComponent("container." + YDM.MOD_ID + ".duel.unknown_player")
                .withStyle((style) -> style.applyFormat(TextFormatting.ITALIC))
                .withStyle((style) -> style.applyFormat(TextFormatting.RED));
    }
    
    protected IFormattableTextComponent getViewName()
    {
        return getView() == ZoneOwner.PLAYER1 ? getPlayer1Name() : getPlayer2Name();
    }
    
    protected IFormattableTextComponent getViewOpponentName()
    {
        return getView() == ZoneOwner.PLAYER1 ? getPlayer2Name() : getPlayer1Name();
    }
    
    protected IFormattableTextComponent getPlayer1Name()
    {
        if(getDuelManager().player1 != null)
        {
            return (IFormattableTextComponent) getDuelManager().player1.getName();
        }
        else
        {
            if(!fetchPlayer1Name() && player1Name == null)
            {
                // we have never fetched the name and the player isnt here
                return null;
            }
            else
            {
                return player1Name.withStyle((style) -> style.applyFormat(TextFormatting.RED));
            }
        }
    }
    
    protected IFormattableTextComponent getPlayer2Name()
    {
        if(getDuelManager().player2 != null)
        {
            return (IFormattableTextComponent) getDuelManager().player2.getName();
        }
        else
        {
            if(!fetchPlayer2Name() && player2Name == null)
            {
                // we have never fetched the name and the player isnt here
                return null;
            }
            else
            {
                return player2Name.withStyle((style) -> style.applyFormat(TextFormatting.RED));
            }
        }
    }
    
    // return true if player 1 is still in the same dimension
    protected boolean fetchPlayer1Name()
    {
        // TODO sync UUIDs to client, instead of setting roles only for uuid-fetchable players
        
        if(getDuelManager().player1Id == null)
        {
            return false;
        }
        
        PlayerEntity p = minecraft.level.getPlayerByUUID(getDuelManager().player1Id);
        if(p != null)
        {
            player1Name = (IFormattableTextComponent) p.getName();
            return true;
        }
        else
        {
            return false;
        }
    }
    
    // return true if player 2 is still in the same dimension
    protected boolean fetchPlayer2Name()
    {
        if(getDuelManager().player2Id == null)
        {
            return false;
        }
        
        PlayerEntity p = minecraft.level.getPlayerByUUID(getDuelManager().player2Id);
        if(p != null)
        {
            player2Name = (IFormattableTextComponent) p.getName();
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public ZoneOwner getView()
    {
        return view;
    }
    
    @Override
    public void renderCardInfo(MatrixStack ms, DuelCard card)
    {
        cardInfo = card;
    }
    
    public static void renderSelectedRect(MatrixStack ms, float x, float y, float w, float h)
    {
        ScreenUtil.drawLineRect(ms, x - 1, y - 1, w + 2, h + 2, 2, 0, 0, 1F, 1F);
    }
    
    public static void renderEnemySelectedRect(MatrixStack ms, float x, float y, float w, float h)
    {
        ScreenUtil.drawLineRect(ms, x - 1, y - 1, w + 2, h + 2, 2, 1F, 0, 0, 1F);
    }
    
    public static void renderBothSelectedRect(MatrixStack ms, float x, float y, float w, float h)
    {
        ScreenUtil.drawLineRect(ms, x - 1, y - 1, w + 2, h + 2, 2, 1F, 0, 1F, 1F);
    }
}
