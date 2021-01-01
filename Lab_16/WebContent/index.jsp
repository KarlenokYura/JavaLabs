<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Lab_16</title>
  <script>
  	var socket = null;

  	function start() {
      	if (socket !== null) {
          	return;
      	}

      	socket = new WebSocket('ws://localhost:8080/Lab_16/ws');
      	socket.onopen = () => {
          	console.log('Socket has been opened');
          	document.getElementById('outdiv').innerText = '';
          	socket.send('connection');
      	};

      	socket.onclose = (s) => {
          	console.log('Socket has been closed', s);
      	};

      	socket.onmessage = message => {
          	var result = document.getElementById('outdiv').innerHTML;
          	document.getElementById('outdiv').innerHTML = result + "<br>" + message.data;
      	};
  	}

  	function stop() {
      	socket.close();
      	socket = null;
      	console.log('Socket has been closed');
  	}
  </script>
</head>

<body>
	<h1>WebSocket</h1>
	<button onclick="start()"> Start WS</button>
	<button onclick="stop()"> Stop WS</button>
	<div id="outdiv">
	</div>
</body>
</html>