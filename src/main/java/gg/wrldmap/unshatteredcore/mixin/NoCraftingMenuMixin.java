package gg.wrldmap.unshatteredcore.mixin;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryMenu.class)
public class NoCraftingMenuMixin {
    @Shadow private CraftingContainer craftSlots;
    @Shadow private ResultContainer resultSlots;

    //idk how this works tbh
    @Inject(method = "slotsChanged", at = @At("HEAD"), cancellable = true, remap = true)
    private void disableCrafting(Container inventory, CallbackInfo ci) {
        if (inventory == this.craftSlots) {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
            ci.cancel();
        }
    }
}

