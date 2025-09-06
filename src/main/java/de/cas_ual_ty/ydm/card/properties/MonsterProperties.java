package de.cas_ual_ty.ydm.card.properties;

import com.google.gson.JsonObject;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.util.JsonKeys;
import net.minecraft.util.text.*;

import java.util.List;

public class MonsterProperties extends Properties
{
    //public String attribute;
    public int atk;
    public String species; // TODO: Make Species an array.
    public MonsterType monsterType;
    public boolean isPendulum;
    public String ability;
    public boolean hasEffect;
    public boolean isMaximumCenter;
    public boolean isDeckmaster;
    public boolean isEvolution;
    
    // Only if isPendulum = true
    public String pendulumText;
    public byte pendulumScaleLeftBlue;
    public byte pendulumScaleRightRed;
    
    // Only if isMaximumCenter = true
    public int maximumAtk;
    
    //Only if isDeckmaster = true
    public String deckmasterText;
    
    //Only if isEvolution = true
    public String evolutionText;
    //public String prevStage;
    public byte evolutionStage;
    
    public MonsterProperties(Properties p0, JsonObject j)
    {
        super(p0);
        readMonsterProperties(j);
    }
    
    public MonsterProperties(Properties p0)
    {
        super(p0);
        
        if(p0 instanceof MonsterProperties)
        {
            MonsterProperties p1 = (MonsterProperties) p0;
            //attribute = p1.attribute;
            atk = p1.atk;
            species = p1.species;
            monsterType = p1.monsterType;
            isPendulum = p1.isPendulum;
            ability = p1.ability;
            hasEffect = p1.hasEffect;
            isMaximumCenter = p1.isMaximumCenter;
            isDeckmaster = p1.isDeckmaster;
            isEvolution = p1.isEvolution;
            
            if(p1.isPendulum)
            {
                pendulumText = p1.pendulumText;
                pendulumScaleLeftBlue = p1.pendulumScaleLeftBlue;
                pendulumScaleRightRed = p1.pendulumScaleRightRed;
            }
            
            if(p1.isMaximumCenter)
            {
                maximumAtk = p1.maximumAtk;
            }
            
            if(p1.isDeckmaster)
            {
            	deckmasterText = p1.deckmasterText;
            }
            
            if(p1.isEvolution)
            {
            	evolutionText = p1.evolutionText;
            	evolutionStage = p1.evolutionStage;
            }
        }
    }
    
    public MonsterProperties()
    {
    }
    
    @Override
    public void readAllProperties(JsonObject j)
    {
        super.readAllProperties(j);
        readMonsterProperties(j);
    }
    
    @Override
    public void writeAllProperties(JsonObject j)
    {
        super.writeAllProperties(j);
        writeMonsterProperties(j);
    }
    
    public void readMonsterProperties(JsonObject j)
    {
    	// TODO: Make isPendulum, ability, isMaximum, isMaximumCenter, maximumAtk and isDeckmaster optional JSON keys
        //attribute = j.get(JsonKeys.ATTRIBUTE).getAsString();
        atk = j.get(JsonKeys.ATK).getAsInt();
        species = j.get(JsonKeys.SPECIES).getAsString();
        monsterType = MonsterType.fromString(j.get(JsonKeys.MONSTER_TYPE).getAsString());
        //isPendulum = j.get(JsonKeys.IS_PENDULUM).getAsBoolean();
        
        if(j.has(JsonKeys.IS_PENDULUM))
        {
        	isPendulum = j.get(JsonKeys.IS_PENDULUM).getAsBoolean();
        	if(getIsPendulum())
            {
                pendulumText = j.get(JsonKeys.PENDULUM_TEXT).getAsString();
                pendulumScaleLeftBlue = j.get(JsonKeys.PENDULUM_SCALE_LEFT_BLUE).getAsByte();
                pendulumScaleRightRed = j.get(JsonKeys.PENDULUM_SCALE_RIGHT_RED).getAsByte();
            }
        }
        else 
        {
        	isPendulum = false;
        }
        
        ability = j.get(JsonKeys.ABILITY).getAsString();
        hasEffect = j.get(JsonKeys.HAS_EFFECT).getAsBoolean();
        
        if(j.has(JsonKeys.IS_MAXIMUM_CENTER))
        {
            isMaximumCenter = j.get(JsonKeys.IS_MAXIMUM_CENTER).getAsBoolean();
            if (getIsMaximumCenter()) 
            {
            	maximumAtk = j.get(JsonKeys.MAXIMUM_ATK).getAsInt();
            }
        }
        else
        {
        	isMaximumCenter = false;
        }
        
        if(j.has(JsonKeys.IS_DECKMASTER))
        {
            isDeckmaster = j.get(JsonKeys.IS_DECKMASTER).getAsBoolean();
            deckmasterText = j.get(JsonKeys.DECKMASTER_TEXT).getAsString();
        }
        else
        {
        	isDeckmaster = false;
        }
        
        if(j.has(JsonKeys.IS_EVOLUTION))
        {
        	isEvolution = j.get(JsonKeys.IS_EVOLUTION).getAsBoolean();
        	if(getIsEvolution())
            {
                evolutionText = j.get(JsonKeys.EVOLUTION_TEXT).getAsString();
                evolutionStage = j.get(JsonKeys.EVOLUTION_STAGE).getAsByte();
            }
        }
        else 
        {
        	isEvolution = false;
        }
        
        /*
        if(getIsPendulum())
        {
            pendulumText = j.get(JsonKeys.PENDULUM_TEXT).getAsString();
            pendulumScaleLeftBlue = j.get(JsonKeys.PENDULUM_SCALE_LEFT_BLUE).getAsByte();
            pendulumScaleRightRed = j.get(JsonKeys.PENDULUM_SCALE_RIGHT_RED).getAsByte();
        }
        */
    }
    
