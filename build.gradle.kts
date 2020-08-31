plugins {
    id("com.palantir.docker") version "0.25.0" apply false
    id("com.palantir.docker-run") version "0.25.0" apply false
}

fun String.sha256(): String {
    val md = java.security.MessageDigest.getInstance("SHA-256")
    val digest = md.digest(toByteArray())
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}

subprojects {
    apply(plugin = "com.palantir.docker")
    apply(plugin = "com.palantir.docker-run")

    // Assume all subprojects have a Dockerfile at root
    val dockerFile = file("Dockerfile")
    // Use sha256 as version
    val dockerfileVersion = dockerFile.readText().sha256()

    // Dynamically configure subproject docker plugins
    extensions.configure(com.palantir.gradle.docker.DockerExtension::class) {
        name = "${project.name}:$dockerfileVersion"
        setDockerfile(dockerFile)
        // TODO (cmoore): add labels, maybe from oci: https://github.com/opencontainers/image-spec
        noCache(true)
        pull(false)
        tag("latest", "${project.name}:latest")
    }

    // For local testing
    extensions.configure(com.palantir.gradle.docker.DockerRunExtension::class) {
        name = project.name
        image = "${project.name}:$dockerfileVersion"
        clean = true
        daemonize = false
    }

}