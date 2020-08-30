package example.enums;

import java.util.function.Supplier;

public enum Roles implements Supplier<String>{
    ADMIN, MANAGER, USER;

    @Override
    public String get() {
        return this.name().toLowerCase();
    }
}
