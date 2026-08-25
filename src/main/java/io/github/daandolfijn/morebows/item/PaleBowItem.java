package io.github.daandolfijn.morebows.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.Nullable;

public class PaleBowItem extends BowItem {

    public PaleBowItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    protected void shootProjectile(LivingEntity shooter, Projectile projectileEntity, int index, float power, float uncertainty, float angle, @Nullable LivingEntity targetOverride) {
        float speedMultiplier = 2.0F;
        projectileEntity.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, power * speedMultiplier, uncertainty);
    }
}