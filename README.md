
# QA Backend API — Health Check Tests

![QA Backend Banner](assets/banner-qa-backend.png)

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)]()
Kotlin | Gradle | Node.js | License: MIT

---

## 📖 Sumário

- Objetivo do Projeto  
- Stack Utilizada  
- Estrutura do Projeto  
- Organização  
- Cenários Testados  
- Como Subir a API Fake  
- Como Rodar os Testes  
- Teste de Contrato (`/health`)  
- Gravando os Testes  
- Instalação Rápida  
- Licença  
- Autor  
- Extras Visuais

---

## 🎯 Objetivo do Projeto

Demonstrar habilidades práticas como **QA Backend**, incluindo:

- Testes automatizados de APIs REST  
- Validação de status HTTP e payload JSON  
- Cobertura de cenários positivos e negativos  
- Organização de testes por domínio/feature  
- Execução via linha de comando (CLI)  
- Estrutura preparada para evolução e manutenção do projeto

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

src/test/kotlin/ ──┐
                   └── api/ ──┐
                              ├── BaseApiTest.kt          # Configurações comuns (baseURI, porta)
                              └── health/ ──┐
                                            ├── HealthContractTest.kt   # Teste de contrato do endpoint /health
                                            └── HealthNegativeTest.kt   # Teste negativo simples
server-completo.js                       # API fake
src/test/resources/contracts/ ──┐
                                 └── health.schema.json       # JSON Schema do /health
   



---

## 📌 Organização

- **BaseApiTest** → centraliza configurações comuns, evitando duplicação  
- **health** → agrupa testes relacionados ao endpoint `/health`, seguindo organização por domínio/feature

---

## 🧪 Cenários Testados

## ✅ Cenário Positivo

- **Endpoint:** `GET /health`  
- **Esperado:**  
-  ```json
-  { "status": "UP" }

-**Status Code: 200 OK** 
-**Content-Type: application/json**


## ❌ Cenário Negativo

-**Teste de contrato negativo: resposta sem o campo obrigatório (***status***) deve falhar**

-**Outros cenários:**
-*POST /health → 405 Method Not Allowed*
-*Headers inválidos → 400 Bad Request*

---


## ⚙️ Como Subir a API Fake

-**mkdir** fake-api
-**cd** fake-api
-npm init -y
-npm install express

**Crie o arquivo (server-completo.js:)**

-const express = require('express');
-const app = express();

-app.get('/health', (req, res) => {
  res.json({ status: 'UP' });
-});

-app.listen(8080, () => {
  console.log('Fake API running on http://localhost:8080');
-});

-**Execute a API:**

-***node server-completo.js***


▶️ ##**Como Rodar os Testes**

Com a API rodando em ***http://localhost:8080***:

-./gradlew clean test
-✅ Resultado esperado: build verde, testes de contrato e negativos passando

---

🧪 ##**Teste de Contrato** — ***/health*** Endpoint**

**Validação via JSON Schema:**

-Campo ***status*** é obrigatório

-Tipo: ***string***

-Campos extras não são permitidos

**Tecnologias**: Kotlin + RestAssured + JUnit 5 + Gradle

-Estrutura escalável para adicionar novos endpoints


---


## 🎥 Execução dos Testes (Asciinema)

 -Gravação: [assista aqui](assets/health-contract-short.cast) / [link público](https://asciinema.org/a/VNHAsI6bcCBDS55F)
 -Gravação: [assista aqui](assets/health-contract.cast) / [link público](https://asciinema.org/a/ljwOBlX7TM0ieCF8)

---


## ⚡ Instalação Rápida

-git clone https://github.com/sandiogenes90-jpg/qa-backend-api.git
-cd qa-backend-api

# Subir API fake
-cd fake-api && node server-completo.js

# Rodar testes
-./gradlew clean test

---

## 📝 Licença

-**MIT License**

---

## 👤 Autor

-**Diógenes J. de Santana**

---

## 🎨 Extras Visuais

-Banner do projeto: assets/banner-qa-backend.png

-Diagrama do projeto: assets/A_README_document_in_Portuguese_showcases_a_QA_Bac.png