    public void writeMonsterProperties(JsonObject j)
    {
        //j.addProperty(JsonKeys.ATTRIBUTE, attribute);
        j.addProperty(JsonKeys.ATK, atk);
        j.addProperty(JsonKeys.SPECIES, species);
        j.addProperty(JsonKeys.MONSTER_TYPE, monsterType.name);
        j.addProperty(JsonKeys.IS_PENDULUM, isPendulum);
        j.addProperty(JsonKeys.ABILITY, ability);
        j.addProperty(JsonKeys.HAS_EFFECT, hasEffect);
        j.addProperty(JsonKeys.IS_MAXIMUM_CENTER, isMaximumCenter);
        j.addProperty(JsonKeys.IS_DECKMASTER, isDeckmaster);
        j.addProperty(JsonKeys.IS_EVOLUTION, isEvolution);
        
        if(getIsPendulum())
        {
            j.addProperty(JsonKeys.PENDULUM_TEXT, pendulumText);
            j.addProperty(JsonKeys.PENDULUM_SCALE_LEFT_BLUE, pendulumScaleLeftBlue);
            j.addProperty(JsonKeys.PENDULUM_SCALE_RIGHT_RED, pendulumScaleRightRed);
        }
        
        if(getIsMaximumCenter())
        {
            j.addProperty(JsonKeys.MAXIMUM_ATK, maximumAtk);
        }
        
        if(getIsDeckmaster())
        {
        	j.addProperty(JsonKeys.DECKMASTER_TEXT, deckmasterText);
        }
        
        if(getIsEvolution())
        {
            j.addProperty(JsonKeys.EVOLUTION_TEXT, evolutionText);
            j.addProperty(JsonKeys.EVOLUTION_STAGE, evolutionStage);
        }
    }
    
    public boolean getIsNormal()
    {
        return getMonsterType() == null && !getHasEffect();
    }
    
    public boolean getIsEffect()
    {
        return getMonsterType() == null && getHasEffect();
    }
    
    public boolean getIsFusion()
    {
        return getMonsterType() == MonsterType.FUSION;
    }
    
    public boolean getIsLink()
    {
        return getMonsterType() == MonsterType.LINK;
    }
    
    public boolean getIsRitual()
    {
        return getMonsterType() == MonsterType.RITUAL;
    }
    
    public boolean getIsSynchro()
    {
        return getMonsterType() == MonsterType.SYNCHRO;
    }
    
    public boolean getIsXyz()
    {
        return getMonsterType() == MonsterType.XYZ;
    }
    
    public boolean getIsMaximum()
    {
        return getMonsterType() == MonsterType.MAXIMUM;
    }
    
    public boolean getIsToken()
    {
        return getMonsterType() == MonsterType.TOKEN;
    }
    
