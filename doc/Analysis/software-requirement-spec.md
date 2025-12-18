# Software Requirements Specification

## Introduction
The purpose of this project is a learning project with practical use in the event of future maintainability, 
This project meets that need and serves the community by streamlining the educational process for mosques, 
the target audience being the teachers/headmaster there and the students (alongside their parents). 

## Project Scope 
The purpose of this specific project is to produce an MVP, a Minimum Viable Product. I will create isolated parts 
of the system (backend, frontend etc.) then integrate them together for a final functional product which will be 
deployed locally. In the future I'd hope to be able to deploy it via cloud and extend on its functionality as not 
all requirements listed may be fulfilled. 

## Project Description & Main Requirements
The project will assume the mosque has 2 main classes, a class for young children that spans for 8 years and 
a class for teens/young adults that spans for 3/7 years (Part time/Full-time options). Each year group has one class 
and each class will have 20 students taught by one teacher. Each subject will have one teacher since most mosques
don't have a large amount of money for head of departments or equivalent which will need to be factored in for 
timetables. This means the project should expect 18 simultaneous classes with 20 students each - 360 students with an 
influx of 60 new students a year for the new year group.   

While students leaving may choose to have data removed it's
assumed most won't, making an admin dashboard all the more necessary to handle the database. It's also assumed 
only the child class will require a parent account, however parents for older students could be kept up to date 
through email as a compromise. Teachers should be able to notify parents of student misconduct, which means for the
older class an alternative system would need to be produced since adults can't have their parents notified.   

As for teachers, privacy for students is key as many may have concerns of their personal information being accessed
so their limitation will be on relevant contact info/grades/basic history. They won't be able to access previous 
complaints from other teachers however, that is exclusive to the admin who is assumed to be the headmaster. As such, 
the system's UI will need to be minimalistic and easy to navigate for various demographics. 

Note: Due to the increasing complexity and me awaiting a bootcamp on vueJS I implemented the public pages with the assumption user based actions will be carried out on the database directly. This doc will act as a springboard for when I can build on this project without relying on ChatGPT
## Extra Requirements
Handling of other academic related information like books and payments.   
Capacity - 360 students with 60 new every year, 160 parent accounts with 20 new each year.   
Performance - Doesn't need to be highly performant as project is very user-centric, not much complex functionality beyond data handling.  
Availability - 24/7 access since users may access system from home.     
Portability - Web app that can be used across any system with internet access and a desktop app for admin.     
Accessibility - Factoring in disabilities and users with low proficiency with tech.   
Maintainability - Future updates shipped via GitHub.    
Security - Data hashing and secure data transmission. 

Note: This project has already had the above requirements explored with AI as seen in previous commits where further 
requirements were elaborated on. Since the database/UI factored that in, it's mundane for that to be documented again 
so I kept this as short as possible. 

