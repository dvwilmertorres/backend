FROM azul/zulu-openjdk-alpine:20-jre-latest
WORKDIR /app

RUN mkdir ./logs
COPY ./build/libs/usermodule-1.0-SNAPSHOT.jar .
HEALTHCHECK --interval=5m --timeout=3s \
  CMD curl -f http://localhost/ || exit 1
RUN rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
ENV JASYPT_ENCRYPTOR xxxxxx
ENV DRIVE XXXXXX
ENV URL_DB xxxxxx
ENV USERNAME_BD xxxxxx
ENV PORT 8081
ENV PDB xxxxxx

EXPOSE $PORT
CMD ["java","-jar","usermodule-1.0-SNAPSHOT.jar"]