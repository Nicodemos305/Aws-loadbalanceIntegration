# AWS Load Balancing Integration

API Java/Spring Boot que recebe uma descrição declarativa de ambientes, projetos, targets, pools, virtual hosts e regras de roteamento. O domínio sugere a intenção de provisionar um **Application Load Balancer (ALB)** e encaminhar tráfego por regras de caminho.

## Estado atual e viabilidade

Este repositório é um **protótipo de validação**, não um provisionador AWS pronto para produção. A versão original misturava a API do Classic Load Balancer (ELB) com conceitos de ALB, tinha trechos incompletos e credenciais AWS configuradas por propriedades locais. O endpoint principal agora valida a configuração e informa `VALIDATION_ONLY`; ele **não cria nem altera recursos AWS**.

A base tecnológica também está defasada: Spring Boot `2.0.3`, Java 8 e AWS SDK for Java 1.x. A AWS encerrou o suporte do SDK 1.x em 31/12/2025. O SDK 1.x e o Classic Load Balancer ainda podem funcionar, mas não são uma base recomendada para novos desenvolvimentos. Para tornar a intenção do domínio real, o próximo passo é migrar para Java 17 ou superior, uma linha Spring Boot com suporte vigente (Spring Boot 4.x atualmente) e AWS SDK for Java 2.x (`elasticloadbalancingv2`), com recursos ALB explícitos: VPC, subnets, security groups, target groups, listeners e listener rules.

Links oficiais: [fim do suporte do AWS SDK for Java 1.x](https://aws.amazon.com/blogs/developer/announcing-end-of-support-for-aws-sdk-for-java-v1-x-on-december-31-2025/), [migração de Classic Load Balancer](https://docs.aws.amazon.com/elasticloadbalancing/latest/userguide/migrate-classic-load-balancer.html), [requisitos atuais do Spring Boot](https://docs.spring.io/spring-boot/system-requirements.html), [AWS SDK for Java 2.x](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html).

## O que esta versão faz

- `GET /LoadBalanceIntegrationAWS/health` retorna `UP` para verificação básica de disponibilidade.
- `POST /LoadBalanceIntegrationAWS/createLoadBalance` recebe JSON e valida campos e referências entre entidades.
- `GET /LoadBalanceIntegrationAWS/createLoadBalancePath?path=config.json` lê um arquivo de configuração empacotado no classpath e aplica a mesma validação. Por segurança, `path` aceita apenas nome de arquivo, sem diretórios.
- Erros de validação retornam `codigo: "400"`. Configuração válida retorna `codigo: "VALIDATION_ONLY"`; isso significa que foi validada, não provisionada.

## Requisitos

- Docker para compilar/executar sem instalar Java e Maven na máquina.
- Para execução local: JDK 8 e Maven Wrapper (`bash mvnw`). O wrapper `mvnw` não tem bit de execução no repositório.
- As chamadas atuais de validação não precisam de conta AWS, rede AWS nem credenciais.

## Executar localmente

```bash
bash mvnw spring-boot:run
```

O servidor inicia na porta `8082` por padrão. Para trocar a porta ou região:

```bash
SERVER_PORT=8090 AWS_REGION=sa-east-1 bash mvnw spring-boot:run
```

Verifique:

```bash
curl -i http://localhost:8082/LoadBalanceIntegrationAWS/health
```

## Validar uma configuração

Exemplo usando o arquivo do projeto:

```bash
curl -i 'http://localhost:8082/LoadBalanceIntegrationAWS/createLoadBalancePath?path=config.json'
```

Ou envie JSON diretamente:

```bash
curl -i -X POST http://localhost:8082/LoadBalanceIntegrationAWS/createLoadBalance \
  -H 'Content-Type: application/json' \
  --data-binary @src/main/resources/config.json
```

Resposta esperada para configuração válida:

```json
{
  "codigo": "VALIDATION_ONLY",
  "mensagens": [
    "Configuração válida. Nenhum recurso AWS foi criado: o provisionamento de ALB ainda não está implementado."
  ]
}
```

Para validar falha, remova um item de `environments`, `projects`, `ruleTypes`, `targets`, `pools` ou `virtualhosts`, ou informe uma referência inexistente. A API deve retornar `codigo: "400"` e uma mensagem indicando o erro.

## Docker

O Dockerfile compila o JAR em uma etapa Maven e executa em uma imagem JRE. A imagem reflete a versão Java legada deste projeto; migre a aplicação antes de escolher uma versão Java mais nova para produção.

```bash
docker build -t aws-loadbalance-integration .
docker run --rm -p 8082:8082 --name aws-loadbalance-integration aws-loadbalance-integration
```

Em outro terminal:

```bash
curl -i http://localhost:8082/LoadBalanceIntegrationAWS/health
curl -i 'http://localhost:8082/LoadBalanceIntegrationAWS/createLoadBalancePath?path=config.json'
```

Pare com `Ctrl+C` ou `docker stop aws-loadbalance-integration`.

## Testes unitários

```bash
bash mvnw test
```

Os testes cobrem a validação de configuração válida, configuração ausente e campos obrigatórios ausentes. Nenhum teste cria recursos na AWS.

## Segurança e operação

- Não coloque access keys no `application.properties`, na imagem Docker ou no Git. O código de cliente AWS legado usa a cadeia padrão de credenciais do SDK, que pode obter credenciais de variáveis de ambiente, profile local ou role do runtime.
- O endpoint de validação não chama a AWS nesta versão. Não interprete `VALIDATION_ONLY` como sucesso de deploy.
- Ao implementar provisionamento, use IAM de menor privilégio, roles de workload, validação de VPC/subnets/security groups e operações idempotentes. Migre para SDK v2 antes de ampliar essa superfície.
- `config.json` é exemplo de domínio; IPs e nomes nele não representam uma infraestrutura criada.
