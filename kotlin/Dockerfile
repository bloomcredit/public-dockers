FROM zenika/kotlin:1.4-M1-jdk12-alpine

RUN apk add --no-cache --update \
    npm \
    docker \
    git \
    python \
    py-pip && \
    pip install awscli

WORKDIR /root