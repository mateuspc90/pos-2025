## API URL

#### Para acessar todos os pedidos
http://localhost:9090/api/delivery

#### Para acessar os pedidos pendentes
http://localhost:8080/api/delivery/pending

#### Para registrar uma entrega - valores de exemplo
Valor de orderNumber deve ser retirado da lista de pedidos

```
curl -X POST http://localhost:9090/api/delivery/register \
  -H "Content-Type: application/json" \
  -d '{"orderNumber": 1001, "receiverCpf": "123.456.789-00"}'
```


## E-mail Service

Adaptado para utilização do GMAIL. Parametros da conta devem ser alteradas no application.properties