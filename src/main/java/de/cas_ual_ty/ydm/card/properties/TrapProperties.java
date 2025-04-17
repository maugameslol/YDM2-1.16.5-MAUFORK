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

public class TrapProperties extends Properties
{
    public TrapType trapType;
    
    // Only if getTrapType() == TrapType.LINK;
    public List<LinkArrow> linkArrows;
    
    public TrapProperties(Properties p0, JsonObject j)
    {
        super(p0);
        readTrapProperties(j);
    }
    
    public TrapProperties(Properties p0)
    {
        super(p0);
        
        if(p0 instanceof TrapProperties)
        {
            TrapProperties p1 = (TrapProperties) p0;
            trapType = p1.trapType;
            
            if(p1.getIsLink())
            {
            	linkArrows = p1.linkArrows;
            }
        }
    }
    
    public TrapProperties()
    {
    }
    
    public boolean getIsLink()
    {
        return getTrapType() == TrapType.LINK;
    }
    
    public boolean getIsNormal()
    {
        return getTrapType() == TrapType.NORMAL;
    }
    
    @Override
    public void readAllProperties(JsonObject j)
    {
        super.readAllProperties(j);
        readTrapProperties(j);
    }
    
    @Override
    public void writeAllProperties(JsonObject j)
    {
        super.writeAllProperties(j);
        writeTrapProperties(j);
    }
    
    public void readTrapProperties(JsonObject j)
    {
        trapType = TrapType.fromString(j.get(JsonKeys.TRAP_TYPE).getAsString());
        
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
    
    public void writeTrapProperties(JsonObject j)
    {
        j.addProperty(JsonKeys.TRAP_TYPE, trapType.name);
        
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
        addTrapHeader(list);
    }
    */
    
    @Override
    public void addCardType(List<ITextComponent> list)
    {
        list.add(new StringTextComponent(getTrapType().name + " " + getType().name));
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
    		s.append("TRAP");
    	}
    	
    	/*
    	if(getTrapType() != null)
        {
            s.append(" / " + getTrapType().name + " Trap");
        }
    	else 
    	{
    		s.append(" / Normal Trap");
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
    	IFormattableTextComponent s = new StringTextComponent("[Trap Card");
    	
    	if (!getIsNormal()) 
    	{
    		s.append(" / " + getTrapType().name + "]");
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
    		s.append("/" + getTrapType().name + "]");
    	}
    	else 
    	{
    		s.append("]");
    	}
    	list.add(s);
    }
    
    // --- Getters ---
    
    public TrapType getTrapType()
    {
        return trapType;
    }
    
    public List<LinkArrow> getLinkArrows()
    {
        return linkArrows;
    }
}
