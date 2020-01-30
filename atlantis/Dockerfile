# The runatlantis/atlantis-base is created by docker-base/Dockerfile.
FROM runatlantis/atlantis:latest
RUN apk add --no-cache python py-pip curl
RUN pip install awscli
RUN curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl
RUN chmod +x ./kubectl
RUN sudo mv ./kubectl /usr/local/bin/kubectl

