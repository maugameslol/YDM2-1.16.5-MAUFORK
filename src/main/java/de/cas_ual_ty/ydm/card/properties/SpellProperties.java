package de.cas_ual_ty.ydm.card.properties;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.cas_ual_ty.ydm.util.JsonKeys;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;
import java.util.List;

public class SpellProperties extends Properties
{
	public SpellType spellType;
    
    // Only if isLink = true / getSpellType() == SpellType.LINK;
    public List<LinkArrow> linkArrows;
    
    public SpellProperties(Properties p0, JsonObject j)
    {
        super(p0);
        readSpellProperties(j);
    }
    
    public SpellProperties(Properties p0)
    {
        super(p0);
        
        if(p0 instanceof SpellProperties)
        {
            SpellProperties p1 = (SpellProperties) p0;
            spellType = p1.spellType;
            
            if(p1.getIsLink())
            {
            	linkArrows = p1.linkArrows;
            }
        }
    }
    
    public SpellProperties()
    {
    }
    
    public boolean getIsLink()
    {
        return getSpellType() == SpellType.LINK;
    }
    
    public boolean getIsNormal()
    {
        return getSpellType() == SpellType.NORMAL;
    }
    
    @Override
    public void readAllProperties(JsonObject j)
    {
        super.readAllProperties(j);
        readSpellProperties(j);
    }
    
    @Override
    public void writeAllProperties(JsonObject j)
    {
        super.writeAllProperties(j);
        writeSpellProperties(j);
    }
    
    public void readSpellProperties(JsonObject j)
    {
        spellType = SpellType.fromString(j.get(JsonKeys.SPELL_TYPE).getAsString());
        
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
    
    public void writeSpellProperties(JsonObject j)
    {
    	j.addProperty(JsonKeys.SPELL_TYPE, spellType.name);
        
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
    
    /*
    @Override
    public void addHeader(List<ITextComponent> list)
    {
        super.addHeader(list);
    }
    */
    
    @Override
    public void addCardType(List<ITextComponent> list)
    {
        list.add(new StringTextComponent(getSpellType().name + " " + getType().name));
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
    		s.append("SPELL");
    	}
    	
    	/*
    	if(getSpellType() != null)
        {
            s.append(" / " + getSpellType().name + " Spell");
        }
    	else 
    	{
    		s.append(" / Normal Spell");
    	}
    	*/
    	
    	list.add(s);
    }
    
    @Override
    public void addText(List<ITextComponent> list)
    {
    	if (getIsLink()) {
    		addLinkMarkers(list);
    		list.add(StringTextComponent.EMPTY);
    	}
        super.addText(list);
    }
    
    @Override
    public void addTypeBox(List<ITextComponent> list)
    {
    	IFormattableTextComponent s = new StringTextComponent("[Spell Card");
    	
    	if (!getIsNormal()) 
    	{
    		s.append(" / " + getSpellType().name + "]");
    	}
    	else 
    	{
    		s.append("]");
    	}
    	
    	list.add(s);
    }
    
    public void addLinkMarkers(List<ITextComponent> list)
    {
        //        list.add(this.linkArrows.stream().map((arrow) -> arrow.name).collect(Collectors.joining(", ")));
        list.addAll(LinkArrow.buildSymbolsString(getLinkArrows(), TextFormatting.DARK_GRAY, TextFormatting.RED, "  "));
    }
    
    // -- Tooltip Formatting --
    
    @Override
    public void addTooltipTypeBox(List<ITextComponent> list)
    {
    	IFormattableTextComponent s = new StringTextComponent("[" + getType().name);
    	if (!getIsNormal()) 
    	{
    		s.append("/" + getSpellType().name + "]");
    	}
    	else 
    	{
    		s.append("]");
    	}
    	list.add(s);
    }
    
    // --- Getters ---
    
    public SpellType getSpellType()
    {
        return spellType;
    }
    
    public List<LinkArrow> getLinkArrows()
    {
        return linkArrows;
    }
}
