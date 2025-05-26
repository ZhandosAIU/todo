

# TODO-LIST Қосымшасы (Spring Boot + Flutter)

## Жоба сипаттамасы
Бұл жоба — күнделікті тапсырмаларды (ToDo) басқаруға арналған веб және мобильді қосымша.  
Бэкенд — Java (Spring Boot) және Firestore (Firebase) мәліметтер базасында,  
Фронтенд — Flutter-да жазылған.

## Функционалдық мүмкіндіктері
- Жаңа тапсырма қосу, көру, өңдеу, жою
- Категория, басымдық (приоритет), дедлайн таңдау
- Тапсырманы орындалған деп белгілеу
- Барлық тапсырмаларды бір тізімде көру
- Дизайн: қара және ашық (dark/light) режимдері

## Технологиялар
- **Backend:** Java 17, Spring Boot, Firebase Firestore
- **Frontend:** Flutter (iOS, Android, Web)
- **API:** RESTful (JSON)
- **Басқару:** Trello, Git

## Орнату және іске қосу

### 1. Репозиторийді клондау
```bash
git clone https://github.com/your-username/your-todo-list-repo.git

2. Backend (Spring Boot)
	•	src/main/resources/serviceAccountKey.json — Firebase қызметтік кілт файлын қосыңыз.
	•	application.properties ішіне қажетті параметрлерді толтырыңыз.
	•	Терминалда жобаның түбірінде іске қосыңыз:

./mvnw spring-boot:run


	•	Сервер әдетте http://localhost:8080 портында жұмыс істейді.

3. Frontend (Flutter)
	•	Flutter SDK және құрылғылар орнатылғанын тексеріңіз.
	•	Терминалда flutter pub get орындаңыз.
	•	Эмуляторда немесе нақты құрылғыда іске қосыңыз:

flutter run


	•	API URL-ді керек болса өзгертіңіз (lib/services/todo_api_service.dart ішінде).

Папкалардың құрылымы

.
├── backend/         # Spring Boot коды
├── frontend/        # Flutter коды
│   ├── models/      # Модельдер (Todo, Note)
│   ├── services/    # API-сервистер
│   ├── screens/     # Экрандар
│   └── widgets/     # Виджеттер
└── README.md        # Бұл құжат

API Сипаттамасы

Route	Method	Description
/api/todos	GET	Барлық тапсырманы алу
/api/todos	POST	Тапсырма қосу
/api/todos/{id}	GET	Тапсырманы көру
/api/todos/{id}	PUT	Тапсырманы жаңарту
/api/todos/{id}	DELETE	Тапсырманы өшіру


Description

This is a cross-platform task management app (ToDo list) with Java Spring Boot backend and Flutter frontend.
Backend: Java (Spring Boot) and Firestore (Firebase).
Frontend: Flutter (iOS, Android, Web).

Features
	•	Create, view, edit, delete tasks
	•	Category, priority, deadline fields
	•	Mark tasks as completed
	•	View all tasks in one list
	•	Dark and light mode

Technologies
	•	Backend: Java 17, Spring Boot, Firebase Firestore
	•	Frontend: Flutter
	•	API: RESTful (JSON)
	•	Management: Trello, Git

Installation

1. Clone repository

git clone https://github.com/your-username/your-todo-list-repo.git

2. Backend (Spring Boot)
	•	Place your Firebase serviceAccountKey.json in src/main/resources/
	•	Edit application.properties as needed.
	•	Start the server:

./mvnw spring-boot:run


	•	Default server URL: http://localhost:8080

3. Frontend (Flutter)
	•	Make sure Flutter SDK is installed.
	•	Run flutter pub get in the frontend directory.
	•	Start the app:

flutter run


	•	Update API URL in lib/services/todo_api_service.dart if needed.

Folder structure

.
├── backend/
├── frontend/
│   ├── models/
│   ├── services/
│   ├── screens/
│   └── widgets/
└── README.md

API Endpoints

Route	Method	Description
/api/todos	GET	Get all tasks
/api/todos	POST	Add a new task
/api/todos/{id}	GET	Get a task by id
/api/todos/{id}	PUT	Update a task
/api/todos/{id}	DELETE	Delete a task



---

