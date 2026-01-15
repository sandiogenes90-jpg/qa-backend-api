# QA Backend API — Health Check Tests

![QA Backend Banner](assets/banner-qa-backend.png)

![Build Status](https://github.com/sandiogenes90-jpg/qa-backend-api/actions/workflows/gradle.yml/badge.svg)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue?logo=kotlin)
![Gradle](https://img.shields.io/badge/Gradle-8.3-brightgreen?logo=gradle)
![Node.js](https://img.shields.io/badge/Node.js-20.6-green?logo=node.js)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

---

## 📖 Sumário

- [Objetivo do Projeto](#objetivo-do-projeto)
- [Stack Utilizada](#stack-utilizada)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Organização](#organização)
- [Cenários Testados](#cenários-testados)
- [Como Subir a API Fake](#como-subir-a-api-fake)
- [Como Rodar os Testes](#como-rodar-os-testes)
- [Gravando os Testes](#gravando-os-testes)
- [Instalação Rápida](#instalação-rápida)
- [Licença](#licença)
- [Autor](#autor)
- [Extras Visuais](#extras-visuais)

---

## 🎯 Objetivo do Projeto

Demonstrar habilidades práticas como **QA Backend**, incluindo:

- Testes automatizados de **APIs REST**  
- Validação de **status HTTP** e **payload JSON**  
- Cobertura de cenários **positivos e negativos**  
- Organização de testes por **domínio/feature**  
- Execução via **linha de comando (CLI)**  
- Estrutura preparada para **evolução e manutenção do projeto**

---

## 🧰 Stack Utilizada

- Kotlin  
- RestAssured  
- JUnit 5  
- Gradle  
- Node.js + Express (API fake para testes)  
- Git  

---

## 📁 Estrutura do Projeto

-src/test/kotlin
-└── api
-├── BaseApiTest.kt
-└── health
-├── HealthApiTest.kt
-└── HealthNegativeTest.kt


---

## 📌 Organização

- **BaseApiTest** → centraliza configurações comuns (baseURI e porta), evitando duplicação  
- **health** → agrupa testes relacionados ao endpoint `/health`, seguindo organização por domínio/feature  

---

## 🧪 Cenários Testados

### ✅ Cenário Positivo
- **Endpoint:** `GET /health`  
- **Esperado:**  
  - Status Code: `200 OK`  
  - Content-Type: `application/json`  
  - Body:
```json
{ "status": "UP" }

---

## ❌ Cenário Negativo

*Endpoint: GET /health/invalid

Esperado:

Status Code: 404 Not Found

---

## ⚙️ Como Subir a API Fake

-mkdir fake-api
-cd fake-api
-npm init -y
-npm install express


## Crie o arquivo server.js:

const express = require('express');
const app = express();

app.get('/health', (req, res) => {
  res.json({ status: 'UP' });
});

app.listen(8080, () => {
  console.log('Fake API running on http://localhost:8080');
});


## Execute:

node server.js

---

## ▶️ Como Rodar os Testes

Com a API rodando em http://localhost:8080

./gradlew clean test

---

## 🎥 Gravando os Testes (Opcional)

Gravamos a execução do terminal usando asciinema:

Arquivo de gravação: assets/test-recording-v2.cast

Para reproduzir localmente:

asciinema play assets/test-recording-v2.cast

---

##  ⚡ Instalação Rápida

git clone https://github.com/sandiogenes90-jpg/qa-backend-api.git
cd qa-backend-api

### Subir API fake

cd fake-api && node server.js

### Rodar testes

./gradlew clean test

---


## 🧪 Teste de Contrato — `/health` Endpoint

Este projeto inclui um **teste de contrato real** para o endpoint `/health` usando **JSON Schema**.  
O objetivo é garantir que a API retorne sempre os campos esperados, evitando breaking changes.

### 📌 Regras do contrato

- Campo `status` sempre existe  
- Tipo: `string`  
- Campos extras **não são permitidos**  

### 🛠️ Tecnologias

- Kotlin + RestAssured + JUnit 5  
- Gradle para build e execução de testes  
- Estrutura escalável para novos endpoints  

### ⚙️ Como rodar o teste

No terminal, dentro do projeto:

```bash
./gradlew clean test


## ▶️ Como Rodar os Testes

Com a API rodando em http://localhost:8080

./gradlew clean test

## 🎥 Execução dos Testes (Asciinema)

- Gravação curta: [assista aqui](assets/health-contract-short.cast) / [link público](https://asciinema.org/a/VNHAsI6bcCBDS55F)
- Gravação completa: [assista aqui](assets/health-contract.cast) / [link público](https://asciinema.org/a/ljwOBlX7TM0ieCF8)



##  📝 Licença

MIT License

---

##  👤 Autor

Diógenes J de Santana

---

## 🎨 Extras Visuais

Banner do projeto: assets/banner-qa-backend.png

Diagrama do projeto: assets/A_README_document_in_Portuguese_showcases_a_QA_Bac.png
