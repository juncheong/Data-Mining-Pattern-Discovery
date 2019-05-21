*Setting up environment variables to connect to database

1) Create a file called 'env' (without any extensions) and 
2) Fill this out with no spaces after the '='

```DB_HOST=
DB_USERNAME=
DB_PASSWORD=
DB_PORT=
DB_NAME=```

Example: 
```DB_HOST=EXAMPLE.com
DB_USERNAME=USERNAME123
DB_PASSWORD=PASSWORD456
DB_PORT=3306
DB_NAME=DATABASENAME789```

*Setting up gitignore

It is very important that you do not share the database information with anyone.
So you need to set up a .gitignore so that you will not accidentally push the 'env' file

1) Create a file called '.gitignore'
2) Inside .gitignore, write 'env' so git will ignore the 'env' file

*Writing code

Always work on features in a new branch. NEVER work directly from master

*Making queries to the database

Now when you run the program, it will automatically get all the information you need to
connect to the database and save them inside a Database object.

The Database object should only be used to perform queries so make sure to return the data back into main
and pass it to a new object or something.