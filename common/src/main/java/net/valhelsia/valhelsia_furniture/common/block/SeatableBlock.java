package net.valhelsia.valhelsia_furniture.common.block;

import net.valhelsia.valhelsia_furniture.common.entity.SeatEntity;

/**
 * @author Valhelsia Team
 * @since 2022-11-08
 */
public interface SeatableBlock {

    SeatEntity.EjectType getEjectType();
}
