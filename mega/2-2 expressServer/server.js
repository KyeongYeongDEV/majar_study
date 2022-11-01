const express = require("express");
const app= express();
const cors = require('cors');
const bodyParser = require("body-parser");
const mysql = require('mysql');
const { response } = require("express");

const connection = mysql.createConnection({
    host: 'localhost',
    port : 3306,
    user: 'root',
    password : 'dkdldnjs7098',
    database : 'USER_DB'
})

connection.connect();

const port = 3000;

app.use(express.static('public'));
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended:true}));

app.use(cors())

app.set('view engine', 'ejs');

app.listen(port,()=>{
    console.log("Start!!");
})

app.get('/',(req,res)=>{
    res.sendFile(__dirname + "/public/main.html");
});

app.post('/email_post', (req,res)=>{
    console.log(req.body.email) 
    //res.send("Welcome ! " + req.body.email);
    res.render('email.ejs', {'email': req.body.email});
})

app.post('/ajax_send_email', (req,res)=>{
    console.log(req.body.email);
   // let email = (req.body.email);
    let responseData = {'resule' : 'ok', 'email': req.body.email};
    res.json(responseData)

    // let query = connection.query('select name from user where email = "' + email + '"', (err,rows)=>{
    //     if(err) throw err;
    //     if(rows[0]){
    //         console.log(rows[0])
    //         responseData.result = "ok";
    //         responseData.name = rows[0].name;
    //     }else{
    //         console.log('none : ' + rows[0])
    //     }
    // })
     //res.json(responseData)
})