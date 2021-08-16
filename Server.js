const http = require('http');

const requestListener = function (req, res) {
    if (req.method === 'POST') {
        let body = ''
        req.on('data', chunk => body += chunk);
        req.on('end', () => {
            let myJSON = JSON.parse(body);
            console.log('Data: ', myJSON);
        })
    }
    res.writeHead(200);
    res.end('Hello');
    console.log("--------------------------------------------------------------");
}

const server = http.createServer(requestListener);
server.listen(23333);