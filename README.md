# zykus-clothing
## Description:

Welcome to the Clothing Store Website project! This open-source project aims to create a modern and user-friendly online clothing store. Whether you're a fashion enthusiast, developer, or entrepreneur, this project provides a foundation for building a stylish and responsive e-commerce platform.

## Key Features:

**Product Catalog**: Display a diverse range of clothing items with detailed descriptions and images.

**User Authentication**: Secure user registration and login functionality for a personalized shopping experience.

**Shopping Cart**: Implement a dynamic shopping cart system for users to easily manage their selected items.

**Responsive Design**: Ensure an optimal user experience across various devices, from desktops to smartphones.

**Checkout Process**: Streamline the checkout process with a simple and intuitive interface.

**Payment Integration**: Integrate payment gateways for seamless and secure transactions.

## Tech Stack:

**Frontend**: Nextjs, TailWind CSS

**Backend**: Spring Boot

**Database**: PostgreSQL

## Steps for getting started
- Check if psql is installed:
> psql --version
### macOS installation steps:
- If not installed, install it using these commands on macOS:
>  brew doctor <br>
>  brew update <br>
>  brew install libpq
- Finally, symlink psql (and other libpq tools) into /usr/local/bin:
> brew link --force libpq

### Ubuntu installation steps:
- Install on Ubuntu and Debian using the apt package manager:
> sudo apt-get update <br>
sudo apt-get install postgresql-client

### Windows10 installation steps:
- We recommend using the [installer from PostgreSQL.org](https://www.postgresql.org/download/windows/?ref=timescale.com)

- Install PostgreSQL: https://www.postgresql.org/download/

### Create A New Postgres Database With psql
- One way to create a new Postgres database is with psql, a command-line interface for managing Postgres databases. Start by opening a terminal and connecting as the postgres superuser:
> psql -U postgres
- Next, I recommend creating a new user to own the new database to promote better security and access privilege management instead of making the postgres superuser the database owner. To create a new user, run the following SQL statement:
> CREATE USER <YOUR_USERNAME> WITH PASSWORD '<YOUR_PASSWORD>';
- Create a new DB with name "zykusdb"
> CREATE DATABASE <YOUR_DATABASE_NAME> OWNER <YOUR_USERNAME>;


#### `Note: Before running the project you need to set these environment variables in application.properties file` 
> PSQL_USERNAME=<YOUR_USERNAME> <br>
> PSQL_PASSWORD=<YOUR_PASSWORD> <br>
> PSQL_DBNAME=<YOUR_DATABASE_NAME>


 
