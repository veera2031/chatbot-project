# AI Chatbot using Spring Boot & Hugging Face

## Overview

This project is a web-based AI Chatbot built using Spring Boot, Java, HTML, CSS, and JavaScript. The chatbot accepts user messages through a modern chat interface and generates AI-powered responses using the Hugging Face Inference API.

## Features

* Interactive chatbot interface
* AI-generated responses using Hugging Face Llama 3.1
* Spring Boot REST API backend
* Responsive and modern UI
* Environment variable support for secure API key management
* Ready for deployment on Railway, Render, or other cloud platforms

## Technologies Used

### Backend

* Java 17
* Spring Boot
* Maven
* REST API

### Frontend

* HTML
* CSS
* JavaScript

### AI Integration

* Hugging Face Inference API
* Meta Llama 3.1 8B Instruct Model

## Project Structure

src/
├── main/
│ ├── java/
│ │ ├── controller/
│ │ └── service/
│ ├── resources/
│ │ └── application.properties
│ └── static/
│ └── index.html
└── pom.xml

## API Endpoint

### POST /chat

Request:

```json
{
  "message": "Hello"
}
```

Response:

```json
{
  "reply": "Hello! How can I assist you today?"
}
```

## Environment Variables

Create an environment variable:

```env
HF_API_KEY=your_huggingface_api_key
```

application.properties:

```properties
server.port=${PORT:8080}
huggingface.api.key=${HF_API_KEY}
```

## Running Locally

### Clone Repository

```bash
git clone https://github.com/your-username/chatbot-project.git
cd chatbot-project
```

### Set Environment Variable

Windows PowerShell:

```powershell
$env:HF_API_KEY="your_api_key"
```

### Run Application

```bash
./mvnw spring-boot:run
```

Application will start at:

```text
http://localhost:8080
```

## Deployment

The application can be deployed on:

* Railway
* Render
* Koyeb
* Oracle Cloud

Add the following environment variable during deployment:

```env
HF_API_KEY=your_huggingface_api_key
```

## Future Enhancements

* Chat history storage
* User authentication
* Multiple AI model support
* Database integration
* Voice input and output
* Dark/Light theme switching

## Author

Veera

Final Year Computer Science Student

## License

This project is developed for educational and learning purposes.
