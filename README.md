QA Backend API — Health Check Tests










📖 Sumário

Objetivo do Projeto

Stack Utilizada

Estrutura do Projeto

Organização

Cenários Testados

Como Subir a API Fake

Como Rodar os Testes

Instalação Rápida

Licença

Autor

🎯 Objetivo do Projeto

Demonstrar habilidades práticas como QA Backend, incluindo:

Testes automatizados de APIs REST

Validação de status HTTP e payload JSON

Cobertura de cenários positivos e negativos

Organização de testes por domínio/feature

Execução via linha de comando (CLI)

Estrutura preparada para evolução e manutenção do projeto

🧰 Stack Utilizada

Kotlin

RestAssured

JUnit 5

Gradle

Node.js + Express (API fake para testes)

Git

📁 Estrutura do Projeto
src/test/kotlin/
└── api/
    ├── BaseApiTest.kt
    └── health/
        ├── HealthApiTest.kt
        └── HealthNegativeTest.kt

📌 Organização

BaseApiTest → centraliza configurações comuns (baseURI e porta), evitando duplicação e facilitando manutenção.

health → agrupa testes relacionados ao endpoint /health, seguindo organização por domínio/feature.

🧪 Cenários Testados
✅ Cenário Positivo

Endpoint: GET /health

Esperado:

Status Code: 200 OK

Content-Type: application/json

Body:

{ "status": "UP" }

❌ Cenário Negativo

Endpoint: GET /health/invalid

Esperado:

Status Code: 404 Not Found

⚙️ Como Subir a API Fake
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


Execute a API:

node server.js

▶️ Como Rodar os Testes

Com a API rodando em http://localhost:8080:

./gradlew clean test

⚡ Instalação Rápida
git clone https://github.com/sandiogenes90-jpg/qa-backend-api.git
cd qa-backend-api


Subir API fake: cd fake-api && node server.js

Rodar testes: ./gradlew clean test

📄 Licença

MIT License © 2026

👤 Autor

Diógenes J de Santana
QA Backend | Automação de Testes | API Testing
