# Controle de Pecas
Repositório do exercício-programa Remote Method Invocation (RMI) da disciplina ACH2147 - Desenvolvimento de Sistemas de Informação Distribuídos
## Integrantes
* Matheus Percoraro de Carvalho Santos    Nº USP: 11917271\n 
* Ryan Brenno Ramos                       Nº USP: 11215772 
* Sungwon Yoon                            Nº USP: 9822261 
* Wendel Fernandes de Lana                Nº USP: 11796722

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
