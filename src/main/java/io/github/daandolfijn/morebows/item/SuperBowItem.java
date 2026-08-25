package io.github.daandolfijn.morebows.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class SuperBowItem extends BowItem {
    public static final int DRAW_DURATION = 10;

    public SuperBowItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void shootProjectile(LivingEntity shooter, Projectile projectileEntity, int index, float power, float uncertainty, float angle, @Nullable LivingEntity targetOverride) {
        float speedMultiplier = 2.0F;
        projectileEntity.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, power * speedMultiplier, uncertainty);
    }

    @Override
    public boolean releaseUsing(ItemStack itemStack, Level level, LivingEntity entity, int remainingTime) {
        if (!(entity instanceof Player player)) return false;

        ItemStack projectile = player.getProjectile(itemStack);
        if (projectile.isEmpty()) return false;

        int timeHeld = this.getUseDuration(itemStack, entity) - remainingTime;
        float pow = getPowerForTime(timeHeld);
        if (pow < 0.1F) return false;

        List<ItemStack> firedProjectiles = draw(itemStack, projectile, player);
        if (level instanceof ServerLevel serverLevel && !firedProjectiles.isEmpty()) {
            this.shoot(serverLevel, player, player.getUsedItemHand(), itemStack, firedProjectiles,
                    pow * 3.0F, 1.0F, pow == 1.0F, null);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT,
                SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + pow * 0.5F);
        player.awardStat(Stats.ITEM_USED.get(this));
        return true;
    }

    public static float getPowerForTime(int timeHeld) {
        float pow = (float) timeHeld / DRAW_DURATION;
        pow = (pow * pow + pow * 2.0F) / 3.0F;
        return Math.min(pow, 1.0F);
    }
}
