## Inicialização

`LogisticaApplication.java` roda o projeto.

`DataInitializer.java` popula o banco com os seguintes dados:
```
[
  {
    "orderNumber": 1001,
    "customerEmail": "mateuspc90@hotmail.com",
    "delivered": false,
    "receiverCpf": null,
    "deliveryDateTime": null
  },
  {
    "orderNumber": 1002,
    "customerEmail": "cliente2@example.com",
    "delivered": false,
    "receiverCpf": null,
    "deliveryDateTime": null
  },
  {
    "orderNumber": 1003,
    "customerEmail": "cliente3@example.com",
    "delivered": false,
    "receiverCpf": null,
    "deliveryDateTime": null
  }
]
```


## API URL

#### Para acessar todos os pedidos
http://localhost:9090/api/delivery

#### Para acessar os pedidos pendentes
http://localhost:9090/api/delivery/pending

#### Para registrar uma entrega - valores de exemplo
Valor de orderNumber deve ser retirado da lista de pedidos apresentados em  `http://localhost:9090/api/delivery/pending`

```
curl -X POST http://localhost:9090/api/delivery/register \
  -H "Content-Type: application/json" \
  -d '{"orderNumber": 1001, "receiverCpf": "123.456.789-00"}'
```


## E-mail Service

Adaptado para utilização do GMAIL. Parametros da conta devem ser alteradas no `application.properties`