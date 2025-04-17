package de.cas_ual_ty.ydm.card.properties;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.cas_ual_ty.ydm.util.JsonKeys;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;

public class SkillProperties extends Properties 
{
	public SkillType skillType;
	public String character;
	public String skillActivation;
	public String skillEffect;
	
	// Only if getSkillType() == SkillType.LINK;
	public List<LinkArrow> linkArrows;
    
    public SkillProperties(Properties p0, JsonObject j)
    {
        super(p0);
        readSkillProperties(j);
    }
    
    public SkillProperties(Properties p0)
    {
        super(p0);
        
        if(p0 instanceof SkillProperties)
        {
            SkillProperties p1 = (SkillProperties) p0;
            skillType = p1.skillType;
            character = p1.character;
            skillActivation = p1.skillActivation;
            skillEffect = p1.skillEffect;
            
            if(p1.getIsLink())
            {
            	linkArrows = p1.linkArrows;
            }
        }
    }
    
    public SkillProperties()
    {
    }
    
    public boolean getIsLink()
    {
        return getSkillType() == SkillType.LINK;
    }
    
    @Override
    public void readAllProperties(JsonObject j)
    {
        super.readAllProperties(j);
        readSkillProperties(j);
    }
    
    @Override
    public void writeAllProperties(JsonObject j)
    {
        super.writeAllProperties(j);
        writeSkillProperties(j);
    }
    
    public void readSkillProperties(JsonObject j)
    {
    	skillType = SkillType.fromString(j.get(JsonKeys.SKILL_TYPE).getAsString());
        character = j.get(JsonKeys.CHARACTER).getAsString();
        if(j.has(JsonKeys.SKILL_ACTIVATION))
        {
        	skillActivation = j.get(JsonKeys.SKILL_ACTIVATION).getAsString();
        }
        else
        {
        	skillActivation = null;
        }
        if(j.has(JsonKeys.SKILL_EFFECT))
        {
        	skillEffect = j.get(JsonKeys.SKILL_EFFECT).getAsString();
        }
        else
        {
        	skillEffect = null;
        }
        
        if(getIsLink())
        {
        	JsonArray linkArrows = j.get(JsonKeys.LINK_ARROWS).getAsJsonArray();
            this.linkArrows = new ArrayList<>(linkArrows.size());
            for(JsonElement linkArrow : linkArrows)
            {
                this.linkArrows.add(LinkArrow.fromString(linkArrow.getAsString()));
            }
        }
    }
    
    public void writeSkillProperties(JsonObject j)
    {
        j.addProperty(JsonKeys.SKILL_TYPE, skillType.name);
        j.addProperty(JsonKeys.CHARACTER, character);
        j.addProperty(JsonKeys.SKILL_ACTIVATION, skillActivation);
        j.addProperty(JsonKeys.SKILL_EFFECT, skillEffect);
        
        if(getIsLink())
        {
        	JsonArray linkArrows = new JsonArray();
            for(LinkArrow linkArrow : this.linkArrows)
            {
                linkArrows.add(linkArrow.name);
            }
            j.add(JsonKeys.LINK_ARROWS, linkArrows);
        }
    }
    
    @Override
    public boolean getIsInExtraDeck()
    {
        return true;
    }
    
    @Override
    public void addText(List<ITextComponent> list)
    {
    	if (getIsLink()) {
    		addLinkMarkers(list);
    		list.add(StringTextComponent.EMPTY);
    	}
        super.addText(list);
        if(getSkillActivation() != null && !getSkillActivation().isEmpty()) 
        {
        	list.add(new StringTextComponent("[ SKILL ACTIVATION ]").setStyle(Style.EMPTY.applyFormat(TextFormatting.BOLD)));
        	list.add(new StringTextComponent(getSkillActivation()));
        	list.add(StringTextComponent.EMPTY);
        }
        if(getSkillEffect() != null && !getSkillEffect().isEmpty()) 
        {
        	list.add(new StringTextComponent("[ SKILL EFFECT ]").setStyle(Style.EMPTY.applyFormat(TextFormatting.BOLD)));
        	list.add(new StringTextComponent(getSkillEffect()));
        }
        
    }
    
    @Override
    public void addCardType(List<ITextComponent> list)
    {
    	if(getSkillType() != null)
        {
            list.add(new StringTextComponent(getSkillType().name + " " + getType().name));
        }
    	else
        {
            list.add(new StringTextComponent("Normal " + getType().name));
        }
    }
    
    @Override
    public void addCardAttribute(List<ITextComponent> list)
    {
    	IFormattableTextComponent s = new StringTextComponent("");
    	if(getAttribute() != null)
        {
            s.append(getAttribute());
        }
    	else
    	{
    		s.append("SKILL");
    	}
    	
    	list.add(s);
    }
    
    @Override
    public void addTypeBox(List<ITextComponent> list)
    {
        IFormattableTextComponent s = new StringTextComponent("[" + getCharacter() + " / ");
        
        if(getSkillType() != null)
        {
            s.append(getSkillType().name + " / ");
        }
        
        s.append("Skill"); //Might put more conditions, or extra things, depends on how I explore design in Custom Skills.
        
        s.append("]");
        
        list.add(s);
    }
    
    public void addLinkMarkers(List<ITextComponent> list)
    {
        list.addAll(LinkArrow.buildSymbolsString(getLinkArrows(), TextFormatting.DARK_GRAY, TextFormatting.RED, "  "));
    }
    
    // -- Tooltip Formatting --
    
    @Override
    public void addTooltipTypeBox(List<ITextComponent> list)
    {
        IFormattableTextComponent s = new StringTextComponent("[" + getCharacter() + "/");
        if(getSkillType() != null)
        {
            s.append(getSkillType().name + "/");
        }
        s.append("Skill");
        s.append("]");
        list.add(s);
    }
    
    // --- Getters ---
    
    public SkillType getSkillType()
    {
        return skillType;
    }
    
    public String getCharacter()
    {
        return character;
    }
    
    public List<LinkArrow> getLinkArrows()
    {
        return linkArrows;
    }
    
    public String getSkillActivation()
    {
        return skillActivation;
    }
    
    public String getSkillEffect()
    {
        return skillEffect;
    }
    
}