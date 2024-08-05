# Starter Redis Caching
# Introdução
Este projeto demonstra como implementar o Redis como um cache para otimizar o desempenho de chamadas a endpoints que recebem um grande volume de requisições. O uso do Redis pode ajudar a reduzir a carga no banco de dados e melhorar o tempo de resposta das suas APIs.

### Por que utilizar Cache na sua aplicação?
**Importância do Cache** <br/>
O cache é uma técnica de armazenamento temporário que permite que dados frequentemente acessados sejam armazenados em uma localização de acesso rápido. A utilização de cache em uma aplicação é fundamental por diversas razões:

- Redução da Latência: O acesso a dados em cache é significativamente mais rápido do que o acesso a um banco de dados tradicional, resultando em respostas mais ágeis para o usuário.
- Melhoria na Escalabilidade: O cache ajuda a aliviar a carga sobre o banco de dados, permitindo que a aplicação escale para suportar mais usuários e requisições simultâneas sem comprometer o desempenho.
- Otimização de Recursos: Ao minimizar o número de requisições ao banco de dados, o cache pode reduzir a utilização de CPU e memória, levando a um melhor uso dos recursos da infraestrutura.
- Experiência do Usuário: Com tempos de resposta mais rápidos, a experiência do usuário melhora, o que pode resultar em maior satisfação e retenção de clientes.
- Custo-Efetividade: Reduzir a carga no banco de dados pode levar a menos custos operacionais, especialmente em ambientes de nuvem onde a cobrança pode ser baseada na quantidade de operações realizadas.

### Por que utilizar o Redis como Cache?
**Motivo**
- O Redis é um sistema de armazenamento de dados em memória, que permite acesso extremamente rápido a dados frequentemente solicitados. Quando sua aplicação enfrenta uma alta carga de requisições em determinados endpoints, isso pode causar um aumento na latência e sobrecarga no banco de dados. O uso do Redis como cache ajuda a mitigar esses problemas.

**Benefícios**
- Desempenho Aprimorado: O Redis fornece tempos de resposta muito mais rápidos em comparação com consultas a bancos de dados tradicionais, permitindo que sua aplicação processe requisições mais rapidamente.
- Redução da Carga no Banco de Dados: Com o Redis armazenando dados frequentemente acessados, o número de consultas ao banco de dados diminui, liberando recursos para operações mais críticas.
- Escalabilidade: Ao reduzir a pressão sobre o banco de dados, sua aplicação pode escalar mais facilmente para suportar um maior número de usuários e requisições simultâneas.
- Facilidade de Implementação: O Redis é fácil de integrar em aplicações existentes e pode ser usado para armazenar uma variedade de tipos de dados, incluindo strings, hashes, listas e conjuntos.
- Persistência Opcional: O Redis oferece opções de persistência que permitem que você mantenha dados importantes mesmo após a reinicialização, combinando velocidade com segurança.

# Instruções
1. Inicie o **docker-compose**
```bash 
  docker-compose up -d
```
2. Execute o **script-sql** </br>
   > Certifique-se de que o banco de dados esteja configurado corretamente executando o script SQL necessário para criar as tabelas.

3. Inicialize o **projeto**
```bash
    gradle build
```
```bash
    gradle bootJar
```

4. Crie uma **account**
   Envie uma requisição POST para criar uma nova conta:
```http request
POST http://localhost:8080/api/accounts/create
```
```json
{
    "username": "Test Account",
    "email": "test@exemple.com"
}
```

5. Crie um **installment**
> Você pode criar um installment manualmente ou usar um script para gerar múltiplos installments. Para isso, adicione o account-id na variável do script.
##### Opção 1: Criação Manual
```http request
POST http://localhost:8080/api/installments/create
```
```json
{
  "account_identifier": "63a0a85e-958a-46d8-83fd-4bd7b7fa2eb5",
  "value": 200.00,
  "due_date": "20240905"
}
```
##### Opção 2: Geração Automática
* Acesse o /initialize-values.js 
* Altere o account_identifier do script
```js
const account_identifier = "value";
```
* Execute o script
```bash
    node .\initialize-values.js
```

