FROM diamol/golang as builder

COPY main.go .
RUN go build -o /web/server
RUN chmod +x /web/server

# app
FROM diamol/base

EXPOSE 80
CMD ["/web/server"]
ENV USER=sixeyed

WORKDIR web
COPY --from=builder /server .
COPY index.html .
