package gg.wrldmap.unshatteredcore.mixin;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(targets = {
        "net.minecraft.world.inventory.InventoryMenu$1",
        "net.minecraft.world.inventory.InventoryMenu$2"
})
public abstract class NoCraftingSlotMixin extends Slot{
    public NoCraftingSlotMixin(Container container, int slot, int x, int y) {
        super(container, slot, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return false; //nuh uh
    }
}
