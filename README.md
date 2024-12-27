# Projeto (Teste técnico de Backend)

## Sobre a API
Esse projeto foi desenvolvido com base nas especificações relatadas no teste técnico. Esse projeto consiste no desenvolvimento de uma API de consulta e cadastro de ceps, desenvolvido com Java e Spring.
O projeto consiste no desenvolvimento de endpoints de: GET por CEP, GET por Logradouro (Lista de CEP), GET por Cidade (Lista de CEP), POST para Criar um CEP, PUT para Atualizar um CEP.

## Importante! ⚠️ <br>
Esse projeto encontra-se em produção em ambiente de nuvem (RAILWAY). Você pode acessa-lo através do link da documentação: https://cep-api.up.railway.app/swagger-ui/index.html#/
- Forneça os seguintes dados de acesso: Login - admin / Senha - admin

## Endpoints

Esta API fornece os seguintes endpoints:

#### CEP

- Busca dados de cep por numero: `GET/cep/api/{numeracaoCep}`
    - Para teste desse endpoint, utilize as seguintes numerações de cep: 01000000, 03022080, 04156080, 04156055, 13474534

- Busca dados de cep por logradouro: `GET/cep/api/logradouro`
    - Para teste desse endpoint, utilize os seguintes nome de logradouro: Rua Aderaldo Ferreira de Araújo, Praça da Sé
    - Esse endpoint retorna dados paginados da base dados, utilize: 0 para o numero da pagina, e 2 para itens (Altere de acordo com a necessidade)

- Busca dados de cep por cidade: `GET/cep/api/cidade`
    - Para teste desse endpoint, utilize os seguintes nome de cidade: São Paulo, Atalaia do Norte, Quixadá.
    - Esse endpoint retorna dados paginados da base dados, utilize: 0 para o numero da pagina, e 2 para itens (Altere de acordo com a necessidade)

- Cadastra dados de cep: `POST/cep/api`
   - Para cadastro de dados de um novo cep, utilize o seguinte JSON: 
`{
    "logradouro": "Rua das Laranjas",
    "bairro": "Larajeiras",
    "cidade": "Açailandia",
    "estado": "Maranhão",
    "uf": "MA",
    "regiao": "Nordeste",
    "ddd": "88"
}`
   - Modifique de acordo com a necessidade.

- Atualiza dados de cep: `PUT/cep/api/{numeracaoCep}`

    - Para atualizacao de dados de um cep, utilize o seguinte JSON:
  `{
      "logradouro": "Rua das Laranjas Verdes",
      "bairro": "Larajeiras",
      "cidade": "Açailandia",
      "estado": "Maranhão",
      "uf": "MA",
      "regiao": "Nordeste",
      "ddd": "88"
  }`
  - Modifique de acordo com a necessidade.


## Tecnologias usadas

Este projeto foi desenvolvido com as seguintes tecnologias:

- **SpringBoot 3.4.1**
- **Java 17**
- **Maven**
- **Postgres**
- **ModelMapper**
- **SpringDoc-OpenApi**

## Como executar o projeto

### Clonar repositório

Clone o repositório git com o seguinte comando:

```
git clone https://github.com/fcojunior97/cep-api.git
```

### Empacotando
Você pode está gerando um `jar` do projeto para executar a API. Para isso, você deve executar o seguinte comando:

```
mvn clean package
```

Ele irá gerar um pacote `.jar` no seguinte diretorio `\algatransito-api\target` como mostrado no exemplo: `algatransito-api-0.0.1-SNAPSHOT`.

### Executando
Para executar o projeto, você deve executar os seguinte comando:

```
java -Dspring.profiles.active=dev -DPGUSER={SEU_USUARIO} -DPGPASSWORD={SUA_SENHA} -jar cep-api-0.0.1-SNAPSHOT.jar
```

- Substitua o campo {SEU_USUARIO} pelo dado de usuario do seu banco de dados e o campo {SUA_SENHA} pela senha de banco de dados. 

