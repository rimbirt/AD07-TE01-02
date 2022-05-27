# AD07-TE01-02
## Import collection to db
mongoimport --file=imports/tv-shows.json --jsonArray --db=moviedata --collection=movies -u root -p pass --authenticationDatabase=admin

## Queries
db.movies.find({},{_id:0, name:1, genres:1, runtime:1}).sort({runtime:1, name:1}).limit(10).pretty()
db.movies.find({genres:"Fantasy", "rating.average":{$gt:7}},{_id:0, genres:1, rating:1, name:1}).pretty()
db.movies.find({"rating.average":{$gte:9, $lte:9.4}},{_id:0, genres:1, rating:1, name:1}).pretty()
db.movies.find({genres:["Drama", "Comedy"]},{_id:0, genres:1, rating:1, name:1}).pretty()
db.movies.find({name:{$regex: 'the'}, genres:{$ne:'Comedy'}},{_id:0, genres:1, name:1}).pretty()
db.movies.find({premiered:{$gt:"2014-10-01"}},{_id:0, name:1, premiered:1}).pretty()
db.movies.find({premiered:{$gte:"2006-01-01", $lte:"2006-31-12"}, language:{$ne:"English"}},{_id:0, name:1, premiered:1, language:1}).pretty()
db.movies.find({genres:[]},{_id:0, name:1, language:1}).sort({name: 1}).pretty()
db.movies.find({runtime:{$gt:30, $mod: [30, 0]}},{_id:0, name:1, runtime:1}).sort({runtime: -1, name: 1}).pretty()

## Database Creation
use birthData
db.alumnos.insertOne({nombre: "Ramiro Iglesias", edad: "40", direccion: {calle: "Caja de Ahorros", CP: "42088", ciudad: "Getxo", provincia: "Bizkaia"}})
db.alumnos.insertMany([{nombre: "Jon", edad: "3", direccion: {calle: "Caja de Ahorros", CP: "42088", ciudad: "Getxo", provincia: "Bizkaia"}, hobbies: ["jugar", "comer"]},{nombre: "Leticia Toja", edad: "39", direccion: {calle: "Caja de Ahorros", CP: "42088", ciudad: "Getxo", provincia: "Bizkaia"}, hobbies: ["escalada"]}])
db.alumnos.updateOne({nombre: "Ramiro Iglesias"}, {$set: {hobbies: ["escalada", "lectura", "videojuegos"]}})
db.alumnos.deleteMany({hobbies:"escalada"})

## Ejercicio libre
mongoimport --file=imports/restaurantes.geojson --jsonArray --db=euskadigeo --collection=sagardotegis -u root -p pass --authenticationDatabase=admin
db.sagardotegis.createIndex({geometry: "2dsphere"})
## Sidrerías a 5km del centro de Romo
db.sagardotegis.find({geometry: {$near: {type: "Point", coordinates:[-3.008764, 43.327842]}, $minDistance: 0, $maxDistance: 5000}, "properties.restorationtype": "Sidreria"}, {_id:0, properties: {documentname: 1}})
## Sidrerías a 20km de Mundaka
db.sagardotegis.find({geometry:{$geoWithin: {$centerSphere: [[-2.7854775,43.4468996], 20/6378.1]}}, "properties.restorationtype": "Sidreria"}, {_id:0, properties: {documentname: 1}}).pretty()

const p1 = [-1.986685,43.321789]
const p2 = [-1.988199,43.323761]
const p3 = [-1.983081,43.325553]
const p4 = [-1.980821,43.323299]
db.sagardotegis.find({geometry:{$geoWithin:{$geometry:{type:"Polygon",coordinates:[[p1,p2,p3,p4,p1]]}}}, "properties.turismdescription": {$regex: "vieja"}}, {_id:0, properties: {documentname: 1}})
