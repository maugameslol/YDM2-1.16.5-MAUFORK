package de.cas_ual_ty.ydm.sleeve;

import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import de.cas_ual_ty.ydm.YDM;
import de.cas_ual_ty.ydm.util.JsonKeys;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class SleeveProperties {
	public static final SleeveProperties DUMMY = new SleeveProperties("Dummy Sleeves", "DUMMY") {
        @Override
        public String getImageName()
        {
            return "blanc_sleeve";
        }
        
        @Override
        public boolean getIsHardcoded()
        {
            return true;
        }
    };
    
	public String name;
	public String code;
	public String image;
	public String[] designers;
	
	public SleeveProperties(String name, String code)
    {
        this.name = name;
        this.code = code;
    }
	
	public void postDBInit()
    {
        
    }
	
	public SleeveProperties(JsonObject j)
    {
		name = j.get(JsonKeys.NAME).getAsString();
		code = j.get(JsonKeys.CODE).getAsString();
		if(!j.has(JsonKeys.IMAGE))
        {
            image = null;
        }
        else
        {
            image = j.get(JsonKeys.IMAGE).getAsString();
        }
		if(j.has(JsonKeys.DESIGNERS))
        {
        	JsonArray designers = j.get(JsonKeys.DESIGNERS).getAsJsonArray();
            this.designers = new String[designers.size()];
            for(int i = 0; i < this.designers.length; ++i)
            {
                this.designers[i] = designers.get(i).getAsString();
            }
        }
        else
        {
        	designers = null;
        }
    }
	
	public void addItemInformation(List<ITextComponent> tooltip)
    {
        tooltip.add(new StringTextComponent(name + " Sleeves"));
    }
    
    public void addInformation(List<ITextComponent> tooltip)
    {
        tooltip.add(new StringTextComponent(name + " Sleeves"));
    }
	
	// -- Getters --
	
	public String getImageName()
    {
        return code.toLowerCase();
    }
	public String getImageURL()
    {
        return image;
    }
	
	public String getInfoImageName()
    {
        return YDM.proxy.addSleeveInfoTag(getImageName());
    }
    
    public String getItemImageName()
    {
        return YDM.proxy.addSleeveItemTag(getImageName());
    }
    
    public ResourceLocation getInfoImageResourceLocation()
    {
        return new ResourceLocation(YDM.MOD_ID, "textures/item/" + YDM.proxy.getSleeveInfoReplacementImage(this) + ".png");
    }
	
	public ResourceLocation getItemImageResourceLocation()
    {
        return new ResourceLocation(YDM.MOD_ID, "item/" + getItemImageName());
    }
	
	public boolean getIsHardcoded()
    {
        return false;
    }
}
