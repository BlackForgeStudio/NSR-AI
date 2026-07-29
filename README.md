# NSR-AI Open-Source API

![Version](https://img.shields.io/badge/Version-3.5-blue.svg)

This is the official open-source API for the NSR-AI Minecraft Plugin. It allows developers to interact with core NSR-AI functionalities in a safe and controlled manner.

## Installation (Maven)

Add the following to your `pom.xml`:

```xml

<dependencies>
    <dependency>
        <groupId>com.nsr-ai</groupId>
        <artifactId>nsr-ai-api</artifactId>
        <version>3.5</version> <!-- Use the current API version -->
        <scope>provided</scope>
    </dependency>
</dependencies>
```

## New Features in API 3.5

*   **Asynchronous Error Catcher Pipeline (`ErrorCatcher`):** Register error handlers to passively monitor, actively modify, or completely suppress AI API and runtime errors before they reach the player.
*   **Legacy V1 Sub-Package Migration (`com.nsr.ai.api.v1`):** Cleaned up the root API directory by moving all 8 legacy support classes (`AIMessage`, `AIResponse`, `AddonInfo`, etc.) into a dedicated `v1` sub-package for pristine organization and seamless backward compatibility.
*   **Pet Health Modification (`setPetHealth`):** Added the missing programmatic pet health modification endpoint to the API bridge (`NSRaiAPI.setPetHealth`), enabling complete dynamic pet stat manipulation.


<details>
<summary><b>📦 Click to view API 3.0-pre Features</b></summary>

*   **Facade Delegation Architecture:** Seamlessly routes legacy V1/V2 API calls to V3 endpoints, preserving full backward compatibility without breaking existing addons.
*   **Dynamic Pet Stat Manipulation:** Programmatically modify pet attributes (`Bond`, `Mood`, `Hunger`, `Level`, `Health`) to build custom pet training or RPG integrations.
*   **Asynchronous Chat Interceptor Pipeline:** Register middleware (`AIInterceptor`) to inspect, sanitize, modify, or cancel player inputs, AI responses, and system prompts.
*   **Granular AI Request Parameters:** Programmatically inject custom provider settings (`Temperature`, `Top-P`, `Top-K`, `Max Tokens`, `presence_penalty`) per individual AI request.
*   **Live Knowledge Base Bridge (RAG):** Dynamically read, inject, or remove vector knowledge base entries directly from active server memory.
*   **Universal Command Routing (`/aia`):** Effortlessly delegate complex subcommands and tab completions directly to your addon or plugin integration.
*   **Non-Blocking Persistence (`SaveMsg`):** Asynchronously save addon data in JSON, YML, TXT, or DAT formats without blocking the primary server thread.
*   **Native Plugin Integration Builder (`SimpleAddon`):** Standard Bukkit plugins can now natively register as NSR-AI integrations without needing an `addon.yml` manifest.

</details>

## Example: The Easiest Way to Register (SimpleAddon)

With the introduction of the `SimpleAddon` builder and `NSRaiAPI.registerAddon()`, any standard Bukkit plugin can act as an NSR-AI addon natively! 
You no longer need to create an `addon.yml` or place your jar in the `addons` folder. Just do this in your plugin's `onEnable()`:

```java
import com.nsr.ai.api.NSRaiAPI;
import com.nsr.ai.api.SimpleAddon;
import org.bukkit.plugin.java.JavaPlugin;

public class MyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Build your addon in just a few lines
        SimpleAddon myAddon = new SimpleAddon("MyPluginAddon", "1.0", "YourName", "My awesome NSR-AI Integration")
            .setAlias("myplugin") // Users type /aia myplugin ...
            .addFeature("keyword", "Description of what this feature does")
            .addCommand("mycmd", "What this command does")
            .onCommandExecution((player, args) -> {
                player.sendMessage("AI Command executed successfully!");
                return "Handled successfully!";
            });

        // Register it natively via the API as a Plugin Integration!
        NSRaiAPI.registerPlugin(this, myAddon);
    }
}
```

## Advanced Example: Implementing AIAddon (Legacy/Detailed method)

If you need deeper control, you can implement the `AIAddon` interface directly. Because of default methods, you only need to override what you actually use:

```java
import com.nsr.ai.api.AIAddon;
import com.nsr.ai.plugin.NSRAIPlugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.Plugin;

import java.util.Map;
import java.util.HashMap;
import org.bukkit.entity.Player;

public class MyAddon extends JavaPlugin implements AIAddon {

    @Override
    public void onEnable() {
        // You can register yourself!
        com.nsr.ai.api.NSRaiAPI.registerPlugin(this, this);
        getLogger().info("MyAddon enabled!");
    }

    @Override
    public String getName() {
        return getDescription().getName();
    }

    @Override
    public String getVersion() {
        return getDescription().getVersion();
    }

    @Override
    public String getAuthor() {
        return getDescription().getAuthors().get(0);
    }

    @Override
    public String getDescription() {
        return getDescription().getDescription();
    }

    @Override
    public String onCommand(Player player, String[] args) {
        // ... command handling logic
        return null;
    }
}
```

## What's Not Included

This API layer *does not* include any of the proprietary or closed-source features of the main NSR-AI plugin, such as:

*   NPC AI System (Spawning, Pathfinding, Interactions) – Upcoming Feature (Coming Soon)
*   Advanced Memory System for AI Entities – Implemented, currently in testing phase
*   Offline AI integrations (e.g., Ollama, LLaMA, local models)
*   Direct API key expansions for external services (e.g., Gemini, OpenAI, Claude)
*   Scripted or canned response systems

These features remain part of the closed-source NSR-AI plugin.

License Restrictions

*   As per the included LICENSE.txt (MIT with Commons Clause), the following restrictions apply:
*   You may NOT create or redistribute offline AI integrations (e.g., Ollama, LLaMA, local models).
*   You may NOT add or expand API key providers (e.g., Gemini, OpenAI, Claude).
*   Addons may use the API for general purposes only (e.g., custom commands, player stats, conversation improvements).
*   However, you must not attempt to expand its scope with additional API providers, offline modes, or external services.
*   You may NOT create scripted or canned-response systems.
*   You may NOT fork, re-implement, or otherwise bypass NSR-AI’s core monetization model.
*   Only the official NSR-AI backend may be used for secure API key handling.
*   Addons must respect user privacy — they must not steal or transmit sensitive data.

## Releases

Developers should depend on specific version tags (e.g., `1.2.0`) for stability. The `main` branch may contain unreleased changes.

## Documentation

*   **Developer Guide:** For detailed information on API usage, versioning, and feature detection, please refer to [DEVELOPER.md](DEVELOPER.md).
*   **Security Policy:** For information on addon compliance, prohibited actions, and security updates, please refer to [SECURITY.md](SECURITY.md).

## full repo tree of BlackForgeStudio/NSR-AI:

```directory tree
NSR-AI/
├── .github/
├── DEVELOPER.md
├── LICENSE.txt
├── README.md
├── SECURITY.md
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── nsr/
                    └── ai/
                        └── api/
                             ├── AIAddon.java
                             ├── AIInterceptor.java
                             ├── AIPet.java
                             ├── AskAI.java
                             ├── NSRaiAPI.java
                             ├── SaveMsg.java
                             ├── SendChat.java
                             ├── SimpleAddon.java
                             └── v1/
                                 ├── AddonInfo.java
                                 ├── AIMessage.java
                                 ├── AIResponse.java
                                 ├── CustomGUIProvider.java
                                 ├── GUIListener.java
                                 ├── NPCListener.java
                                 ├── NSRAI.java
                                 ├── PetDataSnapshot.java
                                 └── PetListener.java
```

## For Addon Developers

If you are developing an addon for NSR-AI, there are now two ways to integrate:

**1. The Plugin Approach (Recommended):**
*   Create a standard Bukkit plugin with `plugin.yml`.
*   Use `NSRaiAPI.registerPlugin(this, new SimpleAddon(...))` inside your `onEnable()`.
*   Users can put your jar in the standard `plugins/` folder!

**2. The Standalone Addon Approach:**
*   For addons specifically built outside of standard plugins, use `NSRaiAPI.registerAddon(new SimpleAddon(...))`.
*   Alternatively, Legacy Addon JAR files must be placed in `/plugins/NSR-AI/addons/` with an `addon.yml` file.

**Command Rules (For both approaches):**
*   **Core Plugin**: Commands starting with `/ai` are strictly reserved for core features (Chat, API Keys, Admin).
*   **Addons**: All addon commands must start with `/aia` followed by the addon's unique **alias** (e.g., `/aia myaddon stats`).

