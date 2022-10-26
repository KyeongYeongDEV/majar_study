const express = require("express");
const app= express();
const bodyParser = require("body-parser");

const port = 3000;

app.use(express.static('public'));
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended:true}));
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