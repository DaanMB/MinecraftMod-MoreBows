package io.github.daandolfijn.morebows.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import org.jspecify.annotations.Nullable;

public class BasaltBowItem extends BowItem {

    public BasaltBowItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void shootProjectile(LivingEntity shooter, Projectile projectileEntity, int index, float power, float uncertainty, float angle, @Nullable LivingEntity targetOverride) {
        super.shootProjectile(shooter, projectileEntity, index, power, uncertainty, angle, targetOverride);
        BasaltArrowTrail.track(projectileEntity.getUUID());
    }
}