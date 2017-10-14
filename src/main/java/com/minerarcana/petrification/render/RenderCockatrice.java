package com.minerarcana.petrification.render;

import com.minerarcana.petrification.entity.EntityCockatrice;
import com.minerarcana.petrification.model.ModelCockatrice;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.minerarcana.petrification.Petrification.MODID;

public class RenderCockatrice extends RenderLiving<EntityCockatrice> {
    private static final ResourceLocation texture = new ResourceLocation(MODID, "textures/mob/cockatrice.png");

    public RenderCockatrice(RenderManager renderManager) {
        super(renderManager, new ModelCockatrice(), 0.3F);
    }

    @Override
    protected float handleRotationFloat(EntityCockatrice livingBase, float partialTicks) {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(@Nonnull EntityCockatrice entity) {
        return texture;
    }
}
