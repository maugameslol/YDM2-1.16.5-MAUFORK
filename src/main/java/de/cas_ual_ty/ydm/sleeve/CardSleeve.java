package de.cas_ual_ty.ydm.sleeve;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import de.cas_ual_ty.ydm.util.JsonKeys;

public class CardSleeve {
	// TODO: Add the ability for card sleeves to use the database
	public String name;
    public String code;
    public boolean isCustom;
    public String type;
    public String text;
    public String image;
    public String[] designers;
    
    public void readProperties(JsonObject j)
    {
        name = j.get(JsonKeys.NAME).getAsString();
        code = j.get(JsonKeys.CODE).getAsString();
        if(j.has(JsonKeys.IS_CUSTOM))
        {
        	isCustom = j.get(JsonKeys.IS_CUSTOM).getAsBoolean();
        }
        else
        {
        	isCustom = false;
        }
        type = j.get(JsonKeys.TYPE).getAsString();
        text = j.get(JsonKeys.TEXT).getAsString();
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
}