    @Override
    public boolean getIsInExtraDeck()
    {
        return getIsFusion() || getIsLink() || getIsSynchro() || getIsXyz() || getIsToken() || getIsRitual() && getIsRush();
    }
    
    public boolean getHasLevel()
    {
        return getMonsterType() == null || getIsFusion() || getIsRitual() || getIsSynchro() || getIsToken() || getIsMaximum();
    }
    
    public boolean getHasDef()
    {
        return getMonsterType() == null || getIsFusion() || getIsRitual() || getIsSynchro() || getIsXyz() || getIsToken() || getIsMaximum();
    }
    
    @Override
    public void addHeader(List<ITextComponent> list)
    {
        super.addHeader(list);
        addMonsterStats(list);
    }
    
    @Override
    public void addText(List<ITextComponent> list)
    {
    	if(getIsMaximumCenter())
        {
        	addMaximumAtkHeader(list);
        	list.add(StringTextComponent.EMPTY);
        }
    	if(getIsDeckmaster())
        {
    		addDeckmasterTextHeader(list);
        	list.add(StringTextComponent.EMPTY);
        }
        if(getIsPendulum())
        {
            addPendulumTextHeader(list);
            if(getPendulumText() != null && !getPendulumText().isEmpty()) 
            {
            	list.add(new StringTextComponent(getPendulumText()));
            }
            //list.add(new StringTextComponent(getPendulumText()));
            list.add(StringTextComponent.EMPTY);
        }
        if(getIsEvolution()) 
        {
        	addEvolutionTextHeader(list);
        	list.add(StringTextComponent.EMPTY);
        }
        
        super.addText(list);
        
        //Thinking about just automatically making Normal Monsters' texts to be in italics, though I'll have to see
        /*
        if(getHasEffect() || getIsToken())
        {
        	super.addText(list);
        }
        else
        {
        	addTypeBox(list);
            list.add(new StringTextComponent(getText()).setStyle(Style.EMPTY.applyFormat(TextFormatting.ITALIC)));
        }
        */
    }
    
