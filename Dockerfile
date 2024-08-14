FROM ubuntu:latest
LABEL authors="sogut"

ENTRYPOINT ["top", "-b"]