6. Execute os endpoints de **find**
- Consultar todos os **installments**
```http request
GET http://localhost:8080/api/installments/find-all/{account-identifier}
```
```json
{
   "account": {
   "identifier": "41e57fbc-6db2-40a9-87d2-92ed1b956fc9",
   "username": "Victor",
   "email": "test_12345@email.com",
   "created_at": "2024-08-05T13:50:27.1643",
   "updated_at": null
   },
   "installments": [
      {
      "identifier": "cee43fb1-d791-408b-9c3f-574f6290fbd2",
      "account_identifier": "41e57fbc-6db2-40a9-87d2-92ed1b956fc9",
      "value": 37.03,
      "due_date": "2024-12-27",
      "enabled": true,
      "type": "PENDING",
      "created_at": "2024-08-05T13:50:49.027299",
      "updated_at": null
      }
   ]
}
```

- Consultar um **installment**
```http request
GET http://localhost:8080/api/installments/find/{installment-identifier}
```
```json
{
   "identifier": "cee43fb1-d791-408b-9c3f-574f6290fbd2",
   "account_identifier": "41e57fbc-6db2-40a9-87d2-92ed1b956fc9",
   "value": 37.03,
   "due_date": "2024-12-27",
   "enabled": true,
   "type": "PENDING",
   "created_at": "2024-08-05T13:50:49.027299",
   "updated_at": null
}
```
<br/>

> Observação
Na primeira requisição feita aos endpoints de consulta, o cache não estará disponível ainda. Somente a partir das requisições subsequentes você perceberá uma melhoria no comportamento e na resposta do endpoint.

# Evidências
Foram realizados dois testes para avaliar o desempenho da aplicação ao recuperar installments, um utilizando a consulta para todos os installments e o outro para um único installment.

1. Recuperando **find-all** installments <br/>
Durante o primeiro teste, foram realizadas duas requisições para recuperar todos os installments associados a uma conta. Os tempos de resposta foram os seguintes:

> 1ª Requisição: 248ms
<img src="/assets/find-all-first-request.png">

> 2ª Requisição: 21ms
<img src="/assets/find-all-second-request.png">

- Observou-se uma redução significativa no tempo de resposta da segunda requisição, demonstrando a eficácia do cache. A primeira requisição, que não utilizou o cache, levou mais tempo para processar, enquanto a segunda requisição se beneficiou dos dados já armazenados, resultando em um tempo de resposta muito mais rápido.

2. Recuperando um **find** installment <br/>
No segundo teste, foram realizadas duas requisições para recuperar um único installment. Os resultados foram:


> 1ª Requisição: 12ms
<img src="/assets/find-first-request.png">

> 2ª Requisição: 3ms
<img src="/assets/find-second-request.png">

- Novamente, notou-se uma melhoria considerável no tempo de resposta entre a primeira e a segunda requisição. A primeira requisição teve um tempo de resposta maior devido à necessidade de buscar os dados no banco de dados, enquanto a segunda requisição se beneficiou do cache, resultando em uma resposta ainda mais rápida.

# Conclusão
Os resultados dos testes demonstram claramente a eficácia do Redis como cache, proporcionando uma redução significativa nos tempos de resposta em chamadas subsequentes aos endpoints. Isso evidencia a importância de implementar caching em aplicações que lidam com grandes volumes de dados e requisições, melhorando a performance e a experiência do usuário.



### 👨‍🚀 Team Members
Developed by `Arruda, Victor Hugo`!

### 📨 Contacts
- [LinkedIn](https://www.linkedin.com/in/victorhugodev/)
- [Email](mailto:contato.arrudavictor@gmail.com)