FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/factual-future-api
WORKDIR /home/app/factual-future-api

RUN native-image --no-server -cp build/libs/factual-future-api-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/factual-future-api/factual-future-api /app/factual-future-api
ENTRYPOINT ["/app/factual-future-api"]
