# 🔗 UShort – High-Performance URL Shortener Service

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?style=for-the-badge&logo=mongodb&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-0db7ed?style=for-the-badge&logo=docker&logoColor=white)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

---

## 📜 Overview

**UShort** is a **high-performance URL shortener** service built with **Spring Boot**, **MongoDB**, and **Redis**, designed for scalability, low latency, and efficient caching.  
It provides unique short-code generation, redirection logic, and analytics through click tracking and TTL-based expiration.

---

## 🚀 Key Features

✅ **Unique Short-Code Generation** – Generates unique, collision-free short URLs for long links.  
⚙️ **Fast Redirection** – Uses **Redis caching** to serve frequently accessed URLs instantly.  
📈 **Click Tracking** – Records each redirect for analytics and usage metrics.  
⏱️ **TTL & Expiration** – Automatically expires inactive or time-limited links using Redis TTL.  
🧩 **MongoDB Persistence** – Stores original URLs and metadata persistently.  
🧰 **Rate Limiting & Validation** – Protects API from abuse and ensures clean input data.  
⚡ **Performance Boost** – Response times improved by **over 80%** via caching layer.  

---

## 🧰 Tech Stack

| Layer | Technology |
|-------|-------------|
| **Backend Framework** | Spring Boot |
| **Database** | MongoDB |
| **Cache** | Redis |
| **Language** | Java |
| **Containerization** | Docker |
| **Build Tool** | Maven / Gradle |


