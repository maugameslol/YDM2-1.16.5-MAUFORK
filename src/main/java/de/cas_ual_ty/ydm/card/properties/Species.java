package de.cas_ual_ty.ydm.card.properties;

public enum Species
{
	// TCG/OCG
    AQUA("Aqua"), BEAST("Beast"), BEAST_WARRIOR("Beast-Warrior"), CREATOR_GOD("Creator-God"), CYBERSE("Cyberse"), DINOSAUR("Dinosaur"), DIVINE_BEAST("Divine-Beast"), DRAGON("Dragon"), FAIRY("Fairy"), FIEND("Fiend"), FISH("Fish"), ILLUSION("Illusion"), INSECT("Insect"), MACHINE("Machine"), PLANT("Plant"), PSYCHIC("Psychic"), PYRO("Pyro"), REPTILE("Reptile"), ROCK("Rock"), SEA_SERPENT("Sea Serpent"), SPELLCASTER("Spellcaster"), THUNDER("Thunder"), WARRIOR("Warrior"), WINGED_BEAST("Winged Beast"), WYRM("Wyrm"), ZOMBIE("Zombie"),
    // RUSH
    CELESTIAL_WARRIOR("Celestial Warrior"), CYBORG("Cyborg"), GALAXY("Galaxy"), HIGH_DRAGON("High Dragon"), MAGICAL_KNIGHT("Magical Knight"), OMEGA_PSYCHIC("Omega Psychic"),
    // VG
    IMMORTAL("Immortal");
    
    public final String name;
    
    Species(String name)
    {
        this.name = name;
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
