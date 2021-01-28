import pl.allegro.tech.build.axion.release.domain.VersionConfig

plugins {
    id("pl.allegro.tech.build.axion-release")
}

group = "io.wttech.graal.templating"
version = scmVersion.version

configure<VersionConfig> {
    checks.aheadOfRemote = false
    checks.isSnapshotDependencies = false

    hooks.pre("fileUpdate", mutableMapOf(
            "files" to listOf("templating/src/main/docs/antora/antora.yml"),
            "pattern" to KotlinClosure2<String, pl.allegro.tech.build.axion.release.domain.hooks.HookContext, String>({ _, _ -> "version: '(.*)'" }),
            "replacement" to KotlinClosure2<String, pl.allegro.tech.build.axion.release.domain.hooks.HookContext, String>({ v, _ -> "version: '$v'" })
    ))
    hooks.pre("fileUpdate", mutableMapOf(
            "files" to listOf("templating/src/main/js/bridge/package.json", "templating/src/main/js/bridge-react/package.json"),
            "pattern" to KotlinClosure2<String, pl.allegro.tech.build.axion.release.domain.hooks.HookContext, String>({ _, _ -> "\"version\": \"(.*)\"" }),
            "replacement" to KotlinClosure2<String, pl.allegro.tech.build.axion.release.domain.hooks.HookContext, String>({ v, _ -> "\"version\": \"$v\"" })
    ))
    hooks.pre("commit")
}
