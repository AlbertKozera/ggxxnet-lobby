print('Run mongo-init.js');

db.createCollection("user")
db.createCollection("config")
db.createCollection("stats")

db.user.insert({
    "id": "1",
    "username": "admin"
    "password": "admin"
});

print('Finish mongo-init.js');