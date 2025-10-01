# Project Background

## Project Motivation
The purpose of this project is to immerse myself in fullstack technology geared
towards development in Java with an emphasis on CRUD based functionality. I decided to do this for a 
meaningful project that has potential for future updates and evolution which is how 
I came into designing a Mosque Management System. 
## Project Goal
Since designing industry grade software covering mobile, desktop and web is unrealistic with my 
current situation (balancing university, grad applications, skill building etc.) the purpose 
of this project is to deliver an MVP (Minimum Viable Product). It should be something good enough to be marketed but primitive, so 
the scope of this project will be geared towards the fundamentals with further updates in the future as time is freed up. 

## Project Feasibility
### Technological Feasibility
This project will focus on CRUD based principles to handle data, this can be achieved with my current 
stack which is:   
- Database: MySQL (hosted on Google Cloud Platform) with phpmyadmin 
- Backend: Springboot (Java backend framework) for GraphQL API and Authentication
- Frontend: Vue.js (frontend web framework)
- Mobile (May not be developed instantly): Kotlin (Similar to Java)
- Desktop: JavaFX/SwingUI (System admin dashboard)

With former experience using MERN stack technologies this provides a good challenge that isn't too easy. 

### Economic Feasibility 
Since I'm freelancing this project it's cost-effective since there is no 
virtual cost (besides time), as a learning project it's worth the time put in and with maintainability it can be 
good enough for actual mosques to use it should there be a reason for it to be used commercially. 

### Operational Feasibility
This will cover basic functionality to streamline the educational process for parents, teachers, students and a headteacher. While feedback at this stage may be limited I do intend on adapting it to potential consumer needs should it be used commercially.

## Resource Allocation
I will simulate the role of an industry standard software development team and consecutively do the work of each role.

## Roadmap

### Team Structure & Roles
The stakeholder/client will be Google Gemini simulating a Mosque owner with 2 courses, an alim class with a class in each year for late teens/adults and a maktab class - one class for each year group for young children. Each class will have around 20 students.  

I do realise that often companies may have different clients/stakeholders but for the purpose of the project that nuance isn't necessary, so I will usually assume them as the same.   
The team structure is as follows:  
- Database Administrator (Me): Sole user of GCP hosted MySQL database. 
- UI/UX Designer (v0.dev): Design UI for web, mobile and desktop.
- Frontend Developer 1 (Me): Responsible for Vue.js frontend
- Backend Developer 2 (Me): Responsible for backend API
- Backend Developer 3 (Me): Responsible for backend authentication
- Developer 4 (Me): Developing desktop app for admin. 
- QA Developer 5 (Me): Responsible for testing, clean practices and maintaining consistency for the project.
- Scrum Master (Me): Responsible for overseeing agile team and assigning backlog items across sprints.
- Product Owner (Me): Bridge between Scrum master and client/stakeholder. 

### Timeline 
As of 30/09/2025 since I'm following a structure of working Tuesday-Thursday inclusive I will aim to:  
- Complete documentation for the project. 
- Complete Jira board with relevant GANTT chart and events/sprints/tasks
- Complete database design/structure checks and insert test data. 
- Document the UI provided by Vercel's AI agent v0.dev. 
- Look at current code and see if it works.
- Analyse current requirements and see if they line up with the wants of the client.

These tasks will be associated with the Product Owner, scrum master, QA developer, database admin and UI/UX designer.

For the overall timeline, it is as follows:  
- Backend API (2 weeks)
- Backend authentication (2 weeks)
- Vue.js website (2 weeks)
- Desktop App (4 weeks)
- Web to backend integration (1 week)
- Desktop to backend integration (1 week)

Note: I set aside extra time for desktop anticipating a steeper learning curve for desktop considering I'm unsure of what to use between JavaFX/SwingUI. While the rest are 1/2 weeks personal issues may stop this which will be documented. As such I will refer to progress by using Week 1, 2 etc. instead of counting 2 weeks in real time. Each week will have 4 days, 3 for development and 1 for planning the next spring/evaluating sprint done. 


## Legal, Social and Ethical Considerations

### Legal Report
Based off the UK GDPR and Data Protection Act these are a few points to keep in mind:  
- To store information that is needed/justified. 
- Users are aware of measures they can take to get data removed (upon graduation, expulsion etc.).
- Transparency so users can submit requests through a form/contact someone relevant.
- Security so people can't unwillingly get access - restrictions placed when necessary.
- Terms & Conditions so users know what they're agreeing to. 

### Ethical Report
The system is intended to streamline the process for users making it morally good, but
making the execution morally good is also key. Considerations include:  
- Security concerns (most of which is covered in legal concerns). 
- Privacy concerns i.e. If a student reaches a certain age is a parent account necessary? 
- Making it accessible for all people - many of which are from ethnic backgrounds and not very tech literate. 
- Emotional impact - Would this be a hindrance on how people may feel in any way?
- Portability - Related to accessibility. 
- Environmental Impacts - Does this harm the environment? (In this case I'd hope not)

