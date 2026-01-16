const express = require("express");

const app = express();
app.use(express.json());

// Middleware de validação
app.use((req, res, next) => {

  // ❌ GET /health não pode ter body
  if (req.method === "GET" && req.path === "/health") {
    if (req.body && Object.keys(req.body).length > 0) {
      return res.status(400).json({ error: "Body not allowed" });
    }
  }

  // ❌ Se header X-Custom existir, não pode ser vazio
  if (req.path === "/health" && "x-custom" in req.headers) {
    if (!req.headers["x-custom"] || req.headers["x-custom"].trim() === "") {
      return res.status(400).json({ error: "Invalid X-Custom header" });
    }
  }

  next();
});

// ✅ Health OK
app.get("/health", (req, res) => {
  res.status(200).json({
    status: "UP"
  });
});

// ❌ Método não permitido
app.post("/health", (req, res) => {
  res.status(405).json({ error: "Method Not Allowed" });
});

// ❌ Endpoint inexistente
app.use((req, res) => {
  res.status(404).json({ error: "Not Found" });
});

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
