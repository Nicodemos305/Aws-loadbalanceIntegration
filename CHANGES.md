# Changes

## 2026-11-03

### Corrigido

- `Config.deserealize` agora lê o arquivo informado do classpath em vez de ignorar o argumento. O endpoint restringe o valor a um nome simples, impedindo traversal de diretórios.
- O endpoint de arquivo usa `GET` com query parameter, alinhado ao uso documentado.
- O cliente AWS deixou de ser criado no construtor antes da injeção do Spring e passou a usar a cadeia padrão de credenciais e a região configurada.
- A inicialização não exige access key/secret key vazias no `application.properties`.
- O fluxo de integração continha referências inexistentes e não era compilável. Foi substituído por validação explícita da configuração, com resposta `VALIDATION_ONLY` para não declarar que recursos foram provisionados quando isso não ocorre.

### Adicionado

- Validador das listas necessárias e das referências entre virtual hosts, ambientes, projetos, regras, pools e targets.
- Endpoint `GET /LoadBalanceIntegrationAWS/health`.
- Testes unitários do validador para configuração válida, entrada nula e ausência de environments.
- Dockerfile multi-stage e `.dockerignore`.
- Instruções de execução, cenários de validação e análise de viabilidade no README.

### Limitações conhecidas

- Não há provisionamento real de ALB. A camada de integração AWS permanece tecnicamente legada e não é acionada pelo endpoint.
- Spring Boot 2.0.3, Java 8 e AWS SDK for Java 1.x precisam de atualização. O SDK 1.x chegou ao fim do suporte em 31/12/2025.
- O modelo de entrada precisa declarar VPC, subnets, security groups, target groups, portas, protocolos e prioridades para suportar criação real de ALB de forma previsível.
- Testes não puderam ser executados neste ambiente: não há runtime Java instalado. O comando `./mvnw` também não é executável; use `bash mvnw test` em ambiente com JDK 8.
