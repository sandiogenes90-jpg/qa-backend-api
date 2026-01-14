# QA Backend API — Health Check Tests

Projeto de **QA Backend** focado em testes automatizados de API REST utilizando **Kotlin, RestAssured e JUnit 5**.

O objetivo é validar endpoints reais, cobrindo cenários **positivos e negativos**, com uma estrutura organizada e preparada para escalar.

---

## 🎯 Objetivo do Projeto

Este projeto foi criado para demonstrar habilidades práticas de **QA Backend**, incluindo:

- Testes de API real (não mockada)
- Validação de status HTTP e payload JSON
- Organização de testes por domínio
- Execução via Gradle no terminal
- Estrutura alinhada a padrões usados em times profissionais

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
- `BaseApiTest`: centraliza configurações comuns (baseURI e porta)
- `health`: testes relacionados ao endpoint `/health`
- Separação clara entre testes positivos e negativos

---

## 🧪 Cenários Testados

### ✅ Teste Positivo
- Verifica se o endpoint `/health` retorna:
  - HTTP 200
  - Content-Type JSON
  - Campo `status` com valor `"UP"`

### ❌ Teste Negativo
- Verifica se um endpoint inexistente (`/health/invalid`) retorna:
  - HTTP 404

---

## 🚀 Como Subir a API Fake



### Criar e subir a API
```bash
mkdir fake-api
cd fake-api
npm init -y
npm install express


const express = require('express');
const app = express();

app.get('/health', (req, res) => {
  res.json({ status: 'UP' });
});

app.listen(8080, () => {
  console.log('Fake API running on http://localhost:8080');
});



node server.js

