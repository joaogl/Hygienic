package us.joaogldarkdeagle.hygienic;

import us.joaogldarkdeagle.hygienic.lib.ModInfo;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class Hygienic {
    
    @Instance("Hygienic")
    public Hygienic instance;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        
    }
    
    @Init
    public void init(FMLInitializationEvent event) {
        
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}
