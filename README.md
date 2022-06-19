# Controle de Pecas
Repositório do exercício-programa Remote Method Invocation (RMI) da disciplina ACH2147 - Desenvolvimento de Sistemas de Informação Distribuídos
## Compilar
```sh
javac -d ./bin -cp ./src ./src/server/*.java
```
```sh
javac -d ./bin -cp ./src ./src/client/*.java
```

## Executar
```sh
java -cp ./bin server.Server [nome_repositorio] [porta]
```
```sh
java -cp ./bin client.Client
```
