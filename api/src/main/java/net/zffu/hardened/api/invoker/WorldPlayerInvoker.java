package net.zffu.hardened.api.invoker;

/**
 * <p>Represents a fully world player invoker.</p>
 * <p>Contains every {@link CommandInvoker} access with a few more unique to players.</p>
 * <p>This isn't only Proxy players but represent players with access to positions being impossible.</p>
 */
public interface WorldPlayerInvoker extends BasePlayerInvoker {

    void teleport(double x, double y, double z);

    void kill();

    double getX();

    double getY();

    double getZ();

}
