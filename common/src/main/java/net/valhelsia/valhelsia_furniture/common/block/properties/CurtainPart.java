package net.valhelsia.valhelsia_furniture.common.block.properties;

import net.minecraft.util.StringRepresentable;

/**
 * @author Valhelsia Team
 * @since 2022-10-25
 */
public interface CurtainPart extends StringRepresentable {

    String getName();

    boolean isSingle();

    boolean isBottomOrSingle();

    boolean isTopOrSingle();

    boolean isSingleRow();

    String getTopTexture();

    String getBottomTexture();

    default String getModelName() {
        return "_".concat(this.getName());
    }
}
