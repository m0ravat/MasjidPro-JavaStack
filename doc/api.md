# API & Library Implementation
I've decided to use a GraphQL API since it'll allow for me to flexibly gather data when loading timetables, as well as the fact alot of my relationships in the database are nested so it'll stop me from using overly convoluted SQL queries. 
## API overview
We will be using mutations for altering/creating/deleting data and queries for reading/fetching data, at this point it's assumed every bit of data from the database will be read and altered in some way so I won't bother listing them all since GraphQL utilises one endpoint. 

## Libraries overview
To implement GraphQL into SpringBoot I will be using ... (TBC)