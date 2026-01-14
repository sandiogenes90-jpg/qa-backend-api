# QA Backend API — Health Check Tests

Projeto de **QA Backend** focado em testes automatizados de **API REST**, utilizando **Kotlin, RestAssured e JUnit 5**.

O objetivo é validar **endpoints reais**, cobrindo cenários **positivos e negativos**, com uma estrutura organizada, escalável e alinhada a boas práticas utilizadas em **times profissionais de qualidade**.

---

## 🎯 Objetivo do Projeto

Demonstrar habilidades práticas como **QA Backend**, incluindo:

- Testes automatizados de API REST
- Validação de status HTTP e payload JSON
- Cobertura de cenários positivos e negativos
- Organização de testes por domínio/feature
- Execução via linha de comando (CLI)
- Estrutura preparada para evolução do projeto

---

## 🧰 Stack Utilizada

- **Kotlin**
- **RestAssured**
- **JUnit 5**
- **Gradle**
- **Node.js + Express** (API fake para testes)
- **Git**

---

## 📁 Estrutura do Projeto

# QA Backend API — Health Check Tests

Projeto de **QA Backend** focado em testes automatizados de **API REST**, utilizando **Kotlin, RestAssured e JUnit 5**.

O objetivo é validar **endpoints reais**, cobrindo cenários **positivos e negativos**, com uma estrutura organizada, escalável e alinhada a boas práticas utilizadas em **times profissionais de qualidade**.

---

## 🎯 Objetivo do Projeto

Demonstrar habilidades práticas como **QA Backend**, incluindo:

- Testes automatizados de API REST
- Validação de status HTTP e payload JSON
- Cobertura de cenários positivos e negativos
- Organização de testes por domínio/feature
- Execução via linha de comando (CLI)
- Estrutura preparada para evolução do projeto

---

## 🧰 Stack Utilizada

- **Kotlin**
- **RestAssured**
- **JUnit 5**
- **Gradle**
- **Node.js + Express** (API fake para testes)
- **Git**

---

## 📁 Estrutura do Projeto

src/test/kotlin
└── api
├── BaseApiTest.kt
└── health
├── HealthApiTest.kt
└── HealthNegativeTest.kt




### 📌 Organização

**BaseApiTest**  
Centraliza configurações comuns (baseURI e porta), evitando duplicação e facilitando manutenção e mudança de ambiente.

**health**  
Agrupa testes relacionados ao endpoint `/health`, seguindo organização por domínio/feature, padrão usado em times profissionais.


## 🧪 Cenários Testados

### ✅ Cenário Positivo

**Endpoint:** `GET /health`

**Esperado:**
- Status Code: `200 OK`
- Content-Type: `application/json`
- Body:
```json
{ "status": "UP" }


❌ Cenário Negativo

Endpoint: GET /health/invalid

Esperado:

Status Code: 404 Not Found

Esses cenários validam tanto o fluxo feliz quanto o comportamento da API em casos de erro, reforçando a confiabilidade do sistema.



🧪 API Fake (Backend de Teste)

Este projeto utiliza uma API fake em Node.js + Express apenas para fins de teste.

Ela simula um backend real para permitir a validação de:

Comunicação HTTP

Status codes

Contrato de resposta JSON

⚠️ O foco do projeto não é a API, mas sim a qualidade, organização e confiabilidade dos testes automatizados.



▶️ Como Subir a API Fake 

mkdir fake-api
cd fake-api
npm init -y
npm install express


Crie o arquivo server.js:

const express = require('express');
const app = express();

app.get('/health', (req, res) => {
  res.json({ status: 'UP' });
});

app.listen(8080, () => {
  console.log('Fake API running on http://localhost:8080');
});



node server.js



▶️ Como Rodar os Testes

Com a API rodando em http://localhost:8080:

./gradlew clean test


Os testes serão executados via Gradle, diretamente pelo terminal.





## 👤 Autor

Diógenes J. de Santana  
QA Backend em formação, com foco em testes automatizados de API, qualidade de software e boas práticas de automação.
