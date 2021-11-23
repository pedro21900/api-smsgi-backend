# Teste smsgi-Backend

Para testar a aplicação Local:

**Passo 1 :** Ultilize o comando `mvn spring-boot:run`

ou

**Passo2 :** para teste local em docker ultilize o comandos:

`docker build -t image-venda .`

`docker run -p 8000:8000 --name api-smsgi-backend image-venda`


Agora é só testar os endpoints .

Modelos para testar ultilizando o médotos HTTP:
Pode ser feito através do Postman

ou

Pelo Swagger disponivél no endpoint `http://localhost:8080/swagger-ui/index.html`


Endpoint **Cliente :**
`http://localhost:8080/api/cliente`

```json
{
  "nome": "Joãoooo Silva",
  "cpfCnpj": "037.345.678-89"
}
```

Endpoint **Produto :**
`http://localhost:8080/api/produto`

```json
 {
  "nome": "Cellular Sansung A50",
  "valor": 1.5
}
````

Endpoint Venda:

`http://localhost:8080/api/venda`

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