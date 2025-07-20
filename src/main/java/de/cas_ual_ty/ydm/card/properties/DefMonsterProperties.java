package de.cas_ual_ty.ydm.card.properties;

import com.google.gson.JsonObject;
import de.cas_ual_ty.ydm.util.JsonKeys;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class DefMonsterProperties extends MonsterProperties
{
    public int def;
    
    public DefMonsterProperties(Properties p0, JsonObject j)
    {
        super(p0);
        readDefMonsterProperties(j);
    }
    
    public DefMonsterProperties(Properties p0)
    {
        super(p0);
        
        if(p0 instanceof DefMonsterProperties)
        {
            DefMonsterProperties p1 = (DefMonsterProperties) p0;
            def = p1.def;
        }
    }
    
    public DefMonsterProperties()
    {
    }
    
    @Override
    public void readAllProperties(JsonObject j)
    {
        super.readAllProperties(j);
        readDefMonsterProperties(j);
    }
    
    @Override
    public void writeAllProperties(JsonObject j)
    {
        super.writeAllProperties(j);
        writeDefProperties(j);
    }
    
    public void readDefMonsterProperties(JsonObject j)
    {
        def = j.get(JsonKeys.DEF).getAsInt();
    }
    
    public void writeDefProperties(JsonObject j)
    {
        j.addProperty(JsonKeys.DEF, def);
    }
    
    @Override
    public void addMonsterStats(List<ITextComponent> list)
    {
    	IFormattableTextComponent atkSymbol = new StringTextComponent("🗡").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED));
    	IFormattableTextComponent defSymbol = new StringTextComponent("🛡").setStyle(Style.EMPTY.applyFormat(TextFormatting.BLUE));
    	IFormattableTextComponent s = new StringTextComponent("");
    	
    	s.append(atkSymbol);
    	if(getAtk() >= 0)
        {
    		s.append(getAtk() + " ATK / ");
        }
        else
        {
            s.append("? ATK / ");
        }
    	
    	s.append(defSymbol);
    	if(getDef() >= 0)
        {
    		s.append(getDef() + " DEF");
        }
        else
        {
            s.append("? DEF");
        }
    	
    	list.add(s);
        //list.add(new StringTextComponent(getAtk() + " ATK / " + getDef() + " DEF"));
    }
    
    // -- Tooltip Formatting --
    
    @Override
    public void addTooltipMonsterStats(List<ITextComponent> list)
    {
    	IFormattableTextComponent statLineA = new StringTextComponent("").setStyle(Style.EMPTY.applyFormat(TextFormatting.RED));
    	IFormattableTextComponent statLineD = new StringTextComponent("").setStyle(Style.EMPTY.applyFormat(TextFormatting.BLUE));
    	IFormattableTextComponent atkSymbol = new StringTextComponent("🗡 ");
    	IFormattableTextComponent defSymbol = new StringTextComponent("🛡 ");
    	statLineA.append(atkSymbol);	
    	if(getAtk() >= 0)
            {
    			statLineA.append(getAtk() + " ATK");
            }
        else
            {
        		statLineA.append("? ATK");
            }
    	statLineD.append(defSymbol);
    	if(getDef() >= 0)
        {
    		statLineD.append(getDef() + " DEF");
        }
        else
        {
        	statLineD.append("? DEF");
        }
    	list.add(statLineA);
    	list.add(statLineD);
    }
    
    // --- Getters ---
    
    public int getDef()
    {
        return def;
    }
}
