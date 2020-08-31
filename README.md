# Public Dockers

This repo contains all docker images that we push to [hub.docker.com].

## How it works

This repo uses a special docker hub user named `bloomcreditbot` 
(login credentials are in 1Password in the `IT Ops` vault), and
pushes via the associated gradle task.

 Build a specific image via:
 ```
./gradlew :atlantis:docker
```
Or get all tasks:
```
./gradlew tasks
```

[hub.docker.com]: https://hub.docker.com/
