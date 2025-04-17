package de.cas_ual_ty.ydm.card.properties;

public enum Species
{
    AQUA("Aqua"), BEAST("Beast"), BEAST_WARRIOR("Beast-Warrior"), CREATOR_GOD("Creator-God"), CYBERSE("Cyberse"), DINOSAUR("Dinosaur"), DIVINE_BEAST("Divine-Beast"), DRAGON("Dragon"), FAIRY("Fairy"), FIEND("Fiend"), FISH("Fish"), ILLUSION("Illusion"), INSECT("Insect"), MACHINE("Machine"), PLANT("Plant"), PSYCHIC("Psychic"), PYRO("Pyro"), REPTILE("Reptile"), ROCK("Rock"), SEA_SERPENT("Sea Serpent"), SPELLCASTER("Spellcaster"), THUNDER("Thunder"), WARRIOR("Warrior"), WINGED_BEAST("Winged Beast"), WYRM("Wyrm"), ZOMBIE("Zombie"),
    CELESTIAL_WARRIOR("Celestial Warrior"), CYBORG("Cyborg"), GALAXY("Galaxy"), HIGH_DRAGON("High Dragon"), MAGICAL_KNIGHT("Magical Knight"), OMEGA_PSYCHIC("Omega Psychic"),
    DESTROYER_GOD("Destroyer God", true), WARRIOR_GOD("Warrior God", true);
    
    public final String name;
    
    Species(String name)
    {
        this.name = name;
    }
    
    Species(String name, boolean custom)
    {
        this(name);
        // not sure if I am going to use the custom parameter
        // this is for custom cards
    }
    
    public static final Species[] VALUES = Species.values();
    
    public static Species fromString(String s)
    {
        for(Species species : Species.VALUES)
        {
            if(species.name.equals(s))
            {
                return species;
            }
        }
        
        return null;
    }
}
