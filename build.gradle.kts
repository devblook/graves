plugins {
    java
    id("io.github.goooler.shadow") version ("8.1.8")
    id("io.papermc.paperweight.userdev") version "1.7.2"
}

repositories {
    mavenCentral()
    maven {
        name = "paper-api"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        name = "oraxen"
        url = uri("https://repo.oraxen.com/releases")
    }
    maven {
        name = "ranull-repo"
        url = uri("https://repo.ranull.com/maven/ranull/")
    }
    maven {
        name = "ranull-repo-external"
        url = uri("https://repo.ranull.com/maven/external/")
    }
    maven {
        name = "clojars-repo"
        url = uri("https://repo.clojars.org/")
    }
    maven {
        name = "dmulloy2-repo"
        url = uri("https://repo.dmulloy2.net/repository/public/")
    }
    maven {
        name = "sonatype-repo"
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }
    maven {
        name = "placeholderapi-repo"
        url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    }
    maven {
        name = "griefdefender-repo"
        url = uri("https://repo.glaremasters.me/repository/bloodshot/")
    }
    maven {
        name = "jeff-media-repo"
        url = uri("https://repo.jeff-media.com/public/")
    }
    maven {
        name = "skript-repo"
        url = uri("https://repo.skriptlang.org/releases")
    }
    maven {
        name = "enginehub"
        url = uri("https://maven.enginehub.org/repo/")
    }
    maven {
        name = "glaremasters-repo"
        url = uri("https://repo.glaremasters.me/repository/towny/")
    }
    maven {
        name = "minebench-repo"
        url = uri("https://repo.minebench.de/")
    }
    maven {
        name = "sonatype-oss-snapshots"
        url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
    }
    maven {
        name = "jitpack.io"
        url = uri("https://jitpack.io/")
    }
}


dependencies {
    //compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    paperweight.paperDevBundle("1.21-R0.1-SNAPSHOT")

    implementation("org.bstats:bstats-bukkit:3.0.0")
    compileOnly("com.github.puregero:multilib:1.1.5")
    compileOnly("com.ranull:skulltextureapi:1.0")
    compileOnly("dev.sergiferry:playernpc:2022.9")
    compileOnly("com.mira:furnitureengine:1.6.3")
    compileOnly("net.milkbowl:vault:1.7.3")
    compileOnly("me.lokka30:treasury:1.2.0")
    compileOnly("com.comphenix.protocol:ProtocolLib:4.8.0")
    compileOnly("com.sk89q.worldedit:worldedit-bukkit:7.2.0-SNAPSHOT")
    compileOnly("com.sk89q.worldguard:worldguard-bukkit:7.0.7-SNAPSHOT")
    compileOnly("com.palmergames.bukkit.towny:towny:0.98.1.12")
    compileOnly("de.jeff_media:ChestSortAPI:13.0.0-SNAPSHOT")
    //compileOnly("me.clip:placeholderapi:2.11.6")
    compileOnly("com.griefdefender:api:2.0.0-20210822.184639-9")
    compileOnly("com.github.SkriptLang:Skript:2.6.1")
    compileOnly("com.github.xerial:sqlite-jdbc:3.36.0.3")
    compileOnly("com.github.Ste3et:FurnitureLib:22fb4086de")
    compileOnly("com.github.LoneDev6:api-itemsadder:2.4.8")
    compileOnly("io.th0rgal:oraxen:1.175.0")
    compileOnly("com.github.jojodmo:ItemBridge:b0054538c1")
    compileOnly("de.themoep:minedown:1.7.1-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:23.0.0")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

paperweight.reobfArtifactConfiguration = io.papermc.paperweight.userdev.ReobfArtifactConfiguration.MOJANG_PRODUCTION

tasks {
    processResources {
        filter<org.apache.tools.ant.filters.ReplaceTokens>(
            "tokens" to mapOf(
                "version" to version,
                "name" to rootProject.name
            )
        )
    }

    compileJava {
        options.release = 21
    }

    javadoc {
        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
    }

    shadowJar {
        minimize()
        archiveBaseName.set("Graves")
        relocate("org.bstats", "com.ranull.graves.libs.bstats")
        archiveVersion.set(rootProject.version.toString())
    }
}


