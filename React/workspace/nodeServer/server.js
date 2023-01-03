const express = require('express');
const app = express();
const path = require('path');

app.use(express.static(path.join(__dirname, 'myreact-app/build')));

app.get('/react', function(req, resp) {
    resp.sendFile(path.join(__dirname, 'myreact-app/build/index.html'));
})

// app.get('경로', functino(요청, 응답) {실행})
app.get('/pet', function(request, response) {
    response.send('<h1>pet page</h1>')
})

app.get('/beauty', function(request, response) {
    response.send('<h1>beauty page</h1>')
})

// 파일 보내기
app.get('/home', function(req, resp) {
    resp.sendFile(__dirname + '/index.html')
})

app.get('/write', function(req, resp) {
    resp.sendFile(__dirname + '/write.html')
})


// app.listen(포트 넘버, ()=>{})
// 포트 넘버, 함수 
app.listen(9090, function() {
    console.log('listening on 9090');
})