# QA Backend API — Health Check Tests

![Build Status](https://github.com/sandiogenes90-jpg/qa-backend-api/actions/workflows/gradle.yml/badge.svg)
![Kotlin](https://img.shields.io/badge/kotlin-1.9-blue?logo=kotlin)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

Projeto de QA Backend focado em testes automatizados de API REST, utilizando **Kotlin**, **RestAssured** e **JUnit 5**.  
O objetivo é validar endpoints reais, cobrindo cenários positivos e negativos, com uma estrutura organizada, escalável e alinhada a boas práticas utilizadas em times profissionais de qualidade.

---

## 🎯 Objetivo do Projeto
Demonstrar habilidades práticas como QA Backend, incluindo:
- Testes automatizados de API REST  
- Validação de status HTTP e payload JSON  
- Cobertura de cenários positivos e negativos  
- Organização de testes por domínio/feature  
- Execução via linha de comando (CLI)  
- Estrutura preparada para evolução do projeto  

---

## 🧰 Stack Utilizada
- Kotlin  
- RestAssured  
- JUnit 5  
- Gradle  
- Node.js + Express (API fake para testes)  
- Git  



## 📁 Estrutura do Projeto
src/test/kotlin
└── api
├── BaseApiTest.kt
└── health
├── HealthApiTest.kt
└── HealthNegativeTest.kt



---

## 📌 Organização
- **BaseApiTest** → centraliza configurações comuns (baseURI e porta), evitando duplicação e facilitando manutenção.  
- **health** → agrupa testes relacionados ao endpoint `/health`, seguindo organização por domínio/feature.  

---

## 🧪 Cenários Testados
### ✅ Cenário Positivo
**Endpoint:** `GET /health`  
**Esperado:**  
- Status Code: `200 OK`  
- Content-Type: `application/json`  
- Body:  
```json
{ "status": "UP" }

## ❌ Cenário Negativo
Endpoint: GET /health/invalid  
Esperado:

Status Code: 404 Not Found


## Como Subir a API Fake

mkdir fake-api
cd fake-api
npm init -y
npm install express

## Crie o arquivo server.js

const express = require('express');
const app = express();

app.get('/health', (req, res) => {
  res.json({ status: 'UP' });
});

app.listen(8080, () => {
  console.log('Fake API running on http://localhost:8080');
});

** Execute
## node server.js

▶️ Como Rodar os Testes
Com a API rodando em http://localhost:8080

./gradlew clean test


🚀 Instalação Rápida

* Clone o repositório:
## git clone git@github.com:sandiogenes90-jpg/qa-backend-api.git

* Suba a API fake:
## node server.js

* Rode os testes:
## ./gradlew clean test


📜 Licença
Este projeto está licenciado sob os termos da licença MIT.
Veja o arquivo [Parece que o resultado não era seguro para exibição. Vamos mudar as coisas e tentar outra opção!] para mais detalhes.


👤 Autor
Diógenes J. de Santana  
QA Backend em formação, com foco em testes automatizados de API, qualidade de software e boas práticas de automação.



