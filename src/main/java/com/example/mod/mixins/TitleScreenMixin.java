package com.example.mod.mixins;

import com.ultreon.craft.render.gui.screens.TitleScreen;
import com.example.mod.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Inject(method = "show", at = @At("HEAD"))
    public void exampleMod$injectShow(CallbackInfo ci) {
        Main.INSTANCE.getLogger().info("Hello from Mixin!");
    }
}
