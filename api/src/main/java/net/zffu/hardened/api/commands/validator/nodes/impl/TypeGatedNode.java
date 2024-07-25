package net.zffu.hardened.api.commands.validator.nodes.impl;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.validator.nodes.ValidatorNode;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.InvokerType;

import java.util.Arrays;
import java.util.List;

/**
 * A {@link ValidatorNode} that only lets Invokers with specific types to run the command.
 * @since 1.0.0
 * @see {@link InvokerType}
 */
public class TypeGatedNode implements ValidatorNode {

    private List<InvokerType> allowedTypes;

    public TypeGatedNode(InvokerType... types) {
        this.allowedTypes = Arrays.asList(types);
    }

    @Override
    public boolean validate(Command command, CommandContext ctx) {
        if(this.allowedTypes.contains(ctx.getInvoker().getType())) return true;
        return false;
    }
}
