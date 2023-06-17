package net.valhelsia.valhelsia_furniture.common.block;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

/**
 * @author Valhelsia Team - stal111
 * @since 2023-06-17
 */
public interface FurnitureBlock {

    Type getType();

    enum Type implements StringRepresentable {
        TABLE("table");

        private final String name;

        Type(String name) {
            this.name = name;
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.name;
        }
    }
}
