# Loadbalance
Projeto destinado a configuração de um AWS ELB (Amazon Webservices Elastic LoadBalance).

# Requisitos:

<ul>
  <li>
    Ter uma conta AWS com os recursos EC2 disponíveis.
  </li>
  <li>
    Importar o projeto na IDE de sua preferência que tenha suporte a linguagem Java.
  </li>
  <li>
    Executar o comando Maven Update Project (para instalação de depências definidas no pom.xml).
  </li>
  <li>
  Colocar as credencias AWS no arquivo application.properties com as seguintes propriedades de sua conta AWS 
  regionName = nomeDeSuaRegiao ,serviceName=elasticloadbalancing, key= sua key /sua chave secreta.
  </li>

  <li>
    O Serviço foi configurado na porta 8082, caso essa porta já esteja em uso por algum serviço, será necessário mudar
    a propriedade server.port no arquivo application.properties.
  </li>
  <li>
    Exportar o projeto como um Jar executável.
  </li>
  <li>
    Realizar deploy da aplicação em um servidor/cointainer. 
  </li>
</ul>

# Como usar
Existem duas maneiras de realizar o cadastro de seu AWS ELB com esse projeto. 

Exemplo 1 

Consumir o serviço 
  url:    localhost:8082/LoadBalanceIntegrationAWS/createLoadBalance
  method: post
  parâmetro: Json com as configurações de um AWS ELB genérico.
  
  ```javascript
  {
	"environments": [
		{
			"id": 1,
			"name": "localhost"
		}
	],
	"projects": [
		{
			"id": 1,
			"name": "projeto1"
		}
	],
	"ruleTypes": [
		{
			"id": 1,
			"name": "UrlPath"
		}
	],
	"targets": [
		{
			"id": 1,
			"name": "http://0.0.0.0:8080",
			"properties": {
				"healthy": "OK"
			}
		},
		{
			"id": 2,
			"name": "http://0.0.0.0:8080",
			"properties": {
				"healthy": "OK"
			}
		},
		{
			"id": 3,
			"name": "http://0.0.0.0:8080",
			"properties": {
				"healthy": "OK"
			}
		}
	],
	"pools": [
		{
			"id": 1,
			"name": "MyPool",
			"properties": {
				"healthCheckPath": "/healthcheck.html",
				"loadBalancePolicy": "RoundRobin",
				"targets": [
					{
						"targetId": 1
					},
					{
						"targetId": 2
					}
				]
			}
		},
		{
			"id": 2,
			"name": "OtherPool",
			"properties": {
				"healthCheckPath": "/healthcheck.html",
				"loadBalancePolicy": "RoundRobin",
				"targets": [
					{
						"targetId": 3
					}
				]
			}
		}
	],
	"virtualhosts": [
		{
			"name": "www.webserver.localdomain",
			"environmentId": 1,
			"projectId": 1,
			"rules": [
				{
					"typeId": 1,
					"poolId": 1,
					"rulePath": "/xpto"
				},
				{
					"typeId": 1,
					"poolId": 2,
					"rulePath": "/"
				}
			]
		}
	]
}
  ```
Exemplo 2

url:    localhost:8082/LoadBalanceIntegrationAWS/createLoadBalancePath?path=www.teste.com.br/config.json
method: get
parâmetro: String com o path
  
  
 
