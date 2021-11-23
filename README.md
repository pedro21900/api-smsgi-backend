# Teste smsgi-Backend

## Teste Local

Para testar a aplicação Local:

**Passo 1 :** Ultilize o comando `mvn spring-boot:run`

## Teste com Docker

**Passo 1 :** para teste local em docker ultilize o comandos:

**Passo 1.1 :** criando imagem docker com o comando : `docker build -t image-venda .`

**Passo 1.2 :** iniciando o contâiner : `docker run -p 8080:8080 --name api-smsgi-backend image-venda`
### Teste de Api

Agora é só testar os endpoints .

Modelos para testar ultilizando o médotos HTTP,pPode ser feito através do Postman.

**Passo 2 :** Usando o software [Postman](https://www.postman.com/downloads/)

ou

**Passo 2 :** Pelo Swagger disponivél no endpoint http://localhost:8080/swagger-ui/index.html


Endpoint **Cliente :** http://localhost:8080/api/cliente

```json
{
  "nome": "Joãoooo Silva",
  "cpfCnpj": "037.345.678-89"
}
```

Endpoint **Produto :** http://localhost:8080/api/produto

```json
 {
  "nome": "Cellular Sansung A50",
  "valor": 1.5
}
````

Endpoint Venda: http://localhost:8080/api/venda

**Lembrando que por seguranção não serão adicionados clientes e nem produtos em venda será nescessário usar o endpoint
de venda e produto para persistir os dados**

```json
{
  "cliente": {
    "id": 1,
    "nome": "James Silva",
    "cpfCnpj": "037.345.678-89"
  },
  "produto": {
    "id": 1,
    "nome": "Cellular Sansung A50",
    "valor": 1.5
  },
  "data": "15/07/2016"
}
```
