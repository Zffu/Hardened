# Hardened
[![MIT License](https://img.shields.io/badge/license-MIT-blue)](LICENSE)

A Minecraft Command API that aims to support most platforms.

### Supported Platforms
- Spigot

## Contributions

Any contribution is greatly appreciated, before actually making your pull request make sure that everything works like intended.

Requirements to contribute:
- Java JDK 8 (for API and Spigot Implementation)
- IntelliJ Idea (Recommended)

## Usage
Every single command in Hardened is represented through a `Command` implementation.

Hardened also uses a Command validator system which allows you to easily add conditions in order to run your command.

### Creating a command using the builder
The fastest way to make a command is by using the `CommandBuilder` class.

#### Basics
Here's an example on how to create a new `CommandBuilder`:
```java
CommandBuilder builder = new CommandBuilder("test");
```
This will create a command builder for the command named "test"

#### Command Properties
You can also add properties such as aliases like this:
```java
builder.aliases("myTestCommand", "test2");
```
This will add the aliases "myTestCommand" and "test2" to the builder created.

#### Add Validator Nodes
You can have multiple validators of the same time (for example multiple permission nodes).

The builder directly allows you to add validation nodes into your command.

For example, you could make your command require the invoker to be a player and to have the "test.permission" like this:
```java
builder.type(InvokerType.PLAYER).permission("test.permission");
```

#### Adding Arguments
In order to add arguments to your command you can use the `Arguments` class to generate the arguments.

For example lets make a string argument.
```java
builder.argument(Arguments.string());
```

To make the argument optional simply do that instead:
```java
builder.argument(Arguments.string().optional(true));
```

**INFO:** Arguments are required by default.

#### Make the command do something
In order to make the command do something, you can use the `execute` builder function.

In this example, we make the command send "hello (argument 1)" to the player who executed the command (for Spigot):
```java
builder.execute((ctx) -> (((PlayerInvoker)ctx.getInvoker()).getPlayer()).sendMessage("Hello " + ctx.get(0, String.class)))
```

#### Building the command
In order to convert your `CommandBuilder` into a usable `Command`, you can simply do:
```java
builder.build();
```

### Registering the command
In order to register commands, you will need a `CommandRegistrar`. Each Hardened platform implementation comes with one that is made for that platform.

Here is how to create a basic `CommandRegistrar` for Spigot:
```java
public class MyPlugin extends JavaPlugin {
    
    private CommandRegistar registrar;
    
    @Override
    public void onEnable() {
     this.registrar = new SpigotCommandRegistrar(this);   
    }
    
    //...
}
```

**WARN:** Some features such as aliases are not supported by every `CommandRegistrar`

Once you have your registrar, you can simply register a command like this:
```java
registar.register(myCommand);
```