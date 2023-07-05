package net.valhelsia.valhelsia_furniture.common.block.properties;

import net.minecraft.data.models.model.ModelTemplate;
import org.jetbrains.annotations.Nullable;

/**
 * @author Valhelsia Team
 * @since 2022-10-25
 */
public interface CurtainPart {

    String getName();

    boolean isSingle();
    boolean isBottomOrSingle();
    boolean isTopOrSingle();
    boolean isSingleRow();

    String getTopTexture();
    String getBottomTexture();

    @Nullable ModelTemplate getModelTemplate();

    default String getModelName() {
        return "_".concat(this.getName());
    }

    //TODO REMOVE
    enum ModelType {
        CURTAIN("template_curtain"),
        CURTAIN_MIRRORED("template_curtain_mirrored"),
        CURTAIN_FULL("template_curtain_full"),
        CURTAIN_FULL_MIRRORED("template_curtain_full_mirrored"),
        CURTAIN_BRACKET("curtain_bracket");

        private final String name;

        ModelType(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
