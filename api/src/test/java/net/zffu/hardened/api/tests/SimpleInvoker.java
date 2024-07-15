package net.zffu.hardened.api.tests;

import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;

/**
 * Used in tests
 */
public class SimpleInvoker implements CommandInvoker {

    public InvokerType type;

    public SimpleInvoker(InvokerType type) {
        this.type = type;
    }

    @Override
    public InvokerType getType() {
        return this.type;
    }
}