    public void addPendulumTextHeader(List<ITextComponent> list)
    {
    	IFormattableTextComponent pendulumBox = new StringTextComponent("[Pendulum Text] ");
    	IFormattableTextComponent pScaleText = new StringTextComponent("P Scale ");
        IFormattableTextComponent leftScale = new StringTextComponent("" + getPendulumScaleLeftBlue());//.setStyle(Style.EMPTY.applyFormatting(TextFormatting.WHITE));
        IFormattableTextComponent leftArrow = new StringTextComponent("◀").setStyle(Style.EMPTY.applyFormat(TextFormatting.BLUE));
        IFormattableTextComponent rightArrow = new StringTextComponent("▶").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED));
        IFormattableTextComponent rightScale = new StringTextComponent("" + getPendulumScaleRightRed());//.setStyle(Style.EMPTY.applyFormatting(TextFormatting.WHITE));
        //list.add(pendEff.append(leftScale).append(" ").append(leftArrow).append(" / ").append(rightArrow).append(" ").append(rightScale));
        if(getPendulumText() != null && !getPendulumText().isEmpty())
        {
        	list.add(pendulumBox.append(pScaleText).append(leftScale).append(" ").append(leftArrow).append(" / ").append(rightArrow).append(" ").append(rightScale));
        }
        else
        {
        	list.add(pScaleText.append(leftScale).append(" ").append(leftArrow).append(" / ").append(rightArrow).append(" ").append(rightScale));
        }
    }
    
    public void addEvolutionTextHeader(List<ITextComponent> list)
    {
    	if(getEvolutionStage() == 0) {
    		list.add(new StringTextComponent("Base Stage"));
    	}
    	else {
    		list.add(new StringTextComponent("Stage " + getEvolutionStage()));
    		list.add(new StringTextComponent(getEvolutionText()));
    	}
    }
    
    public void addMaximumAtkHeader(List<ITextComponent> list)
    {
    	IFormattableTextComponent maximumAtkSymbol = new StringTextComponent("🗡").setStyle(Style.EMPTY.applyFormat(TextFormatting.GOLD));
    	IFormattableTextComponent s = new StringTextComponent("");
    	
    	s.append(maximumAtkSymbol);
    	if(getMaximumAtk() >= 0)
            {
        		s.append(getMaximumAtk() + " MAXIMUM ATK");
            }
            else
            {
                s.append("? MAXIMUM ATK");
            }
    		list.add(s);
    }
    
    public void addDeckmasterTextHeader(List<ITextComponent> list)
    {
    	list.add(new StringTextComponent("[Deck Master Text]"));
    	list.add(new StringTextComponent(getDeckmasterText()));
    }
    
    @Override
    public void addCardType(List<ITextComponent> list)
    {
        if(getMonsterType() != null)
        {
            list.add(new StringTextComponent(getMonsterType().name + " " + getType().name));
        }
        else if(getHasEffect())
        {
            list.add(new StringTextComponent("Effect " + getType().name));
        }
        else
        {
            list.add(new StringTextComponent("Normal " + getType().name));
        }
    }
    
    /*
    public void addMonsterHeader(List<ITextComponent> list)
    {
        addMonsterHeader1(list);
        addMonsterHeader2(list);
    }
    */
    
    @Override
    public void addCardAttribute(List<ITextComponent> list)
    {
    	list.add(new StringTextComponent(getAttribute()));
    }
    
    /*
    public void addMonsterHeader1(List<ITextComponent> list)
    {
        list.add(new StringTextComponent(getAttribute()));
    }
    */
    
    public void addMonsterStats(List<ITextComponent> list)
    {
    	IFormattableTextComponent atkSymbol = new StringTextComponent("🗡").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED));
    	IFormattableTextComponent s = new StringTextComponent("");
    	s.append(atkSymbol);	
    	if(getAtk() >= 0)
            {
        		s.append(getAtk() + " ATK");
            }
        else
            {
                s.append("? ATK");
            }
    	list.add(s);
    }
    
    @Override
    public void addTypeBox(List<ITextComponent> list)
    {
        IFormattableTextComponent s = new StringTextComponent("[" + getSpecies() + " / ");
        
        if(getMonsterType() != null)
        {
            s.append(getMonsterType().name + " / ");
        }
        
        if(getIsPendulum())
        {
            s.append("Pendulum" + " / ");
        }
        
        if(getIsEvolution())
        {
            s.append("Evolution" + " / ");
        }
        
        if(getAbility() != null && !getAbility().isEmpty())
        {
            s.append(getAbility() + " / ");
        }
        
        if(getHasEffect())
        {
            s.append("Effect");
        }
        else
        {
            s.append("Normal");
        }
        
        s.append("]");
        
        list.add(s);
    }
    
    @Override
    public void addRushHeader(List<ITextComponent> list) 
    {
    	if(getHasEffect()) 
    	{
    		super.addRushHeader(list);
    	}
    	else 
    	{
    		
    	}
    }
    
    // -- Tooltip Formatting --
    
    @Override
    public void addTooltipTypeBox(List<ITextComponent> list)
    {
    	IFormattableTextComponent s = new StringTextComponent("[" + getType().name + "/" + getSpecies() + "/");
    	if(getMonsterType() != null)
        {
            s.append(getMonsterType().name + "/");
        }
        if(getIsPendulum())
        {
            s.append("Pendulum" + "/");
        }
        if(getIsEvolution())
        {
            s.append("Evolution" + "/");
        }
        if(getAbility() != null && !getAbility().isEmpty())
        {
            s.append(getAbility() + "/");
        }
        if(getHasEffect())
        {
            s.append("Effect");
        }
        else
        {
            s.append("Normal");
        }
    	s.append("]");
    	list.add(s);
    }
    
    @Override
    public void addTooltipHeader(List<ITextComponent> list)
    {
    	super.addTooltipHeader(list);
    	
        if(getIsPendulum())
        {
        	addTooltipPendulum(list);
        }
        if(getIsEvolution()) 
        {
        	addTooltipEvolution(list);
        }
    }
    
    @Override
    public void addTooltipBattleStats(List<ITextComponent> list) 
    {
    	if(getIsMaximumCenter())
        {
    		addTooltipMaximumAtk(list);
        }
    	addTooltipMonsterStats(list);
    }
    
    public void addTooltipMonsterStats(List<ITextComponent> list)
    {
    	IFormattableTextComponent statLine = new StringTextComponent("").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED));
    	IFormattableTextComponent atkSymbol = new StringTextComponent("🗡 ");
    	statLine.append(atkSymbol);
    	if(getAtk() >= 0)
            {
    			statLine.append(getAtk() + " ATK");
            }
        else
            {
        		statLine.append("? ATK");
            }
    	list.add(statLine);
    }
    
    public void addTooltipPendulum(List<ITextComponent> list)
    {
    	IFormattableTextComponent pScaleL = new StringTextComponent("◀ " + getPendulumScaleLeftBlue() + " ").setStyle(Style.EMPTY.applyFormat(TextFormatting.BLUE));
    	IFormattableTextComponent pScaleR = new StringTextComponent("▶ " + getPendulumScaleRightRed() + " ").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED));
        pScaleL.append(new TranslationTextComponent("cardProperty." + YDM.MOD_ID + ".pscale"));
        pScaleR.append(new TranslationTextComponent("cardProperty." + YDM.MOD_ID + ".pscale"));
        
    	list.add(pScaleL);
    	list.add(pScaleR);
    }
    
    public void addTooltipMaximumAtk(List<ITextComponent> list)
    {
    	IFormattableTextComponent s = new StringTextComponent("").setStyle(Style.EMPTY.applyFormat(TextFormatting.GOLD));
        IFormattableTextComponent maximumAtkSymbol = new StringTextComponent("🗡 ");
        s.append(maximumAtkSymbol);
    	if(getMaximumAtk() >= 0)
            {
    			s.append(getMaximumAtk() + " MAXIMUM ATK");
            }
            else
            {
            	s.append("? MAXIMUM ATK");
            }
    	list.add(s);
    }
    
    public void addTooltipEvolution(List<ITextComponent> list)
    {
    	list.add(new StringTextComponent("Stage" + getEvolutionStage()));
    }
    
    // --- CardColor ---
    
    @Override
    public CardColor getDefaultCardColor() 
    {
    	CardColor defaultColor = null;
    	if(getCardColor() == null) 
    	{
    		if(getIsNormal()) 
        	{
    			defaultColor = CardColor.NORMAL_YELLOW;
        	}
        	else if(getIsEffect() || getIsMaximum()) 
        	{
        		defaultColor = CardColor.EFFECT_ORANGE;
        	}
        	else if(getIsFusion()) 
        	{
        		defaultColor = CardColor.FUSION_PURPLE;
        	}
        	else if(getIsRitual()) 
        	{
        		defaultColor = CardColor.RITUAL_BLUE;
        	}
        	else if(getIsSynchro()) 
        	{
        		defaultColor = CardColor.SYNCHRO_WHITE;
        	}
        	else if(getIsXyz()) 
        	{
        		defaultColor = CardColor.XYZ_BLACK;
        	}
        	else if(getIsLink()) 
        	{
        		defaultColor = CardColor.LINK_BLUE;
        	}
        	else if(getIsToken()) 
        	{
        		defaultColor = CardColor.TOKEN_GRAY;
        	}
        	else if(getIsEvolution()) 
        	{
        		defaultColor = CardColor.RED;
        	}
    	}
    	else 
    	{
    		defaultColor = CardColor.LIGHT_GRAY;
    	}
    	return defaultColor;
    }
    
    // --- Getters ---
    
    public int getAtk()
    {
        return atk;
    }
    
    public String getSpecies()
    {
        return species;
    }
    
    public MonsterType getMonsterType()
    {
        return monsterType;
    }
    
    public boolean getIsPendulum()
    {
        return isPendulum;
    }
    
    public String getAbility()
    {
        return ability;
    }
    
    public boolean getHasEffect()
    {
        return hasEffect;
    }
    
    public String getPendulumText()
    {
        return pendulumText;
    }
    
    public byte getPendulumScaleLeftBlue()
    {
        return pendulumScaleLeftBlue;
    }
    
    public byte getPendulumScaleRightRed()
    {
        return pendulumScaleRightRed;
    }
    
    public boolean getIsDeckmaster()
    {
        return isDeckmaster;
    }
    
    public String getDeckmasterText()
    {
        return deckmasterText;
    }
    
    public boolean getIsMaximumCenter()
    {
        return isMaximumCenter;
    }
    
    public int getMaximumAtk()
    {
        return maximumAtk;
    }
    
    public boolean getIsEvolution()
    {
        return isEvolution;
    }
    
    public String getEvolutionText()
    {
        return evolutionText;
    }
    
    public byte getEvolutionStage()
    {
        return evolutionStage;
    }
}
